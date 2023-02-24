package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.AssetPortfolioPage;
import com.pages.LoansPortfolioPage;
import com.pages.LoginPage;
import com.pages.PortfolioPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoanPortfolioSteps {

    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private LoansPortfolioPage loanporPage = new LoansPortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());


    @Given("Go to portfolio and pick the assets {string}")
    public void go_to_portfolio_and_pick_the_assets(String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        assetporPage.gotoParticularPortfolio(portfolio);
        loanporPage.assentNamesinPortfolio();
        loanporPage.loansCountinPortfolio();

    }

    @When("Go to properties")
    public void go_to_properties() throws InterruptedException {
        loanporPage.gotToAssetPage();
        loanporPage.loansCount();
    }

    @Then("verify the loans are updated in the portfolios {string}")
    public void verify_the_loans_are_updated_in_the_portfolios(String portfolio) {
        loanporPage.verifyLoans();
    }

}
