package com.prounlimited.vms.automation.stepDefinitions.division;

import com.prounlimited.vms.automation.appLib.dataInit.ExcelSheets;
import com.prounlimited.vms.automation.appLib.dataInit.Global;
import com.prounlimited.vms.automation.appLib.dataInit.RunSetting;
import com.prounlimited.vms.automation.appLib.moduleLib.CommonLib;
import com.prounlimited.vms.automation.appLib.moduleLib.DivisionLib;
import com.prounlimited.vms.automation.appLib.webObjects.DivisionObjects;
import com.prounlimited.vms.automation.utility.Assertions;
import com.prounlimited.vms.automation.utility.ExcelReader;
import com.prounlimited.vms.automation.utility.Utils;
import com.prounlimited.vms.automation.webdriverLib.driverManager.WebControls;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class DivisionStepDefinitions {

    @Then("Navigate to client detail page")
    public void navigateToClientDetailPage()
    {
        //RunSetting.TestDataFile ="Pre_Requisite.xlsx";
        List<Map<String,String>> excelDataList= ExcelReader.getExcelRowsdata(RunSetting.TestDataFile, RunSetting.sheetName,"sTestCaseID="+RunSetting.scenarioName);
        Global.testData=excelDataList.get(0);
       // Global.clientName= excelDataList.get(0).get("ClientName");
        Global.clientID= Utils.doubleToString(excelDataList.get(0).get("ClientID"));
        DivisionLib.navigateToClientDetailPage();
    }
    @And("Navigate to approval group page")
    public void navigateToApprovalGroupPage()
    {
        DivisionLib.navigateToApprovalGroupPage();
    }

    @When("Add new approval group")
    public  void addNewApprovalGroup()
    {
        DivisionLib.addNewApprovalGroup();
    }
    @And("Add approval manager in to approval group")
    public void addApprovalManagerInApprovalGroup()
    {
        DivisionLib.addApprovalManagerInApprovalGroup();
    }
    @Then("Verify new approval group added successfully")
    public void VerifyNewApprovalGroupAddedSuccessfully()
    {
        WebElement sObj = WebControls.createObject(DivisionObjects.lblApprovalGroupSuccMessage);
        if (sObj!=null)
        {
            String actualMessage=sObj.getText().trim();
            Assertions.expectedTextsAreEqual("Success Message",actualMessage,"Approval group has been added successfully.");
        }
        else
        {
            Assertions.valueIsNotNull(sObj,"Approval group is not added");
        }

    }

    @Then("Verify approval manager added successfully")
    public void VerifyApprovalManagerAddedSuccessfully()
    {
        WebElement sObj = WebControls.createObject(DivisionObjects.lblApprovalGroupSuccMessage);
        if (sObj!=null)
        {
            String actualMessage=sObj.getText().trim();
            Assertions.expectedTextsAreEqual("Success Message",actualMessage,"Approval role has been added successfully.");
        }
        else
        {
            Assertions.valueIsNotNull(sObj,"Approval manager is not added");
        }
    }

    @And("Navigate to approval setup page")
    public void navigateToApprovalSetupPage()
    {
        DivisionLib.naviageToApprovalWorkflowDetailPage();
    }

    @Then("Create new approval workflow")
    public void createNewApprovalWorkflow()
    {
        DivisionLib.createNewApprovalWorkflow();

    }
    @And("Insert Steps into new approval workflow")
    public void insertStepsIntoNewApprovalWorkflow()
    {
        DivisionLib.selectObjectInNewApprovalWorkflow(Global.testData.get("sObjectName"));
        DivisionLib.insertStepsIntoApprvalWorkflow();

    }
    @Then("Create new approval workflow for amend type")
    public void createNewApprovalWorkflowForAmendType()
    {
        DivisionLib.createNewApprovalWorkflowDropDownValue();

    }

}
