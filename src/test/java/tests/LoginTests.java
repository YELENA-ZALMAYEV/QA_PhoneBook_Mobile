package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public  void  loginSuccess(){
     //  boolean result = new SplashScreen(driver)
      //          .checkCurrentVersion("Version 1.0.0")
          boolean result = new AuthenticationScreen(driver).fillEmail("hobbit@gmail.com")
                .fillPassword("@1234567Qq@")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

    @Test
    public void  loginSuccessModel(){
    //  boolean result = new SplashScreen(driver)
     //          .checkCurrentVersion("Version 1.0.0")  //failed without splashScreen (model)
        Assert.assertTrue (new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("hobbit@gmail.com").password("@1234567Qq@").build())
               .submitLogin()
               .isActivityTitleDisplayed("Contact list"));
      //  Assert.assertTrue(result);

    }
     @Test
     public  void loginWrongEmail(){
         new AuthenticationScreen(driver)
                 .fillLoginRegistrationForm(Auth.builder().email("hobbitgmail.com").password("@1234567Qq@").build())
                 .submitLoginNegative()
                 .isErrorMessageContainsText("Login or Password incorrect");
     }

    @Test
    public  void loginWrongPassword(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("hobbitgmail.com").password("@1234567Qq@").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }


    @AfterMethod
    public void postCondition(){
      new ContactListScreen(driver).logout();
    }
}
