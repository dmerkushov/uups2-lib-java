/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.message;

import java.util.Objects;
import ru.dmerkushov.longbytearray.LongByteArray;
import ru.dmerkushov.uups2.lib.session.Uups2Session;

/**
 *
 * @author dmerkushov
 */
public abstract class Uups2Message {

	public final int typeInt;
	public final MessageType type;
	public final long len;
	public final long cnt;
	public final LongByteArray msg;

	public Uups2Message (Uups2Session session, int typeInt, long len, long cnt, LongByteArray msg) {
		Objects.requireNonNull (msg, "msg");

		this.typeInt = typeInt;
		this.type = MessageType.byValue (typeInt);
		this.len = len;
		this.cnt = cnt;
		this.msg = msg;
	}

	/**
	 * Emit a signal that this message has been received
	 *
	 * @return the emitted signal
	 */
	public abstract Uups2MessageReceivedSignal emitReceivedSignal ();

	public void send () {
		//TODO Implement send()
		throw new UnsupportedOperationException ();
	}

	public void sendAndWaitForResponse () {
		//TODO Implement sendAndWaitForResponse ()
		throw new UnsupportedOperationException ();
	}

}
