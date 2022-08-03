package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {

    WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public SweaterPage productPageOpen() {
        WebElement hummingbirdPrintedSweater = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a"));
        hummingbirdPrintedSweater.click();
        return new SweaterPage(driver);

    }

}
