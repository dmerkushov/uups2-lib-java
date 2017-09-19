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
package ru.dmerkushov.uups2.lib;

import java.net.InetAddress;
import java.net.UnknownHostException;
import ru.dmerkushov.signals4j.Signal;
import ru.dmerkushov.signals4j.Signals4j;
import ru.dmerkushov.uups2.lib.message.Uups2RegularMessageReceivedSignal;
import ru.dmerkushov.uups2.ups1fallback.Ups1Fallback;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public class Uups2Lib {

	private ErrorSlot errorSlot;
	public final Ups1Fallback ups1;

	////////////////////////////////////////////////////////////////////////////
	// Uups2Lib is a singleton class
	////////////////////////////////////////////////////////////////////////////
	private static Uups2Lib _instance;

	/**
	 * Get the single instance of Uups2Lib
	 *
	 * @return The same instance of Uups2Lib every time the method is called
	 */
	public static synchronized Uups2Lib getInstance () {
		if (_instance == null) {
			_instance = new Uups2Lib ();
		}
		return _instance;
	}

	private Uups2Lib () {
		errorSlot = new ErrorSlot ();
		Signals4j.getInstance ().connect (ErrorSignal.class, errorSlot);

		try {
			ups1 = new Ups1Fallback (InetAddress.getByName (Uups2LibConfig.LOCALPEER_HOST), Uups2LibConfig.LOCALPEER_UPS_PORT);
		} catch (UnknownHostException ex) {
			throw new RuntimeException (ex);
		}

	}
	////////////////////////////////////////////////////////////////////////////

	public ErrorSlot getErrorSlot () {
		return errorSlot;
	}

	public Class<? extends Signal> getRegularMessageReceivedSignalClass () {
		return Uups2RegularMessageReceivedSignal.class;
	}

}
