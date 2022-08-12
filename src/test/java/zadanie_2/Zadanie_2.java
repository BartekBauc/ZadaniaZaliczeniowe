package zadanie_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class Zadanie_2 {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @Test
    public void loginAndOrder() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignInButton();                          //kliknięcie SignIn
        MyAccountPage myAccountPage = loginPage.login();                             //zalogowanie
        ResultsPage resultsPage = myAccountPage.searchProduct();                     //szukanie produktu
        SweaterPage sweaterPage = resultsPage.productPageOpen();                     //wybranie Hummingbird Printed Sweater
        Assertions.assertThat(sweaterPage.discountVerification()).contains("20%");   //sprawdza rabat
        CartPage cartPage = sweaterPage.addSweaterToCart("M", "5");      //dodaje sweter o zadanych parametrach do koszyka
        OrderPage orderPage = cartPage.goToOrder();                                  //potwierdza zawartość koszyka i przechodzi do zamówienia
        OrderConfirmationPage orderConfirmationPage = orderPage.fillOrderform();     //uzupełnia dane i potwierdza zamówienie
        try {
            HomePage homePage2 = orderConfirmationPage.takeScreenShot();             //printscreen
        } catch (Exception noPrintScreen) {
            throw new RuntimeException(noPrintScreen);
        }
    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
}
