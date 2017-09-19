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

import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public class Uups2SessionRegistry {
	////////////////////////////////////////////////////////////////////////////
	// Uups2SessionRegistry is a singleton class
	////////////////////////////////////////////////////////////////////////////

	private static Uups2SessionRegistry _instance;

	/**
	 * Get the single instance of Uups2SessionRegistry
	 *
	 * @return The same instance of Uups2SessionRegistry every time the method
	 * is called
	 */
	public static synchronized Uups2SessionRegistry getInstance () {
		if (_instance == null) {
			_instance = new Uups2SessionRegistry ();
		}
		return _instance;
	}

	private Uups2SessionRegistry () {
	}
	////////////////////////////////////////////////////////////////////////////

	HashMap<UUID, Uups2Session> sessionsByUuid = new HashMap<> ();
	HashMap<Socket, Uups2Session> sessionsBySocket = new HashMap<> ();

	private final Object lock = new Object ();

	public void registerSession (Uups2Session session) {
		synchronized (lock) {
			sessionsByUuid.put (session.sessionInfo.getSessionUuid (), session);
			if (session.getSocket () != null) {
				sessionsBySocket.put (session.getSocket (), session);
			}
		}
	}

	public Uups2Session getSession (Uups2Peer remotePeer) {
		//TODO Implement getSession()
		throw new UnsupportedOperationException ();
	}

}
