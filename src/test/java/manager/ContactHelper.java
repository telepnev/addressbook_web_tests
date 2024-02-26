package manager;

import model.ContactDate;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactDate contactDate) {
        openContactPage();
        fillContactForm(contactDate);
        submitContactCreation();
        returnToHomePage();
    }

    private void fillContactForm(ContactDate contactDate) {
        type(By.name("firstname"), contactDate.firstname());
        type(By.name("lastname"), contactDate.lastname());
        type(By.name("address"), contactDate.address());
        type(By.name("mobile"), contactDate.mobile());
        type(By.name("email"), contactDate.email());
    }

    public void modifyContact(ContactDate contact) {
        initContactModifycation();
        fillContactForm(contact);
        submitContactModifycation();
        returnToHomePage();
    }

    public void removeContact() {
        selectContact();
        click(By.xpath("//input[@value='Delete']"));
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.xpath("//h1[contains(text(),'Edit / add address book entry')]"))) {
            click(By.linkText("add new"));
        }
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.xpath("//input[@type='submit'][2]"));
    }

    private void submitContactModifycation() {
        click(By.xpath("//input[@name='update'][2]"));
    }

    private void initContactModifycation() {
        click(By.xpath("//img[@title='Edit']"));
    }

    private void selectContact() {
        click(By.xpath("//input[@name='selected[]']"));
    }
}
