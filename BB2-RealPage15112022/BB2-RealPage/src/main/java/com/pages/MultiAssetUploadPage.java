package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;


public class MultiAssetUploadPage {

    private WebDriver driver;

    boolean overviewFlag  = false;
    boolean valuationsFlag  = false;
    boolean loansFlag  = false;
    boolean flag = false;

    private By properties = By.xpath("//a[@href='/assets']//i");
    private By importButton = By.xpath("//button[@ngbtooltip='Import']");
    private By uploadFile = By.xpath("//*[@class='drag-and-drop-area']//div//input");
    private By nextButton = By.xpath("//button[text()='Next']");
    private By cashflowFile = By.xpath("//label[text()='Cash Flows']//parent::div//following-sibling::div[1]//div[@class='content']//input");
    private By assumptionsFile = By.xpath("//label[text()='Assumptions']//parent::div//following-sibling::div[1]//div[@class='content']//input");
    private By submitButton = By.xpath("//button[text()='Submit']");

    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");
//    private By toasterBox1 = By.xpath("//*[@class='toaster error']//p");
//    private By toasterSuccess = By.xpath("//*[@class='toaster success']//p");


    public MultiAssetUploadPage(WebDriver driver) {

        this.driver = driver;
    }

    //Go to Properties Page
    public void propertiesPage() throws InterruptedException {
        driver.findElement(properties).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(importButton).isDisplayed();
        Thread.sleep(1000);
        driver.findElement(importButton).isEnabled();
        driver.findElement(importButton).click();
    }

    // Upload The Multi Asset FIles Here
    public void filesUpload(String overViewFile, String cashFlowFile, String assumptionFile, String loanFile, String tenantFile,String overviewError,String cashflowError,String assumptionsError,String loanError,String tenantError) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(uploadFile).sendKeys(overViewFile);//Uplaod Overview File
//        Thread.sleep(1000);
        String actOverviewMessage = driver.findElement(toasterBox).getText();
        if (driver.findElement(nextButton).isEnabled()) {
            driver.findElement(nextButton).click();
            Thread.sleep(1000);
            String actCashflowMessage="";
            String actAssumptionMessage = "";
            if(assumptionsError.contains("Excel sheet validated successfully")){
                driver.findElement(cashflowFile).sendKeys(cashFlowFile);//Uplaod CashFLow FIle
                 actCashflowMessage = driver.findElement(toasterBox).getText();
            }
            Thread.sleep(1000);
            if(cashflowError.contains("Excel sheet validated successfully")){
                driver.findElement(assumptionsFile).sendKeys(assumptionFile);//Upload Assumptions FIle Here
//                Thread.sleep(500);
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//                driver.findElement(toasterBox).isDisplayed();
                actAssumptionMessage = driver.findElement(toasterBox).getText();
            }
//            Thread.sleep(1500);
            if (driver.findElement(nextButton).isEnabled()) {
                driver.findElement(nextButton).click();
                driver.findElement(uploadFile).sendKeys(loanFile);//Uplaod Loans File here
                String actLoanMessage = driver.findElement(toasterBox).getText();
//                Thread.sleep(1500);
                if (driver.findElement(nextButton).isEnabled()) {
                    driver.findElement(nextButton).click();
                    driver.findElement(uploadFile).sendKeys(tenantFile);//Upload Tenants File Here
//                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//                    driver.findElement(toasterBox).isDisplayed();
                    String actTenantMessage = driver.findElement(toasterBox).getText();
                    if (driver.findElement(submitButton).isEnabled()) {
                        driver.findElement(submitButton).click();//CLick on Submit Button
                        flag = true;

//            Thread.sleep(1000);

//                        Thread.sleep(2000);
//                        verifyCreatedAssets(viewAsset);

                    } else {
                        Assert.assertEquals(tenantError,actTenantMessage);
                        System.out.println("Error in Next Button of Tenant Tab");
                    }
                } else {
                    Assert.assertEquals(loanError,actLoanMessage);
                    System.out.println("Error in Next Button of Loan Tab");
                }
            }
            else {
                if(assumptionsError.contains("Excel sheet validated successfully")){
                    Assert.assertEquals(cashflowError,actCashflowMessage);
                }else{
                    Assert.assertEquals(assumptionsError,actAssumptionMessage);
                }
                System.out.println("Error in Next Button of Valuation Tab");
            }
        }
        else {
            System.out.println(overviewError+"----overviewerrorrrrr");
            System.out.println(actOverviewMessage+"----toaster errorr");
            Assert.assertEquals(overviewError,actOverviewMessage,"Expected : "+overviewError+" But Found : "+actOverviewMessage);
            System.out.println("Error in Next Button of Overview Tab");
        }

    }

    //CLick On a Particualr Asset
    public void verifyCreatedAssets( String finalmsg) throws InterruptedException {
        if(flag){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
            driver.findElement(toasterBox).isDisplayed();
            String finalToaster = driver.findElement(toasterBox).getText();
            System.out.println(finalToaster + "---toaster");
            Assert.assertEquals(finalmsg, finalToaster, "Expected : " + finalmsg + " But Found : " + finalToaster);
            System.out.println("Successful");
        }
    }

    //Verify The Loans tab
    public void verifyLoansTab() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Loans']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()=' Loan Name ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Lender ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Asset Name ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Type ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Balance ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Rate ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Component Rate ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Matures ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()=' Payment Type ']")).isDisplayed();
//        System.out.println("loan");
    }
    // Verify The Tenants Tab
    public void verifytenantsTab(String name) throws InterruptedException {
        String value = driver.findElement(By.xpath("//h1[text()='" + name + "']//parent::div//p")).getText();
        String[] split_value = value.split("\\|");
        if (split_value[0].equals("Multifamily Asset")) {
            driver.findElement(By.xpath("//a[text()='Units']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()=' Unit Type ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Unit Type Code ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Period ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Total Units ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Leased Units ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Vacant Units ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Leased Expired ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Leased But Unoccupied Units ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Avg Rent Collected Per Unit ']")).isDisplayed();
            driver.findElement(By.xpath("//*[text()=' Avg Market Rent Per Unit ']")).isDisplayed();
//            System.out.println("nits");
        }
    }

    public void checkAssetData(String name) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='"+name+"']")).isDisplayed();
        driver.findElement(By.xpath("//p[contains(.,'Last Updated')]")).isDisplayed();
        driver.findElement(By.xpath("//a[text()='Overview']")).isDisplayed();
        driver.findElement(By.xpath("//a[text()='Valuations']")).isDisplayed();
        driver.findElement(By.xpath("//a[text()='Loans']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Edit']")).isDisplayed();
        driver.findElement(By.xpath("//*[@class='btn btn-lightgrey icon-only btn-delete']")).isDisplayed();
        driver.findElement(By.xpath("//*[@class='icon rpi-download']")).isDisplayed();
//        driver.findElement(By.xpath("//*[@alt='"+name+"']")).isDisplayed();
        driver.findElement(By.xpath("//p[text()='Current Market Value']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Asset Category']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Primary Asset Manager']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Fund']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Location']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Address1']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='City']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='State']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Zip Code']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Country']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Year Built']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Portfolio']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Acquisition Date']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Last Refurbished']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Currency']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Unit of Measure for Space']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Leasable Area']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Valuation Method']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='External Asset Code']")).isDisplayed();
    }
    //Check the Data Present in the Valuations Tab
    public void checkValuationsData() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Valuations']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//h5[text()='Successfully Created Loan Valuation']")).isDisplayed();
        driver.findElement(By.xpath("//h5[text()='Cash Flow ']")).isDisplayed();
        driver.findElement(By.xpath("//h5[text()='Sale Assumptions']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Discount Rate']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Terminal Cap Rate']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Value']")).isDisplayed();

//	        ArrayList<String> elementsInList =  new ArrayList<String>();

        driver.findElement(By.xpath("//*[text()='Value per SF']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Operating Revenue']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Operating Expenditure']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='NOI']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Capital Expenditure']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Unlevered Cash Flow']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Debt Service']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Levered Cash Flow']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Net Cash Flow Yield']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Holding Period (yr)']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Gross Sale Proceeds']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Sale Costs (%)']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Reversion NOI']")).isDisplayed();
//        driver.findElement(By.xpath("//*[text()='Cost of Sale ']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Terminal Cap Rate']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Net Sale Proceeds']")).isDisplayed();
//        driver.findElement(By.xpath("//button[text()=' Export']//i")).isEnabled();
//        driver.findElement(By.xpath("//button[text()=' Export']//i")).click();
//        Thread.sleep(2000);
//        waitUntilFileToDownload("/home/uttham-vlit/Download/","Valuation_GOOGLE OFFICE P.xlsx");
    }

}
