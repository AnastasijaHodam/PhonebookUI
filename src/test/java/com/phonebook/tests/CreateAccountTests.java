package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
            public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){

        //click on Login Link
        app.getUser().clickOnLoginLink();
        //enter Email to email field
        app.getUser().fillregistrationLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify SignOut buttton is displayed
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //click on Login Link
        app.getUser().clickOnLoginLink();
        //enter Email to email field
        app.getUser().fillregistrationLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify Alert is displayed
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }

}
