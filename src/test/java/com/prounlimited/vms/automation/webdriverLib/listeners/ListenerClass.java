package com.prounlimited.vms.automation.webdriverLib.listeners;

import com.prounlimited.vms.automation.appLib.dataInit.DataLoad;
import com.prounlimited.vms.automation.appLib.dataInit.RunSetting;
import com.prounlimited.vms.automation.utility.Reports;
import com.prounlimited.vms.automation.webdriverLib.driverManager.WebDriverHelper;
import org.testng.*;

public class ListenerClass extends WebDriverHelper implements ITestListener, ISuiteListener, IInvokedMethodListener {
    public void onStart(ISuite suite) {
        DataLoad.initialization();
    }

    public void onFinish(ISuite suite) {

      //  Reports.moveallureresult();
    }

    public void onTestStart(ITestResult result) {
        launchBrowser(RunSetting.Browser, RunSetting.URL);
    }
    public void onFinish(ITestContext context) {
        driver.close();
    }
    public void onTestFailure(ITestResult result) {
        driver.close();
    }
}
