import object_model.Contact_model;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Delete_Contact_Test extends TestBase {
@BeforeMethod
        public void login_before_delete_contact() {
    HelperUser user = new HelperUser(app.wd);
    HomePageScreen home=new HomePageScreen(app.wd);

    if (!user.user_logged()){
        home.go_to_login_page();
        user.login("ftoгfpsd@gmail.com","asdsbzsd@M2");

    }


}
@Test(dataProvider = "data_new_contact",dataProviderClass = Data_Provider.class)
    public void delete_contact(String type,Contact_model contact,String added_contact){
if(!type.startsWith("positive"))
    return;

new ContactPage(app.wd).delete_contact(added_contact);
Assert.assertTrue(new ContactPage(app.wd).check_contact_deleted(added_contact));




}






}
