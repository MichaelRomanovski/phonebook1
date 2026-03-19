import object_model.User_model;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testLoginPageNegative extends TestBase{

@BeforeSuite
public void go_to_login(){

    new HomePageScreen(app.wd).go_to_login_page();

}

    @Test(dataProvider = "data", dataProviderClass = Data_Provider.class)
    public void testRegistration_negative_user_already_exist(User_model user)
    {

        new LoginRegistrationPage(app.wd)
                .type_field_email_and_password(user.getEmail(), user.getPassword());
        new LoginRegistrationPage(app.wd).click_on_registration_btn();
        new LoginRegistrationPage(app.wd).is_allert_present("User already exist");
        Assert.assertTrue( new LoginRegistrationPage(app.wd).is_current_page());


    }



    @Test(dataProvider = "data", dataProviderClass = Data_Provider.class)
    public void testRegistration_negative_empty_email(User_model user)
    {

        new LoginRegistrationPage(app.wd)
                .type_field_email_and_password("", user.getPassword());
        new LoginRegistrationPage(app.wd).click_on_registration_btn();
        new LoginRegistrationPage(app.wd).is_allert_present("Wrong email or password");
        Assert.assertTrue( new LoginRegistrationPage(app.wd).is_current_page());

    }
    @Test(dataProvider = "data", dataProviderClass = Data_Provider.class)
    public void testRegistration_negative_empty_password(User_model user)
    {

        new LoginRegistrationPage(app.wd)
                .type_field_email_and_password(user.getEmail(), "");
        new LoginRegistrationPage(app.wd).click_on_registration_btn();
        new LoginRegistrationPage(app.wd).is_allert_present("Wrong email or password");
        Assert.assertTrue( new LoginRegistrationPage(app.wd).is_current_page());

    }



}
