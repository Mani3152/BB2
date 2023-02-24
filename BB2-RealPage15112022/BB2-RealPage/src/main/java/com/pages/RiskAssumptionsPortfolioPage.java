package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class RiskAssumptionsPortfolioPage {

    private WebDriver driver;

    private By riskassumptionsTab = By.xpath("//a[text()='Risk Assumptions']");
    private By simultionsTab = By.xpath("//a[text()='Simulations']");
    private By searchBox = By.xpath("//input[@placeholder='Search...']");
    private By tableData = By.xpath("//tbody//tr//td[1]");
    private By graogh = By.xpath("//div[@class='highcharts-container ']");
    private By crValue = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[5]");
    private By expValue = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[6]");
    private By expValue_Pr = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[7]");
    private By var = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[8]");
    private By var_Pr = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[9]");
    private By graph_values = By.xpath("//h6");
    private By close_Button = By.xpath("//button[text()='Close']");

    public RiskAssumptionsPortfolioPage(WebDriver driver) {
        this.driver = driver;
    }

    ArrayList<String> tbleData = new ArrayList<>();

    public void riskassumptionsClick() throws InterruptedException {
        driver.findElement(riskassumptionsTab).click();
        Thread.sleep(500);
    }

    public void simulationsTab(String keyword, String simulation) throws InterruptedException {
        driver.findElement(simultionsTab).click();
        Thread.sleep(500);
        driver.findElements(By.xpath("//a[text()='" + simulation + "']")).get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(graogh).isDisplayed();
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[5]")).getText(), driver.findElements(graph_values).get(2).getText(), "Expected Current Market Value : " + driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[5]")).getText() + " But Found : " + driver.findElements(graph_values).get(2).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[6]")).getText(), driver.findElements(graph_values).get(3).getText(), "Expected Expected Market Value : " + driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[6]")).getText() + " But Found : " + driver.findElements(graph_values).get(3).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[7]")).getText(), driver.findElements(graph_values).get(4).getText(), "Expected Expected Market Percentage : " + driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[7]")).getText() + " But Found : " + driver.findElements(graph_values).get(4).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[8]")).getText(), driver.findElements(graph_values).get(0).getText(), "Expected VAR Value : " + driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[8]")).getText() + " But Found : " + driver.findElements(graph_values).get(0).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[9]")).getText(), driver.findElements(graph_values).get(1).getText(), "Expected VAR Percentage : " + driver.findElement(By.xpath("//a[text()='" + simulation + "']//parent::td//parent::tr//td[9]")).getText() + " But Found : " + driver.findElements(graph_values).get(1).getText());

        driver.findElement(close_Button).click();
        driver.findElements(searchBox).get(1).sendKeys(keyword);
        Thread.sleep(1500);
        for (int i = 0; i < driver.findElements(tableData).size(); i++) {
            if (!driver.findElements(tableData).get(i).getText().contains(keyword)) {
                Assert.fail("Expected : " + keyword + " But Found : " + driver.findElements(tableData).get(i).getText());
            }
        }

    }


}
