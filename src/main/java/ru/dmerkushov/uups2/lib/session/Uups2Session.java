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
import java.util.Objects;
import javax.json.JsonObject;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public abstract class Uups2Session {

	public final Uups2SessionInfo sessionInfo;

	private Socket socket = null;
	private long utilCnt = 0x8000000000000000L;
	private long regularCnt = 0L;
	private final Object lock = new Object ();
	private Uups2Peer localPeer;
	private Uups2Peer remotePeer;

	/**
	 * Create a new Session object with the given session info
	 *
	 * @param sessionInfo
	 * @throws ru.dmerkushov.uups2.lib.session.Uups2SessionException if the
	 * sessionInfo structure is illegal
	 */
	public Uups2Session (JsonObject sessionInfo) throws Uups2SessionException {
		Objects.requireNonNull (sessionInfo, "sessionInfo");

		Uups2SessionInfo.checkCorrectJson (sessionInfo);

		this.sessionInfo = new Uups2SessionInfo (sessionInfo);
	}

	public Socket getSocket () {
		synchronized (lock) {
			return socket;
		}
	}

	public void setSocket (Socket socket) {
		synchronized (lock) {
			this.socket = socket;
		}
	}

	public void startProcessing () {
		//TODO Implement generated startProcessing() in Uups2Session
		throw new UnsupportedOperationException ("Not supported yet.");

		// Initialize the message queues, start a thread for session incoming messages, set up the session ready state
	}

	public abstract Uups2Peer getInitiatorPeer () throws Uups2SessionException;

	public abstract Uups2Peer getAcceptorPeer () throws Uups2SessionException;

	public abstract boolean isInitiatedSession ();

	public Uups2Peer getLocalPeer () {
		synchronized (lock) {
			return localPeer;
		}
	}

	public Uups2Peer getRemotePeer () {
		synchronized (lock) {
			return remotePeer;
		}
	}

	public void setLocalPeer (Uups2Peer localPeer) {
		synchronized (lock) {
			this.localPeer = localPeer;
		}
	}

	public void setRemotePeer (Uups2Peer remotePeer) {
		synchronized (lock) {
			this.remotePeer = remotePeer;
		}
	}

}
