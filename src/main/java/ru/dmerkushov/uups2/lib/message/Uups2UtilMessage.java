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

import ru.dmerkushov.longbytearray.LongByteArray;
import ru.dmerkushov.uups2.lib.session.Uups2Session;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
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
