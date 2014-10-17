package org.sagebionetworks.bridge.sdk;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.sagebionetworks.bridge.sdk.models.SignInCredentials;

public class UserManagementApiCallerTest {

    private static ClientProvider provider;
    private static UserManagementApiCaller userManagementApi;

    @BeforeClass
    public static void initialSetup() {
        provider = ClientProvider.valueOf();
        userManagementApi = UserManagementApiCaller.valueOf(provider);

        String adminEmail = provider.getConfig().getAdminEmail();
        String adminPassword = provider.getConfig().getAdminPassword();
        SignInCredentials signIn = SignInCredentials.valueOf().setUsername(adminEmail).setPassword(adminPassword);
        provider.signIn(signIn);
    }

    @Test
    public void canCreateUserAndRevokeConsentAndDeleteUser() {
        String email = "testingggggg@sagebase.org";
        String username = "test_username_42";
        String password = "f4keP455word";
        boolean consent = true;

        boolean result = userManagementApi.createUser(email, username, password, consent);
        assertTrue(result);

        result = userManagementApi.revokeAllConsentRecords(email);
        assertTrue(result);

        result = userManagementApi.deleteUser(email);
        assertTrue(result);
    }
}