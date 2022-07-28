package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAddressPage {
    WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddressesPage fillAddressForm(String alias, String address, String city, String zipcode, String country, String phone) {
//        WebElement secondResult = new WebDriverWait(driver, Duration.ofSeconds(3))
//                .until(ExpectedConditions.elementToBeClickable(By.name("alias")));
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys(alias);
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);
        WebElement zipcodeInput = driver.findElement(By.name("postcode"));
        zipcodeInput.sendKeys(zipcode);
        WebElement countryInput = driver.findElement(By.name("id_country"));
        countryInput.sendKeys(country);
        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys(phone);
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveButton.click();
        return new AddressesPage(driver);
    }

}
