package com.pages;

import com.utils.Utils;
import org.apache.poi.ss.formula.functions.Irr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.formula.functions.Irr.irr;

public class DebtPage {

    private WebDriver driver;

    String act_OccValue ="";
    String ExpOccValue = "";
    String waltBreakValue = "";
    String yearsBreakValue = "";
    String act_LTVvalue = "";
    String exp_LTVvalue ="";
    String expMakretValue = "";

    public DebtPage(WebDriver driver) {

        this.driver = driver;
    }

    private By DSCR = By.xpath("//p[text()='DSCR']//following-sibling::h5");
    private By LTV = By.xpath("//p[text()='LTV']//following-sibling::h5");
    private By NOI = By.xpath("//table/tbody/tr[3]/td[2]/span/strong");
    private By DebtService = By.xpath("//table/tbody/tr[6]/td[2]/span");
    private By link_Valutions = By.xpath("//a[text()='Valuations']");
    private By details_Tab = By.xpath("//a[text()='Details']");
    private By tenants_Tab = By.xpath("//a[text()='Tenants']");
    private By loans_Tab = By.xpath("//a[text()='Loans']");
    private By area_Table_tenants= By.xpath("//tbody//tr//td[5]");
    private By area_Table= By.xpath("//tbody//tr//td[4]");
    private By units_Table = By.xpath("//tbody//tr//td[3]");
    private By leasableArea = By.xpath("//div[text()='Leasable Area']//following-sibling::div");
    private By occupanyValue = By.xpath("//p[text()='Occupancy ']//following-sibling::h5");
    private By waltToBreak =  By.xpath("//p[text()='Walt to break']//following-sibling::h5");
    private By yearsToBreak = By.xpath("//div[text()='Years to Break']//parent::div[@class='item']//span");
    private By pageSize = By.xpath("//select[@name='dtBasicExample_length']");
    private By categoryType = By.xpath("//h1//parent::div//following-sibling::p");
    private By unitsTab = By.xpath("//a[text()='Units']");
    private By balance = By.xpath("//table/tbody/tr/td[5]");
    private By marketValue = By.xpath("//p[text()='Current Market Value']//parent::div//h4");
    private By capital = By.xpath("//h5[text()='Discounted Cash Flow Valuation']//parent::div//table//tbody//td[3]");
    private By unlev = By.xpath("//h5[contains(.,'Effective Date')]//parent::div//parent::div[@class='col-12 mb-4']//table//tbody//tr[5]//td");
    private By unlev_10 = By.xpath("//h5[contains(.,'Effective Date')]//parent::div//following-sibling::div[@class='table-responsive']//table//tbody//tr[5]//td[11]");
    private By noi_11 = By.xpath("//h5[contains(.,'Effective Date')]//parent::div//following-sibling::div[@class='table-responsive']//table//tbody//tr[3]//td[12]");
    private By saleCost = By.xpath("//*[text()='Sale Assumptions']//parent::div//following-sibling::div//table//td[text()='Sale Costs (%)']//following-sibling::td");
    private By terminalRate = By.xpath("//*[text()='Sale Assumptions']//parent::div//following-sibling::div//table//td[text()='Terminal Cap Rate']//following-sibling::td");
    private By SP_value = By.xpath("//*[text()='Sale Assumptions']//parent::div//following-sibling::div//table//td[text()='Sale Price Adjustment']//following-sibling::td");

    ArrayList<Double> arrlist = new ArrayList<Double>();

    // Calculatin the DSCR Value
    public void verifyDSCRValue () throws InterruptedException {
        Thread.sleep(1000);
        //DSCR UI Value
        String getDSCR = driver.findElement(DSCR).getText();
        getDSCR = getDSCR.replace("%","");
        double value_ActualDSCR = Double.parseDouble(getDSCR);
        System.out.println(value_ActualDSCR);
        //LTV UI Value
        act_LTVvalue = driver.findElement(LTV).getText();
        act_LTVvalue = act_LTVvalue.replace("%","");
        System.out.println(act_LTVvalue);
        // Occupancy UI Value
        act_OccValue = driver.findElement(occupanyValue).getText();
        act_OccValue = act_OccValue.replace("%","");
        System.out.println(act_OccValue);
//        waltBreakValue=driver.findElement(waltToBreak).getText();
//        yearsBreakValue = driver.findElement(yearsToBreak).getText();

        //DSCR Calculations
        driver.findElement(link_Valutions).click();
        Thread.sleep(1000);
        String getNOI = driver.findElement(NOI).getText();//Taking the NOI Value
        double value_NOI = Double.parseDouble(getNOI.replaceAll(",", ""));
        String getDebtService = driver.findElement(DebtService).getText();//Taking the Debt Service
        double value_DebtService = Double.parseDouble(getDebtService.replaceAll(",", "").replace("(","-").replace(")",""));
        double value_ExpDSCR = (value_NOI/value_DebtService);//DSCR Value Expected
        String ExpDSCR = String.format("%.2f", value_ExpDSCR);
        double expDSCR = Double.parseDouble(ExpDSCR);

        //LTV Calculations
        driver.findElement(details_Tab).click();
        Thread.sleep(500);
        expMakretValue = driver.findElement(marketValue).getText().replace("$","").replace(",","");
        driver.findElement(loans_Tab).click();
        Thread.sleep(500);
        Double balanceSum = 0.0;
        for(int i=0;i<driver.findElements(balance).size();i++){
            balanceSum = balanceSum + Double.parseDouble(driver.findElements(balance).get(i).getText().replaceAll(",","").replace("%",""));
        }

        exp_LTVvalue = String.format("%.1f",balanceSum*100/Double.parseDouble(expMakretValue));

    //Comapring the Actual and Calculated DSCR Values and LTV Values
        Assert.assertEquals(expDSCR,value_ActualDSCR,"Expected DSCR Value : "+expDSCR +" Actual DSCR Value : "+value_ActualDSCR);
//        Assert.assertEquals(exp_LTVvalue,act_LTVvalue,"Expected LTV Value : "+exp_LTVvalue+" Actual LTV Value : "+act_LTVvalue);

    }
    // Occupancy Calculations
    public void occupancyCalculations() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(details_Tab).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(leasableArea).isDisplayed();
        Thread.sleep(1000);
        String leaseAres = driver.findElement(leasableArea).getText();
        leaseAres = leaseAres.replace("SqFt","");
        leaseAres = leaseAres.replace(",","");
        System.out.println(leaseAres);
        String type = driver.findElement(categoryType).getText();
//        System.out.println(type + " assetcategory");

        if (type.contains("Multifamily")) {
            System.out.println(driver.findElements(unitsTab).size() + "UNitssize");
            driver.findElement(unitsTab).click();
            Thread.sleep(500);
            double leased_units_sum = 0.0;
            double total_units_sum = 0.0;
            if(driver.findElements(area_Table).size()>9){
                Select size = new Select(driver.findElement(pageSize));
                size.selectByVisibleText("50");
            }
            Thread.sleep(1000);
            for(int i =0;i<driver.findElements(area_Table).size();i++){
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElements(area_Table).get(i).isDisplayed();
                String area = driver.findElements(area_Table).get(i).getText();
                String units = driver.findElements(units_Table).get(i).getText().replaceAll(",","");
                area = area.replace(",","");
                System.out.println(area+"----area");
                leased_units_sum = leased_units_sum+Double.parseDouble(area);
                total_units_sum = total_units_sum+Double.parseDouble(units);
            }
            System.out.println(leased_units_sum+"-leased units");
            System.out.println(total_units_sum+"--toatal units");
            Double exp_OccValue = leased_units_sum*100/total_units_sum;
            ExpOccValue = String.format("%.1f", exp_OccValue);
        }else{
            driver.findElement(tenants_Tab).click();
            Thread.sleep(500);
            double area_sum = 0.0;
            if(driver.findElements(area_Table_tenants).size()>9){
                Select size = new Select(driver.findElement(pageSize));
                size.selectByVisibleText("50");
            }
            for(int i =0;i<driver.findElements(area_Table_tenants).size();i++){
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElements(area_Table_tenants).get(i).isDisplayed();
                Thread.sleep(1000);
                String area = driver.findElements(area_Table_tenants).get(i).getText();
                area = area.replace(",","");
//                System.out.println(area+"----area");
                area_sum = area_sum+Double.parseDouble(area);
            }
            System.out.println(area_sum);
            Double exp_OccValue = area_sum*100/Double.parseDouble(leaseAres);
            ExpOccValue = String.format("%.1f", exp_OccValue);
            System.out.println(act_OccValue + "-----" +ExpOccValue+"-----" );
        }
    }

    //IRR Check
    public  void IRRCalculations() throws InterruptedException {
        driver.findElement(link_Valutions).click();
        Thread.sleep(500);
        String capital_value = driver.findElement(capital).getText().replace(",","");
        capital_value = "-"+capital_value;
        arrlist.add(Double.parseDouble(capital_value));
        for(int i=2;i<driver.findElements(unlev).size()-1;i++){
            arrlist.add(Double.parseDouble(driver.findElements(unlev).get(i).getText().replace("(","").replace(")","").replace(",","")));
        }

        Double year_10 = Double.parseDouble(driver.findElement(unlev_10).getText().replace("(","").replace(")","").replace(",",""));
        Double noi = Double.parseDouble(driver.findElement(noi_11).getText().replace("(","").replace(")","").replace(",",""))/(Double.parseDouble(driver.findElement(terminalRate).getText().replace("%",""))/100-Double.parseDouble(driver.findElement(SP_value).getText())/100);
        Double salesCost = 1 - Double.parseDouble(driver.findElement(saleCost).getText().replace("%",""))/100;

        Double lastValue = year_10+noi*salesCost;
        arrlist.add(lastValue);
        System.out.println(arrlist+"---arrlist");
        Double unliv_Irr = calculateIrr(arrlist);
        System.out.println(unliv_Irr+"--unliv");


    }
    // IRR Calculations
    private double calculateIrr(List<Double> values) {
        double[] income = new double[values.size() + 1];
//        income[0] = npv;
        for (int i = 1; i < income.length; i++) {
            income[i] = values.get(i - 1);
        }
        return irr(income);
    }
    //Validations of the values
    public void Validate(){
        Assert.assertEquals(ExpOccValue, act_OccValue, "ActualOccupancy Value :" + act_OccValue + "Expected OccupancyValue:" + ExpOccValue);
//        Assert.assertEquals(yearsBreakValue, waltBreakValue, "ActualOccupancy Value :" + waltBreakValue + "Expected OccupancyValue:" + yearsBreakValue);


    }




}
