package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class LoginTestSecond extends AppiumConfig {

    @Test
    public  void  loginSuccess(){
        new AuthenticationScreen(driver)
                .fillEmail("pap@gmail.com")
                .fillPassword("@1234567Qq@")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public  void  loginSuccessModel(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("pap@gmail.com").password("@1234567Qq@").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

//    public void  loginSuccessModel2(){
//        Assert.assertTrue(new AuthenticationScreen(driver)
//                .fillLoginRegistrationForm(Auth.builder().email("pap@gmail.com").password("@1234567Qq@").build())
//                .submitLogin()
//                .isActivityTitleDisplayed("Contact list"));
//    }

}
