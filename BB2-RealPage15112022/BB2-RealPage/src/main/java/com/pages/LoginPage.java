package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By uName = By.xpath("//input[@name='username']");
    private By pswd = By.xpath("//input[@name='password']");
    private By lgn_Button = By.xpath("//button[@name='loginbtn']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");
    private By profileName = By.xpath("//a[@id='profileSettings']//p");
    private By userError = By.xpath("//input[@name='username']//following-sibling::p");
    private By pswdError = By.xpath("//input[@name='password']//following-sibling::p");

    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterDetails(String username,String password){
        driver.findElement(uName).sendKeys(username);
        driver.findElement(pswd).sendKeys(password);

    }

    public void clickonLogin(){
        if(driver.findElement(lgn_Button).isEnabled()){
            driver.findElement(lgn_Button).click();
        }
    }

    public  void verify(String toaster,String name,String username,String password){
        if(toaster.length()>0){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(toasterBox).isDisplayed();
            String error = driver.findElement(toasterBox).getText();
            Assert.assertEquals(error,toaster," Expected : "+toaster+" But Found : "+error);
        }
        else if(name.length()>0){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(profileName).isDisplayed();
            String profile = driver.findElement(profileName).getText();
            Assert.assertEquals(profile,name," Expected : "+name+" But Found : "+profile);
        }
        else if (username.length()>0) {
            driver.findElement(userError).isDisplayed();
        }else{
            driver.findElement(pswdError).isDisplayed();
        }

    }

}
