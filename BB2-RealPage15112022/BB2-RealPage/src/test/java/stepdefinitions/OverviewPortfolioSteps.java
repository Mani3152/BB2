package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.AssetPortfolioPage;
import com.pages.LoginPage;
import com.pages.OverviewPortfolioPage;
import com.pages.PortfolioPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OverviewPortfolioSteps {


    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private OverviewPortfolioPage overviewPage = new OverviewPortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to a Specific Portfolio {string}")
    public void go_to_a_specific_portfolio(String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        assetporPage.gotoParticularPortfolio(portfolio);
        overviewPage.assentNamesinPortfolio();
    }

    @When("Get the Data present in portfolio tab")
    public void get_the_data_present_in_portfolio_tab() {

        overviewPage.incomeCalculation();
    }

    @And("Calculate the values")
    public void calculate_the_values() throws InterruptedException {
        overviewPage.sampleout();
        overviewPage.portfoliometrics();
    }

    @Then("compare the metrics")
    public void compare_the_metrics() {

        overviewPage.compareMetrics();
    }

}
