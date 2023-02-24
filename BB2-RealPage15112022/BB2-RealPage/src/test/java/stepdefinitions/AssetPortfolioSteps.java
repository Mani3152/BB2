package stepdefinitions;

import com.driver.WebdriverIntializer;

import com.pages.AssetPortfolioPage;
import com.pages.CreateLoanPage;
import com.pages.LoginPage;
import com.pages.PortfolioPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssetPortfolioSteps {

    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private CreateLoanPage createLoanPage = new CreateLoanPage(WebdriverIntializer.getDriver());

    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to an asset and change the portfolio for it {string} {string}")
    public void go_to_an_asset_and_change_the_portfolio_for_it(String asset, String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        createLoanPage.gotToAssetPage();
        assetporPage.changePortfolio(asset,portfolio);
    }

    @When("Go to portfolios")
    public void go_to_portfolios() throws InterruptedException {
        portfoliopage.goToPortfolios();
    }

    @Then("verify the asset are updated in the portfolios {string} {string}")
    public void verify_the_asset_are_updated_in_the_portfolios(String asset,String portfolio) throws InterruptedException {
       assetporPage.gotoParticularPortfolio(portfolio);
       assetporPage.checkAssetsinPortfolio(asset);
    }
}
