package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.CreateLoanPage;
import com.pages.DownloadAssetInformationPage;
import com.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLoansSteps {

    private CreateLoanPage createLoanPage = new CreateLoanPage(WebdriverIntializer.getDriver());
    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go To LoansPage {string}")
    public void goToLoansPage(String asset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(asset);
        createLoanPage.clickOnLoans();
    }


    @When("Create New Loan {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void createNewLoan(String externalCode,String loanName,String lender,String servicer,String loanType,String leinPosition,String loanStatus,
                              String originalBalance, String currentBalance,String originationDate, String maturityDate,
                              String rateType, String rate, String daysConvention,String margin ,String paymentType, String amStartDate, String amTerm, String amType,String term) throws InterruptedException {
        createLoanPage.newLoan();
        createLoanPage.enterDetailsIntoGeneralTab(externalCode,loanName,lender,servicer,loanType,leinPosition,loanStatus);
        createLoanPage.enterDetailsIntoBalanceTab(originalBalance, currentBalance);
        createLoanPage.enterDetailsIntoTermTab(originationDate, maturityDate,term);
        createLoanPage.enterDetailsintoRateTab(rateType, rate, daysConvention,margin);
        createLoanPage.enterDetailsIntoPaymentTab(paymentType, amStartDate, amTerm, amType);
    }
    @And("Click On Add Loan Button")
    public void clickOnAddLoanButton() throws InterruptedException {
        createLoanPage.submit_button_for_AddLoan();


    }


//    @Then("Compare Values {List<LinkedHashMap<String, String>>} {List<LinkedHashMap<String, String>>} {String[]}")
//    public void compareValuesAllTableDataExcelDataArr(List<LinkedHashMap<String, String>> allTableData,
//                                                      List<LinkedHashMap<String, String>> excelData, String[] arr) {
//        createLoanPage.compare_the_value(allTableData, excelData, arr);
//    }
    @Then("Verify Loan Is Created {string} {string}")
    public void verifySuccessfullMessage(String expSuccesMessage,String LoanName) throws InterruptedException {
        createLoanPage.verifySuccessfullMessage(expSuccesMessage,LoanName);
    }

}
