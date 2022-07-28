package zadanie_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class Zadanie_2 {

    private WebDriver driver;
//    private ResultsPage resultsPage;
//    private SweaterPage sweaterPage;
//    private CartPage cartPage;
//    private OrderPage orderPage;
//    private HomePage homePage;
//    private LoginPage loginPage;
//    private MyAccountPage myAccountPage;
//    private AddressesPage addressesPage;
//    private NewAddressPage newAddressPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @Test
    public void loginAndAddNewAddress() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignInButton();                          //kliknięcie SignIn
        MyAccountPage myAccountPage = loginPage.login();                             //zalogowanie
        ResultsPage resultsPage = myAccountPage.searchProduct();                     //szukanie produktu
        SweaterPage sweaterPage = resultsPage.productPageOpen();                     //wybranie Hummingbird Printed Sweater
        Assertions.assertThat(sweaterPage.discountVerification()).contains("20%");   //sprawdza rabat
        CartPage cartPage = sweaterPage.addSweaterToCart("M", "5");      //dodaje sweter o zadanych parametrach do koszyka
        OrderPage orderPage = cartPage.goToOrder();                                  //potwierdza zawartość koszyka i przechodzi do zamówienia
        OrderConfirmationPage orderConfirmationPage = orderPage.fillOrderform();


    }

//    @AfterEach
//    public void tearDown(){
//        driver.quit();
//    }

}
