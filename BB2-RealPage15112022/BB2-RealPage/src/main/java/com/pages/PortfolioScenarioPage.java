package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class PortfolioScenarioPage {

    private WebDriver driver;

    boolean flag = false;

    private By Name = By.xpath("//label[text()='Name*']//following::input");
    private By dropDown = By.xpath("//table//tbody//tr//td//select");
    private By submitButton = By.xpath("//button[text()='Submit']");
    private By viewScenerio = By.xpath("//button[text()='View Scenarios']");
    private By addScenerio = By.xpath("//button[@class='btn btn-lightgray icon-only']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");

    public PortfolioScenarioPage(WebDriver driver) {

        this.driver = driver;
    }

    public  void addScenaria() throws InterruptedException {
        driver.findElement(viewScenerio).click();
        driver.findElement(addScenerio).click();
        Thread.sleep(1000);
    }

    public void scenarioSelect(String name,String dropdown,String toaster) throws InterruptedException {
        driver.findElement(Name).sendKeys(name);
       String [] arr =  dropdown.split(",");
        for(int i=0;i<arr.length;i++){
            Select scn = new Select(driver.findElements(dropDown).get(i));
            scn.selectByVisibleText(arr[i]);
        }
        if(driver.findElement(submitButton).isEnabled()){
            flag = true;
            driver.findElement(submitButton).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
            driver.findElement(toasterBox).isDisplayed();
            String msg = driver.findElement(toasterBox).getText();
            Assert.assertEquals(msg,toaster,"Expected : "+toaster+" But Found : "+msg);
        }
    }

    public void verify(String name) throws InterruptedException {
//        driver.findElement(viewScenerio).click();
        if(flag){
            driver.findElement(By.xpath("//div[text()='"+name+"']")).isDisplayed();
        }

    }
}
