package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.*;
import com.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class SimulationCalculationsSteps {

    private CreateLoanPage createLoanPage = new CreateLoanPage(WebdriverIntializer.getDriver());
    private SimulationsCalculationsPage calPage = new SimulationsCalculationsPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());

    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to asset {string}")
    public void go_to_asset(String asset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
       createLoanPage.gotToAssetPage();
       createLoanPage.clickOnparticularAsset(asset);
    }

    @When("Take the Cashflow values in Valuations")
    public void take_the_cashflow_values_in_valuations(String seedValue) throws Exception {
        calPage.clickOnValutiosnTab();
//        calPage.apiData();
        calPage.readCashFlowTable();
        calPage.clickOnLoansTab();
        calPage.loansSum();
        calPage.clickOnDetailsTab();
        calPage.capitalRate();
        calPage.clickonRiskTab();
        calPage.riskValues(seedValue);
//        portfoliopage.goToPortfolios();
//        calPage.gotoParticularPortfolio();
//        calPage.gotoJsonPage();
//        calPage.accessPythonCode();
//        Utils.combineExcel();
    }

    @And("Insert these data into the excel {string} {string} {string}")
    public void insert_these_data_into_the_excel(String file, String sheet,String seedValue) throws IOException {
        calPage.updateDataInExcel(file,sheet);

    }

    @And("Take the values in the other sheets of excel {string} {string}")
    public void take_the_values_in_the_other_sheets_of_excel(String fileOutput,String sheetOutput) throws IOException {
        calPage.datafromPythonOutput(fileOutput,sheetOutput);
    }

    @Then("Compare the values with json")
    public void compare_the_values_with_json() {

        calPage.compareValues();
    }

}
