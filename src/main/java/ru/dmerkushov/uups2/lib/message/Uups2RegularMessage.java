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
public abstract class Uups2RegularMessage extends Uups2Message {

	public Uups2RegularMessage (Uups2Session session, int type, long len, long cnt, LongByteArray msg) {
		super (session, type, len, cnt, msg);
	}

	@Override
	public Uups2MessageReceivedSignal emitReceivedSignal () {
		Uups2RegularMessageReceivedSignal signal = new Uups2RegularMessageReceivedSignal (this);

		signal.emit ();

		return signal;
	}

}
