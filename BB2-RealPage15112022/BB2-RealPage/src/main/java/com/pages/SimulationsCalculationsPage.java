package com.pages;

import com.utils.Utils;
import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;

public class SimulationsCalculationsPage {
    private WebDriver driver;

    int header_count = 0;
    Map<String, List<String>> casfflowMap = new HashMap<>();
    List<List<String>> datacashFlow = new ArrayList<>();
    List<List<String>> discountFlow = new ArrayList<>();
    List<List<String>> discount_Rate = new ArrayList<>();
    List<List<String>> discount_Rate_1 = new ArrayList<>();
    List<List<String>> expectedMarket = new ArrayList<>();
    List<List<String>> fixedRandom = new ArrayList<>();
    List<List<String>> datacashFlow_Output = new ArrayList<>();
    List<List<String>> discountFlow_Output = new ArrayList<>();
    List<List<String>> discountRate_Output = new ArrayList<>();
    List<List<String>> discountRate1_Output = new ArrayList<>();
    List<List<String>> expectedMarket_Output = new ArrayList<>();
    List<List<String>> fixedRandom_Output = new ArrayList<>();
    String terminalCapRate = "";
    String discountRate = "";
    String salesCosts = "";
    String salePriceAdjustment = "";
    int loanAmount = 0;
    String assetCaptial = "";
    String portfolio = "";
    String reversionSpeed = "";
    String longTermRate = "";
    String Voltaility = "";
    String expValue = "";
    String expPercentage = "";
    String varValue = "";
    String varPercentage = "";
    String Excel_expValue = "";
    String Excel_expPercentage = "";
    String Excel_varValue = "";
    String Excel_varPercentage = "";
    String portfolioId="";
    String url = "";
    String seedValue = "";
    String assetId = "";
    String scenarioId = "";
    JSONArray OEValues = new JSONArray();
    JSONArray ORValues = new JSONArray();
    JSONArray CEValues = new JSONArray();


    private By ValuationsTab = By.xpath("//a[text()='Valuations']");
    private By header = By.xpath("//h5[contains(.,'Effective Date')]//parent::div//parent::div[@class='col-12 mb-4']//table//thead//tr//th");
    private By keys = By.xpath("//h5[contains(.,'Effective Date')]//parent::div//parent::div[@class='col-12 mb-4']//table//tbody//tr//td[1]");
    private By discounted_cashFLow = By.xpath("//h5[contains(.,'Discounted')]//parent::div//parent::div[@class='col-lg-5 col-sm-12 mb-4']//table//tbody//tr//td");
    private By saleCost = By.xpath("//td[text()='Sale Costs (%)']//following-sibling::td");
    private By adjustment = By.xpath("//td[text()='Sale Price Adjustment']//following-sibling::td");
    private By LoansTab = By.xpath("//a[text()='Loans']");
    private By loansAmount = By.xpath("//table/tbody//tr//td[5]");
    private By capital = By.xpath("//p[text()='Current Market Value']//parent::div//h4");
    private By portfolioName = By.xpath("//div[text()='Portfolio']//following-sibling::div");
    private By DetailsTab = By.xpath("//a[text()='Details']");
    private By riskTab = By.xpath("//a[text()='Risk Assumptions']");
    private By riskModels = By.xpath("//a[text()='Risk Models']");
    private By discountRate_Model = By.xpath("//a[text()='Discount Rate']");
    private By revSpeed = By.xpath("//*[text()='Reversion Speed ']//parent::div//div[2]");
    private By avgRate = By.xpath("//*[text()='Long-term Average Rate ']//parent::div//div[2]");
    private By voltaility = By.xpath("//*[text()='Volatility ']//parent::div//div[2]");
    private By CancelButton = By.xpath("//button[text()=' Cancel']");
    private By simulationsTab = By.xpath("//a[text()='Simulations']");
    private By RiskUIValues = By.xpath("//a[text()='Discount Rate']//parent::td//following-sibling::td");
    private By simulatiosJson = By.xpath("//a[text()='simulation/']");
    private By spreadMargin = By.xpath("//pre");


    public SimulationsCalculationsPage(WebDriver driver) {

        this.driver = driver;
    }


    public void clickOnValutiosnTab() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.findElement(graphdiv).isDisplayed();
        driver.findElement(ValuationsTab).click();
        Thread.sleep(1000);
    }

    public void apiData() throws IOException {
        // establish and open connection with URL
        HttpURLConnection c=
                (HttpURLConnection)new
                        URL("http://realpage.vassarlabs.com/api/assetValuation/79643892-1069-4251-80f2-ed4a178cecdd/891c9c54-a836-499a-915a-6d38179a6c88")
                        .openConnection();
        // set the HEAD request with setRequestMethod
        c.setRequestMethod("GET");
        // connection started and get response code
        c.connect();
        int r = c.getResponseCode();
        String respo = c.getResponseMessage();
        if (r == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    c.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString()+"resulttt");
        }
        System.out.println("Http response code: " + r);
        System.out.println(respo+"responseee");
    }
    public void readCashFlowTable() {
        Date d = new Date();

        for (int i = 0; i < driver.findElements(header).size(); i++) {
            header_count++;
            if (driver.findElements(header).get(i).getText().contains(String.valueOf(d.getYear() + 1900))) {
                break;
            }
        }

        for (int j = 0; j < driver.findElements(keys).size(); j++) {
            String key = driver.findElements(keys).get(j).getText();
//            System.out.println(key+"-----key"+j);
            List<String> values = new ArrayList<>();
            for (int k = header_count; k <= driver.findElements(header).size(); k++) {
                String val = driver.findElement(By.xpath("//h5[contains(.,'Effective Date')]//parent::div//parent::div[@class='col-12 mb-4']//table//tbody//tr[" + (j + 1) + "]//td[" + k + "]")).getText();
//                System.out.println(val+"----value"+k);
                values.add(val.replace(",", ""));
//                System.out.println(values+"-----list"+k);
            }
            casfflowMap.put(key, values);
        }
        System.out.println(casfflowMap + "--------map");

        terminalCapRate = driver.findElements(discounted_cashFLow).get(1).getText().replace("%", "");
        terminalCapRate = String.format("%.3f", Double.parseDouble(terminalCapRate) / 100);
        discountRate = driver.findElements(discounted_cashFLow).get(0).getText().replace("%", "");
        discountRate = String.valueOf(Double.parseDouble(discountRate) / 100);
        salesCosts = driver.findElement(saleCost).getText();
        salesCosts = String.valueOf(Double.parseDouble(salesCosts) / 100);
        salePriceAdjustment = driver.findElement(adjustment).getText();
        salePriceAdjustment = String.valueOf(Double.parseDouble(salePriceAdjustment) / 100);
    }

    public void clickOnLoansTab() throws InterruptedException {
        driver.findElement(LoansTab).click();
        Thread.sleep(1000);
    }

    public void loansSum() {

        for (int i = 0; i < driver.findElements(loansAmount).size(); i++) {
            loanAmount = loanAmount + Integer.parseInt(driver.findElements(loansAmount).get(i).getText().replaceAll(",", ""));
        }

    }

    public void clickonRiskTab() throws InterruptedException {
        driver.findElement(riskTab).click();
        Thread.sleep(1000);
    }

    // do /100 for seed value
    public void riskValues(String seed_value) throws InterruptedException {
        driver.findElement(riskModels).click();
        Thread.sleep(500);
        driver.findElement(discountRate_Model).click();
        Thread.sleep(500);
        reversionSpeed = driver.findElement(revSpeed).getText();
        longTermRate = driver.findElement(avgRate).getText();
        longTermRate = String.valueOf(Double.parseDouble(longTermRate) / 100);
        Voltaility = driver.findElement(voltaility).getText();
        Voltaility = String.valueOf(Double.parseDouble(Voltaility) / 100);
        seedValue = String.valueOf(Double.parseDouble(seed_value)/100);
        driver.findElement(CancelButton).click();
        driver.findElement(simulationsTab).click();
        Thread.sleep(500);
        expValue = driver.findElements(RiskUIValues).get(3).getText().replace("$", "").replace("M","");
        expPercentage = driver.findElements(RiskUIValues).get(4).getText().replace("%", "").trim();
        varValue = driver.findElements(RiskUIValues).get(5).getText().replace("$", "").replace("M","");
        varPercentage = driver.findElements(RiskUIValues).get(6).getText().replace("%", "").trim();

    }


    public void clickOnDetailsTab() throws InterruptedException {
        driver.findElement(DetailsTab).click();
        Thread.sleep(1000);
    }

    public void capitalRate() {
        assetCaptial = driver.findElement(capital).getText().replace("$", "");
        portfolio = driver.findElement(portfolioName).getText();
        assetId = driver.getCurrentUrl();
        assetId = assetId.split("uuid=")[1].split(";")[0];
    }

    public void gotoParticularPortfolio() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//a[text()='"+portfolio+"']")).isDisplayed();
        driver.findElement(By.xpath("//a[text()='"+portfolio+"']")).click();
        Thread.sleep(1000);
        portfolioId = driver.getCurrentUrl();
        portfolioId = portfolioId.split("uuid=")[1].split(";")[0];
        scenarioId = driver.getCurrentUrl();
        scenarioId = scenarioId.split("baseCaseId=")[1].split(";")[0];
    }
    public void gotoJsonPage() throws ParseException {
        driver.get("http://realpage.vassarlabs.com:8099/");
        driver.findElement(simulatiosJson).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//a[text()='Discount Rate_"+portfolioId+"_"+scenarioId+"_INPUT.json']")).isDisplayed();
        driver.findElement(By.xpath("//a[text()='Discount Rate_"+portfolioId+"_"+scenarioId+"_INPUT.json']")).click();
        url = driver.getCurrentUrl();
        String inputjson = driver.findElement(spreadMargin).getText();
        seedValue = inputjson.split("seedValue")[1].split(",")[0].substring(2);
        seedValue = String.valueOf(Double.parseDouble(seedValue)/100);
        JSONParser parser = new JSONParser();
        JSONObject observationJson = (JSONObject) parser.parse(inputjson);
        JSONObject assets = (JSONObject) observationJson.get("assets");
        JSONObject assetData = (JSONObject) assets.get(assetId);
        JSONObject data = (JSONObject) assetData.get("data");
        JSONObject operatingExpense = (JSONObject) data.get("operatingExpense");
        OEValues = (JSONArray) operatingExpense.get("modelValues");
//        System.out.println(OEValues+"---OE Values");
        JSONObject operatingRevenue = (JSONObject) data.get("operatingRevenue");
        ORValues = (JSONArray) operatingRevenue.get("modelValues");
//        System.out.println(ORValues+"---OR Values");
        JSONObject capitalExpenditure = (JSONObject) data.get("capitalExpenditure");
        CEValues = (JSONArray) capitalExpenditure.get("modelValues");
//        System.out.println(CEValues+"---CE Values");


//        System.out.println(observationJson+"---observeee");
//        String Parent_Window = driver.getWindowHandle();
//
//        for (String Child_Window : driver.getWindowHandles())
//        {
//            driver.switchTo().window(Child_Window);
//            //Perform operation on child window
//            driver.close();
//        }

    }
    public void accessPythonCode() throws IOException, ParseException, InterruptedException {
        Utils.executePythonScript("python3","/home/uttham-vlit/Music/models/code/main.py",url,"/home/uttham-vlit/Music/models/json/simulation/UUID_simulation_OUTPUTSel.json","SIMULATION",assetId);
//        Thread.sleep(35000);
    }


    public void updateDataInExcel(String file, String Sheet) throws IOException {

//        System.out.println(OEValues+"in excel file");
//
//        driver.get("https://docs.google.com/spreadsheets/d/1LKndLDqhcsuaIRoKvxGcuKXfDnDxXT-C/edit#gid=1982949048");

        // Creating file object of existing excel file
        File xlsxFile = new File(file);
        //Creating input stream
        FileInputStream inputStream = new FileInputStream(xlsxFile);

        //Creating workbook from input stream
        Workbook workbook = WorkbookFactory.create(inputStream);

        String[] tabs = Sheet.split(",");
        for (int u = 0; u < tabs.length; u++) {
            //Reading sheet of excel file
            Sheet sheet = workbook.getSheet(tabs[u]);

            if (tabs[u].equals("assetExpences")) {
                for(int i =5 ;i<7;i++){
                    Row row = sheet.getRow(i);
                    for (int j = 1; j < OEValues.size(); j++) {
                        Cell cell = row.getCell(j);
                        if(i==5){
                            cell.setCellValue((Double) ORValues.get(j-1));
                        }else {
                            cell.setCellValue((Double) OEValues.get(j-1));
                        }
                    }
                }
                for (int j = 1; j < OEValues.size(); j++) {
                    Cell cell = sheet.getRow(8).getCell(j);
                    cell.setCellValue((Double) CEValues.get(j - 1));
                }

//                for (int i = 5; i < 12; i++) {
//                    Row row = sheet.getRow(i);
//                    String name = String.valueOf(row.getCell(0));
////                    System.out.println(name+"--name");
//                    List<String> val = casfflowMap.get(name);
//                    for (int j = 1; j < 13; j++) {
//                        Cell cell = row.getCell(j);
////                        System.out.println(i+"--row number "+j+"--cell number");
////                        System.out.println(val.get(j-1)+"-----keys" );
////                        if(Headers.contains(name)){
//                        String value = val.get(j - 1);
//                        if (value.contains("(")) {
//                            value = value.replace("(", "-");
//                            String split_Value = value.substring(0, value.length() - 1);
//                            cell.setCellValue(Double.parseDouble(split_Value));
//                        } else {
//                            cell.setCellValue(Double.parseDouble(value));
//                        }
////                        }
//                    }
//                }

                //Getting age cell of first row from the sheet
                Cell cell1 = sheet.getRow(13).getCell(1);
                //Updating the cell value with new data
                cell1.setCellValue(terminalCapRate);
                Cell cell2 = sheet.getRow(14).getCell(1);
                cell2.setCellValue(salePriceAdjustment);
                Cell cell3 = sheet.getRow(15).getCell(1);
                cell3.setCellValue(salesCosts);
                Cell cell4 = sheet.getRow(16).getCell(1);
                cell4.setCellValue(assetCaptial);
                Cell cell5 = sheet.getRow(17).getCell(1);
                cell5.setCellValue(loanAmount);
                Cell cell6 = sheet.getRow(18).getCell(1);
                cell6.setCellValue(assetCaptial);
                Cell cell7 = sheet.getRow(19).getCell(1);
                cell7.setCellValue(discountRate);


                Cell cell8 = sheet.getRow(3).getCell(14);
                cell1.setCellValue(reversionSpeed);
                Cell cell9 = sheet.getRow(4).getCell(14);
                cell2.setCellValue(longTermRate);
                Cell cell10 = sheet.getRow(5).getCell(14);
                cell3.setCellValue(Voltaility);
                Cell cell11 = sheet.getRow(6).getCell(14);
                cell4.setCellValue(seedValue);


            }
            if (tabs[u].equals("discountFactorOnAssetCashflow")) {
                DecimalFormat df = new DecimalFormat("#.##########");
                for (int i = 6; i < 10006; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 1; j < 11; j++) {
                        sample.add(df.format(row.getCell(j).getNumericCellValue()));
                    }
                    datacashFlow.add(sample);
                }
                System.out.println(datacashFlow.size() + "---discountFactorOnAssetCashflow size");
            }
            if (tabs[u].equals("discountFactor")) {
                DecimalFormat df = new DecimalFormat("#.##########");
                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 0; j < 10; j++) {
                        sample.add(df.format(row.getCell(j).getNumericCellValue()));
                    }
                    discountFlow.add(sample);
                }
                System.out.println(discountFlow.size() + "--discountfactor size");
            }


            if (tabs[u].equals("Discount Rate")) {
                DecimalFormat df = new DecimalFormat("#.##########");


                for (int i = 1; i < 10001; i++) {

                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 0; j < 10; j++) {
                        sample.add(df.format(row.getCell(j).getNumericCellValue()));
//                        sample.add(String.valueOf((row.getCell(j).getNumericCellValue())));
                    }
                    discount_Rate.add(sample);
                }
                System.out.println(discount_Rate.size() + "--dicountrate size");
            }
            if (tabs[u].equals("Discount Rate +1")) {
                DecimalFormat df = new DecimalFormat("#.##########");
                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 0; j < 10; j++) {
                        sample.add(df.format(row.getCell(j).getNumericCellValue()));
                    }
                    discount_Rate_1.add(sample);
                }
                System.out.println(discount_Rate_1.size() + "------discounrat+1 size");
            }
            if (tabs[u].equals("expectedMarketValue")) {

                for (int i = 2; i < 10002; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 1; j < 2; j++) {
                        sample.add(String.valueOf((row.getCell(j).getNumericCellValue())));
                    }
                    expectedMarket.add(sample);
                }
                Excel_expValue = String.valueOf(sheet.getRow(1).getCell(5).getNumericCellValue());
                Excel_expValue = String.format("%.2f", Double.parseDouble(Excel_expValue) / 1000000);
                Excel_expPercentage = String.valueOf(sheet.getRow(1).getCell(8).getNumericCellValue()*100).replace("%", "");
                Excel_expPercentage = String.format("%.1f",Double.parseDouble(Excel_expPercentage));
                Excel_varValue = String.valueOf(sheet.getRow(2).getCell(5).getNumericCellValue());
                Excel_varValue = String.format("%.2f", Double.parseDouble(Excel_varValue) / 1000000);
                Excel_varPercentage = String.valueOf(sheet.getRow(2).getCell(8).getNumericCellValue()*100).replace("%", "");
                Excel_varPercentage = String.format("%.1f",Double.parseDouble(Excel_varPercentage));
                System.out.println(expectedMarket.size() + "------expected size");
            }
            if (tabs[u].equals("fixedRandomValue")) {
//                DecimalFormat df = new DecimalFormat("#.##########");
                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 1; j < 10; j++) {
                        sample.add(String.valueOf((row.getCell(j).getNumericCellValue())));
                    }
                    fixedRandom.add(sample);
                }
                System.out.println(fixedRandom.size() + "------fixedrandom size");
            }
        }


        //Close input stream
        inputStream.close();

        //Crating output stream and writing the updated workbook
        FileOutputStream os = new FileOutputStream(xlsxFile);
        workbook.write(os);
        //Close the workbook and output stream
        workbook.close();
        os.close();


        System.out.println("Excel file has been updated successfully.");

    }

    public void datafromPythonOutput(String file, String Sheet) throws IOException {
        // Creating file object of existing excel file
        File xlsxFile = new File(file);
        //Creating input stream
        FileInputStream inputStream = new FileInputStream(xlsxFile);

        //Creating workbook from input stream
        Workbook workbook = WorkbookFactory.create(inputStream);

        String[] tabs = Sheet.split(",");
        for (int u = 0; u < tabs.length; u++) {
            //Reading sheet of excel file
            Sheet sheet = workbook.getSheet(tabs[u]);

            if (tabs[u].equals("unleveredCashflow")) {

                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 2; j < 12; j++) {
                        sample.add(String.valueOf((row.getCell(j))));
                    }
                    datacashFlow_Output.add(sample);
                }
                System.out.println(datacashFlow_Output.size() + "---discountFactorOnAssetCashflow output size");
            }
            if (tabs[u].equals("discountFactor")) {

                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 1; j < 11; j++) {
                        sample.add(String.valueOf((row.getCell(j))));
                    }
                    discountFlow_Output.add(sample);
                }
                System.out.println(discountFlow_Output.size() + "---discountfactor output size");
            }
            if (tabs[u].equals("discountRate") || tabs[u].equals("vasicekValue")) {
//                DataFormatter formatter = new DataFormatter();

                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 1; j < 11; j++) {
                        sample.add(String.valueOf((row.getCell(j))));

                    }
//                    System.out.println(sample+"--sample");
                    discountRate_Output.add(sample);
                }
                System.out.println(discountRate_Output.size() + "------discountRate_Output size");
            }
            if (tabs[u].equals("discountRatePlusOne")) {

                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 1; j < 11; j++) {
                        sample.add(String.valueOf((row.getCell(j))));
                    }
                    discountRate1_Output.add(sample);
                }
                System.out.println(discountRate1_Output.size() + "---discountRate1_Output size");
            }
            if (tabs[u].equals("expectedMarketValue")) {

                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 1; j < 11; j++) {
                        sample.add(String.valueOf((row.getCell(j))));
                    }
                    expectedMarket_Output.add(sample);
                }
                System.out.println(expectedMarket_Output.size() + "---expected_Output size");
            }
            if (tabs[u].equals("fixedRandomValue")) {

                for (int i = 1; i < 10001; i++) {
                    Row row = sheet.getRow(i);
                    List<String> sample = new ArrayList<>();
                    for (int j = 1; j < 11; j++) {
                        sample.add(String.valueOf((row.getCell(j))));
                    }
                    fixedRandom_Output.add(sample);
                }
                System.out.println(fixedRandom_Output.size() + "---fixedRandom_Output size");
            }

        }
    }

    public void compareValues() {
        Boolean diffFlag;

        //Verify for FixedRandom Value
        for (int i = 0; i < fixedRandom.size(); i++) {
            List<String> rowData = fixedRandom.get(i);
            List<String> rowDataOutput = fixedRandom_Output.get(i);
            for (int j = 0; j < rowData.size(); j++) {
                diffFlag = false;
                Double difference = 0.0;
                if (Double.parseDouble(rowDataOutput.get(j)) > Double.parseDouble(rowData.get(j))) {
                    difference = Double.parseDouble(rowDataOutput.get(j)) - Double.parseDouble(rowData.get(j));
//                    System.out.println(difference + "---differnce");
                } else {
                    difference = Double.parseDouble(rowData.get(j)) - Double.parseDouble(rowDataOutput.get(j));
//                    System.out.println(difference + "---differnce_11");
                }
                if (difference <= 0.0000000001) {
                    diffFlag = true;
                } else {
                    System.out.println(difference + "---differnce");
                }
                Assert.assertTrue(diffFlag, "QA value: " + rowData.get(j) + " Row number : " + i + "--- COlumn number : " + j + " Python Value :" + rowDataOutput.get(j) + "in FIxed Random Values");
            }
        }

        //Verify for DIscountFactor
        for (int i = 0; i < discountFlow.size(); i++) {
            List<String> rowData = discountFlow.get(i);
            List<String> rowDataOutput = discountFlow_Output.get(i);
            for (int j = 0; j < rowData.size(); j++) {
                diffFlag = false;
                Double difference = 0.0;
                if (Double.parseDouble(rowDataOutput.get(j)) > Double.parseDouble(rowData.get(j))) {
                    difference = Double.parseDouble(rowDataOutput.get(j)) - Double.parseDouble(rowData.get(j));
                } else {
                    difference = Double.parseDouble(rowData.get(j)) - Double.parseDouble(rowDataOutput.get(j));
                }
                if (difference <= 0.00000000015) {
                    diffFlag = true;
                } else {
                    System.out.println(difference + "---differnce");
                }
                Assert.assertTrue(diffFlag, "QA value: " + rowData.get(j) + " Row number : " + i + "--- COlumn number : " + j + " Python Value :" + rowDataOutput.get(j) + " in Discount Factor");
            }
        }

        //Verify for DIscountRate
        for (int i = 0; i < discount_Rate.size(); i++) {
            List<String> rowData = discount_Rate.get(i);
            List<String> rowDataOutput = discountRate_Output.get(i);
            for (int j = 0; j < rowData.size(); j++) {
                diffFlag = false;
                Double difference = 0.0;
                if (Double.parseDouble(rowDataOutput.get(j)) > Double.parseDouble(rowData.get(j))) {
                    difference = Double.parseDouble(rowDataOutput.get(j)) - Double.parseDouble(rowData.get(j));
                } else {
                    difference = Double.parseDouble(rowData.get(j)) - Double.parseDouble(rowDataOutput.get(j));
                }
                if (difference <= 0.00000000015) {
                    diffFlag = true;
                } else {
                    System.out.println(difference + "---differnce");
                }
                Assert.assertTrue(diffFlag, "QA value: " + rowData.get(j) + " Row number : " + i + "--- COlumn number : " + j + " Python Value :" + rowDataOutput.get(j) + " in Discount Rate");
            }
        }

        //Verify for DIscountRate+1
        for (int i = 0; i < discount_Rate_1.size(); i++) {
            List<String> rowData = discount_Rate_1.get(i);
            List<String> rowDataOutput = discountRate1_Output.get(i);
            for (int j = 0; j < rowData.size(); j++) {
                diffFlag = false;
                Double difference = 0.0;
                if (Double.parseDouble(rowDataOutput.get(j)) > Double.parseDouble(rowData.get(j))) {
                    difference = Double.parseDouble(rowDataOutput.get(j)) - Double.parseDouble(rowData.get(j));
                } else {
                    difference = Double.parseDouble(rowData.get(j)) - Double.parseDouble(rowDataOutput.get(j));
                }
                if (difference <= 0.00000000015) {
                    diffFlag = true;
                } else {
                    System.out.println(difference + "---differnce");
                }
                Assert.assertTrue(diffFlag, "QA value: " + rowData.get(j) + " Row number : " + i + "--- COlumn number : " + j + " Python Value :" + rowDataOutput.get(j) + " in Discount Rate+1");
            }
        }

        //Verify for DiscountFactorOn AssetCashflow
        for (int i = 0; i < datacashFlow.size(); i++) {
            List<String> rowData = datacashFlow.get(i);
            List<String> rowDataOutput = datacashFlow_Output.get(i);
            for (int j = 0; j < rowData.size(); j++) {
                diffFlag = false;
                Double difference = 0.0;
                if (Double.parseDouble(rowDataOutput.get(j)) > Double.parseDouble(rowData.get(j))) {
                    difference = Double.parseDouble(rowDataOutput.get(j)) - Double.parseDouble(rowData.get(j));
//                    System.out.println(difference + "---differnce");
                } else {
                    difference = Double.parseDouble(rowData.get(j)) - Double.parseDouble(rowDataOutput.get(j));
//                    System.out.println(difference + "---differnce_11");
                }
                if (difference <= 0.0000015) {
                    diffFlag = true;
                } else {
                    System.out.println(difference + "---differnce");
                }
                Assert.assertTrue(diffFlag, "QA value: " + rowData.get(j) + " Row number : " + i + "--- COlumn number : " + j + " Python Value :" + rowDataOutput.get(j) + "in DiscountFactorOn AssetCashflow");
            }
        }


        //Verify for expectedMarketValue
        for (int i = 0; i < expectedMarket.size(); i++) {
            List<String> rowData = expectedMarket.get(i);
            List<String> rowDataOutput = expectedMarket_Output.get(i);
            for (int j = 0; j < rowData.size(); j++) {
                diffFlag = false;
                Double difference = 0.0;
                if (Double.parseDouble(rowDataOutput.get(j)) > Double.parseDouble(rowData.get(j))) {
                    difference = Double.parseDouble(rowDataOutput.get(j)) - Double.parseDouble(rowData.get(j));
                } else {
                    difference = Double.parseDouble(rowData.get(j)) - Double.parseDouble(rowDataOutput.get(j));
                }
                if (difference <= 0.015) {
                    diffFlag = true;
                } else {
                    System.out.println(difference + "---differnce");
                }
//                System.out.println(diffFlag+"-----flagggg");
                Assert.assertTrue(diffFlag, "QA value: " + rowData.get(j) + " Row number : " + i + "--- COlumn number : " + j + " Python Value :" + rowDataOutput.get(j) + " in expectedMarketValue");
            }
        }

        Assert.assertTrue(expValue.contentEquals(Excel_expValue), "QA Value : " + Excel_expValue + " Ui Value : " + expValue);
        Assert.assertTrue(expPercentage.contentEquals(Excel_expPercentage), "QA Value : " + Excel_expPercentage + " Ui Value : " + expPercentage);
        Assert.assertTrue(varValue.contentEquals(Excel_varValue), "QA Value : " + Excel_varValue + " Ui Value : " + varValue);
        Assert.assertTrue(varPercentage.contentEquals(Excel_varPercentage), "QA Value : " + Excel_varPercentage + " Ui Value : " + varPercentage);

    }
}
