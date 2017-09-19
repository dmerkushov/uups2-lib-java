/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib;

import java.util.prefs.Preferences;

/**
 *
 * @author dmerkushov
 */
public class Uups2LibConfig {

	public static final String LOCALPEER_HOST;
	public static final int LOCALPEER_UPS_PORT;
	public static final int LOCALPEER_UUPS_PORT;
	public static final String SERVICELOCATOR_HOST;
	public static final int SERVICELOCATOR_UPS_PORT;

	static {
		LOCALPEER_HOST = Preferences.userNodeForPackage (Uups2LibConfig.class).get ("LOCALPEER_HOST", "127.0.0.1");
		LOCALPEER_UPS_PORT = Preferences.userNodeForPackage (Uups2LibConfig.class).getInt ("PEER_UPS_PORT", 0);
		LOCALPEER_UUPS_PORT = Preferences.userNodeForPackage (Uups2LibConfig.class).getInt ("PEER_UUPS_PORT", 0);
		SERVICELOCATOR_HOST = Preferences.userNodeForPackage (Uups2LibConfig.class).get ("SERVICELOCATOR_HOST", "127.0.0.1");
		SERVICELOCATOR_UPS_PORT = Preferences.userNodeForPackage (Uups2LibConfig.class).getInt ("SERVICELOCATOR_UPS_PORT", 44444);
	}

}
