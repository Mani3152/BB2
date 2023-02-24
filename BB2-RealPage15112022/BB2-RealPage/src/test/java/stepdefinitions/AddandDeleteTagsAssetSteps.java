package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.AddandDeleteTagsAssetPage;
import com.pages.DownloadAssetInformationPage;
import com.pages.LoginPage;
import com.pages.SimulationsCalculationsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddandDeleteTagsAssetSteps {

    private DownloadAssetInformationPage Assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private SimulationsCalculationsPage simulation = new SimulationsCalculationsPage(WebdriverIntializer.getDriver());
    private AddandDeleteTagsAssetPage tagsPage=new AddandDeleteTagsAssetPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());


    @Given("click on assets {string}")
    public void click_on_assets(String particular_asset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        Assetinfo.gotoAssetsPage();
        Assetinfo.goToParticularAsset(particular_asset);
        simulation.clickOnDetailsTab();
    }

    @When("click on tags {string} {string}")
    public void click_on_tags(String Tags,String message) throws InterruptedException {
        tagsPage.Add_tag(Tags,message);
    }

    @Then("Remove tag {string} {string}")
    public void remove_tag(String Tags, String del_message) throws InterruptedException {
        tagsPage.Remove_Tag(Tags,del_message);
    }

}
