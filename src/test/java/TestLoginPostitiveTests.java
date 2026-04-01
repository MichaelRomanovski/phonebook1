import object_model.User_model;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class TestLoginPostitiveTests extends TestBase {
    @BeforeSuite
    public void logout(){
        HelperUser user=new HelperUser(app.wd);

        if(user.user_logged()){
            user.loguot();
            user.pause(10);
            Assert.assertTrue(user.isElementPresent(By.xpath("//a[@href='/login']")));
        }

    }
    @BeforeMethod
    public void refreshPage() {
        app.wd.navigate().refresh();
    }


@Test(dataProvider = "data_login", dataProviderClass = Data_Provider.class)
    public void testLogin(String type,User_model user,String expectedMessage){
if(!type.startsWith("positive"))
    return;

HomePageScreen home=new HomePageScreen(app.wd);
Assert.assertTrue(home.go_to_login_page().login(user.getEmail(),user.getPassword()).conatcts_link.
        isDisplayed());


    }


}
