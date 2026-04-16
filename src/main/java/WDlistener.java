import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Slf4j
public class WDlistener implements WebDriverListener {
    public WDlistener() {

    }


    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Clicking on: " + element);
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Clicked on: " + element);
    }


    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        System.out.println("ERROR: " + e.getTargetException());
        WebDriver driver = (WebDriver) target;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(src.toPath(),
                    Paths.get("screenshots/error_" + System.currentTimeMillis() + ".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }




}

