package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class DeleteAssetPage {

    private WebDriver driver;

    private By deleteIcon  = By.xpath("//button[@ngbtooltip='Delete Asset']//i");
    private By delete = By.xpath("//button[text()='Delete']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");

    public DeleteAssetPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void deleteAsset(String toaster){
        driver.findElement(deleteIcon).click();
        driver.findElement(delete).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
        driver.findElement(toasterBox).isDisplayed();
        String toaster_msg = driver.findElement(toasterBox).getText();
        System.out.println(toaster_msg+"--------toaster");
        Assert.assertEquals(toaster_msg,toaster,"Expected : "+toaster+" But found : "+toaster_msg);
    }
}
