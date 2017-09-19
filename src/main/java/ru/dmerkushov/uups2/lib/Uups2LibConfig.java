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

import java.util.prefs.Preferences;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
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
