package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class TenantsPortfolioPage {

    private WebDriver driver;

    int tenantsSize = 0;
    String tenantsCountPortfolio = "";
    int unitsSize = 0;
    String unitsCountPortfolio = "";
    String totalRent = "";
    String totalMarketRent = "";
    String totalArea = "";
    Double rent = 0.0;
    Double marketRent = 0.0;
    int tenantArea = 0;


    private By assetTab = By.xpath("//a[text()='Assets']");
    private By tenantsTab = By.xpath("//a[text()='Tenants']");

    private By tenantsButton = By.xpath("//button[text()='Tenants ']");
    private By unitsTab = By.xpath("//a[text()='Units']");
    private By unitsButton = By.xpath("//a[text()='Unit Types']");
    private By loanCount = By.xpath("//table//tbody//tr//td[1]");
    private By tableSize = By.xpath("//table//tbody//tr//td[5]");
    private By propertieslink = By.xpath("//a[@href='/assets']//i");
    private By assetNames = By.xpath("//h6[@class='title']");
    private By categoryType = By.xpath("//h1//parent::div//following-sibling::p");
    private By pageSize = By.xpath("//label[text()='Show']//following::select");
    private By tenantsMetrics = By.xpath("//*[local-name()='svg' ]/*[local-name()='text']/*[local-name()='tspan']");
    private By marketRentTab = By.xpath("//a[text()='Total Market Rent']");
    private By area = By.xpath("//table[@id='undefined']//tbody//tr//td[6]");
    private By currentRent = By.xpath("//table[@id='undefined']//tbody//tr//td[11]");
    private By currentMarketRent = By.xpath("//table[@id='undefined']//tbody//tr//td[12]");
    private By cardDropdown = By.xpath("//*[@id='listGridView']");
    private By cardView = By.xpath("//button[text()=' Cards']");

    public TenantsPortfolioPage(WebDriver driver) {

        this.driver = driver;
    }


    ArrayList<String> arrlist = new ArrayList<String>();

    public void assentNamesinPortfolio() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(assetTab).click();
        Thread.sleep(500);
        driver.findElement(cardDropdown).click();
        driver.findElement(cardView).click();
        Thread.sleep(500);
        int size = driver.findElements(assetNames).size();
        for (int i = 0; i < size; i++) {
            arrlist.add(driver.findElements(assetNames).get(i).getText());
        }
        System.out.println(arrlist + "arrlist");
    }

    public void tenantsCount() throws InterruptedException {
        Thread.sleep(1000);
//        String[] assets = asset.split(",");
        for (int i = 0; i < arrlist.size(); i++) {
            System.out.println(arrlist.get(i));
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(By.xpath("//h6[text()='" + arrlist.get(i) + "']")).isDisplayed();
            driver.findElement(By.xpath("//h6[text()='" + arrlist.get(i) + "']")).click();
            Thread.sleep(1000);
            String type = driver.findElement(categoryType).getText();
            System.out.println(type + " assetcategory");

            if (type.contains("Multifamily")) {
                System.out.println(driver.findElements(unitsTab).size() + "UNitssize");
                driver.findElement(unitsTab).click();
                Thread.sleep(1000);
                System.out.println("Asset name :" + arrlist.get(i) + " Size :" + driver.findElements(loanCount).size());
                if (driver.findElements(loanCount).size() >= 10) {
                    Select sizepage_1 = new Select(driver.findElement(pageSize));
                    sizepage_1.selectByVisibleText("100");
                }
                unitsSize = unitsSize + driver.findElements(loanCount).size();
                driver.findElement(propertieslink).click();

            } else {
                System.out.println(driver.findElements(tenantsTab).size() + "tenatssize");
                driver.findElement(tenantsTab).click();
                Thread.sleep(1000);
                System.out.println("Asset name :" + arrlist.get(i) + " Size :" + driver.findElements(loanCount).size());
                if (driver.findElements(loanCount).size() >= 10) {
                    Select sizepage_1 = new Select(driver.findElement(pageSize));
                    sizepage_1.selectByVisibleText("100");
                }
                tenantsSize = tenantsSize + driver.findElements(loanCount).size();
                driver.findElement(propertieslink).click();
                Thread.sleep(500);
            }
        }
    }

    public void tenantsCountinPortfolio() throws InterruptedException {
        // tenants Count in portfolio
        driver.findElements(tenantsTab).get(0).click();
        Thread.sleep(500);
        driver.findElements(tenantsTab).get(1).click();
        Thread.sleep(500);
        if (driver.findElements(tenantsMetrics).size() > 0) {
            totalRent = driver.findElements(tenantsMetrics).get(0).getText().replace("$", "").replace("M", "");
            int totalrent_Size = totalRent.length();
            if(totalRent.substring(totalrent_Size-1,totalrent_Size).contains("0")){
                totalRent = totalRent.substring(0,totalrent_Size-1);
            }
            System.out.println(totalRent+"--totalrent");

            driver.findElement(marketRentTab).click();
            Thread.sleep(500);
            totalMarketRent = driver.findElements(tenantsMetrics).get(0).getText().replace("$", "").replace("M", "");
            int totalMarketrent_Size = totalMarketRent.length();
            if(totalMarketRent.substring(totalrent_Size-1,totalrent_Size).contains("0")){
                totalMarketRent = totalMarketRent.substring(0,totalrent_Size-1);
            }
            totalArea = driver.findElements(tenantsMetrics).get(1).getText().replace(",", "");
            for (int i = 0; i < driver.findElements(area).size(); i++) {
                rent = rent + Double.parseDouble(driver.findElements(currentRent).get(i).getText().replaceAll(",", "").replace("$",""));
                marketRent = marketRent + Double.parseDouble(driver.findElements(currentMarketRent).get(i).getText().replaceAll(",", "").replace("$",""));
                tenantArea = tenantArea + Integer.parseInt(driver.findElements(area).get(i).getText().replaceAll(",", ""));
            }
            marketRent = marketRent / 1000000;
            marketRent = Double.parseDouble(String.format("%.2f", marketRent));
            rent = rent / 1000000;
            rent = Double.parseDouble(String.format("%.2f", rent));

        } else {
            totalRent = "0.0";
            totalMarketRent = "0.0";
            totalArea = "0";
        }
        if (driver.findElements(tableSize).size() >= 10) {
            Select sizepage = new Select(driver.findElement(pageSize));
            sizepage.selectByVisibleText("100");
        }
        tenantsCountPortfolio = String.valueOf(driver.findElements(loanCount).size());
//        tenantsCountPortfolio = driver.findElements(loanCount).get(2).getText().split("of")[1];
//        System.out.println(tenantsCountPortfolio + "--in portfolio tenants");

        // Units Count in portfolio
        driver.findElement(unitsTab).click();
        Thread.sleep(500);
        driver.findElement(unitsButton).click();
        Thread.sleep(500);
        if (driver.findElements(tableSize).size() >= 10) {
            Select sizepage_1 = new Select(driver.findElement(pageSize));
            sizepage_1.selectByVisibleText("100");
            unitsCountPortfolio = String.valueOf(driver.findElements(loanCount).size());
        }else{
            unitsCountPortfolio = "0";
        }
//        unitsCountPortfolio = driver.findElements(loanCount).get(2).getText().split("of")[1];
//            System.out.println(unitsCountPortfolio +"-- unist sin portfolio");

    }

    public void verifyTenants() {
        Assert.assertEquals(tenantsCountPortfolio, String.valueOf(tenantsSize), "Expected TenantsSize :" + tenantsCountPortfolio + " Actual TenantSize :" + tenantsSize);
        Assert.assertEquals(unitsCountPortfolio, String.valueOf(unitsSize), "Expected UnitsSize :" + unitsCountPortfolio + " Actual UnitsSize :" + unitsSize);
        Assert.assertEquals(totalRent, String.valueOf(rent), "Expected Rent :" + rent + " Actual Rent :" + totalRent);
        Assert.assertEquals(totalMarketRent, String.valueOf(marketRent), "Expected Rent :" + marketRent + " Actual Rent :" + totalMarketRent);
        Assert.assertEquals(totalArea, String.valueOf(tenantArea), "Expected Rent :" + tenantArea + " Actual Rent :" + totalArea);
    }
}
