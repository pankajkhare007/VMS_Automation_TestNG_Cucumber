package com.prounlimited.vms.automation.appLib.moduleLib;

import com.prounlimited.vms.automation.appLib.dataInit.Global;
import com.prounlimited.vms.automation.appLib.webObjects.CommonObjects;
import com.prounlimited.vms.automation.webdriverLib.driverManager.WebControls;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.List;

import static com.prounlimited.vms.automation.webdriverLib.driverManager.WebDriverHelper.driver;

public class CommonLib {

    public static void login() {
        WebControls.setValueOnEditBox(CommonObjects.editUsername, Global.userName,"Username");
        WebControls.setValueOnEditBox(CommonObjects.editPassword, Global.password,"Password");
        WebControls.clickonObject(CommonObjects.btnLogin,"Login Button");
        WebControls.waitforElement(CommonObjects.lblMainMenu);

    }
    public static void setFilter(String sSearchOption, String sSearchData)
    {
        List<WebElement> r=WebControls.createObjects("xpath=//*[contains(text(),'filters...')]");
        if(r.size()>0)
        {
            if(!setExistingFilter(sSearchOption,sSearchData))
            {
                WebControls.clickonObject("xpath=//*[contains(text(),'filters...')]","Filter dropdown");
                WebElement filterOption=WebControls.createObject("xpath=//*[@class='slimScrollDiv']//*[text()='" + sSearchOption + "']");
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", filterOption);
                filterOption.click();
                handleLoadingImage();
                setExistingFilter(sSearchOption,sSearchData);



            }
        }
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


            WebControls.waitforElement("xpath=//ul[@class='chosen-results']/li/em[text()='" + sSearchData + "']");
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
            Thread.sleep(3000);
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
    public static void scrollIntoViewElement(WebElement ele)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
    }

    public static void clickOnNewCheckBoxSwitcher(String labelName)
    {
        String xpathObj = "//div[contains(@class,'zc-input-group')]/label[contains(text(),'" + labelName + "')]//parent::*/label[@class='zc-checkbox switcher ']/i";
        WebControls.clickonObject("xpath=" + xpathObj, labelName);
    }
    public static void logout()
    {
        WebControls.clickonObject(CommonObjects.linkProfileIcon,"Profile Icon");
        CommonLib.handleLoadingImage();
        WebControls.clickonObject(CommonObjects.linkLogout,"Logout");
        CommonLib.handleLoadingImage();
    }
}
