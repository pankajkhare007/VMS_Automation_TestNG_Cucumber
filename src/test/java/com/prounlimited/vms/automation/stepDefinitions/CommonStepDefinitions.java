package com.prounlimited.vms.automation.stepDefinitions;

import com.prounlimited.vms.automation.appLib.dataInit.RunSetting;
import com.prounlimited.vms.automation.appLib.moduleLib.CommonLib;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepDefinitions {

    private Scenario scenario;
    @Before
    public void before(Scenario scenario) {

        this.scenario =scenario;
      RunSetting.scenarioName = scenario.getName();

    }

    @Then("^Use excelsheet \"([^\"]*)\" and sheet \"([^\"]*)\"$")
    public void assignExcelSheetNameAndSheetName(String excelSheetName,String sheetName)
    {
        RunSetting.TestDataFile = excelSheetName;
        RunSetting.sheetName = sheetName;
    }
    @Given("^login as admin$")
    // @Given("login as admin")
    public void login_as_admin() {

        CommonLib.login();
//System.out.println("login as admin.....");

    }
}
