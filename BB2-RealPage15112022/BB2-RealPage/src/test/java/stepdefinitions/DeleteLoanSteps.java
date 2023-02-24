package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.DeleteLoanPage;
import com.pages.DownloadAssetInformationPage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLoanSteps {

    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private DeleteLoanPage delLoan = new DeleteLoanPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to an asset {string}")
    public void go_to_an_asset(String particualrAsset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(particualrAsset);
    }

    @When("go to loans and select a loan to delete {string}")
    public void go_to_loans_and_select_a_loan_to_delete(String name) throws InterruptedException {
        delLoan.clickonLoansTab();
        delLoan.deleteLoan(name);
    }

    @Then("delet the loan and verify {string}")
    public void delet_the_loan_and_verify(String msg) {

        delLoan.verify(msg);
    }
}
