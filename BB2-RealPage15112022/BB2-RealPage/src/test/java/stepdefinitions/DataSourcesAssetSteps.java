package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.K;

import java.security.Key;

public class DataSourcesAssetSteps {

    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private DataSourcesAssetPage dsAsset = new DataSourcesAssetPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("go to asset {string}")
    public void go_to_asset(String particualrAsset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(particualrAsset);
    }

    @When("go to data sources in the asset {string}")
    public void go_to_data_sources_in_the_asset(String Keyword) throws InterruptedException {
        dsAsset.clickonDatSources();
        dsAsset.checkDataSources(Keyword);
    }

    @Then("verify the data in the asset {string}")
    public void verify_the_data_in_the_asset(String keyword) throws InterruptedException {
        dsAsset.checkDataSets(keyword);
    }
}
