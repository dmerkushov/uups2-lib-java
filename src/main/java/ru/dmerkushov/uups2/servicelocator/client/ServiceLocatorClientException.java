/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.servicelocator.client;

/**
 *
 * @author dmerkushov
 */
public class ServiceLocatorClientException extends Exception {

	public ServiceLocatorClientException () {
	}

	public ServiceLocatorClientException (String message) {
		super (message);
	}

	public ServiceLocatorClientException (String message, Throwable cause) {
		super (message, cause);
	}

	public ServiceLocatorClientException (Throwable cause) {
		super (cause);
	}

}
