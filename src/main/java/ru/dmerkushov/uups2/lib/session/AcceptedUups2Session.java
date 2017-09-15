/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.session;

import javax.json.JsonObject;

/**
 *
 * @author dmerkushov
 */
public final class AcceptedUups2Session extends Uups2Session {

	public AcceptedUups2Session (JsonObject sessionInfo) throws Uups2SessionException {
		super (sessionInfo);
	}

	@Override
	public Uups2Peer getInitiatorPeer () throws Uups2SessionException {
		return getRemotePeer ();
	}

	@Override
	public Uups2Peer getAcceptorPeer () throws Uups2SessionException {
		return getLocalPeer ();
	}

	@Override
	public boolean isInitiatedSession () {
		return false;
	}

}
