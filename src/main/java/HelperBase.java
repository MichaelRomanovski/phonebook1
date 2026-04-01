import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(By locator) {
        try {
           driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean is_allert_present(String alert) {
        Alert alert1 = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        if (alert == null) {

            return false;
        }
        String alertText =alert1.getText();
        alertText.equalsIgnoreCase(alert);
        driver.switchTo().alert();
        alert1.accept();

        return true;
    }


public WebElement wait_for(WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));




}


    }




