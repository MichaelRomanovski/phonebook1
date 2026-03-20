import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class TestLoginPagePositive extends TestBase {

    @Test
    public void testLogin(){
        new HomePageScreen(app.wd).go_to_login_page();
        new LoginRegistrationPage(app.wd)
                .type_field_email_and_password("ftoгfpsd@gmail.com","asdsbzsd@M2");
        new LoginRegistrationPage(app.wd).click_on_LOGIN_btn();
        Assert.assertTrue(new ContactPage(app.wd).conatcts_link.isDisplayed());

    }


}
