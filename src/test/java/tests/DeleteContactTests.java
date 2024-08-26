package tests;

import config.AppiumConfig;

import models.Auth;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class DeleteContactTests extends AppiumConfig {

    @BeforeClass
    public void preCondition() {
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("hobbit@gmail.com").password("@1234567Qq@").build())
                .submitLogin();
    }

    @Test
    public  void deleteFirstContact(){
        new ContactListScreen(driver)
                .deleteFirstContact();
    }
}
