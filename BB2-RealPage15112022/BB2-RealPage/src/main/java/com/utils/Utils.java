package com.utils;

import com.aspose.cells.Workbook;

import java.io.IOException;
import java.util.List;

import static org.apache.poi.ss.formula.functions.Irr.irr;

public class Utils {

    public static void executePythonScript(String pythonExePath, String pythonScriptPath, String inputJsonPath, String outputJsonPath, String type,String uuid) throws IOException, InterruptedException, org.json.simple.parser.ParseException, IOException {
//        LOGGER.info("In ModelServiceImpl :: execute {} PythonScript",type);
        System.out.println("Executing Started");
        ProcessBuilder pb = new ProcessBuilder(pythonExePath, pythonScriptPath, type, inputJsonPath, outputJsonPath,uuid);
        System.out.println(pythonExePath+pythonScriptPath+type+inputJsonPath+outputJsonPath+uuid+"  Python terminal command");
        pb.redirectErrorStream(true);
        Process p = pb.start();
        p.waitFor();
        System.out.println("Execution Ended");
    }
    public static void combineExcel() throws Exception {
        // Open the first excel file.
        Workbook SourceBook1 = new Workbook("/home/uttham-vlit/Music/models/json/simulation/discountFactor.xlsx");
        // Open the second excel file.
        Workbook SourceBook2 = new Workbook("/home/uttham-vlit/Music/models/json/simulation/discountRate.xlsx");
        Workbook SourceBook3 = new Workbook("/home/uttham-vlit/Music/models/json/simulation/discountRatePlusOne.xlsx");
        Workbook SourceBook4 = new Workbook("/home/uttham-vlit/Music/models/json/simulation/fixedRandomValue.xlsx");
        Workbook SourceBook5 = new Workbook("/home/uttham-vlit/Music/models/json/simulation/unleveredCashflow.xlsx");
        Workbook SourceBook6 = new Workbook("/home/uttham-vlit/Music/models/json/simulation/expectedMarketValue.xlsx");

        // Copy worksheets of second Excel file to the first workbook.
        SourceBook1.combine(SourceBook2);
        SourceBook1.combine(SourceBook3);
        SourceBook1.combine(SourceBook4);
        SourceBook1.combine(SourceBook5);
        SourceBook1.combine(SourceBook6);
        // Save the updated first excel file as a new file.
        SourceBook1.save("/home/uttham-vlit/Music/CombinedFile.xlsx");
    }


}
