package tests;

import model.ContactDate;
import org.junit.jupiter.api.Test;

public class CreateContactTests extends TestBase {
    @Test
    public void canCreateContactTest() {
        openContactPage();
        createContact(new ContactDate
                (
                        "Evgeny",
                        "Telepnev",
                        "Mars, city Akanzas",
                        "+8988879797",
                        "mail@mail.ru"
                ));
    }

    @Test
    public void canCreateContactWithEmptyField() {
        openContactPage();
        createContact(new ContactDate("", "", "", "", ""));
    }

}
