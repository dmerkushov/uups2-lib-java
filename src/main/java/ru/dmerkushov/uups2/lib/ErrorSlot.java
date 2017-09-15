/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.uups2.lib;

import ru.dmerkushov.signals4j.Slot;
import ru.dmerkushov.signals4j.SlotException;

/**
 *
 * @author dmerkushov
 */
public class ErrorSlot extends Slot<ErrorSignal> {

	@Override
	public void threadsafeHandle (ErrorSignal signal) throws SlotException {
		System.err.println (signal.toString ());
	}

}
