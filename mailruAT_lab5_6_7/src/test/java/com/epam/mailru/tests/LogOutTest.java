package com.epam.mailru.tests;

import com.epam.mailru.entity.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    private static final User defaultUser = User.getDefaultUser();

    @BeforeMethod
    public void setUpPreconditions(){
        steps.openMainPage();
        steps.logIn(defaultUser);
    }

    @Test
    public void logOutTest() {
        steps.logOut();
        Assert.assertTrue(steps.checkLogOut(), "User did not log out");
    }

}
