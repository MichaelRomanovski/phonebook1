import object_model.Contact_model;
import object_model.User_model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class AddContactTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void login_before_add_contact(User_model user) {
        HelperUser helperUser=new HelperUser(app.wd);
        if (!helperUser.user_logged()) {
            new HomePageScreen(app.wd).ckickonHome().go_to_login_page();
          helperUser.login(user.getEmail(),user.getPassword()).go_to_add_contact();
        }
    }
@Test
public void add_contact(String type,Contact_model contact,String added_contact) {
    new AddContact_page(app.wd).type_new_contact(Contact_model.builder().name("Michael")
            .last_name("Romanov")
            .phone("234234234243")
            .email("asdasdd@gmail.com").address("harey_gilad")
            .build());
    new AddContact_page(app.wd).click_on_save_btn();
    new ContactPage(app.wd).scrollingList().contact_is_added(added_contact);


}
}
