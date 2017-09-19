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

import java.util.HashMap;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public enum MessageType {

	Util_Session_End (0x00000000),
	Util_SessionInfo (0x00010100),
	Util_SessionInfo_Confirm (0x00010101),
	Util_InputQueue_Full (0x00020100),
	Util_InputQueue_Full_Confirm (0x00020101),
	Util_InputQueue_Free (0x00020102),
	Error_General (0x00FF0000),
	Error_SessionInfo_Invalid (0x00FF0100),
	Error_SessionInfo_NoSuchService (0x00FF0101),
	Text_NoID (0x02000000),
	Text_NoID_Response (0x02000001),
	Text_UUID (0x02010000),
	Text_UUID_Response (0x02010001),
	Text_NoID_JSON (0x02000100),
	Text_NoID_JSON_Response (0x02000101),
	Text_UUID_JSON (0x02010100),
	Text_UUID_JSON_Response (0x02010101),
	Binary_NoID (0x01000000),
	Binary_NoID_Response (0x01000001),
	Binary_UUID (0x01010000),
	Binary_UUID_Response (0x01010001);

	private static final HashMap<Integer, MessageType> mapByValue = new HashMap<> ();

	static {
		for (MessageType type : MessageType.values ()) {
			mapByValue.put (type.value, type);
		}
	}

	public final int value;

	MessageType (int value) {
		this.value = value;
	}

	/**
	 * Is an util message?
	 *
	 * @return
	 */
	public boolean isUtil () {
		switch (this) {
			case Util_Session_End:
			case Util_SessionInfo:
			case Util_SessionInfo_Confirm:
			case Util_InputQueue_Full:
			case Util_InputQueue_Full_Confirm:
			case Util_InputQueue_Free:
			case Error_General:
			case Error_SessionInfo_Invalid:
			case Error_SessionInfo_NoSuchService:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Is an error message? Error messages are a subtype of util messages, so
	 * {@link #isUtil()} will return <code>true</code> for any of error
	 * messages.
	 *
	 * @return
	 */
	public boolean isError () {
		switch (this) {
			case Error_General:
			case Error_SessionInfo_Invalid:
			case Error_SessionInfo_NoSuchService:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Is a regular message?
	 *
	 * @return
	 */
	public boolean isRegular () {
		return !isUtil ();
	}

	/**
	 * Is a non-identified message?
	 *
	 * @return
	 */
	public boolean isNoId () {
		switch (this) {
			case Text_NoID:
			case Text_NoID_Response:
			case Text_NoID_JSON:
			case Text_NoID_JSON_Response:
			case Binary_NoID:
			case Binary_NoID_Response:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Is a UUID-identified message?
	 *
	 * @return
	 */
	public boolean isUuid () {
		switch (this) {
			case Text_UUID:
			case Text_UUID_Response:
			case Text_UUID_JSON:
			case Text_UUID_JSON_Response:
			case Binary_UUID:
			case Binary_UUID_Response:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Is a JSON message?
	 *
	 * @return
	 */
	public boolean isJson () {
		switch (this) {
			case Text_NoID_JSON:
			case Text_NoID_JSON_Response:
			case Text_UUID_JSON:
			case Text_UUID_JSON_Response:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Is a binary message?
	 *
	 * @return
	 */
	public boolean isBinary () {
		switch (this) {
			case Binary_NoID:
			case Binary_NoID_Response:
			case Binary_UUID:
			case Binary_UUID_Response:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Is a text message?
	 *
	 * @return
	 */
	public boolean isText () {
		switch (this) {
			case Text_NoID:
			case Text_NoID_Response:
			case Text_UUID:
			case Text_UUID_Response:
			case Text_NoID_JSON:
			case Text_NoID_JSON_Response:
			case Text_UUID_JSON:
			case Text_UUID_JSON_Response:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Is a response message?
	 *
	 * @return
	 */
	public boolean isResponse () {
		switch (this) {
			case Text_NoID_Response:
			case Text_UUID_Response:
			case Text_NoID_JSON_Response:
			case Text_UUID_JSON_Response:
			case Binary_NoID_Response:
			case Binary_UUID_Response:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Get a message type by its integer value
	 *
	 * @param value
	 * @return
	 * @throws IllegalArgumentException if the value is not registered
	 */
	public static MessageType byValue (int value) {
		if (!mapByValue.containsKey (value)) {
			throw new IllegalArgumentException ("No such value " + value);
		}
		return mapByValue.get (value);
	}

}
