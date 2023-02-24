package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.AssetPortfolioPage;
import com.pages.DataSourcesPortfolioPage;
import com.pages.LoginPage;
import com.pages.PortfolioPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataSourcesPortfolioSteps {

    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private DataSourcesPortfolioPage dsPortfolio = new DataSourcesPortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("go to portfolio {string}")
    public void go_to_portfolio(String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        assetporPage.gotoParticularPortfolio(portfolio);
    }

    @When("go to data sources {string}")
    public void go_to_data_sources(String keyword) throws InterruptedException {
        dsPortfolio.clickonDatSources();
        dsPortfolio.checkDataSources(keyword);
    }

    @Then("verify the data {string}")
    public void verify_the_data(String keyword) throws InterruptedException {
        dsPortfolio.checkDataSets(keyword);
    }

}
