package screens;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen {
    public AddNewContactScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    AndroidElement nameEditText;

    @FindBy(xpath = "")
    AndroidElement lastNameEditText;

    @FindBy(xpath = "")
    AndroidElement emailEditText;

    @FindBy(xpath = "")
    AndroidElement phoneEditText;

    @FindBy(xpath = "")
    AndroidElement addressEditText;

    @FindBy(xpath = "")
    AndroidElement descriptionEditText;

    @FindBy(xpath = "")
    AndroidElement createBtn;
}
