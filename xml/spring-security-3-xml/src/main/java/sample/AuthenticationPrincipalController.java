/*
 * Copyright 2002-2016 the original author or authors.
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
package sample;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demonstrates the use of {@link AuthenticationPrincipal} on a method argument.
 * See test sample.web.AuthenticationPrincipalTests.
 *
 * @author Joe Grandja
 */
@RestController
public class AuthenticationPrincipalController {

	@RequestMapping(value = "/principal", method = RequestMethod.GET)
	public String principal(@AuthenticationPrincipal String principal) {
		return principal;
	}

}