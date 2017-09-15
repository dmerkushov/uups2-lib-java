/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib;

import java.util.prefs.Preferences;
import ru.dmerkushov.signals4j.Signal;
import ru.dmerkushov.signals4j.Signals4j;
import ru.dmerkushov.uups2.lib.message.Uups2RegularMessageReceivedSignal;

/**
 *
 * @author dmerkushov
 */
public class Uups2Lib {

	public static final String PEER_HOST;
	public static final int PEER_UPS_PORT;
	public static final int PEER_UUPS_PORT;

	static {
		PEER_HOST = Preferences.userNodeForPackage (Uups2Lib.class).get ("PEER_HOST", "127.0.0.1");
		PEER_UPS_PORT = Preferences.userNodeForPackage (Uups2Lib.class).getInt ("PEER_UPS_PORT", 0);
		PEER_UUPS_PORT = Preferences.userNodeForPackage (Uups2Lib.class).getInt ("PEER_UUPS_PORT", 0);
	}

	private static Uups2Lib instance = null;

	public static synchronized Uups2Lib getInstance () {
		if (instance == null) {
			instance = new Uups2Lib ();
		}

		return instance;
	}

	private ErrorSlot errorSlot = new ErrorSlot ();

	private Uups2Lib () {
		Signals4j.getInstance ().connect (ErrorSignal.class, errorSlot);
	}

	public ErrorSlot getErrorSlot () {
		return errorSlot;
	}

	public Class<? extends Signal> getRegularMessageReceivedSignalClass () {
		return Uups2RegularMessageReceivedSignal.class;
	}

}
