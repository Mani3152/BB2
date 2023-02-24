package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateLoanPage {

    private WebDriver driver;
    List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
    List<LinkedHashMap<String, String>> excelData;
    boolean generalTab = false;
    boolean balanceTab = false;
    boolean termTab = false;
    boolean rateTab = false;
    boolean success = false;

    // 1. By Locators: OR
    private By nextButton = By.xpath("//button[text()='Next']");
    private By graphdiv = By.xpath("//div[@class='col-lg-8']");

    // 2. Constructor of the page class:
    public CreateLoanPage(WebDriver driver) {
        this.driver = driver;
    }


    //Click on Properties
    public void gotToAssetPage() {

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='/assets']//i")).click();
    }
    //Click on a particular Asset
    public void clickOnparticularAsset(String particular_asset) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//img[@title='" + particular_asset + "']")).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
        driver.findElement(graphdiv).isDisplayed();
    }
    //Select the Loans Tab
    public void clickOnLoans() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Loans']")).click();
    }
    //Click on New Loan
    public void newLoan() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(.,'New Loan')]//i")).click();
    }
    //Enter the Deatils in General tab

    public void enterDetailsIntoGeneralTab(String externalCode, String loanName, String lender, String servicer, String loanType, String leinPosition, String loanStatus) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//label[contains(.,'External Code')]//following-sibling::input")).isDisplayed();
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        driver.findElement(By.xpath("//label[contains(.,'External Code')]//following-sibling::input"))
                .sendKeys(externalCode + rand_int1);
        driver.findElement(By.xpath("//label[contains(.,'Loan Name')]//following-sibling::input")).sendKeys(loanName);
        driver.findElement(By.xpath("//label[contains(.,'Lender')]//following-sibling::input")).sendKeys(lender);
        driver.findElement(By.xpath("//label[contains(.,'Servicer')]//following-sibling::input"))
                .sendKeys(servicer);
        Select lt = new Select(
                driver.findElement(By.xpath("//label[contains(.,'Loan Type')]//following-sibling::select")));
        lt.selectByVisibleText(loanType);
        Select lp = new Select(
                driver.findElement(By.xpath("//label[contains(.,'Lien Position')]//following-sibling::select")));
        lp.selectByVisibleText(leinPosition);
        Select ls = new Select(driver.findElement(By.xpath("//label[contains(.,'Loan Status')]//following-sibling::select")));
        ls.selectByVisibleText(loanStatus);
        if (driver.findElement(nextButton).isEnabled()) {
            driver.findElement(nextButton).click();
            generalTab = true;
            System.out.println("General Tab passed");
        } else {
            System.out.print("Error in Next Button or Data in General Tab");
        }
    }
    //Enter the Details in Balance Tab
    public void enterDetailsIntoBalanceTab(String originalBalance, String currentBalance) {
        if (generalTab) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(By.xpath("//label[contains(.,'Original Balance')]//following-sibling::input")).isDisplayed();
            driver.findElement(By.xpath("//label[contains(.,'Original Balance')]//following-sibling::input"))
                    .sendKeys(originalBalance);
            driver.findElement(By.xpath("//label[contains(.,'Current Balance (USD)')]//following-sibling::input"))
                    .sendKeys(currentBalance);

            if (driver.findElement(nextButton).isEnabled()) {
                driver.findElement(nextButton).click();
                balanceTab = true;
                System.out.println("balance Tab passed");
            } else {
                System.out.print("Error in Next Button or Data in Balance Tab");
            }
        }
    }

    //Enter the Details in Term Tab
    public void enterDetailsIntoTermTab(String originationDate, String maturityDate,String term) {
        if (generalTab && balanceTab) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(By.xpath("//input[@placeholder='Origination Date']")).isDisplayed();
            driver.findElement(By.xpath("//input[@placeholder='Origination Date']"))
                    .sendKeys(originationDate);
            driver.findElement(By.xpath("//*[text()='Maturity Date*']//following-sibling::div//input"))
                    .sendKeys(maturityDate);
//            driver.findElement(By.xpath("//input[@placeholder='Origination Date']")).click();
            driver.findElement(By.xpath("//label[contains(.,'Term')]//following::input")).sendKeys(term);
            if (driver.findElement(nextButton).isEnabled()) {
                driver.findElement(nextButton).click();
                termTab = true;
                System.out.println("details Tab passed");
            } else {
                System.out.print("Error in Next Button or Data in Term Tab");
            }
        }
    }
    // Enter the Details in Rate Tab
    public void enterDetailsintoRateTab(String rateType, String rate, String daysConvention,String margin) {
        if (generalTab && balanceTab && termTab) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(By.xpath("//label[contains(.,'Rate Type')]//following-sibling::select")).isDisplayed();
            Select rt = new Select(
                    driver.findElement(By.xpath("//label[contains(.,'Rate Type')]//following-sibling::select")));
            rt.selectByVisibleText(rateType);
            if(rateType.equals("Fixed")){
                driver.findElement(By.xpath("//label[text()='Rate*']//following-sibling::div//input")).sendKeys(rate);
            }
            else{
                driver.findElement(By.xpath("//label[text()='Spread/Margin*']//following-sibling::div//input")).sendKeys(margin);
            }
            Select dc = new Select(driver.findElement(By.xpath("//label[text()='Days Conventions*']//following-sibling::select")));
            dc.selectByVisibleText(daysConvention);
            if (driver.findElement(nextButton).isEnabled()) {
                driver.findElement(nextButton).click();
                rateTab = true;
                System.out.println("rate Tab passed");
            } else {
                System.out.print("Error in Next Button or Data in Rate Tab");
            }
        }
    }

    //Enter the Details in Payment Tab
    public void enterDetailsIntoPaymentTab(String paymentType, String amStartDate, String amTerm, String amType) {
        if (generalTab && balanceTab && termTab && rateTab) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(By.xpath("//label[text()='Payment Type*']//following-sibling::select")).isDisplayed();
            Select pt = new Select(
                    driver.findElement(By.xpath("//label[text()='Payment Type*']//following-sibling::select")));
            pt.selectByVisibleText(paymentType);

            if (paymentType.equals("Balloon")) {

                driver.findElement(By.xpath("//label[text()='Amortization Start Date*']//following-sibling::div//input"))
                        .sendKeys(amStartDate);
            }

            if (paymentType.equals("Balloon")) {
                driver.findElement(By.xpath("//label[text()='Amortization Term( yrs)*']//following-sibling::input"))
                        .sendKeys(amTerm);
            }

            Select amortizationType = new Select(driver.findElement(By.xpath("//label[text()='Amortization Type*']//following-sibling::select")));
            amortizationType.selectByVisibleText(amType);


        }
        System.out.println("payment Tab passed");

    }
    // Click on SUbmit Button
    public void submit_button_for_AddLoan() throws InterruptedException {
        if(generalTab && balanceTab && termTab && rateTab){
            if (driver.findElement(By.xpath("//button[text()='Create']")).isEnabled()) {
                driver.findElement(By.xpath("//button[text()='Create']")).click();
                Thread.sleep(2000);
                success = true;

            }
        }

    }
    //Verify the New Loan Present or not
    public void verifySuccessfullMessage(String expSuccesMessage,String LoanName) throws InterruptedException{
        if(success){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(By.xpath("//app-custom-toaster//div//p")).isDisplayed();
            String actSucessMessage = driver.findElement(By.xpath("//app-custom-toaster//div//p")).getText();
            Assert.assertEquals(expSuccesMessage,actSucessMessage);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[text()='" + LoanName + "']"));
        }


    }



}
