package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.AddScenerioPage;
import com.pages.DownloadAssetInformationPage;
import com.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddScenerioSteps {

    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private AddScenerioPage scnPage = new AddScenerioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Go to a particular asset {string}")
    public void go_to_a_particular_asset(String name) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(name);
    }

    @When("Go to Details Tab and click on View Scenriao")
    public void go_to_details_tab_and_click_on_view_scenriao() throws InterruptedException {
        scnPage.detaisTab();
        scnPage.addScenaria();
    }

    @And("Click add Scenerio and give the details {string} {string} {string} {string} {string} {string} {string}")
    public void click_add_scenerio_and_give_the_details_valuations(String name, String status, String header, String notes, String valuations, String loans,String tenants ) {
        scnPage.enterDetails(name,status,header,notes,valuations,loans,tenants);
    }

    @Then("verify the created Scenraio {string}")
    public void verify_the_created_scenraio(String name) {

    }
}
