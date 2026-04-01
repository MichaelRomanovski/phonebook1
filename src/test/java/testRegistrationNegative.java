import object_model.User_model;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class testRegistrationNegative extends TestBase{
    @BeforeSuite(alwaysRun = true)
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

    @Test(dataProvider = "data_registration", dataProviderClass = Data_Provider.class)
    public void testRegistration(String type,User_model user,String expectedMessage)
    {
        if(!type.startsWith("negative"))
            return;

        new LoginRegistrationPage(app.wd)
                .type_field_email_and_password(user.getEmail(), user.getPassword()).click_on_registration_btn();
        Assert.assertTrue(new LoginRegistrationPage(app.wd).is_allert_present(expectedMessage));
        Assert.assertTrue( new LoginRegistrationPage(app.wd).is_current_page());

    }



   // @Test(dataProvider = "data", dataProviderClass = Data_Provider.class)
   // public void testRegistration_negative_empty_email(User_model user)
  //  {

    //    new LoginRegistrationPage(app.wd)
       //         .type_field_email_and_password("", user.getPassword());
      //  new LoginRegistrationPage(app.wd).click_on_registration_btn();
       // new LoginRegistrationPage(app.wd).is_allert_present("Wrong email or password");
       // Assert.assertTrue( new LoginRegistrationPage(app.wd).is_current_page());

    //}
    //@Test(dataProvider = "data", dataProviderClass = Data_Provider.class)
   // public void testRegistration_negative_empty_password(User_model user)
    //{

        //new LoginRegistrationPage(app.wd)
           //     .type_field_email_and_password(user.getEmail(), "");
       // new LoginRegistrationPage(app.wd).click_on_registration_btn();
//new LoginRegistrationPage(app.wd).is_allert_present("Wrong email or password");
       // Assert.assertTrue( new LoginRegistrationPage(app.wd).is_current_page());

   // }



}
