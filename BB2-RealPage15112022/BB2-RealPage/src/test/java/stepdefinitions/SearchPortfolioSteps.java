package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;


public class SearchPortfolioSteps {
    private CreateLoanPage loanpage = new CreateLoanPage(WebdriverIntializer.getDriver());
    private AssetPortfolioPage Assetportfolio = new AssetPortfolioPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private SimulationsCalculationsPage simulation = new SimulationsCalculationsPage(WebdriverIntializer.getDriver());
    private DownloadAssetInformationPage Assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private SearchPortfolioPage search_portfolio = new SearchPortfolioPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

    @Given("click on particular Asset in dropdown {string}")
    public void click_on_particular_asset_in_dropdown(String particular_asset) throws InterruptedException {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
        portfoliopage.goToPortfolios();
        search_portfolio.click_portfolio(particular_asset);
        search_portfolio.click_Assets_View();

    }

    @When("verify portfolio {string}")
    public void verify_portfolio(String particular_asset) throws InterruptedException {

        search_portfolio.verify_Asset(particular_asset);
    }

    @And("click on Asset Tab {string}")
    public void click_on_asset_tab(String particular_asset) throws InterruptedException {
        Assetinfo.gotoAssetsPage();
        Assetinfo.goToParticularAsset(particular_asset);
    }

    @And("verify portfolio in details Tab {string}")
    public void verify_portfolio_in_details_tab(String message) throws InterruptedException {
        simulation.clickOnDetailsTab();
        search_portfolio.verify_Assetportfolio(message);
    }

    @And("verify portfolio in search box {string} {string}")
    public void verify_portfolio_in_search_box(String data, String error_msg) throws InterruptedException {
        portfoliopage.goToPortfolios();
        search_portfolio.verify_search(data, error_msg);
    }

    @And("click on particular portfolio {string}")
    public void click_on_particular_portfolio(String portfolio) throws InterruptedException {
        portfoliopage.goToPortfolios();
        Assetportfolio.gotoParticularPortfolio(portfolio);

    }

    @And("click on cardsTab and search Asset {string} {string} {string}")
    public void click_on_cards_tab_and_search_asset(String Asset_data, String Category, String error_msg) throws InterruptedException {
        search_portfolio.click_Assets_View();
        search_portfolio.click_cards(Asset_data, error_msg);
        search_portfolio.Asset_category(Category, error_msg);
    }
    @And("Search Loans for Asset level and portfolio level {string} {string} {string}")
    public void search_loans_for_asset_level_and_portfolio_level(String particular_asset,String search_loan,String portfolio) throws InterruptedException {
        search_portfolio.Loans_Tab();
        search_portfolio.Search_Loan(search_loan);
        search_portfolio.verify_Search_Loan(search_loan);
    }

    @And("Search Tenants for Asset level and portfolio level {string} {string}")
    public void search_tenants_for_asset_level_and_portfolio_level(String portfolio,String search_tenant) throws InterruptedException {
        search_portfolio.click_Tenant();
        search_portfolio.portfoli0_Master_Tenant(search_tenant);
        search_portfolio.verify_Tenant(search_tenant);
    }

    @And("Search Units for Asset level and portfolio level {string} {string} {string}")
    public void search_units_for_asset_level_and_portfolio_level(String multi_portfolio,String search_unit_summary,String search_unit_type) throws InterruptedException {
        search_portfolio.Unit_Tab();
        search_portfolio.Search_Unit_Summary(search_unit_summary);
        search_portfolio.verify_Search_Unit_Summary(search_unit_summary);
        search_portfolio.click_unitType();
        search_portfolio.Search_Unit_Type(search_unit_type);
        search_portfolio.verify_Search_Unit_Type(search_unit_type);
    }
}
