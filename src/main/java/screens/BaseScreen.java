package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {

    AppiumDriver<AndroidElement> driver;

    public BaseScreen(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); //findBy(....)
    }

    //helper base with method

    public  void type(AndroidElement element, String text){


            element.click();
            element.clear();
        if (text!=null){
            element.sendKeys(text);
        }
    }
}
