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

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.UUID;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public class MessageUtil {

	public static UUID readUuid (InputStream is) throws MessageUtilException {
		byte[] uuidBytes = new byte[16];
		try {
			new DataInputStream (is).readFully (uuidBytes);
		} catch (IOException ex) {
			throw new MessageUtilException (ex);
		}

		return readUuid (uuidBytes);
	}

	public static UUID readUuid (byte[] uuidBytes) {
		Objects.requireNonNull (uuidBytes, "uuidBytes");
		if (uuidBytes.length != 16) {
			throw new IllegalArgumentException ("uuidBytes length is not 16: " + uuidBytes.length);
		}

		ByteBuffer bb = ByteBuffer.wrap (uuidBytes);
		bb.order (ByteOrder.BIG_ENDIAN);

		long high = bb.getLong ();
		long low = bb.getLong ();

		UUID uuid = new UUID (high, low);
		return uuid;
	}

	public static JsonObject readJsonObject (byte[] bytes) throws MessageUtilException {
		ByteArrayInputStream bais = new ByteArrayInputStream (bytes);
		JsonReader rdr = Json.createReader (bais);

		JsonObject jsonObject;
		try {
			jsonObject = rdr.readObject ();
		} catch (JsonException ex) {
			throw new MessageUtilException (ex);
		}
		return jsonObject;
	}

}
