/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.message;

import ru.dmerkushov.uups2.lib.Uups2LibException;

/**
 *
 * @author dmerkushov
 */
public class MessageUtilException extends Uups2LibException {

	public MessageUtilException () {
	}

	public MessageUtilException (String message) {
		super (message);
	}

	public MessageUtilException (String message, Throwable cause) {
		super (message, cause);
	}

	public MessageUtilException (Throwable cause) {
		super (cause);
	}

}
