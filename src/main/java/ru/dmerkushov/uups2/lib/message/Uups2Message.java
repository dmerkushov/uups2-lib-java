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
package ru.dmerkushov.uups2.lib.message;

import java.util.Objects;
import ru.dmerkushov.longbytearray.LongByteArray;
import ru.dmerkushov.uups2.lib.session.Uups2Session;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
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
