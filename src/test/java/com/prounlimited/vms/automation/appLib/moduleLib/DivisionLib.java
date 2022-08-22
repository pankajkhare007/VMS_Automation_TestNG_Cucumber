package com.prounlimited.vms.automation.appLib.moduleLib;

import com.prounlimited.vms.automation.appLib.dataInit.Global;
import com.prounlimited.vms.automation.appLib.webObjects.CommonObjects;
import com.prounlimited.vms.automation.appLib.webObjects.DivisionObjects;
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
        WebControls.waitforElement("xpath=//div[@id='FilterRows_1__SelectedItems_chosen']//ul[@class='chosen-choices']//li[@class='search-field']//input[@type='text']","Run Search");
        CommonLib.setExistingFilter("Division", Global.clientName);
        CommonLib.applyFilter();
        CommonLib.clickOnLinkByText(Global.clientID);
    }

    public static void navigateToApprovalGroupPage()
    {
        CommonLib.clickOnLinkByText("Configuration");
        CommonLib.clickOnLinkByText("Approval Groups");
        WebControls.waitforElement(DivisionObjects.editApprovalGroupName,"Approval Group Name");
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
}
