package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {


    @BeforeClass
    public void preCondition(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("hobbit@gmail.com")
                        .password("@1234567Qq@").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");

    }
    @Test (invocationCount = 3)
    public  void  createNewContactSuccess(){
        int i = new Random().nextInt(1000) +1000;
        Contact contact = Contact.builder()
                .name("Walk")
                .lastName("Gutman")
                .email("sdfd"+i+"@gmail.com")
                .phone("147852369")
                .address("Mikonos")
                .description("New")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(), contact.getLastName());
    }

    @Test
    public  void  createContactSuccessReq(){
    }

    @Test
    public  void  createNewWithEmptyName() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("")
                .lastName("Gutman")
                .email("sdfd" + i + "@gmail.com")
                .phone("147852369")
                .address("Mikonos")
                .description("New")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContFormNegative()
                .isErrorContainsText("{name=must not be blank}");

    }
        @AfterClass
    public void  postCondition(){
        new ContactListScreen(driver).logout();
    }
}
