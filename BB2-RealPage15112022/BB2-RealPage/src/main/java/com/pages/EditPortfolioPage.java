package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EditPortfolioPage {

    private WebDriver driver;

    private By txt_input_portfolioname = By.xpath("//label[text()='Portfolio Name*']//parent::label//following-sibling::input");
    private By Submit_button = By.xpath("//*[text()='Submit ']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");

    public EditPortfolioPage(WebDriver driver){
        this.driver = driver;
    }

    public void go_to_portfolio_and_pick_a_portfolio(String portfolio) throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='"+portfolio+"']//ancestor::tr//button//i")).click();
        driver.findElement(By.xpath("//a[text()='"+portfolio+"']//ancestor::tr//button[text()='Edit']")).click();





    }
    public void edit_portfolio(String portfolioname) throws InterruptedException {

        driver.findElement(txt_input_portfolioname).clear();
        driver.findElement(txt_input_portfolioname).sendKeys(portfolioname);
        Thread.sleep(2000);
        if(driver.findElement(Submit_button).isEnabled()){
            driver.findElement(Submit_button).click();
        }
        Thread.sleep(2000);




    }

    public void check_weather_the_changes_are_made_or_not(String portfolioname,String expected_toastermsg) {
        if(expected_toastermsg.length()>0){
            driver.findElement(toasterBox).isDisplayed();
            String Actual_toaster_msg = driver.findElement(toasterBox).getText();
            Assert.assertEquals(Actual_toaster_msg,expected_toastermsg,"Expected : "+expected_toastermsg+" But found : "+Actual_toaster_msg);
            driver.findElement(By.xpath("//a[text()='"+portfolioname+"']//ancestor::tr//button//i")).isDisplayed();
        }


    }
}
