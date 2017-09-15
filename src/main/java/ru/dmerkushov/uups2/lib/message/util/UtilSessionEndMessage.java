/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.message.util;

import ru.dmerkushov.longbytearray.LongByteArray;
import ru.dmerkushov.uups2.lib.message.Uups2UtilMessage;
import ru.dmerkushov.uups2.lib.session.Uups2Session;

/**
 *
 * @author dmerkushov
 */
public class UtilSessionEndMessage extends Uups2UtilMessage {

	public UtilSessionEndMessage (Uups2Session session, int type, long len, long cnt, LongByteArray msg) {
		super (session, type, len, cnt, msg);
	}

}
