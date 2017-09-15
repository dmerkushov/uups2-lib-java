/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author dmerkushov
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
