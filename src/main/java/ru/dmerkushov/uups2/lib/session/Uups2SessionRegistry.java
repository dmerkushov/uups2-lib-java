/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.session;

import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author dmerkushov
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
