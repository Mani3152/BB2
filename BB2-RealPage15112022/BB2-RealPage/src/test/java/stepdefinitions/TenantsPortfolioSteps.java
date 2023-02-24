package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TenantsPortfolioSteps {

    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private LoansPortfolioPage loanporPage = new LoansPortfolioPage(WebdriverIntializer.getDriver());
    private TenantsPortfolioPage tenantporPage = new TenantsPortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to portfolio and pick a portfolio {string}")
    public void go_to_portfolio_and_pick_a_portfolio(String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        assetporPage.gotoParticularPortfolio(portfolio);
        tenantporPage.assentNamesinPortfolio();
        tenantporPage.tenantsCountinPortfolio();
    }

    @When("Go to properties for assets present in the portfolio under the tenants")
    public void go_to_properties_for_assets_present_in_the_portfolio_under_the_tenants() throws InterruptedException {
        loanporPage.gotToAssetPage();
        tenantporPage.tenantsCount();
    }

    @Then("verify the tenants are updated in the portfolios {string}")
    public void verify_the_tenants_are_updated_in_the_portfolios(String portfolio) {

        tenantporPage.verifyTenants();
    }

}
