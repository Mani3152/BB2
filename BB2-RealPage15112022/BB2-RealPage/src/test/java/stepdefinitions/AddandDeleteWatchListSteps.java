package stepdefinitions;


import com.driver.WebdriverIntializer;
import com.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddandDeleteWatchListSteps {
    private AssetPortfolioPage Assetportfolio = new AssetPortfolioPage(WebdriverIntializer.getDriver());

    private AddandDeleteWatchListPage addWatchlistPage = new AddandDeleteWatchListPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private DownloadAssetInformationPage Assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private SimulationsCalculationsPage simulation = new SimulationsCalculationsPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("user click on particular asset {string}")
    public void user_click_on_particular_asset(String particular_asset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        Assetinfo.gotoAssetsPage();
        Assetinfo.goToParticularAsset(particular_asset);
        simulation.clickOnDetailsTab();
    }

    @When("click on AddtoWatchlist {string} {string}")
    public void click_on_addto_watchlist(String verify_asset,String message) throws InterruptedException {
        addWatchlistPage.Add_WatchList();
        addWatchlistPage.go_to_verified_portfolio();
        addWatchlistPage.verify_aseet_watchlist(verify_asset,message);


    }

    @And("user click on particular_portfolio {string}")
    public void user_click_on_particular_portfolio(String portfolio) throws InterruptedException {
        portfoliopage.goToPortfolios();
        Assetportfolio.gotoParticularPortfolio(portfolio);


    }

    @And("click on Assets in Watchlist {string}")
    public void click_on_assets_in_watchlist(String message) throws InterruptedException {
        addWatchlistPage.Assets_in_watchlist();
        addWatchlistPage.Add_watchlist_btn();
        addWatchlistPage.verifywatchlist(message);
    }

    @And("Enter data value in search {string} {string}")
    public void enter_data_value_in_search(String data,String message) throws InterruptedException {
        // addWatchlistPage.Search_Asset(data,message);
        // addWatchlistPage.verify_AssetData(data,message);
    }

    @Given("user click particular asset {string}")
    public void user_click_particular_asset(String particular_asset) throws InterruptedException {
        Assetinfo.gotoAssetsPage();
        Assetinfo.goToParticularAsset(particular_asset);
        simulation.clickOnDetailsTab();
    }

    @When("Remove AddWatchList in particular asset {string}")
    public void remove_add_watch_list_in_particular_asset(String verify_asset) throws InterruptedException {
        addWatchlistPage.Remove_AddWatchlist();
        addWatchlistPage.go_to_verified_portfolio();
        addWatchlistPage.verify_delete_watchlist(verify_asset);


    }

    @When("click on particular_portfolio {string}")
    public void click_on_particular_portfolio(String portfolio) throws InterruptedException {
        portfoliopage.goToPortfolios();
        Assetportfolio.gotoParticularPortfolio(portfolio);

    }

    @And("click Asset in Watchlist {string}")
    public void click_on_asset_in_watchlist(String message) throws InterruptedException {
        addWatchlistPage.Assets_in_watchlist();
        addWatchlistPage.delete_watchlist(message);
    }

    @Then("verify delete watchlist {string}")
    public void verify_delete_watchlist(String message) {
        addWatchlistPage.verify_delete(message);
    }

}
