package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderConfirmationPage fillOrderform() {
        WebElement confirmAddressButton = driver.findElement(By.name("confirm-addresses"));
        confirmAddressButton.click();
        WebElement confirmDeliveryButton = driver.findElement(By.name("confirmDeliveryOption"));
        confirmDeliveryButton.click();
        WebElement payment = driver.findElement(By.id("payment-option-1"));
        payment.click();
        WebElement conditions = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
        conditions.click();
        WebElement orderButton = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        orderButton.click();
        return new OrderConfirmationPage(driver);
    }
}
