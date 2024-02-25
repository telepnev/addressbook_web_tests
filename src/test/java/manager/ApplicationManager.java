package manager;

import model.ContactDate;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected static WebDriver driver;

   public void init() {
        if (driver == null) {
            driver = new FirefoxDriver();
            // веб хук почитать, закрывает драйвер
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));

            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1550, 830));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.id("LoginForm")).click();
            driver.findElement(By.name("pass")).click();
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void createContact(ContactDate contactDate) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contactDate.firstname());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contactDate.lastname());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(contactDate.address());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys(contactDate.mobile());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(contactDate.email());
        driver.findElement(By.xpath("//input[@type='submit'][2]")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        driver.findElement(By.xpath("//input[@name='selected[]']")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void removeGroup() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isContactPresent() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

    public void openContactPage() {
        if (!isElementPresent(By.xpath("//h1[contains(text(),'Edit / add address book entry')]"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    public void openGroupsPage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
    }

    public void createGroup(GroupData group) {
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(group.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(group.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(group.footer());
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }
}