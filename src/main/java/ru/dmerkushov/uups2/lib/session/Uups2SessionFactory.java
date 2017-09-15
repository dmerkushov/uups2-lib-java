/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.session;

import java.net.Socket;

/**
 *
 * @author dmerkushov
 */
public class Uups2SessionFactory {

	////////////////////////////////////////////////////////////////////////////
	// Uups2SessionFactory is a singleton class
	////////////////////////////////////////////////////////////////////////////
	private static Uups2SessionFactory _instance;

	/**
	 * Get the single instance of Uups2SessionFactory
	 *
	 * @return The same instance of Uups2SessionFactory every time the method is
	 * called
	 */
	public static synchronized Uups2SessionFactory getInstance () {
		if (_instance == null) {
			_instance = new Uups2SessionFactory ();
		}
		return _instance;
	}

	private Uups2SessionFactory () {
	}
	////////////////////////////////////////////////////////////////////////////

	public Uups2Session initiateSession (Uups2Peer remotePeer) throws Uups2SessionException {
		//TODO Implement initiateSession()
		throw new UnsupportedOperationException ();
	}

	public Uups2Session acceptSession (Socket socket) throws Uups2SessionException {
		//TODO Implement acceptSession()
		throw new UnsupportedOperationException ();
	}

}
