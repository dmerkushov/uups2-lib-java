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
class Uups2ServerException extends Uups2LibException {

	public Uups2ServerException () {
	}

	public Uups2ServerException (String message) {
		super (message);
	}

	public Uups2ServerException (String message, Throwable cause) {
		super (message, cause);
	}

	public Uups2ServerException (Throwable cause) {
		super (cause);
	}

}
