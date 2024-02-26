package tests;

import model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase{
    @Test
    public void canModifyContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactDate(
                    "test_firstname",
                    "test_lastname",
                    "test_address",
                    "test_mobile",
                    "test_email"
            ));
        }
        app.contacts().modifyContact(new ContactDate().withFirstname("Evgen_modify"));

    }
}
