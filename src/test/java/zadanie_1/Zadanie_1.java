package zadanie_1;

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

    @Given("that the unloged user is on the home page.")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.openPage();
    }

    @When("clicks \"SignIn\" button")
    public void clickSignIn() {
        loginPage = homePage.clickSignInButton();
    }

    @And("logs in")
    public void logIn() {
        myAccountPage = loginPage.login();
    }

    @And("^adds a new address (.*) (.*) (.*) (.*) (.*) (.*)")
    public void fillForm(String alias, String address, String city, String zipcode, String country, String phone) {
        addressesPage = myAccountPage.clickAddressesButton();
        newAddressPage = addressesPage.clickCreateNewAddressButton();
        addressesPage = newAddressPage.fillAddressForm(alias, address, city, zipcode, country, phone);
    }

    @Then("the user confirms the successful addition of the address")
    public void verification() {
        Assertions.assertThat(addressesPage.newaddressverification()).isEqualTo(EXPECTED_TEXT);
        driver.quit();
    }

}
