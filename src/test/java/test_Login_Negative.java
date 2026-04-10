import object_model.User_model;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_Login_Negative extends TestBase {
    @BeforeMethod
    public void logout(){
        HelperUser user=new HelperUser(app.wd);

        if(user.user_logged()){
            user.loguot();
            Assert.assertTrue(user.isElementPresent(By.xpath("//a[@href='/login']")));
        }



    }

    @BeforeMethod(alwaysRun = true)
    public void refreshPage() {
        app.wd.navigate().refresh();
    }


   @Test (dataProvider = "data_login",dataProviderClass = Data_Provider.class)
   public void testlogin(String type, User_model user,String expected_message){
HomePageScreen home=new HomePageScreen(app.wd);
if(!type.startsWith("negative"))
return;

home.go_to_login_page().login(user.getEmail(),user.getPassword());
Assert.assertTrue(new LoginRegistrationPage(app.wd).is_allert_present(expected_message));
Assert.assertTrue(new LoginRegistrationPage(app.wd).is_current_page());






   }











}
