package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class OverviewPortfolioPage {

    private WebDriver driver;

    String netCash ="";
    BigInteger finalIncomeconvo;
    BigInteger finalIncome = BigInteger.ZERO;
    Boolean incomeflag = false;

    private By category = By.xpath("//*[text()='Category:']//parent::p");
    private By income = By.xpath("//*[text()='Valuation:']//parent::p");
    private By assetsize = By.xpath("//div[@class='info']//p");
    private  By assetTab = By.xpath("//a[text()='Assets']");
    private  By portfoliocat = By.xpath("//app-portfolio-overview//div[1][@class='label']");
    private By portfoliocatValue = By.xpath("//app-portfolio-overview//div[1][@class='label']//following-sibling::div//div[@class='progress-value']");
    private  By overviewTab = By.xpath("//a[text()='Overview']");
    private By cardDropdown = By.xpath("//*[@id='listGridView']");
    private By cardView = By.xpath("//button[text()=' Cards']");

    public OverviewPortfolioPage(WebDriver driver) {

        this.driver = driver;
    }

    ArrayList<String> arrlist = new ArrayList<String>();

    public void assentNamesinPortfolio() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(assetTab).click();
        Thread.sleep(500);
        driver.findElement(cardDropdown).click();
        driver.findElement(cardView).click();
        Thread.sleep(500);
    }
    HashMap<String, BigInteger> catIncome = new HashMap<>();
    HashMap<String, Double> categoryMap = new HashMap<>();
    HashMap<String, Double> portfolioMap = new HashMap<>();
    public void incomeCalculation(){
        String assetssize = driver.findElement(assetsize).getText();
        if(!(assetssize.equalsIgnoreCase("0 Asset"))){
            incomeflag = true;
            int catsize = driver.findElements(category).size();

            for(int i =0;i<catsize;i++){
//                System.out.println(driver.findElements(category).get(i).getText() + " ---keyyy");
                if(catIncome.containsKey(driver.findElements(category).get(i).getText().split(":")[1])){
                    catIncome.put(driver.findElements(category).get(i).getText().split(":")[1],catIncome.get(driver.findElements(category).get(i).getText().split(":")[1]).add(new BigInteger(driver.findElements(income).get(i).getText().split(":")[1].replaceAll(",","").replace("$",""))));
//                    System.out.println(catIncome+"-----if loop");
                }
                else
                    catIncome.put(driver.findElements(category).get(i).getText().split(":")[1],new BigInteger(driver.findElements(income).get(i).getText().split(":")[1].replaceAll(",","").replace("$","")));
//                    System.out.println(catIncome+"---elseloop");
            }
        }
    }

    public void sampleout(){
        System.out.println(catIncome+"---final");
        if(incomeflag){
            for (BigInteger name : catIncome.values()){
                finalIncome = finalIncome.add(name);
            }
            netCash = finalIncome.toString();
            if(netCash.length()>9){
                finalIncomeconvo = finalIncome.divide(BigInteger.valueOf(1000000000));
                netCash = finalIncomeconvo.toString()+"B";

            }else{
                finalIncomeconvo = finalIncome.divide(BigInteger.valueOf(1000000));
                netCash = finalIncomeconvo.toString()+"M";
            }
            Set<String> value  = catIncome.keySet();
            for(String v : value){
//                System.out.println( catIncome.get(v));
                BigInteger percentVlue = (catIncome.get(v).multiply(BigInteger.valueOf(100)));
                Double percentValue = percentVlue.doubleValue()/finalIncome.doubleValue();
                String catpercentage = String.format("%.1f", percentValue);
                categoryMap.put(v,Double.parseDouble(catpercentage));
                System.out.println(categoryMap+"_---------mapcat");
                System.out.println(netCash+"--"+finalIncome+"---"+finalIncomeconvo);
            }
        }
    }

    public void portfoliometrics() throws InterruptedException {
        if(incomeflag){
            driver.findElement(overviewTab).click();
            Thread.sleep(500);
            for(int i=0;i<4;i++){
                portfolioMap.put(driver.findElements(portfoliocat).get(i).getText(),Double.parseDouble(driver.findElements(portfoliocatValue).get(i).getText().replace("%","")));
            }
            System.out.println(portfolioMap+"----map portfolio");
        }
    }

    public void compareMetrics(){
        Set<String> compkeys = categoryMap.keySet();
        System.out.println(compkeys+"----keys in ccategory");
        for(String compk: compkeys){
            if(portfolioMap.containsKey(compk)){
                System.out.println(categoryMap.get(compk) +"---cat value" + portfolioMap.get(compk) +"---portmap");
                Assert.assertTrue(categoryMap.get(compk).equals(portfolioMap.get(compk)),"Expected : "+categoryMap +" But Found : "+portfolioMap);
            }
        }
//        Assert.assertTrue(categoryMap.equals(portfolioMap),);
    }








}
