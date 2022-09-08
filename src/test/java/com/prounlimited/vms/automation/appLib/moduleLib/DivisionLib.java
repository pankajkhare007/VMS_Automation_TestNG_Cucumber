package com.prounlimited.vms.automation.appLib.moduleLib;

import com.prounlimited.vms.automation.appLib.dataInit.Global;
import com.prounlimited.vms.automation.appLib.webObjects.CommonObjects;
import com.prounlimited.vms.automation.appLib.webObjects.DivisionObjects;
import com.prounlimited.vms.automation.utility.Assertions;
import com.prounlimited.vms.automation.utility.Utils;
import com.prounlimited.vms.automation.webdriverLib.driverManager.WebControls;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DivisionLib {

    public static void navigateToClientDetailPage()
    {
        WebControls.clickonObject(CommonObjects.linkSetup,"Setup link");
        WebControls.clickonObject(CommonObjects.linkCustomers,"Customers link");
        WebControls.clickonObject(CommonObjects.linkDivisions,"Divisions link");
        WebControls.waitforElement("xpath=//div[@id='FilterRows_1__SelectedItems_chosen']//ul[@class='chosen-choices']//li[@class='search-field']//input[@type='text']");
        CommonLib.setFilter("Division ID", Global.clientID);
        CommonLib.applyFilter();
        CommonLib.clickOnLinkByText(Global.clientID);
    }

    public static void navigateToApprovalGroupPage()
    {
        CommonLib.clickOnLinkByText("Configuration");
        CommonLib.clickOnLinkByText("Approval Groups");
        WebControls.waitforElement(DivisionObjects.editApprovalGroupName);
    }

    public static void addNewApprovalGroup()
    {
        WebControls.setValueOnEditBox(DivisionObjects.editApprovalGroupName,Global.testData.get("ApprovalGroupName"),"Approval Group Name");
        WebControls.clickonObject(DivisionObjects.btnAdd,"Add Approval Group button");
        CommonLib.handleLoadingImage();
       // Assert.assertTrue(WebControls.isElementPresent("xpath=//li[@class='sucMsg successImage']"));
    }

    public static void addApprovalManagerInApprovalGroup()
    {
        WebControls.setValueOnEditBox(DivisionObjects.editFilter_ApprovalGroupName,Global.testData.get("ApprovalGroupName"),"Apprval Group");
        WebControls.createObject(DivisionObjects.editFilter_ApprovalGroupName).sendKeys(Keys.ENTER);
        CommonLib.handleLoadingImage();
        WebControls.createObject("xpath=//*[@id='ctl00_contplhDynamic_ZeroChaosGrid_ctl00__0']/td[4]/a").click();
        WebControls.clickonObject("linktext=Add/Edit Role","Add Edit link");
        WebElement sObj =WebControls.createObject(DivisionObjects.editContactTextBox);
        CommonLib.slowmotionSendKeys(sObj,Global.testData.get("ApprovalManager"));
        sObj.sendKeys(Keys.DOWN);
        sObj.sendKeys(Keys.ENTER);
        WebControls.clickonObject(DivisionObjects.btnAddApprovalManager,"Add contact");


    }

    public static void naviageToApprovalWorkflowDetailPage()
    {
        CommonLib.clickOnLinkByText("Configuration");
        CommonLib.clickOnLinkByText("Approval Workflow");
        WebControls.waitforElement(DivisionObjects.tblApprovalWorkflowList);
    }

    public static void createNewApprovalWorkflow()
    {
        WebControls.clickonObject(DivisionObjects.btnNewApprovalWorkFlow,"New Approval Workflow");
        WebControls.waitforElement(DivisionObjects.ddlObject);
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlObject, Global.testData.get("sObjectName"));
        CommonLib.handleLoadingImage();
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlField, Global.testData.get("sField"));
        CommonLib.handleLoadingImage();
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlComparison, Global.testData.get("Compare"));
        String compareValue=Utils.doubleToString(Global.testData.get("CompareValue"));
        WebControls.setValueOnEditBox(DivisionObjects.editValue,compareValue,"value");
        WebControls.clickonObject(DivisionObjects.btnNewApprovalWorkflowSubmit,"Submit");
        WebControls.waitforElement(DivisionObjects.btnClose);
        WebControls.clickonObject(DivisionObjects.btnClose,"Close");
        CommonLib.handleLoadingImage();
        CommonLib.handleLoadingImage();
        WebControls.waitforElementClickable(DivisionObjects.btnRunSearch_ApprovalFlowDetail);

    }
    public static void createNewApprovalWorkflowDropDownValue()
    {
        WebControls.clickonObject(DivisionObjects.btnNewApprovalWorkFlow,"New Approval Workflow");
        WebControls.waitforElement(DivisionObjects.ddlObject);
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlObject, Global.testData.get("sObjectName"));
        CommonLib.handleLoadingImage();
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlField, Global.testData.get("sField"));
        CommonLib.handleLoadingImage();
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlComparison, Global.testData.get("Compare"));
//        String compareValue=Utils.doubleToString(Global.testData.get("CompareValue"));
//        WebControls.setValueOnEditBox(DivisionObjects.editValue,compareValue,"value");
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlValue, Global.testData.get("CompareValue"));
        WebControls.clickonObject(DivisionObjects.btnNewApprovalWorkflowSubmit,"Submit");
        WebControls.waitforElement(DivisionObjects.btnClose);
        WebControls.clickonObject(DivisionObjects.btnClose,"Close");
        CommonLib.handleLoadingImage();
        CommonLib.handleLoadingImage();
        WebControls.waitforElementClickable(DivisionObjects.btnRunSearch_ApprovalFlowDetail);

    }

    public static void selectObjectInNewApprovalWorkflow(String objectName)
    {
        String xpathObj="//div[@id='divFilter']//div[@id='divFilterContent']//form[@id='filterForm']//ul[@id='tblFilter']//li[contains(@class,'filter-boolean col-xs-4')]//div[contains(@class,'')]//div[@id='FilterRows_0__BoolValue_chosen']//a[contains(@class,'chosen-single')]//div";
        WebControls.clickonObject("xpath=//a[@class='chosen-single']","select");
        WebControls.setValueOnEditBox("xpath=//*[@id='FilterRows_0__BoolValue_chosen']/div/div/input",objectName,"AWF Object");
        String xpathObject = "//*[@id='FilterRows_0__BoolValue_chosen']/div/ul/li";
        WebControls.clickonObject("xpath="+xpathObject,"select");
        CommonLib.handleLoadingImage();
        //WebControls.waitforElementClickable(DivisionObjects.btnRunSearch_ApprovalFlowDetail);
    }
    public static void insertStepsIntoApprvalWorkflow()
    {

        WebControls.clickonObject(DivisionObjects.btnRunSearch_ApprovalFlowDetail,"Run Search");
        //CommonLib.handleLoadingImage();
        CommonLib.handleLoadingImage();
        WebControls.waitforElementClickable(DivisionObjects.linkViewDetails);
        WebControls.clickonObject("class=btn btn-secondary cleardatabtn", "Record page");
        CommonLib.handleLoadingImage();
        clickOnAddApprvalWorkflow();
       // String flowOrder=Utils.doubleToString(Global.testData.get("sFlowOrder"));
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlOrder,Global.testData.get("sFlowOrder"));
        WebControls.setValueOnEditBox(DivisionObjects.editApprovalStepName,Global.testData.get("sStepName"),"step name");
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlApprovalGroupType,Global.testData.get("sApprovalGroupType"));
        CommonLib.handleLoadingImage();
        WebElement ele = WebControls.createObject("xpath=//input[@class='cls-req-deflt-apr']/parent::*");
        CommonLib.scrollIntoViewElement(ele);
        selectApprvalGroupInApprovalStep(Global.testData.get("sAppovalGroup"));
        WebControls.selectValuefromDoropDownByText(DivisionObjects.ddlDefaultApproval,Global.testData.get("sDefaultApprover"));
       CommonLib.clickOnNewCheckBoxSwitcher("Allow Owners to Approve Workflow");
        CommonLib.clickOnNewCheckBoxSwitcher("Active");
        WebControls.clickonObject(DivisionObjects.btnSubmit_AddApprovalWorkflowStep,"Submit");
        CommonLib.handleLoadingImage();
        WebControls.clickonObject(DivisionObjects.btnSubmitClose_AddWorkFlowStep,"Submit and Close");
        CommonLib.handleLoadingImage();
        WebControls.waitforElementClickable("xpath=//a[@class='chosen-single']");
        boolean flag=WebControls.clickonObject(DivisionObjects.btnClose,"Close");
        CommonLib.handleLoadingImage();
        Assertions.valueIsTure(flag,"Close button of instert popup is clicked");
        WebControls.clickonObject(DivisionObjects.btnFinalCloseAWF,"Close pupup");
        CommonLib.handleLoadingImage();
        CommonLib.logout();

    }
    public static void clickOnAddApprvalWorkflow()
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //CommonLib.scrollIntoViewElement(WebControls.createObject(DivisionObjects.linkViewDetails));
        WebControls.clickonObject(DivisionObjects.linkViewDetails, "View Details");
        CommonLib.handleLoadingImage();
        CommonLib.handleLoadingImage();
        WebControls.waitforElementClickable(DivisionObjects.btnAddNewWorkflowStep_ApprovalFlowDetail);
        WebControls.clickonObject(DivisionObjects.btnAddNewWorkflowStep_ApprovalFlowDetail,"add workflow step");
        CommonLib.handleLoadingImage();
        //WebControls.waitforElement(DivisionObjects.ddlOrder);
      //  WebControls.waitforElementSelectable(DivisionObjects.ddlOrder);
    }

    public static void selectApprvalGroupInApprovalStep(String approvalGroupName)
    {
//        WebElement ele =WebControls.createObject("xpath=//*[@id='frmAddApprovalFlowStep']/div[5]/div[1]/div[4]/div[3]/span");
//        CommonLib.scrollIntoViewElement(ele);
        WebControls.clickonObject("xpath=//div[@id='ddlApprovalGroup_chosen']//a[@class='chosen-single']", "Select");
        CommonLib.handleLoadingImage();
        WebControls.setValueOnEditBox("xpath=//*[@id='ddlApprovalGroup_chosen']/div/div/input",approvalGroupName,"Approval Group");
        CommonLib.handleLoadingImage();
        WebControls.clickonObject("xpath=//div[@id='ddlApprovalGroup_chosen']/div/ul/li", "Approval Group");

    }
}
