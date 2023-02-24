package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddScenerioPage {

    private WebDriver driver;

    private By detailsTab = By.xpath("//a[text()='Details']");
    private By viewScenerio = By.xpath("//button[text()='View Scenarios']");
    private By addScenerio = By.xpath("//a[text()=' Add Scenario ']");
    private By name = By.xpath("//label[text()='Name*']//following-sibling::input");
    private By status = By.xpath("//*[@id=\"flexSwitchCheckChecked\"]");
    private By notes = By.xpath("//textarea");
    private By nextButton = By.xpath("//button[text()='Next']");
    private By tenatsFile = By.xpath("//label[text()='Tenants']//parent::div//parent::div//input");
    private By loansFile = By.xpath("//label[text()='Loans']//parent::div//parent::div//input");
    private By valuationFile = By.xpath("//label[text()='Valuations']//parent::div//parent::div//input");
    private By submit =By.xpath("//button[text()='Add Scenario']");
    private By graphdiv = By.xpath("//div[@class='col-lg-8']");
    public AddScenerioPage(WebDriver driver) {

        this.driver = driver;
    }

    public void detaisTab() throws InterruptedException {

        driver.findElement(detailsTab).click();
        Thread.sleep(1000);
    }
    public  void addScenaria() throws InterruptedException {
        driver.findElement(viewScenerio).click();
        driver.findElement(addScenerio).click();
        Thread.sleep(1000);
    }
    public void enterDetails(String Name,String Status,String Headers,String Notes,String Valuations,String Loans,String Tenants){
        driver.findElement(name).sendKeys(Name);
        if(Status.equalsIgnoreCase("Yes")){
            driver.findElement(status).click();
        }
//        String [] header_Arr = Headers.split(",");
//        for(int i=0;i<header_Arr.length;i++){
//            driver.findElement(By.xpath("//label[text()='"+header_Arr[i]+" ']//parent::div//input")).click();
//        }
        driver.findElement(notes).sendKeys(Notes);
        driver.findElement(nextButton).isEnabled();
        driver.findElement(nextButton).click();
        driver.findElements(valuationFile).get(1).sendKeys(Valuations);
        driver.findElements(loansFile).get(1).sendKeys(Loans);
        driver.findElements(tenatsFile).get(1).sendKeys(Tenants);
        if(driver.findElement(submit).isEnabled()){
            driver.findElement(submit).click();
        }
//        Thread.sleep(2000);
    }
}
