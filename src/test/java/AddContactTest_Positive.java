import object_model.Contact_model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class AddContactTest_Positive extends TestBase {
    @BeforeMethod()
    public void login_before_add_contact() {
        HelperUser helperUser = new HelperUser(app.wd);
        if (!helperUser.user_logged()) {
            new HomePageScreen(app.wd).ckickonHome().go_to_login_page();
            helperUser.login("ftoгfpsd@gmail.com", "asdsbzsd@M2").go_to_add_contact();
        }
    }
    @BeforeMethod(alwaysRun = true)
    public void refreshPage() {
        app.wd.navigate().refresh();
    }

    @Test(dataProvider = "data_new_contact",dataProviderClass = Data_Provider.class)
public void add_contact(String type,Contact_model contact,String added_contact) {
        if(!type.startsWith("positive"))
            return;

    new AddContact_page(app.wd).type_new_contact(Contact_model.builder().name(contact.getName())
            .last_name(contact.getLast_name())
            .phone(contact.getPhone())
            .email(contact.getEmail()).address(contact.getAddress())
            .build());
    new AddContact_page(app.wd).click_on_save_btn_going_to_contact_page().contact_is_added(added_contact);



}
}
