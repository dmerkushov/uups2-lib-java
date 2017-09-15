/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.message;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import ru.dmerkushov.longbytearray.LongByteArray;
import ru.dmerkushov.longbytearray.LongByteArrayReader;
import ru.dmerkushov.uups2.lib.message.util.UtilSessionEndMessage;
import ru.dmerkushov.uups2.lib.session.Uups2Session;

/**
 *
 * @author dmerkushov
 */
public class Uups2MessageFactory {

	private static Uups2MessageFactory instance;

	public static synchronized Uups2MessageFactory getInstance () {
		if (instance == null) {
			instance = new Uups2MessageFactory ();
		}
		return instance;
	}

	private Uups2MessageFactory () {
	}

	public Uups2Message readMessage (Uups2Session session, InputStream is) throws Uups2MessageFactoryException {
		ByteBuffer typeBb = ByteBuffer.wrap (readBytes (is, 4));	// Field TYPE is 4 bytes long
		typeBb.order (ByteOrder.BIG_ENDIAN);
		int typeInt = typeBb.getInt ();

		MessageType type = MessageType.byValue (typeInt);

		ByteBuffer lenBb = ByteBuffer.wrap (readBytes (is, 8));		// Field LEN is 8 bytes long
		lenBb.order (ByteOrder.BIG_ENDIAN);
		long len = lenBb.getLong ();

		ByteBuffer cntBb = ByteBuffer.wrap (readBytes (is, 8));		// Field LEN is 8 bytes long
		cntBb.order (ByteOrder.BIG_ENDIAN);
		long cnt = cntBb.getLong ();

		LongByteArray msg;
		try {
			msg = LongByteArrayReader.read (is, len);
		} catch (IOException ex) {
			throw new Uups2MessageFactoryException ("When reading the MSG of len " + len, ex);
		}

		Uups2Message message;

		switch (type) {
			////////////////////////////////////////////////////////////////////
			// Service messages
			////////////////////////////////////////////////////////////////////

			case Util_Session_End:
				message = new UtilSessionEndMessage (session, typeInt, len, cnt, msg);
				break;
			case Util_SessionInfo:
			//TODO Implement reading Util-SessionInfo
			case Util_SessionInfo_Confirm:
			//TODO Implement reading Util-SessionInfo-Confirm
			case Util_InputQueue_Full:
			//TODO Implement reading Util-InputQueue-Full
			case Util_InputQueue_Full_Confirm:
			//TODO Implement reading Util-InputQueue-Full-Confirm
			case Util_InputQueue_Free:
			//TODO Implement reading Util-InputQueue-Free
			case Error_General:
			//TODO Implement reading Error-General
			case Error_SessionInfo_Invalid:
			//TODO Implement reading Error-SessionInfo-Invalid
			case Error_SessionInfo_NoSuchService:
			//TODO Implement reading Error-SessionInfo-NoSuchService

			////////////////////////////////////////////////////////////////////
			// Regular messages
			////////////////////////////////////////////////////////////////////
			case Text_NoID:
			//TODO Implement reading Binary-NoID
			case Text_NoID_Response:
			//TODO Implement reading Binary-NoID-Response
			case Text_UUID:
			//TODO Implement reading Binary-UUID
			case Text_UUID_Response:
			//TODO Implement reading Binary-UUID-Response
			case Text_NoID_JSON:
			//TODO Implement reading Text-NoID
			case Text_NoID_JSON_Response:
			//TODO Implement reading Text-NoID-Response
			case Text_UUID_JSON:
			//TODO Implement reading Text-UUID
			case Text_UUID_JSON_Response:
			//TODO Implement reading Text-UUID-Response
			case Binary_NoID:
			//TODO Implement reading Text-NoID-JSON
			case Binary_NoID_Response:
			//TODO Implement reading Text-NoID-JSON-Response
			case Binary_UUID:
			//TODO Implement reading Text-UUID-JSON
			case Binary_UUID_Response:
			//TODO Implement reading Text-UUID-JSON-Response
			default:
				throw new Uups2MessageFactoryException ("Unknown message type 0x" + Integer.toHexString (typeInt));
		}

		return message;
	}

	private byte[] readBytes (InputStream is, int length) throws Uups2MessageFactoryException {
		byte[] bytes = new byte[length];

		int totalRead = 0;
		int remains = length;
		while (totalRead < length) {
			int currentRead;
			try {
				currentRead = is.read (bytes, totalRead, remains);
			} catch (IOException ex) {
				throw new Uups2MessageFactoryException ("When trying to read the remaining part after byte " + totalRead + " of " + length, ex);
			}
			totalRead += currentRead;
			remains -= currentRead;
		}

		return bytes;
	}

}
