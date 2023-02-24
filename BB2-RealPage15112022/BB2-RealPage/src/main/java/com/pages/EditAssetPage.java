package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class EditAssetPage {

    private WebDriver driver;

    private By txtInput_Name = By.xpath("//span[text()='Asset Name*']//parent::label//following-sibling::input");

    private By txtInput_ExternalAssetCode = By.xpath("//label[text()='External Asset Code*']//following-sibling::input");

    private By select_Country = By.xpath("//label[text()='Country*']//following-sibling::select");

    private By txtInput_AddressLine1 = By.xpath("//label[text()='Address Line 1*']//following-sibling::input");

    private By txtInput_City = By.xpath("//label[text()='City*']//following-sibling::input");

    private By select_State = By.xpath("//label[text()='State*']//following-sibling::select");

    private By input_ZipCode = By.xpath("//label[text()='Zip Code*']//following-sibling::input");

    private By txtInput_CurrentMarketValue = By.xpath("//label[text()='Current Market Value*']//following-sibling::input");

    private By select_AssetCategory = By.xpath("//label[text()='Asset Category*']//following-sibling::select");

    private By txtInput_YearBuilt = By.xpath("//label[text()='Year Built*']//following-sibling::input");

    private By txtInput_LastRefurbished = By.xpath("//label[text()='Last Refurbished*']//parent::div/div/input");

    private By txtInput_LeasableArea = By.xpath("//label[text()='Leasable Area*']//following-sibling::input");

    private By select_UnitOfMeasureForSpace = By.xpath("//label[text()='Unit of Measure for Space*']//following-sibling::select");

    private By Input_Image = By.xpath("//p[text()='Drag files or click upload here']//preceding-sibling::input");

    private By select_LifeCycle = By.xpath("//label[text()='Lifecycle*']//following-sibling::select");

    private By select_PriamryAssetManager = By.xpath("//label[text()='Primary Asset Manager*']//following-sibling::select");

    private By select_Fund = By.xpath("//label[text()='Fund (Optional)']//following-sibling::select");

    private By select_Portfolio = By.xpath("//label[text()='Portfolio (Optional)']//following-sibling::select");

    private By input_AcquisitionDate = By.xpath("//label[text()='Acquisition Date*']//parent::div//div//input");

    private By select_ValutionMethod = By.xpath("//label[text()='Valuation Method*']//following-sibling::select");

    private By select_Currecy = By.xpath("//label[text()='Currency*']//following-sibling::select");
    private By btn_CancelForOverview = By.xpath("//button[text()='Close']");
    private By btn_NextForOverview = By.xpath("//button[text()='Next']");
    private By btn_Submit = By.xpath("//button[text()='Submit']");
    private By check_Name = By.xpath("//h1");
    private By check_name2 = By.xpath("//div[@class='item pb-3 address']//div[@class='label']");
    private By check_Category = By.xpath("//div[text()='Asset Category']//following-sibling::div");
    private By check_category2 = By.xpath("//div[@class='description-with-dropdown']//p[1]");
    private By check_MarketValue = By.xpath("//p[text()='Current Market Value']//parent::div//h4");
    private By check_Manager = By.xpath("//div[text()='Primary Asset Manager']//following-sibling::div");
    private By check_Fund = By.xpath("//div[text()='Fund']//following-sibling::div");
    private By check_YearBuilt = By.xpath("//div[text()='Year Built']//following-sibling::div");
    private By check_Portfolio = By.xpath("//div[text()='Portfolio']//following-sibling::div");
    private By check_AcqDate = By.xpath("//div[text()='Acquisition Date']//following-sibling::div");
    private By check_LastRefDate = By.xpath("//div[text()='Last Refurbished']//following-sibling::div");
    private By check_Currency = By.xpath("//div[text()='Currency']//following-sibling::div");
    private By check_UnitSpace = By.xpath("//div[text()='Unit of Measure for Space']//following-sibling::div");
    private By check_Area = By.xpath("//div[text()='Leasable Area']//following-sibling::div");
    private By check_Valuation = By.xpath("//div[text()='Valuation Method']//following-sibling::div");
    private By check_Code = By.xpath("//div[text()='External Asset Code']//following-sibling::div");
    private By check_address = By.xpath("//div[@class='item pb-3 address']//div[@class='value']");
    private By detailsTab = By.xpath("//a[text()='Details']");
    private By editButton = By.xpath("//a[text()='Edit']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");
    private By outsideclick = By.xpath("//div[@class='offcanvas-body pt-4']");
    public EditAssetPage(WebDriver driver) {

        this.driver = driver;
    }

    public void deatilsPage() throws InterruptedException {
        driver.findElement(detailsTab).click();
        Thread.sleep(1000);
        driver.findElement(editButton).click();
        Thread.sleep(500);
    }

    public void overViewTab(String name, String code, String country, String address, String city, String state,
                            String zipcode, String category, String lifecycle, String marketvalue, String manager, String fund,
                            String protfolio, String acquisitiondate, String yearbuilt, String lastrefurbished, String currency,
                            String unitofmeasure, String area, String valuationmethod) throws InterruptedException {


        if (name.length() > 0) {
            driver.findElement(txtInput_Name).clear();
            driver.findElement(txtInput_Name).sendKeys(name);
        }
        if (code.length() > 0) {
            driver.findElement(txtInput_ExternalAssetCode).clear();
            driver.findElement(txtInput_ExternalAssetCode).sendKeys(code);
        }
        if (country.length() > 0) {
            driver.findElement(select_Country).click();
            int Country = driver.findElements(By.xpath("//option[text()='" + country + "']")).size();
            if (Country > 0) {
                driver.findElement(By.xpath("//option[text()='" + country + "']")).click();
            }
        }
        if (address.length() > 0) {
            driver.findElement(txtInput_AddressLine1).clear();
            driver.findElement(txtInput_AddressLine1).sendKeys(address);
        }
        if (city.length() > 0) {
            driver.findElement(txtInput_City).clear();
            driver.findElement(txtInput_City).sendKeys(city);
        }
        if (state.length() > 0) {
            Select State = new Select(driver.findElement(select_State));
            State.selectByVisibleText(state);
        }
        if (zipcode.length() > 0) {
            driver.findElement(input_ZipCode).clear();
            driver.findElement(input_ZipCode).sendKeys(zipcode);
        }
        if (marketvalue.length() > 0) {
            driver.findElement(txtInput_CurrentMarketValue).clear();
            driver.findElement(txtInput_CurrentMarketValue).sendKeys(marketvalue);
        }
        if (category.length() > 0) {
            Select assetCategory = new Select(driver.findElement(select_AssetCategory));
            assetCategory.selectByVisibleText(category);
        }
        if (yearbuilt.length() > 0) {
            driver.findElement(txtInput_YearBuilt).clear();
            driver.findElement(txtInput_YearBuilt).sendKeys(yearbuilt);
        }
        if (lastrefurbished.length() > 0) {
            driver.findElement(txtInput_LastRefurbished).clear();
            driver.findElement(txtInput_LastRefurbished).sendKeys(lastrefurbished);
        }
        if (area.length() > 0) {
            driver.findElement(txtInput_LeasableArea).clear();
            driver.findElement(txtInput_LeasableArea).sendKeys(area);
        }
        if (unitofmeasure.length() > 0) {
            Select unitOfMeasure = new Select(driver.findElement(select_UnitOfMeasureForSpace));
            unitOfMeasure.selectByVisibleText(unitofmeasure);
        }
        if (lifecycle.length() > 0) {
            Select lifeCycle = new Select(driver.findElement(select_LifeCycle));
            lifeCycle.selectByVisibleText(lifecycle);
        }
        if (manager.length() > 0) {
            Select primaryAssetManager = new Select(driver.findElement(select_PriamryAssetManager));
            primaryAssetManager.selectByVisibleText(manager);
        }
        if (fund.length() > 0) {
            driver.findElement(select_Fund).click();
            int Fund = driver.findElements(By.xpath("//option[text()='" + fund + "']")).size();
            if (Fund > 0) {
                driver.findElement(By.xpath("//option[text()='" + fund + "']")).click();
            }
        }
        if (protfolio.length() > 0) {
            driver.findElement(select_Portfolio).click();
            int Protfolio = driver.findElements(By.xpath("//option[text()='" + protfolio + "']")).size();
            if (Protfolio > 0) {
                driver.findElement(By.xpath("//option[text()='" + protfolio + "']")).click();
            }
        }
        if (acquisitiondate.length() > 0) {
            driver.findElement(input_AcquisitionDate).clear();
            driver.findElement(input_AcquisitionDate).sendKeys(acquisitiondate);
        }
        if (valuationmethod.length() > 0) {
            Select ValuationMethod = new Select(driver.findElement(select_ValutionMethod));
            ValuationMethod.selectByVisibleText(valuationmethod);
        }
        if (currency.length() > 0) {
            Select Currency = new Select(driver.findElement(select_Currecy));
            Currency.selectByVisibleText(currency);
        }
        driver.findElement(outsideclick).click();
        driver.findElement(btn_CancelForOverview).isDisplayed();
        driver.findElement(btn_CancelForOverview).isEnabled();
        driver.findElement(btn_NextForOverview).isDisplayed();

        if (driver.findElement(btn_NextForOverview).isEnabled()) {
            driver.findElement(btn_NextForOverview).click();
        }
        if (driver.findElement(btn_NextForOverview).isEnabled()) {
            driver.findElement(btn_NextForOverview).click();
        }
        if (driver.findElement(btn_NextForOverview).isEnabled()) {
            driver.findElement(btn_NextForOverview).click();
        }
        Thread.sleep(1000);
        if (driver.findElement(btn_Submit).isEnabled()) {
            driver.findElement(btn_Submit).click();
//            Thread.sleep(2000);
        }
    }

    public void updatedValueCheck(String name, String code, String country, String address, String city, String state,
                                  String zipcode, String category, String lifecycle, String marketvalue, String manager, String fund,
                                  String protfolio, String acquisitiondate, String yearbuilt, String lastrefurbished, String currency,
                                  String unitofmeasure, String area, String valuationmethod,String toaster) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(600));
        driver.findElement(toasterBox).isDisplayed();
        String toaster_msg = driver.findElement(toasterBox).getText();
        Assert.assertEquals(toaster_msg,toaster,"Expected : "+toaster+" But found : "+toaster_msg);
        Thread.sleep(1000);
        if (name.length() > 0) {
            String name_1 = driver.findElement(check_Name).getText();
            String name_2 = driver.findElement(check_name2).getText();
            Assert.assertEquals(name_1,name,"Expected : "+name + " But Found : "+name_1);
            Assert.assertEquals(name_2,name,"Expected : "+name + " But Found : "+name_2);
        }
        if (code.length() > 0) {
            String Code = driver.findElement(check_Code).getText();
            Assert.assertEquals(Code,code,"Expected : "+code + " But Found : "+Code);
        }
        if (country.length() > 0) {
            String Country = driver.findElement(check_address).getText();
            Assert.assertTrue(Country.contains(country),"Expected : "+country + " But Found : "+Country);
        }
        if (address.length() > 0) {
            String Address = driver.findElement(check_address).getText();
            Assert.assertTrue(Address.contains(address),"Expected : "+address + " But Found : "+Address);
        }
        if (city.length() > 0) {
            String City = driver.findElement(check_address).getText();
            Assert.assertTrue(City.contains(city),"Expected : "+city + " But Found : "+City);
        }
        if (state.length() > 0) {
            String State = driver.findElement(check_address).getText();
            Assert.assertTrue(State.contains(state),"Expected : "+state + " But Found : "+State);
        }
        if (zipcode.length() > 0) {
            String ZipCode = driver.findElement(check_address).getText();
            Assert.assertTrue(ZipCode.contains(zipcode),"Expected : "+zipcode + " But Found : "+ZipCode);
        }
        if (marketvalue.length() > 0) {
            String MarketValue = driver.findElement(check_MarketValue).getText().replace("$","");
            Assert.assertEquals(MarketValue,marketvalue,"Expected : "+marketvalue + " But Found : "+MarketValue);
        }
        if (category.length() > 0) {
            String Category_1 = driver.findElement(check_Category).getText();
            String Category_2 = driver.findElement(check_category2).getText();
            Assert.assertEquals(Category_1,category,"Expected : "+category + " But Found : "+Category_1);
            Assert.assertTrue(Category_2.contains(category),"Expected : "+category + " But Found : "+Category_2);
        }
        if (yearbuilt.length() > 0) {
            String YearBuilt = driver.findElement(check_YearBuilt).getText();
            Assert.assertEquals(YearBuilt,yearbuilt,"Expected : "+yearbuilt + " But Found : "+YearBuilt);
        }
        if (lastrefurbished.length() > 0) {
            String LastRefurbished = driver.findElement(check_LastRefDate).getText();
            Assert.assertEquals(LastRefurbished,lastrefurbished,"Expected : "+lastrefurbished + " But Found : "+LastRefurbished);
        }
        if (area.length() > 0) {
            String Area = driver.findElement(check_Area).getText();
            Area = Area.substring(0,Area.length()-5);
            Assert.assertEquals(Area,area,"Expected : "+area + " But Found : "+Area);
        }
        if (unitofmeasure.length() > 0) {
            String UnitofMeasure = driver.findElement(check_UnitSpace).getText().toUpperCase();
            Assert.assertEquals(UnitofMeasure,unitofmeasure,"Expected : "+unitofmeasure + " But Found : "+UnitofMeasure);
        }
//        if (lifecycle.length() > 0) {
//            String LifeCycle = driver.findElement(check_l).getText();
//            Assert.assertEquals(UnitofMeasure,unitofmeasure,"Expected : "+unitofmeasure + " But Found : "+UnitofMeasure);
//        }
        if (manager.length() > 0) {
            String Manager = driver.findElement(check_Manager).getText();
            Assert.assertEquals(Manager,manager,"Expected : "+manager + " But Found : "+Manager);
        }
        if (fund.length() > 0) {
            String Fund = driver.findElement(check_Fund).getText();
            Assert.assertEquals(Fund,fund,"Expected : "+fund + " But Found : "+Fund);
        }
        if (protfolio.length() > 0) {
            String Portfolio = driver.findElement(check_Portfolio).getText();
            Assert.assertEquals(Portfolio,protfolio,"Expected : "+protfolio + " But Found : "+Portfolio);
        }
        if (acquisitiondate.length() > 0) {
            String AcqDate = driver.findElement(check_AcqDate).getText();
            Assert.assertEquals(AcqDate,acquisitiondate,"Expected : "+acquisitiondate + " But Found : "+AcqDate);
        }
        if (valuationmethod.length() > 0) {
            String Valuation = driver.findElement(check_Valuation).getText();
            Assert.assertEquals(Valuation,valuationmethod,"Expected : "+valuationmethod + " But Found : "+Valuation);
        }
        if (currency.length() > 0) {
            String Currency = driver.findElement(check_Currency).getText();
            Assert.assertEquals(Currency,currency,"Expected : "+currency + " But Found : "+Currency);
        }

    }


}
