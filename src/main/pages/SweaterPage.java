package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SweaterPage {
    WebDriver driver;

    public SweaterPage(WebDriver driver) {
        this.driver = driver;
    }

    public String discountVerification() {
        return driver.findElement(By.className("discount-percentage")).getText();
    }

    public CartPage addSweaterToCart(String size, String quantity) {
        WebElement sizeOfProduct = driver.findElement(By.id("group_1"));
        sizeOfProduct.sendKeys(size);
//        sizeOfProduct.submit();
        WebElement quantityOfProduct = driver.findElement(By.id("quantity_wanted"));
//        quantityOfProduct.click();
        quantityOfProduct.clear();
        quantityOfProduct.sendKeys(quantity);
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@data-button-action='add-to-cart']"));
        addToCartButton.click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")));
        WebElement goToCartButton = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        goToCartButton.click();
        return new CartPage(driver);
    }
}
