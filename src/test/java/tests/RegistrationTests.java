package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class RegistrationTests extends AppiumConfig {

    @Test
    public  void  registrationSuccess(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        boolean result = new AuthenticationScreen(driver).fillEmail("pip"+i+"a@gmail.com")
                .fillPassword("@1234567Qq@")
                .submitRegistr()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

}
