/*
 * Copyright 2020-2022 DiffPlug
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.spotless.maven.generic;

import org.apache.maven.plugins.annotations.Parameter;

import com.diffplug.spotless.generic.FenceStep;

public class ToggleOffOn {
	@Parameter
	public String off = FenceStep.defaultToggleOff();

	@Parameter
	public String on = FenceStep.defaultToggleOn();

	@Parameter
	public String regex;

	public FenceStep createFence() {
		if (regex != null) {
			return FenceStep.named(FenceStep.defaultToggleName()).regex(regex);
		} else {
			return FenceStep.named(FenceStep.defaultToggleName()).openClose(off, on);
		}
	}
}
