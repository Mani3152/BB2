package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class PortfolioPage {

    private WebDriver driver;

    public PortfolioPage(WebDriver driver) {

        this.driver = driver;
    }

    private By portfolios = By.xpath("//a[@href='/portfolios']");
    private By newportfolio_Button = By.xpath("//button[@class='btn btn-primary rounded-pill']//i");
    private By portfolio_Name = By.xpath("//label[contains(.,'Portfolio Name')]//following-sibling::input");
    private By portfolio_Type = By.xpath("//label[contains(.,'Type')]//following-sibling::select");
    private By portfolio_Manager = By.xpath("//label[contains(.,'Portfolio Manager')]//following-sibling::select");
    private By description = By.xpath("//label[contains(.,'Description')]//following-sibling::textarea");
    private By create_Button = By.xpath("//button[text()='Create']");
    private By portfolio_NameVerification = By.xpath("//tbody//td[1]//a[1]");
    public void goToPortfolios() throws InterruptedException {
        driver.findElement(portfolios).click();
        Thread.sleep(1000);
    }

    public void newPortfolio(String Name,String Type,String Manager,String Description){
        driver.findElement(newportfolio_Button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(portfolio_Name).isDisplayed();
        driver.findElement(portfolio_Name).sendKeys(Name);
//        Select type = new Select(driver.findElement(portfolio_Type));
//        type.selectByVisibleText(Type);
        Select manager = new Select(driver.findElement(portfolio_Manager));
        manager.selectByVisibleText(Manager);
        driver.findElement(description).sendKeys(Description);

    }

    public void createPortfolio(String portfolioName) throws InterruptedException {
        if(driver.findElement(create_Button).isEnabled()){
            driver.findElement(create_Button).click();
            Thread.sleep(2000);
            String name =  driver.findElements(portfolio_NameVerification).get(0).getText();
            Assert.assertTrue(name.equals(portfolioName),"Expected Name : "+portfolioName + "Actual Name : "+name);
        }
    }



}
