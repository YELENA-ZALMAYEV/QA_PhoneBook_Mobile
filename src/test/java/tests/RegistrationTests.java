package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class RegistrationTests extends AppiumConfig {

    @Test
    public  void  registrationSuccess(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        boolean result = new AuthenticationScreen(driver).fillEmail("hob"+i+"t@gmail.com")
                .fillPassword("@1234567Qq@")
                .submitRegistr()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

    @Test
    public void registrationSuccessModel(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Assert.assertTrue(new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("hob"+i+"t@gmail.com").password("@1234567Qq@").build())
                .submitRegistr()
                .isActivityTitleDisplayed("Contact list"));


    }
     @Test
    public void  registrationWrongEmail(){

        Auth auth = Auth.builder().email("hobtgmail.com").password("@1234567Qq@").build();

        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(auth)
                .submitRegistratioNegative()
                .isErrorMessageContainsText("must be well-formed email address");

     }

    @Test
    public void  registrationWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Auth auth = Auth.builder().email("hob"+i+"t@gmail.com").password("@123456").build();

        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(auth)
                .submitRegistratioNegative()
                .isErrorMessageContainsText("At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}");

    }

    @Test
    public void  registrationErrorUserExist(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Auth auth = Auth.builder().email("hobbit@gmail.com").password("@1234567Qq@").build();

        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(auth)
                .submitRegistratioNegative()
                .isErrorMessageContainsText("User already exists");

    }

//    @Test
//    public void postCondition(){
//        new ContactListScreen(driver)
//        .logout();
//    }
}
