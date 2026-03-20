import object_model.Contact_model;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class AddContactTestPositive extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void login_before_add_contact() {
        HelperUser user = new HelperUser(app.wd);

        if (!user.user_logged()) {
            new HomePageScreen(app.wd).go_to_login_page();
          user.login("ftoгfpsd@gmail.com","asdsbzsd@M2");
            new ContactPage(app.wd).go_to_add_contact();
        }
    }
@Test
public void add_contact(){
new AddContact_page(app.wd).type_new_contact(Contact_model.builder().name("Michael")
                .last_name("Romanov")
                .phone("234234234243")
                .email("asdasdd@gmail.com").address("harey_gilad")
        .build());
new AddContact_page(app.wd).click_on_save_btn();
new ContactPage(app.wd).scrollingList();

Assert.assertTrue(new ContactPage(app.wd).contact_is_added("Michael"));
    Assert.assertTrue(new ContactPage(app.wd).contact_is_added("234234234243"));
//Assert.assertTrue(new ContactPage(app.wd).item_of_added_contact.isDisplayed());
        }














}
