package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
        app.getUser().fillregistrationLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        //click LoginButton
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
      //click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.Name)
                .setLastname(ContactData.Last_Name)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIl)
                .setAddress(ContactData.ADDRESS)
                .setDescripton(ContactData.DESCRIPTION));
        //click on save button
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.Name));
    }


    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String lastName, String phone, String email, String address, String description){
        //click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastname(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescripton(description));
        //click on save button
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }

    @Test(dataProvider = "addNewContactWithCsv", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderWithCsvFileTest(Contact contact){
        //click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContactForm(contact);
        //click on save button
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();
    }
}
