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
package ru.dmerkushov.uups2.lib.session;

import ru.dmerkushov.uups2.lib.Uups2LibException;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
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
