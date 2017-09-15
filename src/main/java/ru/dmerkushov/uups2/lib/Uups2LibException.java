/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib;

/**
 *
 * @author dmerkushov
 */
public class Uups2LibException extends Exception {

	public Uups2LibException () {
	}

	public Uups2LibException (String message) {
		super (message);
	}

	public Uups2LibException (String message, Throwable cause) {
		super (message, cause);
	}

	public Uups2LibException (Throwable cause) {
		super (cause);
	}

}
