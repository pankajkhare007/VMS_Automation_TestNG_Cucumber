package com.prounlimited.vms.automation.utility;

import java.text.DecimalFormat;

public class Utils {

    //double converted to String and also removed ".0"
    public static String doubleToString(String number)
    {
        double d=Double.parseDouble(number);
        DecimalFormat df = new DecimalFormat("#");
        String sData=df.format(d);
        return sData;
    }
}
