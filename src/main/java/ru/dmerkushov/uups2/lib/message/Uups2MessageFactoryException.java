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
class Uups2MessageFactoryException extends Uups2LibException {

	public Uups2MessageFactoryException () {
	}

	public Uups2MessageFactoryException (String message) {
		super (message);
	}

	public Uups2MessageFactoryException (String message, Throwable cause) {
		super (message, cause);
	}

	public Uups2MessageFactoryException (Throwable cause) {
		super (cause);
	}

}
