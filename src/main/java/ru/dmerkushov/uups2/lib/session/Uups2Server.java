/*
 * Copyright 2017 Dmitriy Merkushov <d.merkushov@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.dmerkushov.uups2.lib.session;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.prefs.Preferences;
import ru.dmerkushov.signals4j.util.Signals4jThreadFactory;
import ru.dmerkushov.uups2.lib.ErrorSignal;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public class Uups2Server {

	public final InetAddress serverHost;
	public final int serverPort;
	public final String serviceName;
	public final ServerSocket serverSocket;

	public static final ExecutorService uups2SocketProcessorService;
	public static final int SO_TIMEOUT;

	static {
		int nThreads = Preferences.userNodeForPackage (Uups2Server.class).getInt ("SERVER_SOCKET_PROCESSORS", 10);
		ThreadFactory threadFactory = new Signals4jThreadFactory ("UUPS2_SOCKET_PROCESSOR", true);
		uups2SocketProcessorService = Executors.newFixedThreadPool (nThreads, threadFactory);

		SO_TIMEOUT = Preferences.userNodeForPackage (Uups2Server.class).getInt ("SERVER_SO_TIMEOUT", 3000);
	}

	public Uups2Server (String serverHostName, int serverPort, String serviceName) throws Uups2ServerException {
		Objects.requireNonNull (serverHostName, "serverHostName");
		Objects.requireNonNull (serviceName, "serviceName");
		if (serverPort < 0) {
			throw new IllegalArgumentException ("serverPort < 0: " + serverPort);
		}

		try {
			this.serverHost = InetAddress.getByName (serverHostName);
		} catch (UnknownHostException ex) {
			throw new Uups2ServerException (ex);
		}
		this.serverPort = serverPort;
		this.serviceName = serviceName;

		try {
			this.serverSocket = new ServerSocket (serverPort, 0, serverHost);
		} catch (IOException ex) {
			throw new Uups2ServerException ("Cannot create a server socket for the UUPS2 server", ex);
		}

		try {
			serverSocket.setSoTimeout (SO_TIMEOUT);
		} catch (SocketException ex) {
			throw new Uups2ServerException ("Cannot set SO_TIMEOUT for the UUPS2 server", ex);
		}

		Uups2ServerListener serverListenerRunnable = new Uups2ServerListener ();
		Thread serverListenerThread = new Thread (serverListenerRunnable);
		serverListenerThread.setDaemon (true);
		serverListenerThread.setName ("UUPS2_SERVER_LISTENER");
		serverListenerThread.start ();
	}

	public class Uups2ServerListener implements Runnable {

		@Override
		public void run () {
			while (true) {
				Socket socket = null;
				try {
					socket = Uups2Server.this.serverSocket.accept ();
				} catch (SocketTimeoutException ex) {
					// Do nothing, this is ok
				} catch (IOException ex) {
					new ErrorSignal ("Exception when accepting a TCP connection", ex).emit ();
				}

				uups2SocketProcessorService.submit (new Uups2SocketProcessor (socket));
			}
		}
	}

	public class Uups2SocketProcessor implements Runnable {

		public final Socket socket;

		public Uups2SocketProcessor (Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run () {
			Uups2Session session;
			try {
				session = Uups2SessionFactory.getInstance ().acceptSession (socket);
			} catch (Uups2SessionException ex) {
				new ErrorSignal ("Exception when accepting a UUPS2 session", ex).emit ();
				return;
			}
			Uups2SessionRegistry.getInstance ().registerSession (session);
			session.startProcessing ();
		}

	}

}
