package com.prounlimited.vms.automation.webdriverLib.driverManager;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebControls extends WebDriverHelper{

    public static WebElement createObject(String ValueofElement) {


        WebElement ele;
        String[] values = ValueofElement.split("=", 2);
        switch (values[0].toString().toLowerCase()) {
            case "xpath":
                try {

                    ele = driver.findElement(By.xpath(values[1].toString()));
                    return ele;
                } catch (Exception e) {
                    return null;
                }

            case "id":
                try {
                    ele = driver.findElement(By.id(values[1].toString()));
                    return ele;
                } catch (Exception e) {
                    return null;
                }

            case "css":
                try {
                    ele = driver.findElement(By.cssSelector(values[1].toString()));
                    return ele;
                } catch (Exception e) {
                    return null;
                }
            case "linktext":
                try {
                    ele = driver.findElement(By.linkText(values[1].toString()));
                    return ele;
                } catch (Exception e) {
                    return null;
                }
            default:
                return ele = null;
        }

    }

    public static List<WebElement> createObjects(String ValueofElement) {

        List<WebElement> ele;
        String[] values = ValueofElement.split("=", 2);
        switch (values[0].toString().toLowerCase()) {
            case "xpath":
                ele = driver.findElements(By.xpath(values[1].toString()));
                if (ele != null)
                    return ele;
                else
                    return null;
            case "id":
                ele = driver.findElements(By.id(values[1].toString()));
                if (ele != null)
                    return ele;
                else
                    return null;
            case "css":
                ele = driver.findElements(By.cssSelector(values[1].toString()));
                if (ele != null)
                    return ele;
                else
                    return null;
            case "linkText":
                ele = driver.findElements(By.linkText(values[1].toString()));
                if (ele != null)
                    return ele;
                else
                    return null;
            default:
                return ele = null;
        }

    }

    @Step("Clicked on '{report}' button")
    public static boolean clickonObject(String ValueofElement, String report)  {
        WebElement ele = createObject(ValueofElement);
        boolean flag =false;
        if ((ele != null) && (ele.isEnabled())) {
            ele.click();
            flag=true;
            // ReportCommonMethods.TestStep(report);
        } else {
            System.out.println("Element is not clickable");
            //   ReportCommonMethods.Verification("Fail", "Element is not clickable");
            flag =false;

        }
        return  flag;
    }

    @Step("Entered '{DetailforReports}' text")
    public static void setValueOnEditBox(String ValueofElement, String InputVlaue, String DetailforReports)
    {
        WebElement ele = createObject(ValueofElement);
        if ((ele != null) && (ele.isEnabled())) {
            ele.sendKeys(InputVlaue);
            //   ReportCommonMethods.TestStep(DetailforReports + " " + InputVlaue);

        }
//        else
        //  ReportCommonMethods.Verification("Fail", "Input_not_set");
    }

    public static WebElement RelativeLocator(String ParentLocator, String TagName, String RelativeType) {
        By element;
        WebElement el;
        WebElement e = createObject(ParentLocator);
        if (RelativeType.toLowerCase().equals("above")) {
            element = RelativeLocator.with(By.tagName(TagName)).above(e);
            el = driver.findElement(element);
            return el;
        }
        if (RelativeType.toLowerCase().equals("below")) {
            element = RelativeLocator.with(By.tagName(TagName)).below(e);
            el = driver.findElement(element);
            return el;
        }
        return null;
    }

    public static void ScrollintoView(String ElementProperty) {
        WebElement ele = createObject(ElementProperty);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", ele);
    }

    public static void waitforElement(String ElementProperty) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            String[] values = ElementProperty.split("=", 2);

            switch (values[0].toString().toLowerCase()) {

                case "xpath":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1].toString())));
                    // ReportCommonMethods.TestStep("Element found by xpath which is " + Report );
                    break;

                case "id":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(values[1].toString())));
                    //   ReportCommonMethods.TestStep("Element found by id " + Report);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Element is not visible");
        }
    }

    public static void waitforElementClickable(String ElementProperty) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            String[] values = ElementProperty.split("=", 2);

            switch (values[0].toString().toLowerCase()) {

                case "xpath":
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1].toString())));
                    // ReportCommonMethods.TestStep("Element found by xpath which is " + Report );
                    break;

                case "id":
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(values[1].toString())));
                    //   ReportCommonMethods.TestStep("Element found by id " + Report);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Element is not clickable");
        }
    }


    public static void waitforElementSelectable(String ElementProperty) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String[] values = ElementProperty.split("=", 2);

            switch (values[0].toString().toLowerCase()) {

                case "xpath":
                    wait.until(ExpectedConditions.elementToBeSelected(By.xpath(values[1].toString())));
                    // ReportCommonMethods.TestStep("Element found by xpath which is " + Report );
                    break;

                case "id":
                    wait.until(ExpectedConditions.elementToBeSelected(By.id(values[1].toString())));
                    //   ReportCommonMethods.TestStep("Element found by id " + Report);
                    break;
            }
        } catch (Exception e) {
           System.out.println("Element is not selectable");
        }
    }
    @Step("Select by '{SelectionOfValue}' text")
    public static void selectValuefromDoropDownByText(String ElementProperty, String SelectionOfValue)

             {
        WebElement ele = createObject(ElementProperty);
        Select se = new Select(ele);
        se.selectByVisibleText(SelectionOfValue);


    }

    public static void selectValuefromDoropDownByIndex(String ElementProperty, int Index)

            throws InterruptedException {
        WebElement ele = createObject(ElementProperty);
        Select se = new Select(ele);
        se.selectByIndex(Index);


    }

    public static void setValueFOrCheckbox(String ElementProperty , boolean value)
    {
        WebElement ele = createObject(ElementProperty);
        if(value==true) {
//            if (ele.getAttribute("checked")!=null)
//               // ReportCommonMethods.TestStep("Checkbox already checked");
//            else
            ele.click();
        }
        else
        {

//            if (ele.getAttribute("checked")==null)
//              //  ReportCommonMethods.TestStep("Checkbox already checked");
//            else
            ele.click();


        }
    }
    public static  boolean isElementPresent(String ElementProperty)
    {
        boolean flag = false;
        WebElement ele = createObject(ElementProperty);
        if(ele!=null)
            flag=true;
        return flag;
    }
}
