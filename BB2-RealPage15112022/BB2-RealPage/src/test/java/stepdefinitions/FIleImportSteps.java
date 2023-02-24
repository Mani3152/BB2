package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.DownloadAssetInformationPage;
import com.pages.FileImportPage;
import com.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FIleImportSteps {

    private FileImportPage importfile = new FileImportPage(WebdriverIntializer.getDriver());
    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("user click on Asset {string}")
    public void user_click_on_asset(String AssetName) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(AssetName);
    }



    @When("click on import loan {string} {string} {string} {string}")
    public void click_on_import_loan(String Loan,String filemsg,String toastermsg,String names) throws InterruptedException {
        importfile.click_loan(Loan,filemsg,toastermsg,names);
    }

    @And("click on import Tenants {string} {string} {string} {string} {string} {string} {string} {string}")
    public void click_on_import_tenants(String tenant,String filemsg,String toastermsg,String names,String unit,String unitfilemsg,String unittoaster,String unitnames) throws InterruptedException {
        importfile.import_tenant(tenant,filemsg,toastermsg,names,unit,unitfilemsg,unittoaster,unitnames);

    }
}
