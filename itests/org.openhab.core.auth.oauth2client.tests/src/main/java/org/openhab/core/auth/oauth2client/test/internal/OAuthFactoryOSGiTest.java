/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.core.auth.oauth2client.test.internal;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.junit.Before;
import org.junit.Test;
import org.openhab.core.auth.client.oauth2.OAuthClientService;
import org.openhab.core.auth.client.oauth2.OAuthFactory;
import org.openhab.core.auth.oauth2client.internal.OAuthFactoryImpl;
import org.openhab.core.test.java.JavaOSGiTest;

/**
 * Test for {@link OAuthFactoryImpl}.
 *
 * @author Christoph Weitkamp - Initial contribution
 */
@NonNullByDefault
public class OAuthFactoryOSGiTest extends JavaOSGiTest {

    private @NonNullByDefault({}) OAuthFactory oAuthFactory;

    @Before
    public void setup() {
        registerVolatileStorageService();

        oAuthFactory = getService(OAuthFactoryImpl.class);
    }

    @Test
    public void testCreateOAuthClientService() {
        OAuthClientService service = oAuthFactory.createOAuthClientService("My Handle", "My Token URL", null,
                "My Client Id", null, null, null);
        assertThat(service, is(notNullValue()));
    }
}
