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

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
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
