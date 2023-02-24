package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.AssetPortfolioPage;
import com.pages.LoginPage;
import com.pages.PortfolioPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KPIPorfolioSteps {
    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("go to a specific portfolio {string}")
    public void go_to_a_specific_portfolio(String newportfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        assetporPage.gotoParticularPortfolio(newportfolio);
    }

    @When("capture the kpi Data and got to specific assets in portfolio")
    public void capture_the_kpi_data_and_got_to_specific_assets_in_portfolio() {

    }

    @And("go to cashflows for data")
    public void go_to_cashflows_for_data() {

    }

    @Then("verify the Data")
    public void verify_the_data() {

    }
}
