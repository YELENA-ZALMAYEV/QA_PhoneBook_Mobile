package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityTextView;

    @FindBy(xpath = "//*[@content-desc='More options']")
    AndroidElement menuOptions;

    @FindBy (xpath = "//*[@content-desc='More option']")
    List <AndroidElement> menuOptionList;

    @FindBy(xpath = "//*[@text='Logout']")
    AndroidElement logoutBtn;

    @FindBy (xpath = "//*[@content-desc='add']")
    AndroidElement plusBtn;

    @FindBy (xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List <AndroidElement> contactNameList;

    @FindBy (xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowContainer']")
   List< AndroidElement>  contactList;




    public boolean isActivityTitleDisplayed(String text){

      //  return activityTextView.getText().contains("Contact List"); //need wait
        return isShouldHave(activityTextView,text,15);
    }

    public  AuthenticationScreen logout(){
        if(activityTextView.getText().equals("Contact list")) {
            menuOptions.click();
            logoutBtn.click();
        }
            return new AuthenticationScreen(driver);

    }

    public  AuthenticationScreen logout2(){
        if (isElementDisplayed(menuOptions)){
            menuOptions.click();
            logoutBtn.click();
        }
        return  new AuthenticationScreen(driver);
    }

    public AuthenticationScreen logout3(){
        if (isElementPresentInList(menuOptionList)){ //menuOptionList
            menuOptions.click();
            logoutBtn.click();
        }
        return  new AuthenticationScreen(driver);
    }
    public ContactListScreen isAccountOpened() {
        Assert.assertTrue(isActivityTitleDisplayed("Contact list"));
        return  this;
    }

    
    public ContactListScreen errorMassege() {
       Assert.assertTrue(isActivityTitleDisplayed("must be well-formed email address"));
        return this;
    }
     public ContactListScreen errorMassege1(String text){
        checkAlertText(text);
        return  this;
     }


    public AddNewContactScreen openContactForm() {
        if (activityTextView.getText().equals("Contact list")){
            shold(plusBtn, 5);
            plusBtn.click();
        }
        return new AddNewContactScreen(driver);
    }

    public ContactListScreen isContactAddedByName (String name, String lastName){
        isShouldHave(activityTextView, "Contact list", 5);
        System.out.println("size of list" + contactNameList.size());
        boolean isPresent = false;

        for (AndroidElement el: contactNameList){
            if (el.getText().equals(name + "" + lastName)){
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
        return this;
    }

    public ContactListScreen deleteFirstContact() {
        isActivityTitleDisplayed("Contact list");
        AndroidElement first = contactList.get(0);
        Rectangle rectangle = first.getRect();
        int xFrom=rectangle.getX()+ rectangle.getWidth()/8;
        //int xTo= rectangle.getX()+(rectangle.getWidth()/8)*7;
        int xTo = rectangle.getWidth()-xFrom;
        int y=rectangle.getY()+rectangle.getHeight()/2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y)).moveTo(PointOption.point(xTo,y)).release().perform();


        return this;
    }
}
