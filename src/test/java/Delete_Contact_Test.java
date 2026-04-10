import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Delete_Contact_Test extends TestBase {
@BeforeMethod
        public void login_before_delete_contact() {
    HelperUser user = new HelperUser(app.wd);
    if (!user.user_logged()){
        user.login("ftoгfpsd@gmail.com","asdsbzsd@M2");
    }


}
@Test
    public void delete_contact(){






}






}
