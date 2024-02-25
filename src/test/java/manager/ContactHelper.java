package manager;

import model.ContactDate;
import org.openqa.selenium.By;

public class ContactHelper {
    private final ApplicationManager manager;

    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void createContact(ContactDate contactDate) {
        openContactPage();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contactDate.firstname());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contactDate.lastname());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contactDate.address());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contactDate.mobile());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contactDate.email());
        manager.driver.findElement(By.xpath("//input[@type='submit'][2]")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        manager.driver.findElement(By.xpath("//input[@name='selected[]']")).click();
        manager.driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.xpath("//h1[contains(text(),'Edit / add address book entry')]"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }
}
