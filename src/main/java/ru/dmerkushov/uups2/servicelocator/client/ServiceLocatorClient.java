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
package ru.dmerkushov.uups2.servicelocator.client;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import ru.dmerkushov.uups2.lib.Uups2LibConfig;
import ru.dmerkushov.uups2.lib.session.Uups2Session;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public class ServiceLocatorClient {

	public final JsonObject localPeer;

	////////////////////////////////////////////////////////////////////////////
	// ServiceLocatorClient is a singleton class
	////////////////////////////////////////////////////////////////////////////
	private static ServiceLocatorClient _instance;

	/**
	 * Get the single instance of ServiceLocatorClient
	 *
	 * @return The same instance of ServiceLocatorClient every time the method
	 * is called
	 */
	public static synchronized ServiceLocatorClient getInstance () {
		if (_instance == null) {
			_instance = new ServiceLocatorClient ();
		}
		return _instance;
	}

	private ServiceLocatorClient () {
		JsonObjectBuilder localPeerBuilder = Json.createObjectBuilder ();
		localPeerBuilder.add ("service-name", "somebody");
		localPeerBuilder.add ("uups-versions", Json.createArrayBuilder ().add (2));
		localPeerBuilder.add ("host", "10.1.0.200");
		localPeerBuilder.add ("ups-port", Uups2LibConfig.LOCALPEER_UPS_PORT);
		localPeerBuilder.add ("uups-port", Uups2LibConfig.LOCALPEER_UUPS_PORT);

		localPeer = localPeerBuilder.build ();
	}
	////////////////////////////////////////////////////////////////////////////

	public Uups2Session getSession (String peer) throws ServiceLocatorClientException {
		//TODO Implement getSession()
		throw new UnsupportedOperationException ();
	}
}
