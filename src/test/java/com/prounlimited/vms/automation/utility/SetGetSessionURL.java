package com.prounlimited.vms.automation.utility;

import java.io.*;

public class SetGetSessionURL {
    static String urlFilePath=System.getProperty("user.dir")+"/src/main/resources/Data/URLText.txt";
    static String sessionFilePath=System.getProperty("user.dir")+"//src/main/resources/Data/SessionID.txt";
    public static String getSessionText() {
        String txtFile=null;
        try {
            FileReader reader = new FileReader(sessionFilePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;


            while ((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                txtFile=line;

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(txtFile);
        return txtFile;
    }

    public static String getURLText() {
        String txtFile=null;
        try {
            FileReader reader = new FileReader(urlFilePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;


            while ((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                txtFile=line;

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(txtFile);
        return txtFile;
    }

    public static void setSessionIDText(String str) {
        try {
            clearTheSessionID();
            FileWriter writer = new FileWriter(sessionFilePath, true);
            writer.write(str);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void setURLText(String str) {
        try {
            clearTheURLText();
            FileWriter writer = new FileWriter(urlFilePath, true);
            writer.write(str);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void clearTheSessionID() throws IOException {
        FileWriter fwOb = new FileWriter(sessionFilePath, false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
    public static void clearTheURLText() throws IOException {
        FileWriter fwOb = new FileWriter(urlFilePath, false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

}