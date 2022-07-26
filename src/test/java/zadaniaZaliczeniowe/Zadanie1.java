//package zadaniaZaliczeniowe;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pages.*;
//
//public class Zadanie1 {
//
//    private WebDriver driver;
//
//    @BeforeEach
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://mystore-testlab.coderslab.pl/index.php");
//    }
//
//    @Test
//    public void loginAndAddNewAddress() {
//        HomePage2 homePage2 = new HomePage2(driver);
//        LoginPage loginPage = homePage2.clickSignInButton();
//        MyAccountPage myAccountPage = loginPage.login();
//        AddressesPage addressesPage = myAccountPage.clickAddressesButton();
//        NewAddressPage newAddressPage = addressesPage.clickCreateNewAddressButton();
//
//
//    }
//
////    @AfterEach
////    public void tearDown(){
////        driver.quit();
////    }
//
//}
