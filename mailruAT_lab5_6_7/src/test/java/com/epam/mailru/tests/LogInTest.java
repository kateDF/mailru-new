package com.epam.mailru.tests;

import com.epam.mailru.entity.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    private static final String EMAIL_DOMAIN = "@mail.ru";
    private static final User defaultUser = User.getDefaultUser();

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
    }

    @Test
    public void logInTest() {
        steps.logIn(defaultUser);
        String actualUser = steps.getCurrentUser();
        Assert.assertEquals(actualUser, defaultUser.getUsername() + EMAIL_DOMAIN,
                "Should be:" + defaultUser.getUsername() + EMAIL_DOMAIN + ", but actual user: " + actualUser);
    }

}
