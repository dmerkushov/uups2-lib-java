/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.session;

import java.util.Objects;
import java.util.UUID;
import javax.json.JsonObject;

/**
 *
 * @author dmerkushov
 */
public final class Uups2SessionInfo {

	public final JsonObject sessionInfoJson;

	public Uups2SessionInfo (JsonObject sessionInfoJson) {
		Objects.requireNonNull (sessionInfoJson, "sessionInfoJson");

		this.sessionInfoJson = sessionInfoJson;
	}

	public UUID getSessionUuid () {
		String uuidStr = sessionInfoJson.getString ("session-uuid");
		UUID uuid = UUID.fromString (uuidStr);
		return uuid;
	}

	public int getUupsVersion () {
		return sessionInfoJson.getInt ("uups-version");
	}

	public Uups2Peer getInitiatorPeer () {
		return new Uups2Peer (sessionInfoJson.getJsonObject ("initiator"));
	}

	public Uups2Peer getAcceptorPeer () {
		return new Uups2Peer (sessionInfoJson.getJsonObject ("acceptor"));
	}

	public static void checkCorrectJson (JsonObject sessionInfoJson) throws Uups2SessionException {
		//TODO Implement checking the session JSON for correctness
	}

}
