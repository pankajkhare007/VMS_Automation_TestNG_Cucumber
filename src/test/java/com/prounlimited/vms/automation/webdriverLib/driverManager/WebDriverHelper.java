package com.prounlimited.vms.automation.webdriverLib.driverManager;

import com.prounlimited.vms.automation.appLib.dataInit.RunSetting;
import com.prounlimited.vms.automation.utility.SetGetSessionURL;
import com.prounlimited.vms.automation.utility.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.codec.w3c.W3CHttpCommandCodec;
import org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class WebDriverHelper {

    public static WebDriver driver;
    static  HttpCommandExecutor executor;
    static URL sUrl;
    static SessionId session_id;

    static RemoteWebDriver driver2;
    public static String existingUrl;
    public static void launchBrowser(String browser, String url)  {
        switch(browser)
        {
            case "CH" :
                if(RunSetting.newSession.equals("true"))
                {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    executor = (HttpCommandExecutor) ((RemoteWebDriver) driver).getCommandExecutor();
                    sUrl = executor.getAddressOfRemoteServer();
                    session_id = ((RemoteWebDriver) driver).getSessionId();
                    SetGetSessionURL.setURLText(sUrl+"");
                    SetGetSessionURL.setSessionIDText(session_id+"");
                }
               else if(RunSetting.newSession.equals("false"))
                {
                    existingUrl=SetGetSessionURL.getURLText();
                    String existingSessionID=SetGetSessionURL.getSessionText();
                    RemoteWebDriver driver2 = null;
                    try {
                        driver2 = createDriverFromSession(new SessionId(existingSessionID), new URL(existingUrl));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    /// driver2 = createDriverFromSession(new SessionId(System.getenv("session_id")), new URL(System.getenv("url")));
                    //driver2 = createDriverFromSession(session_id, url);
                    driver = (WebDriver)driver2;
                }
                break;

            case "FF":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

                break;


        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor){
        CommandExecutor executor = new HttpCommandExecutor(command_executor) {


            public Response execute(Command command) throws IOException {
                Response response = null;
                if (command.getName() == "newSession") {
                    response = new Response();
                    response.setSessionId(sessionId.toString());
                    response.setStatus(0);
                    response.setValue(Collections.<String, String>emptyMap());

                    try {
                        Field commandCodec = null;
                        commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
                        commandCodec.setAccessible(true);
                        commandCodec.set(this, new W3CHttpCommandCodec());

                        Field responseCodec = null;
                        responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
                        responseCodec.setAccessible(true);
                        responseCodec.set(this, new W3CHttpResponseCodec());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                } else {
                    response = super.execute(command);
                }
                return response;
            }
        };

        return new RemoteWebDriver(executor, new DesiredCapabilities());
    }

}
