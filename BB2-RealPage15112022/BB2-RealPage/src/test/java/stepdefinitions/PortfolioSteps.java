package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.LoginPage;
import com.pages.PortfolioPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortfolioSteps {

    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to Portfolio Page")
    public void go_to_portfolio_page() throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
    }

    @When("Create  New Portfolio {string} {string} {string} {string}")
    public void create_new_portfolio(String name, String type, String manager, String description) {
        portfoliopage.newPortfolio(name,type,manager,description);
    }

    @Then("Verify the created Portfolio {string}")
    public void verify_the_created_portfolio(String name) throws InterruptedException {
        portfoliopage.createPortfolio(name);
    }
}
