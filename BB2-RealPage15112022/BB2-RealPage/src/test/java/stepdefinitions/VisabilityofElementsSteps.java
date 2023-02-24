package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class VisabilityofElementsSteps {
    private VisabilityfoElementsPage elementsPage = new VisabilityfoElementsPage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());
    private DownloadAssetInformationPage Assetinfo = new DownloadAssetInformationPage(WebdriverIntializer.getDriver());
    private PortfolioPage portfoliopage = new PortfolioPage(WebdriverIntializer.getDriver());
    private AssetPortfolioPage Assetportfolio = new AssetPortfolioPage(WebdriverIntializer.getDriver());


//        lgnpage.enterDetails("superadmin", "Demo@123");
//        lgnpage.clickonLogin();
//        elementsPage.click_on_home();
//        elementsPage.Verify_Portfolio_Homepage();
//        elementsPage.Verify_Assets_Homepage();


    @Given("verify elements {string}")
    public void verify_elements() throws InterruptedException {
        elementsPage.click_on_home();
        elementsPage.Verify_Portfolio_Homepage();
        elementsPage.Verify_Assets_Homepage();
        portfoliopage.goToPortfolios();
       // Assetportfolio.gotoParticularPortfolio(portfolio);
    }

}
