package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.LoginPage;
import com.pages.SalesAssumptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesAssumptionSteps {

    private SalesAssumptionPage sales = new SalesAssumptionPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("click Asset {string}")
    public void click_asset(String particular_asset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        sales.click_Asset(particular_asset);

    }
    @When("user click on valuation {string} {string} {string} {string}")
    public void user_click_on_valuation(String Holding_Period, String Sale_Costs, String Terminal_Rate, String Sale_Price_Adjustment) throws InterruptedException {
        sales.click_valuation(Holding_Period,Sale_Costs,Terminal_Rate,Sale_Price_Adjustment);
    }

    @Then("veify Edit Sale {string} {string} {string} {string}")
    public void veify_edit_sale(String Holding_Period, String Sale_Costs, String Terminal_Rate,String Sale_Price_Adjustment) throws InterruptedException {
        sales.verify_edit(Holding_Period,Sale_Costs,Terminal_Rate,Sale_Price_Adjustment);
    }
}
