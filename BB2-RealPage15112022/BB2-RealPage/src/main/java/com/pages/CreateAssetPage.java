package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateAssetPage {

    private WebDriver driver;

    boolean overview = false;
    boolean valution = false;
    boolean loans = false;
    //	boolean assetFlag = false;
    boolean submit = false;

    private By link_Properties = By.xpath("//a[@href='/assets']//i");
    private By title_Asset = By.xpath("//h1[text()='Assets']");
    private By btn_Asset = By.xpath("//button[text()=' New Asset']");
    private By title_CreateNewAsset = By.xpath("//h5[text()='Create New  Asset']");
    private By lable_Name = By.xpath("//span[text()='Asset Name*']");
    private By link_ViewTemplate = By.xpath("//a[text()='View Template']");
    private By txtInput_Name = By.xpath("//span[text()='Asset Name*']//parent::label//following-sibling::input");
    private By label_ExternalAssetCode = By.xpath("//label[text()='External Asset Code*']");
    private By txtInput_ExternalAssetCode = By.xpath("//label[text()='External Asset Code*']//following-sibling::input");
    private By label_Country = By.xpath("//label[text()='Country*']");
    private By select_Country = By.xpath("//label[text()='Country*']//following-sibling::select");
    private By label_SearchAddress = By.xpath("//label[text()='Search Address']");
    private By txtInput_SearchAddress = By.id("pac-input");
    private By label_AddressLine1 = By.xpath("//label[text()='Address Line 1*']");
    private By txtInput_AddressLine1 = By.xpath("//label[text()='Address Line 1*']//following-sibling::input");
    private By label_City = By.xpath("//label[text()='City*']");
    private By txtInput_City = By.xpath("//label[text()='City*']//following-sibling::input");
    private By label_State = By.xpath("//label[text()='State*']");
    private By select_State = By.xpath("//label[text()='State*']//following-sibling::select");
    private By label_ZipCode = By.xpath("//label[text()='Zip Code*']");
    private By input_ZipCode = By.xpath("//label[text()='Zip Code*']//following-sibling::input");
    private By label_CurrentMarketValue = By.xpath("//label[text()='Current Market Value*']");
    private By txtInput_CurrentMarketValue = By.xpath("//label[text()='Current Market Value*']//following-sibling::input");
    private By label_AssetCategory = By.xpath("//label[text()='Asset Category*']");
    private By select_AssetCategory = By.xpath("//label[text()='Asset Category*']//following-sibling::select");
    private By label_YearBuilt = By.xpath("//label[text()='Year Built*']");
    private By txtInput_YearBuilt = By.xpath("//label[text()='Year Built*']//following-sibling::input");
    private By label_LastRefurbished = By.xpath("//label[text()='Last Refurbished*']");
    private By txtInput_LastRefurbished = By.xpath("//label[text()='Last Refurbished*']//parent::div/div/input");
    private By label_LeasableArea = By.xpath("//label[text()='Leasable Area*']");
    private By txtInput_LeasableArea = By.xpath("//label[text()='Leasable Area*']//following-sibling::input");
    private By label_UnitOfMeasureForSpace = By.xpath("//label[text()='Unit of Measure for Space*']");
    private By select_UnitOfMeasureForSpace = By.xpath("//label[text()='Unit of Measure for Space*']//following-sibling::select");
    private By label_Image = By.xpath("//label[text()='Image*']");
    private By Input_Image = By.xpath("//p[text()='Drag files or click upload here']//preceding-sibling::input");
    private By label_Mangement = By.xpath("//label[text()='Management']");
    private By label_LifeCycle = By.xpath("//label[text()='Lifecycle*']");
    private By select_LifeCycle = By.xpath("//label[text()='Lifecycle*']//following-sibling::select");
    private By label_PriamryAssetManager = By.xpath("//label[text()='Primary Asset Manager*']");
    private By select_PriamryAssetManager = By.xpath("//label[text()='Primary Asset Manager*']//following-sibling::select");
    private By label_Fund = By.xpath("//label[text()='Fund (Optional)']");
    private By select_Fund = By.xpath("//label[text()='Fund (Optional)']//following-sibling::select");
    private By label_Portfolio = By.xpath("//label[text()='Portfolio (Optional)']");
    private By select_Portfolio = By.xpath("//label[text()='Portfolio (Optional)']//following-sibling::select");
    private By label_AcquisitionDate = By.xpath("//label[text()='Acquisition Date*']");
    private By input_AcquisitionDate = By.xpath("//label[text()='Acquisition Date*']//parent::div//div//input");
    private By label_ValutionMethod = By.xpath("//label[text()='Valuation Method*']");
    private By select_ValutionMethod = By.xpath("//label[text()='Valuation Method*']//following-sibling::select");
    private By label_Currecy = By.xpath("//label[text()='Currency*']");
    private By select_Currecy = By.xpath("//label[text()='Currency*']//following-sibling::select");
    private By btn_CancelForOverview = By.xpath("//button[text()='Cancel']");
    private By btn_NextForOverview = By.xpath("//button[text()='Next']");
    private By label_CashFlow = By.xpath("//label[text()='Cash Flows']");
    private By label_CashFlowStatement = By.xpath("//label[text()='Provide cash flow information. Refer to the template file for the information needed.']");
    private By note_Cashflow = By.xpath("//*[@id='valuations']/div[2]/label[2]/span");
    private By link_ViewTemplateForCashFlow = By.xpath("//*[@id='valuations']/div[2]/label[2]/a");
    private By label_UploadCashFlow = By.xpath("//*[@id='valuations']/div[2]/div/div/p");
    private By input_CashFlow = By.xpath("//*[@id='valuations']/div[2]/div/div/input");
    private By label_Assumptions = By.xpath("//label[text()='Assumptions']");
    private By label_AssumptionsStatement = By.xpath("//label[text()='Provide assumption information. Refer to the template file for the information needed.']");
    private By note_Assumptions = By.xpath("//*[@id='valuations']/div[4]/label[2]/span");
    private By link_ViewTemplateForAssumptions = By.xpath("//*[@id='valuations']/div[4]/label[2]/a");
    private By label_UploadAssumptions = By.xpath("//*[@id='valuations']/div[4]/div/div/p");
    private By input_Assumptions = By.xpath("//*[@id='valuations']/div[4]/div/div/input");
    private By btn_BackForValutions = By.xpath("//button[text()='Back']");
    private By btn_NextForValutions = By.xpath("//button[text()='Next']");
    private By label_LoanStatement = By.xpath("//label[text()='Provide loan details. Refer to the template file for the information needed.']");
    private By note_Loans = By.xpath("//*[@id='loans']/div/label[2]/span");
    private By link_ViewTemplateForLoans = By.xpath("//*[@id='loans']/div/label[2]/a");
    private By lable_UploadLoans = By.xpath("//*[@id='loans']/div/div/div/p");
    private By input_Loans = By.xpath("//*[@id='loans']/div/div/div/input");
    private By btn_BackForLoans = By.xpath("//button[text()='Back']");
    private By btn_NextForLoans = By.xpath("//button[text()='Next']");
    private By label_Tenants = By.xpath("//label[text()='Provide tenant details. Refer to the template file for the information needed.']");
    private By note_Tenants = By.xpath("//*[@id='tenant']/div/label[2]/span");
    private By link_ViewTemplateForTenants = By.xpath("//*[@id='tenant']/div/label[2]/a");
    private By label_UploadTenants = By.xpath("//*[@id='tenant']/div/div/div/p");
    private By input_Tenants = By.xpath("//*[@id='tenant']/div/div/div/input");
    private By btn_BackForTenants = By.xpath("//button[text()='Back']");
    private By btn_Submit = By.xpath("//button[text()='Create']");
    private By downloadButton = By.xpath("//*[@id=\"dropdownManual\"]//i");
    private By downloadAsssetHeading = By.xpath("//*[text()='Download Asset Data']");
    private By dowloand_button = By.xpath("//button[text()='Download']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");
//	private By toasterBox = By.xpath(".//*[@id=\"toast-container\"]/div/div[1][@Class=\"toast-message\"]");


    public CreateAssetPage(WebDriver driver) {

        this.driver = driver;
    }

    // Go To properties Page and click on New Asset Button
    public void gotToAssetPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(link_Properties).isDisplayed();
        driver.findElement(link_Properties).click();
        driver.findElement(title_Asset).isDisplayed();
    }

    public void assetPresent(String particular_asset) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath("//img[@title='" + particular_asset + "']")).size() == 1) {
//			assetFlag = true;
        }

    }

    public void clickonNewAssetButton() {

        driver.findElement(btn_Asset).isEnabled();
        driver.findElement(btn_Asset).click();
        driver.findElement(title_CreateNewAsset).isDisplayed();

    }

    // Enter the Details in Overview Tab
    public void overViewTab(String name, String code, String country, String address, String city, String state,
                            String zipcode, String category, String lifecycle, String marketvalue, String manager, String fund,
                            String protfolio, String acquisitiondate, String yearbuilt, String lastrefurbished, String currency,
                            String unitofmeasure, String area, String valuationmethod, String image) {


        driver.findElement(lable_Name).isDisplayed();
//		driver.findElement(link_ViewTemplate).isDisplayed();
        driver.findElement(txtInput_Name).sendKeys(name);
        driver.findElement(label_ExternalAssetCode).isDisplayed();
//		Random rand = new Random();
//		int rand_int1 = rand.nextInt(1000);
        driver.findElement(txtInput_ExternalAssetCode).sendKeys(code);
        driver.findElement(label_Country).isDisplayed();
        driver.findElement(select_Country).click();
        int Country = driver.findElements(By.xpath("//option[text()='" + country + "']")).size();
        if (Country > 0) {
            driver.findElement(By.xpath("//option[text()='" + country + "']")).click();
        }
        driver.findElement(label_AddressLine1).isDisplayed();
        driver.findElement(txtInput_AddressLine1).sendKeys(address);
        driver.findElement(label_City).isDisplayed();
        driver.findElement(txtInput_City).sendKeys(city);
        driver.findElement(label_State).isDisplayed();
        Select State = new Select(driver.findElement(select_State));
        State.selectByVisibleText(state);
        driver.findElement(label_ZipCode).isDisplayed();
        driver.findElement(input_ZipCode).sendKeys(zipcode);
        driver.findElement(label_CurrentMarketValue).isDisplayed();
        driver.findElement(txtInput_CurrentMarketValue).sendKeys(marketvalue);
        driver.findElement(label_AssetCategory).isDisplayed();
        Select assetCategory = new Select(driver.findElement(select_AssetCategory));
        assetCategory.selectByVisibleText(category);
        driver.findElement(label_YearBuilt).isDisplayed();
        driver.findElement(txtInput_YearBuilt).sendKeys(yearbuilt);
        driver.findElement(label_LastRefurbished).isDisplayed();
        driver.findElement(txtInput_LastRefurbished).sendKeys(lastrefurbished);
        driver.findElement(label_LeasableArea).isDisplayed();
        driver.findElement(txtInput_LeasableArea).sendKeys(area);
        driver.findElement(label_UnitOfMeasureForSpace).isDisplayed();
        Select unitOfMeasure = new Select(driver.findElement(select_UnitOfMeasureForSpace));
        unitOfMeasure.selectByVisibleText(unitofmeasure);
        driver.findElement(label_Image).isDisplayed();
        driver.findElement(Input_Image).sendKeys(image);
        driver.findElement(label_Mangement).isDisplayed();
        driver.findElement(label_LifeCycle).isDisplayed();
        Select lifeCycle = new Select(driver.findElement(select_LifeCycle));
        lifeCycle.selectByVisibleText(lifecycle);
        driver.findElement(label_PriamryAssetManager).isDisplayed();
        Select primaryAssetManager = new Select(driver.findElement(select_PriamryAssetManager));
        primaryAssetManager.selectByVisibleText(manager);
        driver.findElement(label_Fund).isDisplayed();
        driver.findElement(select_Fund).click();
        int Fund = driver.findElements(By.xpath("//option[text()='" + fund + "']")).size();
        if (Fund > 0) {
            driver.findElement(By.xpath("//option[text()='" + fund + "']")).click();
        }
        driver.findElement(label_Portfolio).isDisplayed();

        driver.findElement(select_Portfolio).click();
        int Protfolio = driver.findElements(By.xpath("//option[text()='" + protfolio + "']")).size();
        if (Protfolio > 0) {
            driver.findElement(By.xpath("//option[text()='" + protfolio + "']")).click();
        }
        driver.findElement(label_AcquisitionDate).isDisplayed();
        driver.findElement(input_AcquisitionDate).sendKeys(acquisitiondate);
        driver.findElement(label_ValutionMethod).isDisplayed();
        Select ValuationMethod = new Select(driver.findElement(select_ValutionMethod));
        ValuationMethod.selectByVisibleText(valuationmethod);
        driver.findElement(label_Currecy).isDisplayed();
        Select Currency = new Select(driver.findElement(select_Currecy));
        Currency.selectByVisibleText(currency);
        driver.findElement(btn_CancelForOverview).isDisplayed();
        driver.findElement(btn_CancelForOverview).isEnabled();
        driver.findElement(btn_NextForOverview).isDisplayed();

        if (driver.findElement(btn_NextForOverview).isEnabled()) {
            driver.findElement(btn_NextForOverview).click();
            overview = true;

        }


    }

    // Enter the Details in ValutionsTab
    public void valutionsTab(String cashFlowFile, String assumptionsFile, String ToasterMessageForCashFlow, String ToasterMessageForAssumption) throws InterruptedException {
        if (overview) {
            driver.findElement(label_CashFlow).isDisplayed();
            driver.findElement(label_CashFlowStatement).isDisplayed();
            driver.findElement(label_UploadCashFlow).isDisplayed();
            driver.findElement(input_CashFlow).sendKeys(cashFlowFile);
//            Thread.sleep(400);
            String toaster_CashFlow = driver.findElement(toasterBox).getText();
            Assert.assertEquals(ToasterMessageForCashFlow, toaster_CashFlow, "Expected : " + ToasterMessageForCashFlow + " But Found : " + toaster_CashFlow+ " in cashflows") ;


            driver.findElement(label_Assumptions).isDisplayed();
            driver.findElement(label_AssumptionsStatement).isDisplayed();
            driver.findElement(label_UploadAssumptions).isDisplayed();
            driver.findElement(input_Assumptions).sendKeys(assumptionsFile);
//            Thread.sleep(400);
            String toaster_Assumption = driver.findElement(toasterBox).getText();
            Assert.assertEquals(ToasterMessageForAssumption, toaster_Assumption, "Expected : " + ToasterMessageForAssumption + " But Found : " + toaster_Assumption + " in assumptions");
            Thread.sleep(1000);

            driver.findElement(btn_BackForValutions).isDisplayed();
            driver.findElement(btn_BackForValutions).isEnabled();
            driver.findElement(btn_NextForValutions).isDisplayed();
            if (driver.findElement(btn_NextForValutions).isEnabled()) {
                driver.findElement(btn_NextForValutions).click();
                valution = true;
            }

        }

    }


    //Enter the Details in LoansTab
    public void loansTab(String loansFile, String ToasterMessageForLoans) throws InterruptedException {
        if (valution) {
            driver.findElement(label_LoanStatement).isDisplayed();
            driver.findElement(lable_UploadLoans).isDisplayed();
            driver.findElement(input_Loans).sendKeys(loansFile);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
            driver.findElement(toasterBox).isDisplayed();
//            Thread.sleep(400);
            String toaster_Loan = driver.findElement(toasterBox).getText();
            Assert.assertEquals(ToasterMessageForLoans, toaster_Loan, "Expected : " + ToasterMessageForLoans + " But Found : " + toaster_Loan + " in loans");

            driver.findElement(btn_BackForLoans).isDisplayed();
            driver.findElement(btn_NextForLoans).isDisplayed();
            driver.findElement(btn_NextForLoans).isEnabled();
            if (ToasterMessageForLoans.contains("Excel sheet validated successfully")) {
                driver.findElement(btn_NextForLoans).click();
                loans = true;
            }
        }

    }

    //Enter the Details in Tenants Tab
    public void tenantsTab(String tenantsFile, String ToasterMessageForTenants) throws InterruptedException {
        if (loans) {
            driver.findElement(label_Tenants).isDisplayed();

            driver.findElement(label_UploadTenants).isDisplayed();
            driver.findElement(input_Tenants).sendKeys(tenantsFile);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
            driver.findElement(toasterBox).isDisplayed();
//            Thread.sleep(400);
            String toaster_Tenant = driver.findElement(toasterBox).getText();
            Assert.assertEquals(ToasterMessageForTenants, toaster_Tenant, "Expected : " + ToasterMessageForTenants + " But Found : " + toaster_Tenant+ " in tenants");
            Thread.sleep(1000);
            driver.findElement(btn_BackForTenants).isDisplayed();
            driver.findElement(btn_Submit).isDisplayed();
            driver.findElement(btn_Submit).isEnabled();
            if (ToasterMessageForTenants.contains("Excel sheet validated successfully")) {
                driver.findElement(btn_Submit).click();
                Thread.sleep(2000);
                submit = true;
            }
        }

    }

    public void verify(String finalmsg) throws InterruptedException {
        String finalToaster = "";
        if (submit) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
//            Thread.sleep(1000);
            driver.findElement(toasterBox).isDisplayed();
            finalToaster = driver.findElement(toasterBox).getText();
            System.out.println(finalToaster + "---toaster");
            Assert.assertEquals(finalmsg, finalToaster, "Expected : " + finalmsg + " But Found : " + finalToaster);
        }
        if (finalmsg.equals(finalToaster)) {
            submit = true;
        } else {
            submit = false;
        }
    }

    public void clickOnparticularAsset(String particular_asset) {
        if(submit){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
            driver.findElement(By.xpath("//img[@title='" + particular_asset + "']")).isDisplayed();
        }
//            driver.findElement(By.xpath("//img[@title='" + particular_asset + "']")).click();

    }




}
