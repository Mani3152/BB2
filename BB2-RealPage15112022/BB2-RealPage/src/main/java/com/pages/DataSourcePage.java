package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class DataSourcePage {

    private WebDriver driver;

    private By dataSource_Button = By.xpath("//a[@href='/data-sources']//i");
    private By dataSource = By.xpath("//*[text()='US Federal Reserve']");
    private By addButton = By.xpath("//button[text()='Add']//i");
    private By selectAllButton = By.xpath("//th[text()='Name']//parent::tr//input");
    private By addDSButton = By.xpath("//*[@class='modal-footer']//button[text()='Add']");
    private By wgs3mo = By.xpath("//*[text()='1-Year Treasury']");
    private By wgs1yr = By.xpath("//*[text()='CPI']");
    private By closeButton = By.xpath("//*[@class='modal-footer']//button[text()='Close']");
    private By dataSets_Button = By.xpath("//a[text()='Data Sets']");
    private By datasourceButton = By.xpath("//a[text()='Data Sources']");
    private By heading = By.xpath("//h1[text()='Data Sources']");
    private By search = By.xpath("//*[@placeholder='Search...']");
    private By headings = By.xpath("//div[@class='filter-section mb-4']//ul[@class='kpi-content d-flex']//li");
    private By values = By.xpath("//div[@class='filter-section mb-4']//ul[@class='kpi-content d-flex']//li//div[@class='value']");
    private By checkbox_DataSource = By.xpath("//input[@type='checkbox']");
    private By buttons = By.xpath("//div[@class='bulk-action-start']//button");
    private By viewButton = By.xpath("//button[@id='listGridView']");
    private By listview = By.xpath("//button[text()=' List']");
    private By cardView = By.xpath("//button[text()=' Cards']");
    private By datasets_button = By.xpath("//a[text()='Data Sets']");
    private By searchBar = By.xpath("//input[@placeholder='Search...']");
    private By all_Datasets = By.xpath("//tbody//tr/td[2]");
    private By sezeAssets = By.xpath("//input[@placeholder='Search...']//parent::div//li");
    private By checkbox = By.xpath("//li//input");
    private By okButton = By.xpath("//button[text()='OK']");
    private By all_DataSources = By.xpath("//div[@class='summary-top-start']//h4");

    public DataSourcePage(WebDriver driver) {

        this.driver = driver;
    }

    ArrayList<String> datasources_list = new ArrayList<String>();
    ArrayList<String> after_datasources_list = new ArrayList<String>();
    ArrayList<String> datasets_list = new ArrayList<String>();
    ArrayList<String> after_datasets_list = new ArrayList<String>();

    //Go TO Data Source Page
    public void clickOnDataSources()   {
        driver.findElement(dataSource_Button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(heading).isDisplayed();
    }

    public void checkDataSources(String keyword) throws InterruptedException {
        for(int i=0;i<driver.findElements(headings).size();i++){
            driver.findElements(headings).get(i).isDisplayed();
        }

        String Connected_Sources= driver.findElements(values).get(0).getText();
        String SourcesInUse = driver.findElements(values).get(1).getText();

        int datasources_size = driver.findElements(all_DataSources).size();

        Assert.assertEquals(Connected_Sources,String.valueOf(datasources_size),"Expected : "+datasources_size+" But Found : "+Connected_Sources);
//        Assert.assertEquals(SourcesInUse,String.valueOf(datasources_size),"Expected : "+datasources_size+" But Found : "+SourcesInUse);

        driver.findElements(checkbox_DataSource).get(0).isDisplayed();
        driver.findElements(checkbox_DataSource).get(0).click();
        for(int i=0;i<driver.findElements(buttons).size();i++){
            driver.findElements(buttons).get(i).isDisplayed();
        }
        driver.findElement(viewButton).isDisplayed();
        driver.findElement(viewButton).click();
        driver.findElement(listview).click();
        Thread.sleep(500);
        driver.findElement(viewButton).click();
        driver.findElement(cardView).click();

        for(int i=0;i<datasources_size;i++){
            datasources_list.add(driver.findElements(all_DataSources).get(i).getText());
        }
        driver.findElements(searchBar).get(0).isDisplayed();
        driver.findElements(searchBar).get(0).sendKeys(keyword);
        int displayedCount = driver.findElements(sezeAssets).size();
        int count = 0;
        System.out.println(datasources_list+"-arrlis");

        for(int i=0;i<datasources_list.size();i++){
            if(datasources_list.get(i).contains(keyword)){
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
            int afterCount = driver.findElements(all_DataSources).size();
            Assert.assertEquals(count,afterCount,"Expected Count : "+count+" But Displayed : "+afterCount);

            for(int i=0;i<afterCount;i++){
                after_datasources_list.add(driver.findElements(all_DataSources).get(i).getText());
            }

            for(int i=0;i<after_datasources_list.size();i++){
                if(after_datasources_list.get(i).contains(keyword)){
                    Assert.assertTrue(true,"The lsit contains : "+after_datasources_list);
                }
            }
        }

    }

    public void checkDataSets(String keyword) throws InterruptedException {
        driver.findElement(datasets_button).click();
        for(int i=0;i<driver.findElements(headings).size();i++){
            driver.findElements(headings).get(i).isDisplayed();
        }
        String activeDatasets= driver.findElements(values).get(0).getText();
        String datasetsInUse = driver.findElements(values).get(1).getText();

        int datasets_size = driver.findElements(all_Datasets).size();

        Assert.assertEquals(activeDatasets,String.valueOf(datasets_size),"Expected : "+datasets_size+" But Found : "+activeDatasets);
//        Assert.assertEquals(datasetsInUse,String.valueOf(datasets_size),"Expected : "+datasets_size+" But Found : "+datasetsInUse);

        for(int i=0;i<datasets_size;i++){
            datasets_list.add(driver.findElements(all_Datasets).get(i).getText());
        }

        driver.findElements(searchBar).get(0).isDisplayed();
        driver.findElements(searchBar).get(0).sendKeys(keyword);
        int displayedCount = driver.findElements(sezeAssets).size();
        int count = 0;
        System.out.println(datasets_list+"-arrlis");

        for(int i=0;i<datasets_list.size();i++){
            if(datasets_list.get(i).contains(keyword)){
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
            int afterCount = driver.findElements(all_Datasets).size();
            Assert.assertEquals(count,afterCount,"Expected Count : "+count+" But Displayed : "+afterCount);

            for(int i=0;i<afterCount;i++){
                after_datasets_list.add(driver.findElements(all_Datasets).get(i).getText());
            }

            for(int i=0;i<after_datasets_list.size();i++){
                if(after_datasets_list.get(i).contains(keyword)){
                    Assert.assertTrue(true,"The lsit contains : "+after_datasets_list);
                }else{
                    Assert.fail("The lsit contains : "+after_datasets_list);
                }
            }
        }
    }
    //Click on a Data Source and verify The Data Sources are Present or Not
    public void addDataSources() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(dataSets_Button).click();
        driver.findElement(datasourceButton).click();
        Thread.sleep(1000);
        driver.findElement(dataSource).click();
        Thread.sleep(1000);
//        driver.findElement(addButton).click();
//        Thread.sleep(1000);
//        driver.findElement(selectAllButton).click();
//        driver.findElement(addDSButton).click();
//        Thread.sleep(2000);
        driver.findElement(wgs3mo).isDisplayed();
        driver.findElement(wgs1yr).isDisplayed();
        driver.findElement(wgs3mo).click();
        Thread.sleep(1000);
//        driver.findElement(closeButton).click();

    }

}
