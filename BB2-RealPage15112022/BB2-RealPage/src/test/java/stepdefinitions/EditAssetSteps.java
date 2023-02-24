package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.DownloadAssetInformationPage;
import com.pages.EditAssetPage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAssetSteps {

    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private EditAssetPage editasset = new EditAssetPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Opens RealPage  and user clicks on properties goes to a particular asset {string}")
    public void opens_real_page_and_user_clicks_on_properties_goes_to_a_particular_asset(String particualrAsset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
       assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(particualrAsset);
        editasset.deatilsPage();
    }

    @When("clicks on edit button and edit the values {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void clicks_on_edit_button_and_edit_the_values(String name, String code, String country, String address, String city, String state,
                                  String zipcode, String category, String lifecycle, String marketvalue, String manager, String fund,
                                  String protfolio, String acquisitiondate, String yearbuilt, String lastrefurbished, String currency,
                                  String unitofmeasure, String area, String valuationmethod) throws InterruptedException {
        editasset.overViewTab(name,code,country,address,city,state,zipcode,category,lifecycle,marketvalue,manager,fund,protfolio,acquisitiondate,yearbuilt,lastrefurbished,currency,unitofmeasure,area,valuationmethod);
        
    }

    @Then("check the updated values {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void check_the_updated_values(String name, String code, String country, String address, String city, String state,
                                  String zipcode, String category, String lifecycle, String marketvalue, String manager, String fund,
                                  String protfolio, String acquisitiondate, String yearbuilt, String lastrefurbished, String currency,
                                  String unitofmeasure, String area, String valuationmethod,String toaster) throws InterruptedException {
        editasset.updatedValueCheck(name,code,country,address,city,state,zipcode,category,lifecycle,marketvalue,manager,fund,protfolio,acquisitiondate,yearbuilt,lastrefurbished,currency,unitofmeasure,area,valuationmethod,toaster);
        
    }

}
