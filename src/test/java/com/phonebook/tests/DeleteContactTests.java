package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    //precondition
    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        //login
        app.getUser().clickOnLoginLink();
        app.getUser().fillregistrationLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        //add contact
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.Name)
                .setLastname(ContactData.Last_Name)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIl)
                .setAddress(ContactData.ADDRESS)
                .setDescripton(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        //click on the card
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //verify contact is deleted(by; size)
        Assert.assertEquals(sizeAfter, sizeBefore -1);
    }
}

