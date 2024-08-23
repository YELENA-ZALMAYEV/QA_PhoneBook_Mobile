package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthenticationScreen extends BaseScreen{


    public AuthenticationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

     //user.setEmail("pap@gmail.com");
//        user.setPassword("@1234567Qq@");

    @FindBy (xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputEmail']")
    AndroidElement emailEditText;

    @FindBy (id = "com.sheygam.contactapp:id/inputPassword")
    AndroidElement passwordEditText;

    @FindBy (xpath = "//*[@text ='LOGIN']")
    AndroidElement loginBtn;

    @FindBy(xpath = "//*[@text = 'REGISTRATION']")
    AndroidElement registrBtn;

    public AuthenticationScreen fillEmail(String email){
        //pause(500);
        shold(emailEditText,10);
        type (emailEditText, email);
       return this;
    }

    public AuthenticationScreen fillPassword(String password){
        type(passwordEditText, password);
        return this;
    }

    public  ContactListScreen submitLogin(){    //return new screen
        loginBtn.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen submitRegistr(){
        registrBtn.click();
        return new ContactListScreen(driver);
    }

    public AuthenticationScreen fillLoginRegistrationForm(Auth auth) {
        shold(emailEditText,10);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        return  this;
    }

    public AuthenticationScreen submitLoginNegative() {
        loginBtn.click();
        return this;
    }

    public AuthenticationScreen isErrorMessageContainsText(String text) {
        Alert alert = new WebDriverWait(driver,10)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();

        return this;
    }
}
