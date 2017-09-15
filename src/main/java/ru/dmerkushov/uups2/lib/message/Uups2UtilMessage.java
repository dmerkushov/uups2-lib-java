/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.message;

import ru.dmerkushov.longbytearray.LongByteArray;
import ru.dmerkushov.uups2.lib.session.Uups2Session;

/**
 *
 * @author dmerkushov
 */
public abstract class Uups2UtilMessage extends Uups2Message {

	public Uups2UtilMessage (Uups2Session session, int type, long len, long cnt, LongByteArray msg) {
		super (session, type, len, cnt, msg);
	}

	@Override
	public Uups2MessageReceivedSignal emitReceivedSignal () {
		Uups2UtilMessageReceivedSignal signal = new Uups2UtilMessageReceivedSignal (this);

		signal.emit ();

		return signal;
	}

}
