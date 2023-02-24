package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class SalesAssumptionPage {

    private WebDriver driver;

    public SalesAssumptionPage(WebDriver driver) {
        this.driver = driver;
    }

    private By valuation = By.xpath("//*[text()='Valuations']");
    private By Asset_Tab = By.xpath("//*[@class='sidemenu-content']//a[3]//i");
    private By edit = By.xpath("//*[text()='Edit']");
    private By holding_period = By.xpath("//*[text()='Holding Period (yr)']//following-sibling::input");
    private By sale_cost = By.xpath("//*[text()='Sale Costs']//parent::div//div//input");
    private By terminal_rate = By.xpath("//*[text()='Terminal Cap Rate']//parent::div//div//input");
    private By sale_price = By.xpath("//*[text()='Sale Price Adjustment']//following-sibling::input");
    private By submit = By.xpath("//*[text()='Submit']");
    private By H_verify = By.xpath("//*[text()='Sale Assumptions']//parent::div//following-sibling::div//table//td[text()='Holding Period (yr)']//following-sibling::td");
    private By S_cost = By.xpath("//*[text()='Sale Assumptions']//parent::div//following-sibling::div//table//td[text()='Sale Costs (%)']//following-sibling::td");
    private By T_rate = By.xpath("//*[text()='Sale Assumptions']//parent::div//following-sibling::div//table//td[text()='Terminal Cap Rate']//following-sibling::td");
    private By SP_value = By.xpath("//*[text()='Sale Assumptions']//parent::div//following-sibling::div//table//td[text()='Sale Price Adjustment']//following-sibling::td");

    public void click_Asset(String particular_asset) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(Asset_Tab).click();
        driver.findElement(By.xpath("//img[@title='" + particular_asset + "']")).isDisplayed();
        driver.findElement(By.xpath("//img[@title='" + particular_asset + "']")).click();
        Thread.sleep(1000);

    }

    public void click_valuation(String Holding_Period, String Sale_Costs, String Terminal_Rate, String Sale_Price_Adjustment) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(2000);
        driver.findElement(valuation).isDisplayed();
        driver.findElement(valuation).click();
        driver.findElement(edit).isDisplayed();
        driver.findElement(edit).click();
        driver.findElement(holding_period).clear();
        driver.findElement(holding_period).sendKeys(Holding_Period);
        driver.findElement(sale_cost).clear();
        driver.findElement(sale_cost).sendKeys(Sale_Costs);
        driver.findElement(terminal_rate).clear();
        driver.findElement(terminal_rate).sendKeys(Terminal_Rate);
        driver.findElement(sale_price).clear();
        driver.findElement(sale_price).sendKeys(Sale_Price_Adjustment);
        Thread.sleep(1000);
        driver.findElement(submit).click();
    }

    public void verify_edit(String Holding_Period, String Sale_Costs, String Terminal_Rate,String Sale_Price_Adjustment) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(1000);
        String hold_value = driver.findElement(H_verify).getText();
        Assert.assertEquals(hold_value, Holding_Period,"Expected : "+Holding_Period + " But Found : "+hold_value);
        String cost = driver.findElement(S_cost).getText();
        Assert.assertEquals(cost,Sale_Costs,"Expected : "+Sale_Costs + " But Found : "+cost);
        String rate = driver.findElement(T_rate).getText().replace("%", "");
        Assert.assertEquals(rate, Terminal_Rate,"Expected : "+Terminal_Rate + " But Found : "+rate);
        String salesPrice = driver.findElement(SP_value).getText();
        Assert.assertEquals(salesPrice,Sale_Price_Adjustment,"Expected : "+Sale_Price_Adjustment + " But Found : "+salesPrice);
    }
}
