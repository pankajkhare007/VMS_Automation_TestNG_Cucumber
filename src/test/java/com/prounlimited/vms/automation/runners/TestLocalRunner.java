package com.prounlimited.vms.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(glue = {"com.prounlimited.vms.automation.stepDefinitions"},
        features ={"src/test/resources/Features"}
       // plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
      //  tags = ("@Regression")
        )

@Listeners(com.prounlimited.vms.automation.webdriverLib.listeners.ListenerClass.class)
public class TestLocalRunner extends AbstractTestNGCucumberTests {
}
