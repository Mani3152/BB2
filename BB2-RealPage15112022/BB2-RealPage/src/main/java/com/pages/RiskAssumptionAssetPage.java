package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class RiskAssumptionAssetPage {
    private  WebDriver driver;
    private By riskassumptionsTab = By.xpath("//a[text()='Risk Assumptions']");
    private By simultionsTab = By.xpath("//a[text()='Simulations']");
    private By searchBox = By.xpath("//input[@placeholder='Search...']");
    private By tableData = By.xpath("//tbody//tr//td[1]");
    private By graogh = By.xpath("//div[@class='highcharts-container ']");
    private By crValue = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[4]");
    private By expValue = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[5]");
    private By expValue_Pr = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[6]");
    private By var = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[7]");
    private By var_Pr = By.xpath("//a[text()='Loan Interest Rate']//parent::td//parent::tr//td[8]");
    private By graph_values = By.xpath("//h6");
    private By riskModel_Button = By.xpath("//button[contains(.,'Add Risk Model')]");
    private By rskModelTab = By.xpath("//a[text()='Risk Models']");
    private By rskName = By.xpath("//label[text()='Risk Model Name']//following-sibling::input");
    private By rskfactor = By.xpath("//label[text()='Risk Factor']//following-sibling::select");
    private By rsktemplate = By.xpath("//label[text()='Risk Model Template']//following-sibling::select");
    private By createButton = By.xpath("//button[text()='Create']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");
    private By modelName = By.xpath("//tbody//tr[1]//td[1]");

    public RiskAssumptionAssetPage(WebDriver driver) {
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
        Assert.assertEquals(driver.findElement(crValue).getText(), driver.findElements(graph_values).get(2).getText(), "Expected Current Market Value : " + driver.findElement(crValue).getText() + " But Found : " + driver.findElements(graph_values).get(2).getText());
        Assert.assertEquals(driver.findElement(expValue).getText(), driver.findElements(graph_values).get(3).getText(), "Expected Expected Market Value : " + driver.findElement(expValue).getText() + " But Found : " + driver.findElements(graph_values).get(3).getText());
        Assert.assertEquals(driver.findElement(expValue_Pr).getText(), driver.findElements(graph_values).get(4).getText(), "Expected Expected Market Percentage : " + driver.findElement(expValue_Pr).getText() + " But Found : " + driver.findElements(graph_values).get(4).getText());
        Assert.assertEquals(driver.findElement(var).getText(), driver.findElements(graph_values).get(0).getText(), "Expected VAR Value : " + driver.findElement(var).getText() + " But Found : " + driver.findElements(graph_values).get(0).getText());
        Assert.assertEquals(driver.findElement(var_Pr).getText(), driver.findElements(graph_values).get(1).getText(), "Expected VAR Percentage : " + driver.findElement(var_Pr).getText() + " But Found : " + driver.findElements(graph_values).get(1).getText());

        driver.findElements(searchBox).get(1).sendKeys(keyword);
        Thread.sleep(1500);
        for (int i = 0; i < driver.findElements(tableData).size(); i++) {
            if (!driver.findElements(tableData).get(i).getText().contains(keyword)) {
                Assert.fail("Expected : " + keyword + " But Found : " + driver.findElements(tableData).get(i).getText());
            }
        }

    }

    public void riskModels(String name,String factor,String template,String finalmsg) throws InterruptedException {
        driver.findElement(rskModelTab).click();
        Thread.sleep(500);
        driver.findElement(riskModel_Button).click();
        Thread.sleep(500);
        driver.findElement(rskName).sendKeys(name);
        Select riskFactor = new Select(driver.findElement(rskfactor));
        riskFactor.selectByVisibleText(factor);
        Select riskTemplate = new Select(driver.findElement(rsktemplate));
        riskTemplate.selectByVisibleText(template);
        if(driver.findElement(createButton).isEnabled()){
            driver.findElement(createButton).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
//            Thread.sleep(1000);
            driver.findElement(toasterBox).isDisplayed();
            String finalToaster = driver.findElement(toasterBox).getText();
            System.out.println(finalToaster + "---toaster");

            Assert.assertEquals(finalmsg, finalToaster, "Expected : " + finalmsg + " But Found : " + finalToaster);
            if(finalmsg.contains("Successfully")){
                Assert.assertEquals(name.replace(" ",""),driver.findElement(modelName).getText(),"Expected : " + name + " But Found : " + driver.findElement(modelName).getText());
                System.out.println("yess");
            }
        }
    }

}
