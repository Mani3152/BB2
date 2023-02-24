package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.EditPortfolioPage;
import com.pages.LoginPage;
import com.pages.PortfolioPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EditPortfolioSteps {

    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
     private EditPortfolioPage editportfoliopage = new EditPortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to Portfolio and Pick a portfolio {string}")
    public void go_to_portfolio_and_pick_a_portfolio(String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        editportfoliopage.go_to_portfolio_and_pick_a_portfolio(portfolio);


    }

    @And("Edit portfolio {string}")
    public void edit_portfolio(String portfolioname) throws InterruptedException {

        editportfoliopage.edit_portfolio(portfolioname);

    }


    @Then("Check weather the changes are made or not {string} {string}")
    public void check_weather_the_changes_are_made_or_not(String portfolioname, String expected_toastermsg) {

        editportfoliopage.check_weather_the_changes_are_made_or_not(portfolioname,expected_toastermsg);

    }

}
