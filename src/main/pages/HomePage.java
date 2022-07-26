package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public HomePage openPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        return this;
    }
    public LoginPage clickSignInButton(){
        WebElement signInButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signInButton.click();
        return new LoginPage(driver);
    }
}
