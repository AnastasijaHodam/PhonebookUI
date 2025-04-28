package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest(){
        logger.info("Login with data-->"+ UserData.EMAIL+"****************************"+UserData.PASSWORD);
        //click on Login Link
        app.getUser().clickOnLoginLink();
        //enter Email to email field
        app.getUser().fillregistrationLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        //click LoginButton
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest(){
        //click on Login Link
        app.getUser().clickOnLoginLink();
        //enter Email to email field
        app.getUser().fillregistrationLoginForm(new User().setPassword(UserData.PASSWORD));
        //click LoginButton
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
