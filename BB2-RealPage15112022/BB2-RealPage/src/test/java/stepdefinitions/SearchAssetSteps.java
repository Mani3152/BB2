package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchAssetSteps {

    private SearchPortfolioPage search_portfolio = new SearchPortfolioPage(WebdriverIntializer.getDriver());


    private DownloadAssetInformationPage assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private SearchAssetPage searchPage = new SearchAssetPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());
    @Given("Go to assets Page")
    public void go_to_assets_page() throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        assetinfo.gotoAssetsPage();
    }

    @When("Take all the assets Data")
    public void take_all_the_assets_data() {
        searchPage.assetsNames();
    }

    @And("enter in search box and check Whether its present or not {string}")
    public void enter_in_search_box_and_check_whether_its_present_or_not(String keyword) throws InterruptedException {
        searchPage.enterKeyWord(keyword);
        searchPage.filterButton();
    }
    @And("go to particular Asset {string} {string}")
    public void go_to_particular_asset(String particular_asset,String data) throws InterruptedException {
        portfoliopage.goToPortfolios();
        assetinfo.gotoAssetsPage();
        assetinfo.goToParticularAsset(particular_asset);
        searchPage.go_to_Tenant_abd_Unit(data);
    }
    @And("Search Tenant or Unit particular Asset  {string}")
    public void search_tenant_in_particular_asset(String data) throws InterruptedException {
        searchPage.verify_Search(data);
    }
    @And("Search Loans in particular Asset {string}")
    public void search_loans_in_particular_asset(String search_loan) throws InterruptedException {
        searchPage.Loans_Tab();
        searchPage.Search_Loan(search_loan);
        searchPage.verify_Search_Loan(search_loan);
    }
}
