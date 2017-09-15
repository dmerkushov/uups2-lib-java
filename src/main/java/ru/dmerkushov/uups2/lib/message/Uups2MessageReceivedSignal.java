/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib.message;

import java.util.Objects;
import ru.dmerkushov.signals4j.Signal;

/**
 *
 * @author dmerkushov
 */
public abstract class Uups2MessageReceivedSignal extends Signal {

	public final Uups2Message message;

	public Uups2MessageReceivedSignal (Uups2Message message) {
		Objects.requireNonNull (message, "message");

		this.message = message;
	}

}
