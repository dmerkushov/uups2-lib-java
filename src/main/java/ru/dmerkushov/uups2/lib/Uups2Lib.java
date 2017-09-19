/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author dmerkushov
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
