/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.servicelocator.client;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import ru.dmerkushov.uups2.lib.Uups2LibConfig;
import ru.dmerkushov.uups2.lib.session.Uups2Session;

/**
 *
 * @author dmerkushov
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
