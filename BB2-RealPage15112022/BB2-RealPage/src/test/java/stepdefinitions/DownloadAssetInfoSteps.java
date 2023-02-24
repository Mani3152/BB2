package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.DownloadAssetInformationPage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DownloadAssetInfoSteps {

//    private EditAssetPage editAsset = new EditAssetPage(WebdriverIntializer.getDriver());
    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to particualr asset {string}")
    public void go_to_particualr_asset(String particualrAsset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(particualrAsset);
    }

    @When("CLick on download button and select the format {string} {string}")
    public void c_lick_on_download_button_and_select_the_format(String type,String content) throws InterruptedException {

        assetinfo.downloadAssetInfo(type,content);
    }

    @Then("CHeck the downloaded file {string}")
    public void c_heck_the_downloaded_file(String toaster) {
        assetinfo.verify_toaster(toaster);
    }
}
