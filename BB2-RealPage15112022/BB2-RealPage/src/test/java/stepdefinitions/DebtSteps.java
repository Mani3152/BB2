package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.CreateLoanPage;
import com.pages.DebtPage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DebtSteps {

    private DebtPage debtPage = new DebtPage(WebdriverIntializer.getDriver());
    private CreateLoanPage createLoanPage = new CreateLoanPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());


    @Given("Go To Asset Page For DSCR {string}")
   public void goToAssetOverView(String asset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
       createLoanPage.gotToAssetPage();
       createLoanPage.clickOnparticularAsset(asset);
   }
    @When("Verify DSCR and Occupancy")
    public void verify_dscr_and_occupancy() throws InterruptedException {
        debtPage.verifyDSCRValue();
    }
    @Then("validate DSCR and Occupancy")
    public void validate_dscr_and_occupancy() throws InterruptedException {
        debtPage.occupancyCalculations();
        debtPage.IRRCalculations();
        debtPage.Validate();

    }
}
