package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddressesPage clickAddressesButton() {
        WebElement addressesButton = driver.findElement(By.xpath("//a[@title='Addresses']"));
        addressesButton.click();
        return new AddressesPage(driver);
    }

    public ResultsPage searchProduct(){
        WebElement searchInput = driver.findElement(By.name("s"));
        searchInput.sendKeys("Hummingbird Printed Sweater");
        searchInput.submit();
        return new ResultsPage(driver);
    }

}
