/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.session;

import ru.dmerkushov.uups2.lib.Uups2LibException;

/**
 *
 * @author dmerkushov
 */
public class Uups2SessionException extends Uups2LibException {

	public Uups2SessionException () {
	}

	public Uups2SessionException (String message) {
		super (message);
	}

	public Uups2SessionException (String message, Throwable cause) {
		super (message, cause);
	}

	public Uups2SessionException (Throwable cause) {
		super (cause);
	}

}
