package com.prounlimited.vms.automation.utility;

import io.qameta.allure.Step;
import org.testng.Assert;

public class Assertions {


    @Step("Check the '{fieldName}' field is equal '{expected}'")
    public static void expectedTextsAreEqual(String fieldName,String actual,String expected)
    {

        Assert.assertEquals(actual,expected,"String in fieldName '"+fieldName+"' should be equal to '"+expected+"'" +
                "but displayed '"+actual+"'");
    }

    @Step("Check '{value}' value is NOT null")
    public static void valueIsNotNull(Object value,String errorMessage)
    {
        Assert.assertNotNull(value,errorMessage);
    }

    @Step("Check '{value}' value is true")
    public static void valueIsTure(boolean value,String message)
    {
        Assert.assertTrue(value,message);
    }
}
