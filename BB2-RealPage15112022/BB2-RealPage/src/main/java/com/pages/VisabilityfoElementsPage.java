package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class VisabilityfoElementsPage {
    private WebDriver driver;
    public VisabilityfoElementsPage(WebDriver driver){
        this.driver=driver;
    }
    private By Home=By.xpath("//a[@href='/home']//i");
    private By portfolio_btn=By.xpath("//a[@href='/portfolios']//i");
    private By Asset_btn=By.xpath("//a[@href='/assets']//i");
    private By Risk_Assumption_btn=By.xpath("//a[@href='/risk-assumptions']//i");
    private By Data_source_btn=By.xpath("//a[@href='/data-sources']//i");
    private By Models_btn=By.xpath("//a[@href='/models']//i");
    private By Settings_btn=By.xpath("//a[@href='/settings']//i");

    private By welcome=By.xpath("//*[text()='Welcome back,']");
    private By welcome_msg=By.xpath("//*[contains(text(),'See what you’ve missed')]");
    private By recent_activity=By.xpath("//*[text()='Recent Activity']");
    private By Activity=By.xpath("//*[text()='Activity']");
    private By Task=By.xpath("//*[text()='Tasks']");
    private By View_more=By.xpath("//*[text()='View more']");
    private By Asset_portfolio=By.xpath("//*[text()='Portfolios and Assets']");
    private By portfolio=By.xpath("//*[contains(@class,'card-body pt')]//ul//li[1]//div//div[2]");
    private By asset=By.xpath("//*[contains(@class,'card-body pt')]//ul//li[2]//div//div[2]");
    private By Portfolio=By.xpath("//*[contains(@class,'card-body pt')]//ul[2]//li[1]//a");
    private By Assets=By.xpath("//*[contains(@class,'card-body pt')]//ul[2]//li[2]//a");
    private By view_all_portfolio=By.xpath("//*[text()='View All Portfolios']");
    private By text_Portfolio=By.xpath("(//*[text()='Portfolios'])[2]");
    private By Asset_dropdown = By.xpath("(//*[@class='filter-section-start']//following-sibling::div//select)[1]");
    private By search = By.xpath("//*[@type='text']");
    private By Access_dropdown = By.xpath("(//*[@class='filter-section-start']//following-sibling::div//select)[2]");
    private By Filter=By.xpath("//*[text()=' Filter']");
    private By New_portfolio=By.xpath("//*[text()=' New Portfolio']");
    private By imp_btn=By.xpath("//*[@class='filter-section-end']//button[3]//i");
    private By tabel_portfolio=By.xpath("//table//thead//th//span[text()='Portfolio ']");
    private By table_type=By.xpath("//table//thead//th//span[text()='Type ']");
    private By table_discription=By.xpath("//table//thead//th//span[text()='Description ']");
    private By table_date=By.xpath("//table//thead//th//span[text()='As Of Date ']");
    private By table_Asset=By.xpath("//table//thead//th//span[text()='Assets ']");
    private By table_manager=By.xpath("//table//thead//th//span[text()='Portfolio Manager ']");
    private By table_live=By.xpath("//table//thead//th//span[text()='Live ']");
    private By list_of_portfolio=By.xpath("//table//tbody//tr//td[1]//a");
    private By list_of_live=By.xpath("//table//tbody//tr//td[7]//input");
    private By list_drop_btn=By.xpath("//table//tbody//tr//td[8]//i");
    private By text_asset=By.xpath("//h1");
    private By Asset_category_dropdown=By.xpath("//*[text()='Asset Category']//parent::div//select");
    private By Region_dropdown=By.xpath("//*[text()='Region']//parent::div//select");
    private By List_grid_view=By.xpath("//*[@id='listGridView']");
    private By New_Asset_btn=By.xpath("//*[text()=' New Asset']");
    private By text_riskAssumption=By.xpath("(//*[text()='Risk Assumptions'])[2]");
    private By text_risk_template=By.xpath("//*[text()='Risk Model Templates']");
    private By risk_profile=By.xpath("//*[text()='Risk Profile']");
    private By risk_prpfile_dropdown=By.xpath("//*[@id='riskProfile']");









    public void click_on_home() throws InterruptedException {
        driver.findElement(Home).isDisplayed();
       if (driver.findElement(Home).isEnabled()) {
           driver.findElement(Home).click();
           Thread.sleep(500);
           driver.findElement(welcome).isDisplayed();
           driver.findElement(welcome_msg).isDisplayed();
           driver.findElement(recent_activity).isDisplayed();
           driver.findElement(Activity).isDisplayed();
           driver.findElement(Activity).isEnabled();
           driver.findElement(Task).isDisplayed();
           driver.findElement(Task).isEnabled();
           driver.findElement(View_more).isDisplayed();
           driver.findElement(View_more).isEnabled();
           driver.findElement(Asset_portfolio).isDisplayed();
           driver.findElement(portfolio).isDisplayed();
           driver.findElement(asset).isDisplayed();
           driver.findElement(Portfolio).isDisplayed();
           driver.findElement(Portfolio).isEnabled();
           driver.findElement(Assets).isDisplayed();
           driver.findElement(Assets).isEnabled();
           driver.findElement(view_all_portfolio).isDisplayed();
           driver.findElement(view_all_portfolio).isEnabled();
       }

    }
    public void Verify_Portfolio_Homepage() throws InterruptedException {
        driver.findElement(portfolio_btn).isDisplayed();
        driver.findElement(portfolio_btn).isEnabled();
        driver.findElement(portfolio_btn).click();
        Thread.sleep(500);
        driver.findElement(text_Portfolio).isDisplayed();
        driver.findElement(search).isDisplayed();
        driver.findElement(search).isEnabled();
        driver.findElement(Asset_dropdown).isDisplayed();
        driver.findElement(Asset_dropdown).isEnabled();
        driver.findElement(Access_dropdown).isDisplayed();
        driver.findElement(Access_dropdown).isEnabled();
        driver.findElement(Filter).isDisplayed();
        driver.findElement(Filter).isEnabled();
        driver.findElement(New_portfolio).isDisplayed();
        driver.findElement(New_portfolio).isEnabled();
        driver.findElement(imp_btn).isDisplayed();
        driver.findElement(imp_btn).isEnabled();
        driver.findElement(tabel_portfolio).isDisplayed();
        driver.findElement(table_type).isDisplayed();
        driver.findElement(table_discription).isDisplayed();
        driver.findElement(table_date).isDisplayed();
        driver.findElement(table_Asset).isDisplayed();
        driver.findElement(table_manager).isDisplayed();
        driver.findElement(table_live).isDisplayed();

        if (driver.findElements(list_of_portfolio).size()>0){
          int size=driver.findElements(list_of_portfolio).size();
          for (int i=0;i<size;i++){
              driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[1]//a")).isDisplayed();
              driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[1]//a")).isEnabled();
          }
        }else {
            driver.findElement(By.xpath("//*[text()=' No data to display']")).isDisplayed();
        }
    }
    public void Verify_Assets_Homepage() throws InterruptedException {
        driver.findElement(Asset_btn).isDisplayed();
        driver.findElement(Asset_btn).isEnabled();
        driver.findElement(Asset_btn).click();
        Thread.sleep(500);
        driver.findElement(text_asset).isDisplayed();
        driver.findElement(search).isDisplayed();
        driver.findElement(search).isEnabled();
        driver.findElement(Asset_category_dropdown).isDisplayed();
        driver.findElement(Asset_category_dropdown).isEnabled();
        driver.findElement(Region_dropdown).isDisplayed();
        driver.findElement(Region_dropdown).isEnabled();
        driver.findElement(Filter).isDisplayed();
        driver.findElement(Filter).isEnabled();
        driver.findElement(List_grid_view).isDisplayed();
        driver.findElement(List_grid_view).isEnabled();
        driver.findElement(New_Asset_btn).isDisplayed();
        driver.findElement(New_Asset_btn).isEnabled();
        driver.findElement(imp_btn).isDisplayed();
        driver.findElement(imp_btn).isEnabled();
        if (driver.findElements(By.xpath("//h6")).size()>0){
            int size=driver.findElements(By.xpath("//h6")).size();
            for (int i=0;i<size;i++){
                driver.findElement(By.xpath("(//h6)["+i+"]")).isDisplayed();
                driver.findElement(By.xpath("(//h6)["+i+"]")).isEnabled();
            }
        }else {
            driver.findElement(By.xpath("//*[text()=' No data to display']")).isDisplayed();
        }

    }







}
