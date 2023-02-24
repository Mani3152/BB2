package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class DeleteLoanPage {
    private WebDriver driver;

    private By loansTab = By.xpath("//a[text()='Loans']");
    private By deleteButton = By.xpath("//button[text()='Delete']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");

    public DeleteLoanPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickonLoansTab() throws InterruptedException {
        driver.findElement(loansTab).click();
        Thread.sleep(1000);
    }

    public void deleteLoan(String loan){
        driver.findElement(By.xpath("//a[text()='"+loan+"']//parent::td//following-sibling::td[9]//button//i")).isEnabled();
        driver.findElement(By.xpath("//a[text()='"+loan+"']//parent::td//following-sibling::td[9]//button//i")).click();
        driver.findElement(deleteButton).isDisplayed();
        driver.findElement(deleteButton).click();
    }
    public void verify(String finalmsg){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
        driver.findElement(toasterBox).isDisplayed();
        String finalToaster = driver.findElement(toasterBox).getText();
        System.out.println(finalToaster + "---toaster");
        Assert.assertEquals(finalmsg, finalToaster, "Expected : " + finalmsg + " But Found : " + finalToaster);
    }


}
