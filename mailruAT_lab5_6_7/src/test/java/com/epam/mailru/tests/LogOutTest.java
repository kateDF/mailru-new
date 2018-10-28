package com.epam.mailru.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    @BeforeMethod
    public void setUpPreconditions(){
        steps.openMainPage();
        steps.logIn(DEFAULT_USER);
    }

    @Test
    public void logOutTest() {
        steps.logOut();
        Assert.assertTrue(steps.checkLogOut(), "User did not log out");
    }

}
