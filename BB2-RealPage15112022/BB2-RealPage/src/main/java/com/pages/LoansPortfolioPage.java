package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoansPortfolioPage {
    private WebDriver driver;

    int loanSize = 0;
    int loansCountPortfolio =0;

    private  By assetTab = By.xpath("//a[text()='Assets']");
    private By cardDropdown = By.xpath("//*[@id='listGridView']");
    private By cardView = By.xpath("//button[text()=' Cards']");
    private By loansTab = By.xpath("//a[text()='Loans']");
    private By loanCount = By.xpath("//tbody//tr//td[1]");
    private By propertieslink = By.xpath("//a[@href='/assets']//i");
    private By assetNames = By.xpath("//h6[@class='title']");
    private By graphdiv = By.xpath("//div[@class='col-lg-8']");

    public LoansPortfolioPage(WebDriver driver) {

        this.driver = driver;
    }

    ArrayList<String> arrlist = new ArrayList<String>();

    public void assentNamesinPortfolio() throws InterruptedException {
        driver.findElement(assetTab).click();
        Thread.sleep(1000);
        driver.findElement(cardDropdown).click();
        driver.findElement(cardView).click();
        Thread.sleep(500);
        int size = driver.findElements(assetNames).size();
        for(int i=0;i<size;i++){
            arrlist.add(driver.findElements(assetNames).get(i).getText());
        }
        System.out.println(arrlist+"arrlist");
    }

    public void gotToAssetPage() {

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(propertieslink).click();
    }
    public void loansCount() throws InterruptedException {
        Thread.sleep(1000);
//        String[] assets = asset.split(",");
        for(int i=0;i<arrlist.size();i++){
            System.out.println(arrlist.get(i));
            if(driver.findElements(By.xpath("//h6[text()='"+arrlist.get(i)+"']")).size()==0){
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
            }
            driver.findElement(By.xpath("//h6[text()='"+arrlist.get(i)+"']")).isDisplayed();
            driver.findElement(By.xpath("//h6[text()='"+arrlist.get(i)+"']")).click();
            Thread.sleep(500);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//            driver.findElement(graphdiv).isDisplayed();
            driver.findElement(loansTab).click();
            Thread.sleep(1000);
            System.out.println("Asset name :"+arrlist.get(i)+" Size :"+driver.findElements(loanCount).size());
            loanSize = loanSize+driver.findElements(loanCount).size();
            driver.findElement(propertieslink).click();
        }
    }

    public void loansCountinPortfolio() throws InterruptedException {
        driver.findElement(loansTab).click();
        Thread.sleep(1000);
        loansCountPortfolio = driver.findElements(loanCount).size();
    }
    public void verifyLoans(){
        Assert.assertTrue(loanSize==loansCountPortfolio,"Expected loanSize :"+loansCountPortfolio +" Actual loanSize :"+loanSize);


    }
}
