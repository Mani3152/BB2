package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.DownloadAssetInformationPage;
import com.pages.LoginPage;
import com.pages.RiskAssumptionAssetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RiskAssumptionAssetSteps {

    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private RiskAssumptionAssetPage rskAsset = new RiskAssumptionAssetPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("go to assets {string}")
    public void go_to_assets_portfolio(String particualrAsset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(particualrAsset);
    }

    @When("go to riskassumption")
    public void go_to_riskassumption() throws InterruptedException {
        rskAsset.riskassumptionsClick();
    }

    @And("verify data in risk models {string} {string} {string} {string}")
    public void verify_data_in_risk_models(String name, String factor, String template,String toaster) throws InterruptedException {
        rskAsset.riskModels(name, factor, template,toaster);
    }

    @Then("verify the data in risk assumption {string} {string}")
    public void verify_the_data_in_risk_assumption(String keyword, String simulation) throws InterruptedException {
        rskAsset.simulationsTab(keyword,simulation);
    }

}
