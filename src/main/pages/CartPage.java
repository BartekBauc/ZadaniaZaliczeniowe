package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage goToOrder() {
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        proceedToCheckoutButton.click();
        return new OrderPage(driver);
    }
}
