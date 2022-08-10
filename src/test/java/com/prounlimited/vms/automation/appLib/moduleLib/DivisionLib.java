package com.prounlimited.vms.automation.appLib.moduleLib;

import com.prounlimited.vms.automation.appLib.dataInit.Global;
import com.prounlimited.vms.automation.appLib.webObjects.CommonObjects;
import com.prounlimited.vms.automation.webdriverLib.driverManager.WebControls;

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
}
