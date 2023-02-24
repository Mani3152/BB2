package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortfolioScenarioSteps {
    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private AddScenerioPage scnPage = new AddScenerioPage(WebdriverIntializer.getDriver());
    private PortfolioScenarioPage pscn = new PortfolioScenarioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("go to a portfolio {string}")
    public void go_to_a_portfolio(String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        assetporPage.gotoParticularPortfolio(portfolio);
    }

    @When("click on add Scenario")
    public void click_on_add_scenario() throws InterruptedException {
        pscn.addScenaria();
    }

    @And("give the details {string} {string} {string}")
    public void give_the_details(String name, String Scenarios,String toaster) throws InterruptedException {
        pscn.scenarioSelect(name,Scenarios,toaster);
    }

    @Then("check the Scenario created {string}")
    public void check_the_scenario_created(String name) throws InterruptedException {
        pscn.verify(name);
    }

}
