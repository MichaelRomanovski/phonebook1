import object_model.Contact_model;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContact_page extends HelperUser {

    public AddContact_page(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement field_name;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
   private WebElement field_last_name;
    @FindBy(xpath = "//input[@placeholder='Phone']")
   private WebElement field_phone;

    @FindBy(xpath = "//input[@placeholder='email']")
   private WebElement field_email;

    @FindBy(xpath = "//input[@placeholder='Address']")
    private WebElement field_address;

    @FindBy(xpath = "//button[.='Save']")
     private WebElement save_btn;


    public void type_new_contact(Contact_model contact){
        field_name.click();
        field_name.clear();
        field_name.sendKeys(contact.getName());
        field_last_name.click();
        field_last_name.clear();
        field_last_name.sendKeys(contact.getLast_name());
        field_phone.click();
        field_phone.clear();
        field_phone.sendKeys(contact.getPhone());
        field_email.click();
        field_email.clear();
        field_email.sendKeys(contact.getEmail());
        field_address.click();
        field_address.clear();
        field_address.sendKeys(contact.getAddress());

    }


public void click_on_save_btn(){
        save_btn.click();
        pause(2000);

}

    public ContactPage click_on_save_btn_going_to_contact_page(){
        save_btn.click();
        pause(2000);
        return new ContactPage(driver);
    }

}
