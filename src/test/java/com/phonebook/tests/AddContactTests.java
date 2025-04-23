package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    //login

    @BeforeMethod
            public void precondition(){

        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        //click on Login Link
        app.getUser().clickOnLoginLink();
        //enter Email to email field
        app.getUser().fillregistrationLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        //click LoginButton
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){
      //click on Add link
        app.getContact().clickOnAddLink();

        //enter name
        app.getContact().fillContactForm(new Contact()
                .setName("Oliver")
                .setLastname("Adam")
                .setPhone("01234567890")
                .setEmail("Karla@gmail.com")
                .setAddress("Rishon")
                .setDescripton("QA"));
        //click on save button
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactAdded("Oliver"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();
    }

}
