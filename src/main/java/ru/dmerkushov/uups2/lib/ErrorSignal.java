/*
 * Copyright 2017 Dmitriy Merkushov <d.merkushov@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.dmerkushov.uups2.lib;

import java.util.Objects;
import ru.dmerkushov.signals4j.Signal;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public class ErrorSignal extends Signal {

	public final String description;
	public final Throwable throwable;

	public ErrorSignal (String description, Throwable throwable) {
		Objects.requireNonNull (description, "description");

		this.description = description;
		this.throwable = throwable;
	}

	public ErrorSignal (String description) {
		this (description, null);
	}

	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append (super.toString ());
		sb.append ("\nERROR: " + description);
		if (throwable != null) {
			sb.append ("\nTHROWABLE:\n");
			sb.append (getFullThrowableMsg (throwable));
		}
		return sb.toString ();
	}

	/**
	 * Get a full message of a throwable: its message, stack trace, and causes
	 * (other Throwables, also described recursively)
	 *
	 * @param throwable
	 * @return
	 */
	public static String getFullThrowableMsg (Throwable throwable) {
		StringBuilder resultBuilder = new StringBuilder ();
		resultBuilder.append (throwable.getClass ().getCanonicalName ())
				.append (": ")
				.append (throwable.getMessage ());

		StackTraceElement[] stackTraceElements = throwable.getStackTrace ();

		if (stackTraceElements != null) {
			if (stackTraceElements.length > 0) {
				resultBuilder.append ("\nStack Trace:\n");

				StackTraceElement stackTraceElement = stackTraceElements[0];
				resultBuilder.append ("\t")
						.append (stackTraceElement.getClassName ())
						.append (":")
						.append (stackTraceElement.getMethodName ())
						.append ("():")
						.append (stackTraceElement.getLineNumber ());

				for (int i = 1; i < stackTraceElements.length; i++) {
					stackTraceElement = stackTraceElements[i];
					resultBuilder.append ("\n\tat ")
							.append (stackTraceElement.getClassName ())
							.append (":")
							.append (stackTraceElement.getMethodName ())
							.append ("():")
							.append (stackTraceElement.getLineNumber ());
				}
			}
		}

		Throwable cause = throwable.getCause ();

		if (cause != null) {
			resultBuilder.append ("\nCaused by:\n")
					.append (getFullThrowableMsg (cause));
		}

		String fullThrowableMsg = resultBuilder.toString ();
		return fullThrowableMsg;
	}
}
