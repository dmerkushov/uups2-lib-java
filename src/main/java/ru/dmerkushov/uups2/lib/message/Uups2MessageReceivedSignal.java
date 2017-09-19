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
package ru.dmerkushov.uups2.lib.message;

import java.util.Objects;
import ru.dmerkushov.signals4j.Signal;

/**
 *
 * @author Dmitriy Merkushov <d.merkushov@gmail.com>
 */
public abstract class Uups2MessageReceivedSignal extends Signal {

	public final Uups2Message message;

	public Uups2MessageReceivedSignal (Uups2Message message) {
		Objects.requireNonNull (message, "message");

		this.message = message;
	}

}
