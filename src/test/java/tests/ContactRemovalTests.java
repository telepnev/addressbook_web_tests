package tests;

import model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        openContactPage();
        if (!isContactPresent()) {
            createContact(new ContactDate(
                    "test_firstname",
                    "test_lastname",
                    "test_address",
                    "test_mobile",
                    "test_email"
            ));
        }
        removeContact();
    }

}
