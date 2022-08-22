package com.prounlimited.vms.automation.appLib.moduleLib;

import com.prounlimited.vms.automation.appLib.dataInit.Global;
import com.prounlimited.vms.automation.appLib.webObjects.CommonObjects;
import com.prounlimited.vms.automation.webdriverLib.driverManager.WebControls;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CommonLib {

    public static void login() {
        WebControls.setValueOnEditBox(CommonObjects.editUsername, Global.userName,"Username");
        WebControls.setValueOnEditBox(CommonObjects.editPassword, Global.password,"Password");
        WebControls.clickonObject(CommonObjects.btnLogin,"Login Button");
        WebControls.waitforElement(CommonObjects.lblMainMenu,"Main menu");

    }
    public static boolean setExistingFilter(String sSearchOption, String sSearchData)
    {
        boolean isFilterFound = false;
        WebElement filterSection =WebControls.createObject("xpath=//label[contains(text(),'" + sSearchOption + "')]//parent::*//input[contains(@class,'chosen-search-input')]");

        // Section added for Clicking on Dropdown list section
        WebElement dropDownFilterSection = WebControls.createObject("xpath=//label[contains(text(),'" + sSearchOption + "')]//parent::*//input[contains(@class,'chosen')]");
        if(dropDownFilterSection!=null)
        {
            dropDownFilterSection.click();
        }
        if(filterSection != null)
        {
            isFilterFound = true;
            filterSection.click();
            filterSection.sendKeys(sSearchData);


            WebControls.waitforElement("xpath=//ul[@class='chosen-results']/li/em[text()='" + sSearchData + "']","Search Data");
            filterSection.sendKeys(Keys.ENTER);
           // WebElement result=WebControls.createObject("//ul[@class='chosen-results']/li/em[text()='" + sSearchData + "']/parent::*");

//            if(result!=null)
//            {
//
//                result.click();
//            }
        }
        return isFilterFound;
    }

    public static void handleLoadingImage()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void applyFilter()
    {
        WebControls.clickonObject(CommonObjects.btnRunSearch,"Search button");

    }

    public static void clickOnLinkByText(String linkText)
    {
        WebControls.clickonObject("linktext="+linkText,linkText);
    }

    public static void slowmotionSendKeys(WebElement ele ,String text)
    {
        String val = text;
        ele.clear();
        for (int i=0;i < val.length(); i++)
        {
            char c = val.charAt(i);
            String  s=new StringBuffer().append(c).toString();
            ele.sendKeys(s);
            CommonLib.handleLoadingImage();
        }
    }
}
