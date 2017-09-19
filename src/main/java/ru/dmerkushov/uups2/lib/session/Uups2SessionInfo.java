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

import java.util.Objects;
import java.util.UUID;
import javax.json.JsonObject;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
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
