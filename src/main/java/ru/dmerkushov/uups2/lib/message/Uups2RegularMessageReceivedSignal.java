/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.message;

/**
 *
 * @author dmerkushov
 */
public class Uups2RegularMessageReceivedSignal extends Uups2MessageReceivedSignal {

	public Uups2RegularMessageReceivedSignal (Uups2RegularMessage message) {
		super (message);
	}

}
