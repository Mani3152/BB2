package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.CreateAssetPage;
import com.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAssetSteps {
	
	private CreateAssetPage newAssetPage = new CreateAssetPage(WebdriverIntializer.getDriver());
	private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());

	@Given("Opens RealPage  and user clicks on properties")
	public void opens_real_page_and_user_clicks_on_properties() throws InterruptedException {
		lgnpage.enterDetails("superadmin","Demo@123");
		lgnpage.clickonLogin();
		newAssetPage.gotToAssetPage();
		newAssetPage.clickonNewAssetButton();
	}

	@When("Enter Details Into OverViewPage {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void enter_Details_Into_OverViewTab(String name, String code, String country, String address, String city, String state,
											   String zipcode, String category, String lifecycle, String marketvalue, String manager, String fund,
											   String protfolio, String acquisitiondate, String yearbuilt, String lastrefurbished, String currency,
											   String unitofmeasure, String area, String valuationmethod, String image ){
		newAssetPage.overViewTab( name,  code,  country,  address,  city,  state,
				 zipcode,  category,  lifecycle,  marketvalue,  manager,  fund,
				 protfolio,  acquisitiondate,  yearbuilt,  lastrefurbished,  currency,
				 unitofmeasure,  area,  valuationmethod,  image);


	}
	@And("Enter Details Into ValutionsPage {string} {string} {string} {string}")
	public void enter_Details_Into_valutionsTab(String cashFlowFile, String assumptionsFile, String ToasterMessageForCashFlow, String ToasterMessageForAssumption ) throws InterruptedException {
		newAssetPage.valutionsTab( cashFlowFile, assumptionsFile, ToasterMessageForCashFlow,  ToasterMessageForAssumption );
	}
	@And("Enter Details Into LoansPage {string} {string}")
	public void enter_Details_Into_loansTab(String loansFile, String ToasterMessageForLoans ) throws InterruptedException {
		newAssetPage.loansTab( loansFile, ToasterMessageForLoans );
	}
	@Then("Enter Details Into TenantsPage {string} {string} {string} {string}")
	public void enter_Details_Into_tenantsTab(String tenantsFile, String ToasterMessageForTenants,String name,String finalToaster) throws InterruptedException {
		newAssetPage.tenantsTab( tenantsFile, ToasterMessageForTenants);
//		newAssetPage.verify(finalToaster);
		newAssetPage.clickOnparticularAsset(name);
	}






}
