package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FileImportPage {

    private WebDriver driver;


    private By Asset_Tab = By.xpath("//*[@class='sidemenu-content']//a[3]//i");
    private By loan = By.xpath("//*[text()='Loans']");
    private By impot = By.xpath("//*[text()=' Import']");
    private By I_loan = By.xpath("//*[text()='Import Loan']//following::div//div//div//div//input");
    private By impot_btn = By.xpath("//*[text()='Import']");
    private By toaster = By.xpath("//div[contains(@class,'toaster')]//p");
    private By tenant = By.xpath("//*[text()='Tenants']");
    private By I_tenant = By.xpath("//*[text()='Import Tenant']//following::div//div//div//div//input");
//    private By error = By.xpath("//*[@class='toaster error']//p");
    private By text = By.xpath("(//*[text()='Skyview Apartments']//following-sibling::div//p)[1]");
    private By units = By.xpath("//*[text()='Units']");
    private By I_units = By.xpath("//*[text()='Import Unit']//following::div//div//div//div//input");
    private By check_category2 = By.xpath("//div[@class='description-with-dropdown']//p[1]");

    public FileImportPage(WebDriver driver) {

        this.driver = driver;
    }

    public void click_loan(String Loan, String filetoaster, String loantoaster,String names) throws InterruptedException {
        driver.findElement(loan).click();
        Thread.sleep(500);
        driver.findElement(impot).click();
        driver.findElement(I_loan).sendKeys(Loan);
        String bef_toaster = driver.findElement(toaster).getText();
        Assert.assertEquals(bef_toaster, filetoaster);
        driver.findElement(impot_btn).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(toaster).isDisplayed();
        String s = driver.findElement(toaster).getText();
        Assert.assertEquals(s, loantoaster);
        Thread.sleep(500);
        String[] Names = names.split(",");
        for (int i = 1; i < Names.length; i++) {
            String name = driver.findElement(By.xpath("//table//tbody//tr//td[1]//a[text()='" + Names[i] + "']")).getText();
            System.out.println(name);
        }
    }

    public void import_tenant(String Tenant, String filetoaster, String tenanttoaster,String names,String unit,String unitfilemsg,String unittoaster,String unitnames) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if(driver.findElement(check_category2).getText().contains("Multi")){
            driver.findElement(units).click();
            driver.findElement(impot).click();
            driver.findElement(I_units).sendKeys(unit);
            String bef_toaster = driver.findElement(toaster).getText();
            Assert.assertEquals(bef_toaster, unitfilemsg);
            driver.findElement(impot_btn).click();
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(toaster).isDisplayed();
            String s = driver.findElement(toaster).getText();
            Assert.assertEquals(s, unittoaster);
            Thread.sleep(500);
        } else {
            driver.findElement(tenant).isDisplayed();
            driver.findElement(tenant).click();
            Thread.sleep(2000);
            driver.findElement(impot).click();
            driver.findElement(I_tenant).sendKeys(Tenant);
            String bef_toaster = driver.findElement(toaster).getText();
            Assert.assertEquals(bef_toaster, filetoaster);
            driver.findElement(impot_btn).click();
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(toaster).isDisplayed();
            String s = driver.findElement(toaster).getText();
            Assert.assertEquals(s, tenanttoaster);
            Thread.sleep(500);
            String[] Tenant_Name = names.split(",");
            for (int i = 1; i < Tenant_Name.length; i++) {
                String name = driver.findElement(By.xpath("//table//tbody//tr//td[1]//a[text()='" + Tenant_Name[i] + "']")).getText();
                System.out.println(name);
            }
        }
    }

    public void verify() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
}
