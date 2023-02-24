package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class SearchPortfolioPage {

    private WebDriver driver;

    private By portfolio_Tab = By.xpath("//*[@class='sidemenu-content']//a[2]//i");
    private By Asset_dropdown = By.xpath("(//*[@class='filter-section-start']//following-sibling::div//select)[1]");
    private By portfolio = By.xpath("//table//tbody//tr//td[1]//a");
    private By asset = By.xpath("(//*[text()='Assets'])[2]");
    private By Asset_Tab = By.xpath("//*[@class='sidemenu-content']//a[3]//i");
    private By detail = By.xpath("//*[text()='Details']");
    private By portfolio_B = By.xpath("//div[text()='Portfolio']//following-sibling::div");
    private By portfolio_display = By.xpath("(//*[text()='Portfolios'])[2]");
    private By search = By.xpath("//*[@type='text']");
    private By search_portfolio = By.xpath("//table//tbody//tr//td[1]");
    private By cards_btn = By.xpath("//*[text()=' Cards']");
    private By Asset_search = By.xpath("(//*[@type='text'])[3]");
    private By chech_btn = By.xpath("//ul//li//input");
    private By ok_btn = By.xpath("//*[text()='OK']");
    private By dropdown_card = By.xpath("//*[@id='listGridView']");
    private By verify_asset = By.xpath("//*[@class='card-body']//h6");
    private By search_loan = By.xpath("(//*[@type='text'])[3]");
    private By graphdiv = By.xpath("//div[@class='col-lg-8']");
    private By check_category2 = By.xpath("//div[@class='description-with-dropdown']//p[1]");
    private By tenant = By.xpath("//*[text()='Tenants']");
    private By text = By.xpath("(//*[@type='text'])[3]");
    private By Master_tenant_btn = By.xpath("//*[text()='Master Tenants']");
    private By table_size=By.xpath("//table//tbody//tr//td[1]//a");
    private By loan = By.xpath("//*[text()='Loans']");
    private By unit_Tab = By.xpath("//*[text()='Units']");
    private By search_unit = By.xpath("(//*[@type='text'])[4]");
    private By unit_summary = By.xpath("//*[text()='Unit Summary']");
    private By unit_type = By.xpath("//*[text()='Unit Types']");

    public SearchPortfolioPage(WebDriver driver){
        this.driver = driver;
    }

    public void click_portfolio(String particular_asset) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.findElement(portfolio_Tab).click();
        driver.findElement(Asset_dropdown).click();
        Select sc = new Select(driver.findElement(Asset_dropdown));
        sc.selectByVisibleText(particular_asset);
        driver.findElement(portfolio_display).isDisplayed();
        Thread.sleep(1000);
        driver.findElement(portfolio).click();
    }
    public  void click_Assets_View() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(asset).isDisplayed();
        driver.findElement(asset).click();
        Thread.sleep(1000);

    }

    public void verify_Asset(String particular_asset) throws InterruptedException {
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String asset = driver.findElement(By.xpath("//table//tbody//tr//td[2]//a[text()='" + particular_asset + "']")).getText();
        Assert.assertEquals(asset, particular_asset);
    }

    /**
     * click on Asset
     */

    public void verify_Assetportfolio(String message) throws InterruptedException {
//       click on detail Tab

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String Port = driver.findElement(portfolio_B).getText();
        Assert.assertEquals(Port, message);
    }

    public void verify_search(String data,String error_msg) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //  driver.findElement(portfolio_Tab).click();
        driver.findElement(search).sendKeys(data);
        Thread.sleep(1000);
        if (driver.findElements(search_portfolio).size()>0){
            int size = driver.findElements(search_portfolio).size();
            for (int i = 1; i <= size; i++) {
                String name = driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[1]")).getText();
                if (name.toLowerCase().contains(data.toLowerCase())){
                    System.out.println(name);
                    Assert.assertTrue(true, "Expected Category : " + name + " But found : " + data);

                }
            }
        } else {
            String error = driver.findElement(By.xpath("//h5")).getText();
            Assert.assertEquals(error, error_msg);
            driver.navigate().refresh();
        }

    }

    //click on  portfolio
    //click on particular portfolio
    //click on Assets_View
    public void click_cards(String Asset_data, String error_msg) throws InterruptedException {
//       clicl Asset_view
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(dropdown_card).click();
        driver.findElement(cards_btn).click();
        driver.findElement(Asset_search).sendKeys(Asset_data);
        if (driver.findElements(chech_btn).size()>0) {
            driver.findElement(chech_btn).click();
            driver.findElement(ok_btn).click();
            Thread.sleep(1000);
            String name = driver.findElement(verify_asset).getText();
            if (name.toLowerCase().contains(Asset_data.toLowerCase())) {
                Assert.assertTrue(true, "Expected Category : " + name + " But found : " + Asset_data);
            } else {
                String error = driver.findElements(By.xpath("//h5")).get(1).getText();
                Assert.assertEquals(error, error_msg);
            }
        } else {
            System.out.println(driver.findElement(By.xpath("//*[@class='search-results']//h4")).getText());
        }
        driver.findElement(Asset_search).clear();
        Thread.sleep(1000);
    }

    public void Asset_category(String Category, String error_msg) {
        driver.findElement(Asset_dropdown).click();
        Select sc = new Select(driver.findElement(Asset_dropdown));
        sc.selectByVisibleText(Category);
        String cat_text = "";
        int size = driver.findElements(By.xpath("//strong[text()='Category:']//parent::p")).size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                cat_text = driver.findElements(By.xpath("//strong[text()='Category:']//parent::p")).get(i).getText();

                if (cat_text.contains(Category)) {
                    Assert.assertTrue(true, "Expected Category : " + Category + " But found : " + cat_text);
                }
            }
        } else {
            String error = driver.findElement(By.xpath("//h5")).getText();
            Assert.assertEquals(error, error_msg);
        }

    }

    public void goToParticularAsset(String particular_asset) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//*[text()='Assets']")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//img[@title='" + particular_asset + "']")).isDisplayed();
        driver.findElement(By.xpath("//img[@title='" + particular_asset + "']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        if (!driver.findElement(check_category2).getText().contains("Multi")) {
            driver.findElement(tenant).isDisplayed();
            driver.findElement(tenant).click();
            Thread.sleep(1000);
        }

    }

    public void Enter_data_masterTenant(String data) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(text).sendKeys(data);
        Thread.sleep(2000);

    }
    public void verify_Tenant(String data) {
        if (driver.findElements(table_size).size() > 0) {
            int size = driver.findElements(table_size).size();
            for (int i = 0; i < size; i++) {
                String name = driver.findElement(table_size).getText();
                Assert.assertTrue(true, "Expected Category : " + data + " But found : " + name);
            }
        } else {
            String error = driver.findElement(By.xpath("//h5")).getText();
            Assert.assertEquals(error, "No data to display");
        }
    }
    //click on particular portfolio
    public void click_Tenant() throws InterruptedException {
        driver.findElement(tenant).isDisplayed();
        driver.findElement(tenant).click();
        Thread.sleep(1000);
    }

    public void portfoli0_Master_Tenant(String data) throws InterruptedException {
        driver.findElement(Master_tenant_btn).isDisplayed();
        driver.findElement(text).sendKeys(data);
        Thread.sleep(2000);
    }
    public void Loans_Tab() throws InterruptedException {
        driver.findElement(loan).click();
        Thread.sleep(500);
    }

    public void Search_Loan(String data) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(search_loan).sendKeys(data);
        Thread.sleep(1000);
    }

    public void verify_Search_Loan(String data) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (driver.findElements(By.xpath("//table//tbody//tr[1]//td[1]//a")).size() > 0) {
            int size=driver.findElements(By.xpath("//table//tbody//tr[1]//td[1]//a")).size();
            for (int i=1;i<=size;i++) {
                String loan = driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[1]//a")).getText();
                System.out.println(loan);
                if (loan.toLowerCase().contains(data.toLowerCase())) {
                    Assert.assertTrue(true, "Expected Category : " + data + " But found : " + loan);
                }
            } } else {
            String error = driver.findElement(By.xpath("//h5")).getText();
            Assert.assertEquals(error, "No data to display");
        }



    }

    public void Unit_Tab() throws InterruptedException {
        driver.findElement(unit_Tab).click();
        Thread.sleep(500);
    }
    public void Search_Unit_Summary(String search_unitsummary) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(search_unit).sendKeys(search_unitsummary);
        Thread.sleep(1000);
    }
    public void verify_Search_Unit_Summary(String search_unitsummary) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (driver.findElements(By.xpath("//table//tbody//tr//td//a")).size()>0) {
            String unit = driver.findElement(By.xpath("//table//tbody//tr//td//a")).getText();
            if (unit.toLowerCase().contains(search_unitsummary.toLowerCase())) {
                Assert.assertTrue(true, "Expected Category : " + search_unitsummary + " But found : " + unit);
            }
        } else {
            String error = driver.findElement(By.xpath("//h5")).getText();
            Assert.assertEquals(error, "No data to display");
        }

    }
    public  void click_unitType() throws InterruptedException {
        driver.findElement(unit_type).click();
        Thread.sleep(500);
        driver.findElement(search_unit).clear();
    }
    public void Search_Unit_Type(String search_unittype) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(search_unit).sendKeys(search_unittype);
        Thread.sleep(2000);
    }
    public void verify_Search_Unit_Type(String search_unittype) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (driver.findElements(By.xpath("//table//tbody//tr//td[1]//div[1]")).size()>0) {
            String unit = driver.findElement(By.xpath("//table//tbody//tr//td[1]//div[1]")).getText();
            if (unit.toLowerCase().contains(search_unittype.toLowerCase())) {
                Assert.assertTrue(true, "Expected Category : " + search_unittype + " But found : " + unit);
            }
        } else {
            String error = driver.findElement(By.xpath("//h5")).getText();
            Assert.assertEquals(error, "No data to display");
        }

    }
}
