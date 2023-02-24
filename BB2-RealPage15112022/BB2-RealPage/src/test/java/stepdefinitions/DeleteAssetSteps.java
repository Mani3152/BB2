package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.DeleteAssetPage;
import com.pages.DownloadAssetInformationPage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DeleteAssetSteps {

    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private DeleteAssetPage deleteAsset = new DeleteAssetPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("go to assets page")
    public void go_to_assets_page() throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
    }

    @When("sleect an asset {string}")
    public void sleect_an_asset(String asset) throws InterruptedException {
        assetinfo.goToParticularAsset(asset);
    }

    @Then("Delete the assset {string}")
    public void delete_the_assset(String toaster) {

        deleteAsset.deleteAsset(toaster);
    }

}
