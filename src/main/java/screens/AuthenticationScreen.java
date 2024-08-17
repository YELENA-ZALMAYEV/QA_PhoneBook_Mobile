package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen{


    public AuthenticationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

     //user.setEmail("pap@gmail.com");
//        user.setPassword("@1234567Qq@");

    @FindBy (xpath = "")
    AndroidElement emailEditText;

    @FindBy (xpath = "")
    AndroidElement passwordEditText;

    @FindBy (xpath = "")
    AndroidElement loginBtn;

    public AuthenticationScreen fillEmail(String email){
        type(emailEditText, email);
       return this;
    }

    public AuthenticationScreen fillPassword(String password){
        type(passwordEditText, password);
        return this;
    }


}
