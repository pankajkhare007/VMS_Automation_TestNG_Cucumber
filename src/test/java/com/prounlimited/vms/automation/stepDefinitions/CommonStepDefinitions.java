package com.prounlimited.vms.automation.stepDefinitions;

import com.prounlimited.vms.automation.appLib.dataInit.RunSetting;
import com.prounlimited.vms.automation.appLib.moduleLib.CommonLib;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions {

    private Scenario scenario;
    @Before
    public void before(Scenario scenario) {

        this.scenario =scenario;
      RunSetting.scenarioName = scenario.getName();

    }
    @Given("login as admin")
    // @Given("login as admin")
    public void login_as_admin() {

        CommonLib.login();
//System.out.println("login as admin.....");

    }
}
