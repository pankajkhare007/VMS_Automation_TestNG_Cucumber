package com.prounlimited.vms.automation.stepDefinitions.division;

import com.prounlimited.vms.automation.appLib.dataInit.ExcelSheets;
import com.prounlimited.vms.automation.appLib.dataInit.Global;
import com.prounlimited.vms.automation.appLib.dataInit.RunSetting;
import com.prounlimited.vms.automation.appLib.moduleLib.DivisionLib;
import com.prounlimited.vms.automation.utility.ExcelReader;
import com.prounlimited.vms.automation.utility.Utils;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class DivisionStepDefinitions {

    @And("Navigate to client detail page")
    public void navigateToCleientDetailPage()
    {
        RunSetting.TestDataFile ="Pre_Requisite.xlsx";
        List<Map<String,String>> excelDataList= ExcelReader.getExcelRowsdata(RunSetting.TestDataFile, ExcelSheets.Project.toString(),"sTestCaseID="+RunSetting.scenarioName);
        Global.clientName= excelDataList.get(0).get("ClientName");
        Global.clientID= excelDataList.get(0).get("ClientID");
        DivisionLib.navigateToClientDetailPage();
    }
}
