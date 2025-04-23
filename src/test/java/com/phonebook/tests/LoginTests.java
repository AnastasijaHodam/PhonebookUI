package com.phonebook.tests;

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
        //click on Login Link
        app.getUser().clickOnLoginLink();
        //enter Email to email field
        app.getUser().fillregistrationLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        //click LoginButton
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest(){
        //click on Login Link
        app.getUser().clickOnLoginLink();
        //enter Email to email field
        app.getUser().fillregistrationLoginForm(new User().setPassword("Nnoa12345$"));
        //click LoginButton
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
