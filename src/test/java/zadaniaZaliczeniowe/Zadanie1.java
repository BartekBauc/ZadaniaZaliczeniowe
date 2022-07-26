package zadaniaZaliczeniowe;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class Zadanie1 {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @Test
    public void shouldgotologinpage() {
        loginPage = homePage.clickSignInButton();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
