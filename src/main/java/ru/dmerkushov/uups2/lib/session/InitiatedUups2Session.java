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

import javax.json.JsonObject;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public final class InitiatedUups2Session extends Uups2Session {

	public InitiatedUups2Session (JsonObject sessionInfo) throws Uups2SessionException {
		super (sessionInfo);
	}

	@Override
	public Uups2Peer getInitiatorPeer () throws Uups2SessionException {
		return getLocalPeer ();
	}

	@Override
	public Uups2Peer getAcceptorPeer () throws Uups2SessionException {
		return getRemotePeer ();
	}

	@Override
	public boolean isInitiatedSession () {
		return true;
	}

}
