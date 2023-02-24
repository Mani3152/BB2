package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class SearchAssetPage {
    private WebDriver driver;

    public SearchAssetPage(WebDriver driver) {
        this.driver = driver;
    }

    private By asssets = By.xpath("//h6");
    private By searchBar = By.xpath("//input[@placeholder='Search...']");
    private By sezeAssets = By.xpath("//input[@placeholder='Search...']//parent::div//li");
    private By okButton = By.xpath("//button[text()='OK']");
    private By checkbox = By.xpath("//li//input");
    private By check_category2 = By.xpath("//div[@class='description-with-dropdown']//p[1]");
    private By graphdiv = By.xpath("//div[@class='col-lg-8']");
    private By unit_Tab = By.xpath("//*[text()='Units']");
    private By tenant = By.xpath("//*[text()='Tenants']");
    private By search_unit = By.xpath("(//*[@type='text'])[3]");
    private By text = By.xpath("(//*[@type='text'])[3]");
    private By filterButton = By.xpath("//button[text()=' Filter']");
    private By filterText = By.xpath("//h6[text()='Filter']");
    private By loan = By.xpath("//*[text()='Loans']");
    private By search_loan = By.xpath("(//*[@type='text'])[3]");


    ArrayList<String> arrlist = new ArrayList<String>();
    ArrayList<String> after_arrlist = new ArrayList<String>();
    SoftAssert softAssert = new SoftAssert();

    public void assetsNames(){

        int assets_size = driver.findElements(asssets).size();
        for(int i=0;i<assets_size;i++){
            arrlist.add(driver.findElements(asssets).get(i).getText());
        }
    }

    public void enterKeyWord(String keyword) throws InterruptedException {
        driver.findElement(searchBar).isDisplayed();
        driver.findElement(searchBar).sendKeys(keyword);
        int displayedCount = driver.findElements(sezeAssets).size();
        int count = 0;
        System.out.println(arrlist+"-arrlis");
        String s1 = keyword.substring(0, 1).toUpperCase()+ keyword.substring(1);
        System.out.println(s1+"---------");
        for(int i=0;i<arrlist.size();i++){
            if(arrlist.get(i).contains(s1)){
                count = count+1;
            }
        }
        Assert.assertEquals(count,displayedCount,"Expected Count : "+count+" But Displayed : "+displayedCount);
        for(int j=0;j<driver.findElements(checkbox).size();j++){
            driver.findElements(checkbox).get(j).click();
        }
        if(driver.findElements(checkbox).size()>0){
            driver.findElement(okButton).isEnabled();
            driver.findElement(okButton).click();
            Thread.sleep(500);
            int afterCount = driver.findElements(asssets).size();
            Assert.assertEquals(count,afterCount,"Expected Count : "+count+" But Displayed : "+afterCount);

            for(int i=0;i<afterCount;i++){
                after_arrlist.add(driver.findElements(asssets).get(i).getText());
            }

            for(int i=0;i<after_arrlist.size();i++){
                if(after_arrlist.get(i).contains(s1)){
                    Assert.assertTrue(true,"The lsit contains : "+after_arrlist);
                }
            }
        }

    }

    public void filterButton(){
//        boolean flag = false;
        driver.findElement(filterButton).click();
//        if(driver.findElement(filterText).isDisplayed()){
//            flag = true;
//        }
        softAssert.assertTrue(driver.findElement(filterText).isDisplayed(),"Filter Button in asset Page is Not working");
    }

    public void go_to_Tenant_abd_Unit(String data) throws InterruptedException {
        if (driver.findElement(check_category2).getText().contains("Multi")) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(graphdiv).isDisplayed();
            driver.findElement(unit_Tab).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.findElement(search_unit).sendKeys(data);
            Thread.sleep(2000);
        } else {
            driver.findElement(tenant).click();
            driver.findElement(text).sendKeys(data);
            Thread.sleep(2000);
        }
    }

    public void verify_Search(String data) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (driver.findElements(By.xpath("//table//tbody//tr//td[1]")).size() > 0) {
            int size = driver.findElements(By.xpath("//table//tbody//tr//td[1]")).size();
            for (int i = 1; i <=size; i++) {
                String loan = driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[1]")).getText();
                System.out.println(loan);
                if (loan.toLowerCase().contains(data.toLowerCase())) {
                    Assert.assertTrue(true, "Expected Category : " + data + " But found : " + loan);
                }
            }
        } else {
            String error = driver.findElement(By.xpath("(//h5)[2]")).getText();
            Assert.assertEquals(error, "No data to display");
        }

    }
    public void Loans_Tab() throws InterruptedException {
        driver.findElement(loan).click();
        Thread.sleep(500);
    }

    public void Search_Loan(String data) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(search_loan).sendKeys(data);
        Thread.sleep(1000);
    }

    public void verify_Search_Loan(String data) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (driver.findElements(By.xpath("//table//tbody//tr[1]//td[1]//a")).size() > 0) {
            int size=driver.findElements(By.xpath("//table//tbody//tr[1]//td[1]//a")).size();
            for (int i=1;i<=size;i++) {
                String loan = driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[1]//a")).getText();
                System.out.println(loan);
                if (loan.toLowerCase().contains(data.toLowerCase())) {
                    Assert.assertTrue(true, "Expected Category : " + data + " But found : " + loan);
                }
            } } else {
            String error = driver.findElement(By.xpath("//h5")).getText();
            Assert.assertEquals(error, "No data to display");
        }

        softAssert.assertAll();


    }
}
