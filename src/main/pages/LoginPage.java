package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public MyAccountPage login() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("User321321@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Psswd321");
        WebElement signinbutton = driver.findElement(By.id("submit-login"));
        signinbutton.click();
        return new MyAccountPage(driver);
    }
}
