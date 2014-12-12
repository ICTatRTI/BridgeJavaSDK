package org.sagebionetworks.bridge.sdk.integration;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sagebionetworks.bridge.sdk.TestUserHelper;
import org.sagebionetworks.bridge.sdk.TestUserHelper.TestUser;
import org.sagebionetworks.bridge.sdk.UserClient;
import org.sagebionetworks.bridge.sdk.models.users.UserProfile;

public class UserProfileTest {

    private TestUser user;

    @Before
    public void before() {
        user = TestUserHelper.createAndSignInUser(UserProfileTest.class, true);
    }

    @After
    public void after() {
        user.signOutAndDeleteUser();
    }

    @Test
    public void canUpdateProfile() throws Exception {
        final UserClient client = user.getSession().getUserClient();

        UserProfile profile = client.getProfile();
        profile.setFirstName("Davey");
        profile.setLastName("Crockett");

        client.saveProfile(profile);

        profile = client.getProfile();

        assertEquals("First name updated", "Davey", profile.getFirstName());
        assertEquals("Last name updated", "Crockett", profile.getLastName());
    }

}
