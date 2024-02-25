package tests;

import model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        app.openContactPage();
        if (!app.isContactPresent()) {
            app.createContact(new ContactDate(
                    "test_firstname",
                    "test_lastname",
                    "test_address",
                    "test_mobile",
                    "test_email"
            ));
        }
        app.removeContact();
    }

}
