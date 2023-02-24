package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.AssetPortfolioPage;
import com.pages.LoginPage;
import com.pages.PortfolioPage;
import com.pages.RiskAssumptionsPortfolioPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RiskAssumptionsPortfolioSteps {
    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private RiskAssumptionsPortfolioPage rskPortfolio = new RiskAssumptionsPortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("go to protfolio {string}")
    public void go_to_protfolio(String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        assetporPage.gotoParticularPortfolio(portfolio);
    }

    @When("go to riskassumptions")
    public void go_to_riskassumptions() throws InterruptedException {
        rskPortfolio.riskassumptionsClick();
    }

    @Then("verify the data in risk assumptions {string} {string}")
    public void verify_the_data(String keyword,String simulation) throws InterruptedException {
        rskPortfolio.simulationsTab(keyword,simulation);
    }
}
