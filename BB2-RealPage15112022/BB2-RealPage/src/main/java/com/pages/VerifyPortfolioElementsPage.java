package com.pages;

import com.aspose.cells.b.a.b.b.d;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class VerifyPortfolioElementsPage {
    private WebDriver driver;

    public VerifyPortfolioElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By text_Portfolio = By.xpath("(//*[text()='Portfolios'])[2]");
    private By text_portfolio_i = By.xpath("//ol//li[2]");
    private By Portfolio_Name = By.xpath("//*[@class='info']//h1");
    private By recent_activity = By.xpath("//*[@class='info']//p[1]");
    private By Base_case = By.xpath("//*[@class='info']//p[2]");
    private By base_case_drop = By.xpath("//*[@id='basecase']");
    private By Add_tag = By.xpath("//*[text()=' Add Tag']");
    private By text_live = By.xpath("//*[text()='Live']");
    private By View_Scenario = By.xpath("(//*[text()='View Scenarios'])[1]");
    private By imp_btn = By.xpath("//*[@class='content-end']//button[3]");
    private By Over_View_tab = By.xpath("//*[text()='Overview']");
    private By Assets_tab = By.xpath("(//*[text()='Assets'])[2]");
    private By Details=By.xpath("//*[text()='Details']");
    private By valuation=By.xpath("//*[text()='Valuations']");
    private By Loans_tab = By.xpath("//*[text()='Loans']");
    private By Tenants_tab = By.xpath("(//*[text()='Tenants'])[1]");
    private By Units_tab = By.xpath("//*[text()='Units']");
    private By Data_source_tab=By.xpath("(//*[text()='Data Sources'])[2]");
    private By risk_assumption_tab = By.xpath("(//*[text()='Risk Assumptions'])[2]");
    private By IRR = By.xpath("//*[text()='IRR']");
    private By Levered_text = By.xpath("//*[text()='IRR']//following-sibling::div//div[1]//p");
    private By unlevered_text = By.xpath("//*[text()='IRR']//following-sibling::div//div[2]//p");
    private By Debt = By.xpath("//*[text()='Debt']");
    private By Dscr_text = By.xpath("//*[text()='Debt']//following-sibling::div//div[1]//p");
    private By Debt_yeild_text = By.xpath("//*[text()='Debt']//following-sibling::div//div[2]//p");
    private By IRR_risk = By.xpath("//*[text()='IRR (Risk-Adjusted)']");
    private By IRR_risk_levered = By.xpath("//*[text()='IRR (Risk-Adjusted)']//following-sibling::div//div[1]//p");
    private By IRR_risk_unlevered = By.xpath("//*[text()='IRR (Risk-Adjusted)']//following-sibling::div//div[2]//p");
    private By Debt_risk = By.xpath("//*[text()='Debt (Risk-Adjusted)']");
    private By Debt_risk_levered = By.xpath("//*[text()='Debt (Risk-Adjusted)']//following-sibling::div//div[1]//p");
    private By Debt_risk_unlevered = By.xpath("//*[text()='Debt (Risk-Adjusted)']//following-sibling::div//div[2]//p");
    private By Asset_allocation = By.xpath("//*[text()='Asset Allocation & Diversification']");
    private By Asset_type = By.xpath("//*[text()='Asset Type']");
    private By Region = By.xpath("//*[text()='Region']");
    private By north = By.xpath("//*[text()='Northeast ']");
    private By west = By.xpath("//*[text()='West ']");
    private By south = By.xpath("//*[text()='South ']");
    private By midwest = By.xpath("//*[text()='Midwest ']");
    private By Total_value = By.xpath("//*[text()='Total Value']");
    private By industrial = By.xpath("//*[text()='Industrial ']");
    private By multifamily = By.xpath("//*[text()='Multifamily ']");
    private By Office = By.xpath("//*[text()='Office ']");
    private By Retail = By.xpath("//*[text()='Retail ']");
    private By simulated_portfolio = By.xpath("//*[text()='Simulated Portfolio Impact by Risk Factor']");
    private By Asset_projected = By.xpath("//*[text()='Assets | Projected 10-year IRR Return vs Risk Study ']");
    private By Inset_rate = By.xpath("//*[text()='Interest Rate']");
    private By Expence_rate = By.xpath("//*[text()='Expense Inflation Rate']");
    private By chart = By.xpath("//*[@id='chartType']");
    private By Avg_tooltip = By.xpath("//*[@class='sub-header-start']//div//div[1]//i");
    private By Std_dev_tooltip = By.xpath("//*[@class='sub-header-start']//div//div[2]//div[2]//i");
    private By Watchlist = By.xpath("//*[text()='Watchlist']");
    private By watchlist_advice_available = By.xpath("//*[text()=' Advice Available']");
    private By watchlist_dropbtn = By.xpath("//*[text()=' Advice Available']//following-sibling::div//button//i");
    private By Asset_watchlist = By.xpath("//*[text()='Watchlist']//following::a[1]");
    private By manage_watchlist = By.xpath("//*[text()='Manage Watchlist']");
    private By News_watchlist = By.xpath("//*[text()='Watchlist']//following::a[2]");
    private By watch_recomendation = By.xpath("//*[text()='Watchlist']//following::a[3]");
    private By watch_aasetName = By.name("//*[text()='Watchlist']//following::span[1]");
    private By watch_aasetType = By.name("//*[text()='Watchlist']//following::span[2]");
    private By watch_aasetLocation = By.name("//*[text()='Watchlist']//following::span[3]");
    private By watch_Marketvalue = By.name("//*[text()='Watchlist']//following::span[4]");
    private By watch_IRR = By.name("//*[text()='Watchlist']//following::span[5]");
    private By watch_Risk_score = By.name("//*[text()='Watchlist']//following::span[6]");
    private By watch_Vrr_Range = By.name("//*[text()='Watchlist']//following::span[7]");
    private By watch_Ocupancy = By.name("//*[text()='Watchlist']//following::span[8]");
    private By Scenario_impact = By.xpath("//*[text()='Scenario Impact Analysis']");
    private By view_Scenario = By.xpath("(//*[text()='View Scenarios'])[2]");
    private By drop_btn = By.xpath("(//*[text()='View Scenarios'])[2]//following-sibling::button//i");
    private By Weight_avg = By.xpath("//*[text()='Weighted Average Lease Term']");
    private By Tab_view = By.xpath("//*[text()='Table View']");
    private By Years_expire = By.xpath("//*[text()='Years to Expiry']");
    private By Years_break = By.xpath("//*[text()='Years to Break']");
    private By Average_rent = By.xpath("//*[text()='Average Rent Compared to Average Market Rent']");
    private By cateegory = By.xpath("//*[@class='ng-arrow-wrapper']");
    private By Asset_search = By.xpath("(//*[@type='text'])[3]");
    private By Asset_category_dropdown = By.xpath("//*[text()='Asset Category']//parent::div//select");
    private By Region_dropdown = By.xpath("//*[text()='Region']//parent::div//select");
    private By cancel = By.xpath("//*[text()='Cancel']");
    private By Filter = By.xpath("//*[text()=' Filter']");
    private By List_grid_view = By.xpath("//*[@id='listGridView']");
    private By Asset_checkbox = By.xpath("//table//thead//tr//th[1]//input");
    private By Asset_Asset_text = By.xpath("//table//thead//tr//th[2]//span");
    private By Asset_Asset_category = By.xpath("//table//thead//tr//th[3]//span");
    private By Asset_manager_name = By.xpath("//table//thead//tr//th[4]//span");
    private By Asset_Asset_location = By.xpath("//table//thead//tr//th[5]//span");
    private By Asset_Asset_valuatoin = By.xpath("//table//thead//tr//th[6]//span");
    private By Loan_name = By.xpath("//table//thead//tr//th[1]//span");
    private By Lender = By.xpath("//table//thead//tr//th[2]//span");
    private By Loan_Asset_name = By.xpath("//table//thead//tr//th[3]//span");
    private By Type = By.xpath("//table//thead//tr//th[4]//span");
    private By Original_Balance = By.xpath("//table//thead//tr//th[5]//span");
    private By Rate = By.xpath("//table//thead//tr//th[6]//span");
    private By Rate_Type = By.xpath("//table//thead//tr//th[7]//span");
    private By Component_rate = By.xpath("//table//thead//tr//th[8]//span");
    private By Matures = By.xpath("//table//thead//tr//th[9]//span");
    private By Paymenttype = By.xpath("//table//thead//tr//th[10]//span");
    private By T_Rent_Industry = By.xpath("//*[text()='Rent by Industry ']");
    private By Total_Rent = By.xpath("//*[text()='Total Rent']");
    private By Total_Market_Rent = By.xpath("(//*[text()='Total Market Rent'])[1]");
    private By Area_Industry = By.xpath("//*[text()='Area by Industry ']");
    private By Master_Tenant = By.xpath("//*[text()='Master Tenants']");
    private By Master_Tenant_Name = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[1]//span");
    private By Master_Tenant_Industry = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[2]//span");
    private By Master_Tenant_Leases = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[3]//span");
    private By Master_Tenant_Area = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[4]//span");
    private By Master_Current_Market = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[5]//span");
    private By tenant = By.xpath("(//*[text()='Tenants'])[2]");
    private By Master_Current_rent = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[6]//span");
    private By Tenant_Name = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[1]//span");
    private By Tenant_Asset_Name = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[2]//span");
    private By master_tenant_name = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[3]//span");
    private By Unit = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[4]//span");
    private By lease_code = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[5]//span");
    private By Area = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[6]//span");
    private By start_date = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[7]//span");
    private By End_date = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[8]//span");
    private By Next_break = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[9]//span");
    private By Tenant_industry = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[10]//span");
    private By Current_rent = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[11]//span");
    private By Current_marketrent = By.xpath("//*[@class='table-responsive table-head-fixed']//table//thead//tr//th[12]//span");
    private By unit_vs_lead=By.xpath("//*[text()='Units vs Leased Units']");
    private By search_unit = By.xpath("(//*[@type='text'])[4]");
    private By unit_type = By.xpath("//*[text()='Unit Types']");
    private By unit_summary = By.xpath("//*[text()='Unit Summary']");
    private By connected_source=By.xpath("//*[text()='Connected Sources']");
    private By source_use=By.xpath("//*[text()='Sources In Use']");
    private By source_newdata=By.xpath("//*[text()='Sources with New Data']");
    private By source_notuse=By.xpath("//*[text()='Sources not in-use']");
    private By data_sources=By.xpath("(//*[text()='Data Sources'])[3]");
    private By us_federal=By.xpath("//*[text()='US Federal Reserve']");
    private By federal_msg=By.xpath("//*[contains(text(),'Board of Governors')]");
    private By places_used=By.xpath("//*[text()='Places Used']");
    private By federal_checkbox=By.xpath("//*[@class='card-footer']//div[1]//div//input");
    private By connected_btn=By.xpath("//*[@class='card-footer']//div[2]//div//input");
    private By new_data=By.xpath("//*[text()='New Data']");
    private By connected=By.xpath("//*[text()='Connected']");
    private By Data_seats=By.xpath("//*[text()='Data Sets']");
    private By tableCheckbox=By.xpath("//table//thead//tr//th[1]//span//input");
    private By table_name=By.xpath("//table//thead//tr//th[2]//span");
    private By table_datasource=By.xpath("//table//thead//tr//th[3]//span");
    private By table_description=By.xpath("//table//thead//tr//th[4]//span");
    private By table_last_refresed=By.xpath("//table//thead//tr//th[5]//span");
    private By table_As_of=By.xpath("//table//thead//tr//th[6]//span");
    private By table_frequency=By.xpath("//table//thead//tr//th[7]//span");
    private By table_places_used=By.xpath("//table//thead//tr//th[8]//span");
    private By Risk_factor=By.xpath("//*[text()='Risk Factors']");
    private By Risk_model=By.xpath("//*[text()='Risk Models']");
    private By simulation=By.xpath("//*[text()='Simulations']");
    //search box
    private By environment_risk=By.xpath("//*[text()='Environmental Risk']");
    private By Source1=By.xpath("//*[text()='Environmental Risk']//following::div[1]//span[1]");
    private By table_climaterisk=By.xpath("//*[text()='Climate Risk']");
    private By table1_weight=By.xpath("(//table//thead)[1]//th[2]");
    private By table1_value=By.xpath("(//table//thead)[1]//th[3]");
    private By table2_environment=By.xpath("(//table//thead)[2]//th[1]");
    private By table2_weight=By.xpath("(//table//thead)[2]//th[2]");
    private By table2_value=By.xpath("(//table//thead)[2]//th[3]");
    private By market_risk=By.xpath("//*[text()='Market Risk']");
    private By table_discount=By.xpath("//*[text()='Discount Rate Risk']");
    private By table3_weight=By.xpath("(//table//thead)[3]//th[2]");
    private By table3_value=By.xpath("(//table//thead)[3]//th[3]");
    private By table4_environment=By.xpath("(//table//thead)[4]//th[1]");
    private By table4_weight=By.xpath("(//table//thead)[4]//th[2]");
    private By table4_value=By.xpath("(//table//thead)[4]//th[3]");
    private By market_source=By.xpath("//*[text()='Market Risk']//following::div[1]//span[1]");
    private By risk_model_checkbox=By.xpath("//table//thead//th[1]//span[1]//input");
    private By risk_model_table_riskfactor=By.xpath("//table//thead//span[text()='Risk Factor ']");
    private By risk_model_table_Asset=By.xpath("//table//thead//span[text()='Assets ']");
    private By risk_model_table_miss_simulation=By.xpath("//table//thead//span[text()='Assets Missing Simulations ']");
    private By table_simulation=By.xpath("//table//thead//div[text()=' Simulation ']");
    private By t_simulation_runtime=By.xpath("//table//thead//th[text()='Run Time']");
    private By t_simulation_AssetName=By.xpath("//table//thead//th[text()='Asset Name']");
    private By t_simulation_riskmodel=By.xpath("//table//thead//th[text()='Risk Model']");
    private By t_simulation_currentvalue=By.xpath("//table//thead//th[text()='Current Value']");
    private By t_simulation_exp_value=By.xpath("//table//thead//th[text()='Expected Value']");
    private By t_simulation_exp_percent=By.xpath("//table//thead//th[text()='Expected Value %']");
    private By t_simulation_VAR=By.xpath("//table//thead//th[text()='VaR']");
    private By t_var_percent=By.xpath("//table//thead//th[text()='VaR %']");



    private By text_Asset=By.xpath("(//*[text()='Assets'])[2]");
    private By Operational=By.xpath("//*[text()='Operational ']");
    private By Ocupancy=By.xpath("//*[text()='Operational ']//following-sibling::div//div[1]//p");
    private By wali_to_break=By.xpath("//*[text()='Operational ']//following-sibling::div//div[2]//p");
    private By Risk_Ratio=By.xpath("//*[text()='Risk Ratio ']");
    private By Sharp_ratio=By.xpath("//*[text()='Risk Ratio ']//following-sibling::div//p");
    private By Risk_score=By.xpath("//*[text()='Risk Score ']");
    private By Environmental_Risk=By.xpath("//*[text()='Risk Score']//following::span[text()='Environmental Risk']");
    private By Market_Risk=By.xpath("//*[text()='Risk Score']//following::span[text()='Market Risk']");
    private By Operational_Risk=By.xpath("//*[text()='Risk Score']//following::span[text()='Operational Risk']");
    private By Credit_Risk=By.xpath("//*[text()='Risk Score']//following::span[text()='Credit Risk']");
    private By Risk_1stlink=By.xpath("//*[@class='main-data dummy-link']//span");
    private By environment_1stlink=By.xpath("//*[text()='Environmental Risk']//parent::div//i");
    private By environment_2ndlink=By.xpath("//*[text()='Environmental Risk']//parent::div//span[2]");
    private By Market_1stlink=By.xpath("//*[text()='Market Risk']//parent::div//i");
    private By Market_2ndlink=By.xpath("//*[text()='Market Risk']//parent::div//span[2]");
    private By Operational_1stlink=By.xpath("//*[text()='Operational Risk']//parent::div//i");
    private By Operational_2ndlink=By.xpath("//*[text()='Operational Risk']//parent::div//span[2]");
    private By Credit_1stlink=By.xpath("//*[text()='Credit Risk']//parent::div//i");
    private By Credit_2ndlink=By.xpath("//*[text()='Credit Risk']//parent::div//span[2]");
    private By Riskscore_summary=By.xpath("//*[text()='Risk Score Summary']");
    private By Risk_Assumption=By.xpath("//*[text()='Risk Assumption']");
    private By Risk_summary=By.xpath("//*[text()='Risk Summary']");
    private By Loan_Interest_rate=By.xpath("//*[text()='Loan Interest Rate']");
    private By Discount_Rate=By.xpath("//*[text()='Discount Rate']");
    private By Expence_Inflation_Rate=By.xpath("//*[text()='Expense Inflation Rate']");
    private By Loan_Interest_bottomline=By.xpath("//*[text()='Loan Interest Rate']//following-sibling::p");
    private By Discount_Rate_bottomline=By.xpath("//*[text()='Discount Rate']//following-sibling::p");
    private By Expence_Rate_botttomline=By.xpath("//*[text()='Expense Inflation Rate']//following-sibling::p");
    private By value_risk_tooltip=By.xpath("//*[contains(text(),'Value at Risk ')]//i");
    private By Shortfall_tooltip=By.xpath("//*[contains(text(),'Shortfall ')]//i");
    private By Value_At_Risk=By.xpath("//*[text()='Value at Risk']");
    private By Cumilative_Distribution=By.xpath("//*[text()='Cumulative Distribution']");
    private By Mean_Excel_Loss=By.xpath("//*[text()='Mean Excess Loss']");









    public void verify_particular_portfolio_elements() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(text_Portfolio).isDisplayed();
        driver.findElement(text_portfolio_i).isDisplayed();
        driver.findElement(Portfolio_Name).isDisplayed();
        driver.findElement(recent_activity).isDisplayed();
        driver.findElement(Base_case).isDisplayed();
        driver.findElement(base_case_drop).isDisplayed();
        driver.findElement(base_case_drop).click();
        driver.findElement(By.xpath("(//*[@type='text'])[1]")).click();
        driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("bas");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[text()=' Add Tag']//preceding::div[@class='content-radio'][1]")).isDisplayed();
        driver.findElement(Add_tag).isDisplayed();
        driver.findElement(Add_tag).click();
        driver.findElement(By.xpath("//*[text()=' Add Tag']//following-sibling::div//div[2]//label[1]//div//a")).isDisplayed();
        driver.findElement(text_live).isDisplayed();
        driver.findElement(imp_btn).isDisplayed();
        //    driver.findElement(imp_btn).isEnabled();
        driver.findElement(view_Scenario).isDisplayed();
        driver.findElement(view_Scenario).isDisplayed();
        driver.findElement(view_Scenario).click();
        driver.findElement(By.xpath("//*[text()='Scenarios']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Close']")).click();


    }

    public void verify_Over_view_Tab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(Over_View_tab).isDisplayed();
        driver.findElement(Over_View_tab).click();
        driver.findElement(IRR).isDisplayed();
        driver.findElement(Levered_text).isDisplayed();
        driver.findElement(unlevered_text).isDisplayed();
        driver.findElement(Debt).isDisplayed();
        driver.findElement(Dscr_text).isDisplayed();
        driver.findElement(Debt_yeild_text).isDisplayed();
        driver.findElement(IRR_risk).isDisplayed();
        driver.findElement(IRR_risk_levered).isDisplayed();
        driver.findElement(IRR_risk_unlevered).isDisplayed();
        driver.findElement(Debt_risk).isDisplayed();
        driver.findElement(Debt_risk_levered).isDisplayed();
        driver.findElement(Debt_risk_unlevered).isDisplayed();
        driver.findElement(Asset_allocation).isDisplayed();
        if (driver.findElement(Region).isDisplayed()) {
            driver.findElement(Region).isEnabled();
            driver.findElement(Region).click();
            Thread.sleep(500);
            driver.findElement(north).isDisplayed();
            driver.findElement(west).isDisplayed();
            driver.findElement(south).isDisplayed();
            driver.findElement(midwest).isDisplayed();
        }
        if (driver.findElement(Asset_type).isDisplayed()) {
            driver.findElement(Asset_type).isEnabled();
            driver.findElement(Asset_type).click();
            Thread.sleep(500);
            driver.findElement(industrial).isDisplayed();
            driver.findElement(multifamily).isDisplayed();
            driver.findElement(Office).isDisplayed();
            driver.findElement(Retail).isDisplayed();
        }
        driver.findElement(simulated_portfolio).isDisplayed();
        driver.findElement(Asset_projected).isDisplayed();
        driver.findElement(Expence_rate).isDisplayed();
        driver.findElement(Expence_rate).isEnabled();
        driver.findElement(Expence_rate).click();
        driver.findElement(Avg_tooltip).isDisplayed();
        driver.findElement(Std_dev_tooltip).isDisplayed();
        driver.findElement(Inset_rate).isDisplayed();
        driver.findElement(Inset_rate).isEnabled();
        driver.findElement(Inset_rate).click();
        ;
        driver.findElement(Inset_rate).isDisplayed();
        driver.findElement(Inset_rate).isEnabled();
        driver.findElement(chart).isDisplayed();
        driver.findElement(chart).isEnabled();
        driver.findElement(Watchlist).isDisplayed();
        driver.findElement(watchlist_advice_available).isDisplayed();
        driver.findElement(watchlist_advice_available).isEnabled();
        driver.findElement(watchlist_dropbtn).isDisplayed();
        driver.findElement(watchlist_dropbtn).isEnabled();
        driver.findElement(watchlist_dropbtn).click();
        driver.findElement(manage_watchlist).isDisplayed();
        driver.findElement(manage_watchlist).click();
        driver.findElement(By.xpath("(//*[text()='Manage Watchlist'])[2]")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        driver.findElement(Asset_watchlist).isDisplayed();
        driver.findElement(Asset_watchlist).click();
        driver.findElement(watch_aasetName).isDisplayed();
        driver.findElement(watch_aasetType).isDisplayed();
        driver.findElement(watch_aasetLocation).isDisplayed();
        driver.findElement(watch_Marketvalue).isDisplayed();
        driver.findElement(watch_IRR).isDisplayed();
        driver.findElement(watch_Risk_score).isDisplayed();
        driver.findElement(watch_Vrr_Range).isDisplayed();
        driver.findElement(watch_Ocupancy).isDisplayed();
        driver.findElement(Scenario_impact).isDisplayed();
        driver.findElement(view_Scenario).isDisplayed();
        driver.findElement(view_Scenario).isEnabled();
        driver.findElement(view_Scenario).click();
        driver.findElement(By.xpath("//*[text()='Scenarios']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        driver.findElement(Weight_avg).isDisplayed();
        driver.findElement(Years_expire).isDisplayed();
        driver.findElement(Years_break).isDisplayed();
        driver.findElement(Tab_view).isDisplayed();
        driver.findElement(Tab_view).isEnabled();
        driver.findElement(Tab_view).click();
        driver.findElement(By.xpath("(//*[text()='Weighted Average Lease Term'])[2]")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        driver.findElement(Average_rent).isDisplayed();
        driver.findElement(cateegory).isDisplayed();
        driver.findElement(cateegory).click();
        driver.findElement(By.xpath("//ng-dropdown-panel//div//div[2]//div[1]")).isDisplayed();

    }

    public void verify_Assets_Tab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(Assets_tab).isDisplayed();
        driver.findElement(Assets_tab).click();
        Thread.sleep(500);
        driver.findElement(Asset_search).click();
        driver.findElement(Asset_search).sendKeys("sky");
        if (driver.findElement(cancel).isDisplayed()) {
            driver.findElement(cancel).click();
        } else {
            driver.findElement(By.xpath("//*[@class='input-group input-group-search']//h4")).isDisplayed();
        }
        driver.findElement(Asset_category_dropdown).isDisplayed();
        driver.findElement(Asset_category_dropdown).click();
        driver.findElement(By.xpath("(//*[@class='filter-section-start']//following-sibling::div//select)[1]//option[2]")).isDisplayed();
        driver.findElement(Region_dropdown).isDisplayed();
        driver.findElement(Region_dropdown).click();
        driver.findElement(By.xpath("//*[text()='Region']//parent::div//select//option[2]")).isDisplayed();
        driver.findElement(List_grid_view).isDisplayed();
        driver.findElement(List_grid_view).isEnabled();
        driver.findElement(List_grid_view).click();
        driver.findElement(By.xpath("//*[text()=' List']")).isDisplayed();
        driver.findElement(Asset_checkbox).isDisplayed();
        driver.findElement(Asset_checkbox).isEnabled();
        driver.findElement(Asset_checkbox).click();
        driver.findElement(Asset_checkbox).click();
        driver.findElement(Asset_Asset_text).isDisplayed();
        driver.findElement(Asset_Asset_category).isDisplayed();
        driver.findElement(Asset_manager_name).isDisplayed();
        driver.findElement(Asset_Asset_location).isDisplayed();
        driver.findElement(Asset_Asset_valuatoin).isDisplayed();
    }

    public void verify_Loans_Tab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(Loans_tab).isDisplayed();
        driver.findElement(Loans_tab).isEnabled();
        driver.findElement(Loans_tab).click();
        Thread.sleep(500);
        driver.findElement(Asset_search).isDisplayed();
        driver.findElement(Asset_search).isEnabled();
        driver.findElement(Asset_search).click();
        driver.findElement(Asset_search).sendKeys("wel");
        Thread.sleep(500);
        if (driver.findElement(By.xpath("//table//tbody//tr//td[1]")).isDisplayed()) {
            driver.findElement(By.xpath("//table//tbody//tr//td[1]//a")).isDisplayed();
        } else {
            driver.findElement(By.xpath("//h5")).isDisplayed();
        }
        driver.findElement(Loan_name).isDisplayed();
        driver.findElement(Lender).isDisplayed();
        driver.findElement(Loan_Asset_name).isDisplayed();
        driver.findElement(Type).isDisplayed();
        driver.findElement(Original_Balance).isDisplayed();
        driver.findElement(Rate).isDisplayed();
        driver.findElement(Rate_Type).isDisplayed();
        driver.findElement(Component_rate).isDisplayed();
        driver.findElement(Matures).isDisplayed();
        driver.findElement(Paymenttype).isDisplayed();

    }

    public void verify_Tenant_Tab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(Tenants_tab).isDisplayed();
        driver.findElement(Tenants_tab).isEnabled();
        driver.findElement(Tenants_tab).click();
        Thread.sleep(500);
        driver.findElement(T_Rent_Industry).isDisplayed();
        if (driver.findElement(Total_Market_Rent).isDisplayed()) {
            driver.findElement(Total_Market_Rent).isEnabled();
            driver.findElement(Total_Market_Rent).click();
            driver.findElement(By.xpath("(//*[text()='Total Market Rent'])[2]")).isDisplayed();
        }
        if (driver.findElement(Total_Rent).isDisplayed()) {
            driver.findElement(Total_Rent).isEnabled();
            driver.findElement(Total_Rent).click();
            driver.findElement(By.xpath("(//*[text()='Total Rent'])[2]")).isDisplayed();
        }
        driver.findElement(Area_Industry).isDisplayed();
        driver.findElement(Asset_search).isDisplayed();
        driver.findElement(Master_Tenant).isDisplayed();
        driver.findElement(Master_Tenant).isEnabled();
        driver.findElement(Master_Tenant).click();
        driver.findElement(Master_Tenant_Name).isDisplayed();
        driver.findElement(Master_Tenant_Industry).isDisplayed();
        driver.findElement(Master_Tenant_Leases).isDisplayed();
        driver.findElement(Master_Tenant_Area).isDisplayed();
        driver.findElement(Master_Current_Market).isDisplayed();
        driver.findElement(Master_Current_rent).isDisplayed();
        driver.findElement(tenant).isDisplayed();
        driver.findElement(tenant).isEnabled();
        driver.findElement(tenant).click();
        Thread.sleep(500);
        driver.findElement(Tenant_Name).isDisplayed();
        driver.findElement(Tenant_Asset_Name).isDisplayed();
        driver.findElement(master_tenant_name).isDisplayed();
        driver.findElement(Unit).isDisplayed();
        driver.findElement(lease_code).isDisplayed();
        driver.findElement(Area).isDisplayed();
        driver.findElement(start_date).isDisplayed();
        driver.findElement(End_date).isDisplayed();
        driver.findElement(Next_break).isDisplayed();
        driver.findElement(Tenant_industry).isDisplayed();
        driver.findElement(Current_rent).isDisplayed();
        driver.findElement(Current_marketrent).isDisplayed();

        //Master Tenant dropdown Not Working
    }

    public void verify_Unit_Tab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(Units_tab).isDisplayed();
        driver.findElement(Units_tab).isEnabled();
        driver.findElement(Units_tab).click();
        Thread.sleep(500);
        driver.findElement(unit_vs_lead).isEnabled();
        driver.findElement(By.xpath("//*[@class='ng-value-container']")).click();
        driver.findElement(By.xpath("//*[@class='ng-dropdown-panel-items scroll-host']//div[2]//div[3]//span")).isDisplayed();
        driver.findElement(search_unit).isDisplayed();
        driver.findElement(search_unit).isEnabled();
        driver.findElement(unit_type).isDisplayed();
        driver.findElement(unit_type).isEnabled();
        driver.findElement(unit_type).click();
        Thread.sleep(500);
        driver.findElement(unit_summary).isDisplayed();
        driver.findElement(unit_summary).isEnabled();
        driver.findElement(unit_summary).click();
        Thread.sleep(500);

        //Not verifying table headers
    }
public void verify_Data_source_Tab() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.findElement(Data_source_tab).isDisplayed();
    driver.findElement(Data_source_tab).isEnabled();
    driver.findElement(Data_source_tab).click();
    Thread.sleep(500);
    driver.findElement(Filter).isDisplayed();
    driver.findElement(List_grid_view).isDisplayed();
    driver.findElement(List_grid_view).isEnabled();
    driver.findElement(connected_source).isDisplayed();
    driver.findElement(source_use).isDisplayed();
    driver.findElement(source_newdata).isDisplayed();
    driver.findElement(source_notuse).isDisplayed();
    driver.findElement(Asset_search).isDisplayed();
    driver.findElement(Asset_search).isEnabled();
    driver.findElement(By.xpath("//*[@class='ng-input']//following::span[1]")).isDisplayed();
    driver.findElement(By.xpath("//*[@class='ng-input']//following::span[1]")).isEnabled();
  //  driver.findElement(By.xpath("//*[@class='ng-option']//div//div")).isDisplayed();
    driver.findElement(data_sources).isDisplayed();
    driver.findElement(data_sources).isEnabled();
    driver.findElement(data_sources).click();
    driver.findElement(us_federal).isDisplayed();
    driver.findElement(federal_msg).isDisplayed();
    driver.findElement(places_used).isDisplayed();
    driver.findElement(new_data).isDisplayed();
    driver.findElement(connected).isDisplayed();
    driver.findElement(federal_checkbox).isDisplayed();
    driver.findElement(federal_checkbox).isEnabled();
    driver.findElement(connected_btn).isDisplayed();
    driver.findElement(connected_btn).isEnabled();
    driver.findElement(Data_seats).isDisplayed();
    driver.findElement(Data_seats).isEnabled();
    driver.findElement(Data_seats).click();
    Thread.sleep(500);
    driver.findElement(tableCheckbox).isDisplayed();
    driver.findElement(table_name).isDisplayed();
    driver.findElement(table_datasource).isDisplayed();
    driver.findElement(table_description).isDisplayed();
    driver.findElement(table_last_refresed).isDisplayed();
    driver.findElement(table_As_of).isDisplayed();
    driver.findElement(table_frequency).isDisplayed();
    driver.findElement(table_places_used).isDisplayed();
    driver.findElement(Filter).isDisplayed();




}
}

