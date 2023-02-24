package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.AddandDeleteTagsPortfolioPage;
import com.pages.AssetPortfolioPage;
import com.pages.LoginPage;
import com.pages.PortfolioPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddandDeleteTagsPortfolio {
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private AddandDeleteTagsPortfolioPage addanddeleteportfoliotagspage = new AddandDeleteTagsPortfolioPage(WebdriverIntializer.getDriver());
    private AssetPortfolioPage assetporPage = new AssetPortfolioPage(WebdriverIntializer.getDriver());

    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to portfolio and click any portfolio {string}")
    public void go_to_portfolio_and_click_any_portfolio(String portfolio) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        assetporPage.gotoParticularPortfolio(portfolio);


    }

    @When("Click on SearchDropdown {string}")
    public void click_on_search_dropdown(String keyword) throws InterruptedException {

        addanddeleteportfoliotagspage.click_on_search_dropdown(keyword);

    }

    @And("Click on Add Tag {string} {string}")
    public void click_on_add_tag(String addtags, String expected_toastmsg) throws InterruptedException {

        addanddeleteportfoliotagspage.click_on_add_tag(addtags, expected_toastmsg);

    }

    @Then("Delete the Addedtags {string} {string}")
    public void delete_the_addedtags(String deletetags, String expected_toastermsg) throws InterruptedException {

        addanddeleteportfoliotagspage.delete_the_addedtags(deletetags, expected_toastermsg);


    }
}
