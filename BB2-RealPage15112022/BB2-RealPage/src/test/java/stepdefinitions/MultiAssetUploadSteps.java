package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.LoginPage;
import com.pages.MultiAssetUploadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

public class MultiAssetUploadSteps {

    private MultiAssetUploadPage multiAsset = new MultiAssetUploadPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to properties page and click on import button")
    public void go_to_properties_page_and_click_on_import_button() throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        multiAsset.propertiesPage();
    }

    @When("Upload the required Files {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void upload_the_required_files(String overview,String cashflow,String assumptions,String loan,String tenant,String overviewError,String cashflowError,String assumptionsError,String loanError,String tenantError) throws InterruptedException {
       multiAsset.filesUpload(overview,cashflow,assumptions,loan,tenant,overviewError,cashflowError,assumptionsError,loanError,tenantError);

    }

    @Then("Submit the Data {string}")
    public void submit_the_data(String toaster) throws InterruptedException {
            multiAsset.verifyCreatedAssets(toaster);



    }


}
