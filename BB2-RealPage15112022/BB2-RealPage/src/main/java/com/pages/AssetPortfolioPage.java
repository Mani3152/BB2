package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class AssetPortfolioPage {
    private WebDriver driver;

    public AssetPortfolioPage(WebDriver driver) {

        this.driver = driver;
    }

    private By detailsTab = By.xpath("//a[text()='Details']");
    private By editButton = By.xpath("//a[text()='Edit']");
    private By portfolio = By.xpath("//label[contains(.,'Portfolio (Optional)')]//parent::div//select");
    private By nextButton = By.xpath("//button[text()='Next']");
    private By submitButton = By.xpath("//button[text()='Submit']");
    private By portfolioDetails = By.xpath("//div[text()='Portfolio']//parent::div//div[@class='value']");
    private By propertieslink = By.xpath("//a[@class='nav-link active'][@href='/properties']//i");
    private By price = By.xpath("//h4[@class='price']");
    public void changePortfolio(String asset,String Portfolio) throws InterruptedException {
        String[] assets = asset.split(",");
        for(int i=0;i<assets.length;i++){
            System.out.println(assets[i]);
            driver.findElement(By.xpath("//h6[text()='"+assets[i]+"']")).isDisplayed();
            driver.findElement(By.xpath("//h6[text()='"+assets[i]+"']")).click();
            Thread.sleep(1000);
            driver.findElement(detailsTab).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(editButton).isDisplayed();
            driver.findElement(editButton).click();
            Thread.sleep(1000);
            Select port = new Select(driver.findElement(portfolio));
            port.selectByVisibleText(Portfolio);
            driver.findElement(nextButton).click();
            driver.findElement(nextButton).click();
            driver.findElement(nextButton).click();
            driver.findElement(submitButton).click();
            Thread.sleep(4000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.findElement(detailsTab).isEnabled();
            driver.findElement(detailsTab).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.findElement(price).isDisplayed();
            Thread.sleep(1000);
            String editedPortfolio = driver.findElement(portfolioDetails).getText();
            Assert.assertTrue(Portfolio.equals(editedPortfolio),"Expected Portfolio : "+Portfolio +" Actual Portfolio :"+editedPortfolio);
            driver.findElement(propertieslink).click();
        }
    }

    public void gotoParticularPortfolio(String portfolio) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//a[text()='"+portfolio+"']")).isDisplayed();
        driver.findElement(By.xpath("//a[text()='"+portfolio+"']")).click();
        Thread.sleep(1000);
    }

    public void checkAssetsinPortfolio(String asset){
        String[] assets = asset.split(",");
        for(int i=0;i<assets.length;i++) {
            System.out.println(assets[i]);
            driver.findElement(By.xpath("//h6[text()='"+assets[i]+"']"));
        }
    }
}
