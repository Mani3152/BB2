package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DownloadAssetInformationPage {

    private WebDriver driver;

    private By downloadButton = By.xpath("//*[@id=\"dropdownManual\"]//i");
//    private By pdfButton = By.xpath("//button[text()='Print to PDF']");
//    private By wordButton = By.xpath("//button[text()='Save as Word doc']");
    private By downloadAsssetHeading = By.xpath("//*[text()='Download Asset Data']");
    private By dowloand_button = By.xpath("//button[text()='Download']");
    private By graphdiv = By.xpath("//div[@class='col-lg-8']");
    private By check_category2 = By.xpath("//div[@class='description-with-dropdown']//p[1]");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");




    public DownloadAssetInformationPage(WebDriver driver) {

        this.driver = driver;
    }

    public void gotoAssetsPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//a[@href='/assets']//i")).isDisplayed();
        driver.findElement(By.xpath("//a[@href='/assets']//i")).click();
        Thread.sleep(1000);
    }
    // Go to Particular Asset in properties Page
    public void goToParticularAsset(String particular_asset) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//*[text()='Assets']")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//img[@title='"+particular_asset+"']")).isDisplayed();
        driver.findElement(By.xpath("//img[@title='"+particular_asset+"']")).click();
        Thread.sleep(1000);
        if(driver.findElement(check_category2).getText().contains("Multi"))
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(graphdiv).isDisplayed();
    }

    //Click on Download Button and CHoose the format u want to Select and click Submit
    public void downloadAssetInfo(String type,String Content) throws InterruptedException {
        driver.findElement(downloadButton).click();
        Thread.sleep(1000);
        driver.findElement(downloadAsssetHeading).isDisplayed();
        String [] content = Content.split(",");
        for(int i=0;i<content.length;i++){
//            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()='"+content[i]+" ']//parent::div//input")).click();
        }
        Select Type = new Select(driver.findElement(By.xpath("//label[contains(.,'Type')]//following-sibling::select")));

        Type.selectByVisibleText(type.toUpperCase());
        driver.findElement(dowloand_button).isEnabled();
        driver.findElement(dowloand_button).click();
        Thread.sleep(2000);
    }

    public void verify_toaster(String toaster){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
//            Thread.sleep(1000);
        driver.findElement(toasterBox).isDisplayed();
        String finalToaster = driver.findElement(toasterBox).getText();
        System.out.println(finalToaster + "---toaster");
        Assert.assertEquals(toaster, finalToaster, "Expected : " + toaster + " But Found : " + finalToaster);
    }
}
