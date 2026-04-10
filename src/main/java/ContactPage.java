import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactPage extends HelperUser

{

    public ContactPage(WebDriver driver) {
        super(driver);
    }

@FindBy(xpath = "//*[.='CONTACTS']")
    WebElement conatcts_link;

    @FindBy(xpath = "//*[.='ADD']")
    WebElement ADD_LINK;


    @FindBy(xpath = "//div[@class='contact-item_card__2SOIM']")

    WebElement item_of_added_contact;

    @FindBy(xpath = "//div[@class='contact-item_card__2SOIM']")
    List<WebElement> contactList;

    @FindBy(xpath = "//div[@class='contact-item-detailed_card__50dTS']//h2")
   WebElement nameText;

    @FindBy(id="com.sheygam.contactapp:id/lastNameTxt")
    WebElement lastNameText;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/emailTxt']")
    WebElement emailText;

    @FindBy(xpath = "//div[@class='contact-item-detailed_card__50dTS']")
    WebElement phoneText;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/addressTxt']")
    WebElement addressText;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/descTxt']")
    WebElement descriptionText;

    @FindBy(xpath = "//button[.='Remove']")
    WebElement remove_button;


    public void go_to_add_contact(){

ADD_LINK.click();


    }

    public ContactPage scrollingList() {
pause(2000);

        WebElement lastItem = contactList.get(contactList.size() - 1);
        Actions actions=new Actions(driver);
        actions.moveToElement(lastItem).perform();
        lastItem.click();
return this;
      }


public boolean contact_is_added(String contact){
    return nameText.getText().contains(contact) || phoneText.getText().contains(contact);
}

public void delete_contact(){
if(contactList.isEmpty())
    return;
item_of_added_contact.click();
remove_button.click();

}








    }



