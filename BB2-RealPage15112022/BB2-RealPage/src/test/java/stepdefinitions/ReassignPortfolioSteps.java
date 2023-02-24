package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReassignPortfolioSteps {

    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private ReassignPortfolioPage reassignPortpofio = new ReassignPortfolioPage(WebdriverIntializer.getDriver());
    private OverviewPortfolioPage overviewPage = new OverviewPortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());


    @Given("Go to portfolios tab")
    public void go_to_portfolios_tab() throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
    }

    @When("Select a portfolio to reassign {string}")
    public void select_a_portfolio_to_reassign(String portfolio) throws InterruptedException {

        reassignPortpofio.portfolioToReassign(portfolio);
    }

    @And("reassign the asset to different portfolio {string} {string}")
    public void reassign_the_asset_to_different_portfolio(String assets,String newportfolio) throws InterruptedException {
        reassignPortpofio.reassignPortfolios(assets,newportfolio);
    }

    @Then("check whether the assets are reasigned or not {string} {string}")
    public void check_whether_the_assets_are_reasigned_or_not(String newportfolio,String assets) throws InterruptedException {
        assetporPage.gotoParticularPortfolio(newportfolio);
        overviewPage.assentNamesinPortfolio();
        reassignPortpofio.verifyreassignedPortfolios(assets);
    }
}
