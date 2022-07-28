package zadaniaZaliczeniowe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class Zadanie_1 {
    private WebDriver driver;
    private static final String EXPECTED_TEXT = "Username Userlastname\n" +
                                                "BakerStreet221B\n" +
                                                "London\n" +
                                                "NW16XE\n" +
                                                "United Kingdom\n" +
                                                "123456789";
    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private AddressesPage addressesPage;
    private NewAddressPage newAddressPage;

    @Given("niezalogowany uzytkownik jest na stronie glownej")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.openPage();
    }

    @When("kliknie w SignIn")
    public void clickSignIn() { loginPage = homePage.clickSignInButton();}

    @And("zaloguje sie")
    public void logIn() {myAccountPage = loginPage.login();}

    @And("^doda adres (.*) (.*) (.*) (.*) (.*) (.*)")
    public void fillForm(String alias, String address, String city, String zipcode, String country, String phone){
        addressesPage = myAccountPage.clickAddressesButton();
        newAddressPage = addressesPage.clickCreateNewAddressButton();
        addressesPage = newAddressPage.fillAddressForm(alias, address, city, zipcode, country, phone);
    }

    @Then("adres jest poprawnie dodany")
    public void verification() {
        Assertions.assertThat(addressesPage.newaddressverification()).isEqualTo(EXPECTED_TEXT);
//    }
//    public void tearDown() {
        driver.quit();
    }






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
//    @AfterEach
//    public void tearDown(){
//        driver.quit();
//    }

}
