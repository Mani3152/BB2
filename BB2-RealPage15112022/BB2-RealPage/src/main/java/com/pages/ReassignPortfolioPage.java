package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ReassignPortfolioPage {

    private WebDriver driver;

    private By dropDownButton = By.xpath("//ng-select[@placeholder='Select Assets']");
    private By reassignDropdownButton = By.xpath("//ng-select[@placeholder='Choose']");
    private By reassignButton  =By.xpath("//button[text()=' Reassign']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");

    public ReassignPortfolioPage(WebDriver driver) {

        this.driver = driver;
    }

    public void portfolioToReassign(String portfolio) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[text()='"+portfolio+"']//ancestor::tr//button//i")).click();
        driver.findElement(By.xpath("//a[text()='"+portfolio+"']//ancestor::tr//button[text()='Reassign']")).click();
        Thread.sleep(1000);
    }

    public void reassignPortfolios(String asset,String newportfolio) throws InterruptedException {
        String[] assets = asset.split(",");
        driver.findElement(dropDownButton).click();
        for(int i=0;i<assets.length;i++) {
            System.out.println(assets[i]);
            driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='"+assets[i]+"']")).click();
        }
        driver.findElement(reassignDropdownButton).click();
        driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='"+newportfolio+"']")).click();
        driver.findElement(reassignButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        driver.findElement(toasterBox).isDisplayed();
    }

    public void verifyreassignedPortfolios(String asset){
        String[] assets = asset.split(",");
        for(int i=0;i<assets.length;i++) {
            System.out.println(assets[i]);
            driver.findElement(By.xpath("//h6[text()='"+assets[i]+"']")).isDisplayed();
        }
    }





}
