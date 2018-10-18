package com.epam.mailru.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    private static final String USERNAME = "autesttest";
    private static final String PASSWORD = "test12345";

    @BeforeMethod
    public void setUpPreconditions(){
        steps.openMainPage();
        steps.logIn(USERNAME, PASSWORD);
    }

    @Test
    public void logOutTest() {
        steps.logOut();
        Assert.assertTrue(steps.checkLogOut(), "User did not log out");
    }

}
