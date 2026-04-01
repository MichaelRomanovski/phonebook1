
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver driver) {
        super(driver);
    }


    public boolean user_logged(){
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public ContactPage login(String email,String password)
    {
    new LoginRegistrationPage(driver).type_field_email_and_password(email,password);
    new LoginRegistrationPage(driver).click_on_LOGIN_btn();
return new ContactPage(driver);

    }

    public void loguot(){
        driver.findElement(By.xpath("//*[.='Sign Out']")).click();

    }



}

