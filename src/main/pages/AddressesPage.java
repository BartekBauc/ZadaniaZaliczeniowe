package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage {

    WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewAddressPage clickCreateNewAddressButton() {
        WebElement createNewAddressButton = driver.findElement(By.xpath("//a[@data-link-action='add-address']"));
        createNewAddressButton.click();
        return new NewAddressPage(driver);
    }
    public String newaddressverification() {
        return driver.findElement(By.xpath("//div[@class='address-body']/address")).getText();
    }
}
