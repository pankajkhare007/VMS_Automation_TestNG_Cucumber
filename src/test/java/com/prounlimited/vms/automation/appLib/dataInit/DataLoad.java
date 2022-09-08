package com.prounlimited.vms.automation.appLib.dataInit;

import com.prounlimited.vms.automation.utility.ExcelReader;
import com.prounlimited.vms.automation.utility.JsonReader;
import com.prounlimited.vms.automation.webdriverLib.database.MSSQLManager;

import java.sql.SQLException;
import java.util.HashMap;

public class DataLoad {

    public static void initialization()
    {
        String en= JsonReader.getJSONObjectContent("Environment");
        RunSetting.Browser =JsonReader.getJSONObjectContent("Browser");
        RunSetting.newSession =JsonReader.getJSONObjectContent("NewSession");
        RunSetting.URL =JsonReader.getJsonMatchingObjectContent(en, "Environments", "url");
        RunSetting.dbUrl=JsonReader.getJsonMatchingObjectContent(en, "Environments", "dburl");

        RunSetting.dbUsername=JsonReader.getJsonMatchingObjectContent(en, "Environments", "dbusername");
        RunSetting.dbPassword=JsonReader.getJsonMatchingObjectContent(en, "Environments", "dbpassword");
        RunSetting.driverClassName=JsonReader.getJsonMatchingObjectContent(en, "Environments", "driverclassname");
        RunSetting.connectionString=JsonReader.getJsonMatchingObjectContent(en, "Environments", "connectionString");
        RunSetting.TestDataFile ="TestData.xlsx";
        int rowNum= ExcelReader.getRowNumber(RunSetting.TestDataFile, ExcelSheets.Login.toString(),"sRole="+Global.userType,"Environment="+ en.toLowerCase());
        HashMap<String,String> loginData =ExcelReader.getExcelData(rowNum);
//        List<Map<String, String>> excelData=ExcelManager.getExcelRowsdata(RunSettings.TestDataFile, ExcelSheets.Login.toString(),"Environment="+ en.toLowerCase());
//        if(excelData.size() < 1)
//            Assert.fail();

        // Global.testData =loginData.get("sUserName");

        Global.userName=loginData.get("sUserName");
        Global.password=loginData.get("sPassword");
//        Global.resultSet= MSSQLManager.getResultSetFromMSSQL("select top 10 * from zcproject");
//        try {
//            System.out.println(Global.resultSet.getString("projID"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //Global.clientID=DatabaseManager.getQueryResultByParameters(SELECT_CLIENT_ID_BY_NAME,Global.clientName);

        // Global.userName =  DatabaseManager.getPersonListFromDatabas(SELECT_MSP_WITH_CLIENT_SERVICE_ROLE,USER_TEMPLATE, Global.clientID).get(0).getUserName();
        //  Global.password = DatabaseManager.getPersonListFromDatabas(SELECT_MSP_WITH_CLIENT_SERVICE_ROLE,USER_TEMPLATE, Global.clientID).get(0).getPassword();
    }
}
