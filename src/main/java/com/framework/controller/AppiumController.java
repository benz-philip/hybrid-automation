package com.framework.controller;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.framework.logger.Log;

public class AppiumController {

    public static final AppiumController instance = new AppiumController();
    AppiumDriver<MobileElement> driver;
    private static AppiumDriverLocalService server;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public void appLaunch(Properties config){
        try {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getProperty("PLATFORM_VERSION"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("DEVICE_NAME"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getProperty("AUTOMATION_NAME"));
            capabilities.setCapability(MobileCapabilityType.UDID, config.getProperty("DEVICE_ID"));
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, config.getProperty("APP_PACKAGE"));
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, config.getProperty("APP_ACTIVITY"));
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, config.getProperty("SESSION_TIMEOUT"));
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:"+config.getProperty("APPIUM_PORT")+"/wd/hub"), capabilities);
        } catch (Exception e) {
            Log.warn("App not launched due to : "+e.getMessage());
        }
    }

    public void appClose() {
        try {
            if (driver != null) {
                driver.closeApp();
                driver.quit();
            }
        } catch (Exception e) {
            driver = null;
        } finally {
            driver = null;
        }
    }

    public void startAppiumServer(Properties config) {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingPort(Integer.parseInt(config.getProperty("APPIUM_PORT")));
        serviceBuilder.usingDriverExecutable(new File(config.getProperty("NODE_PATH")));
        serviceBuilder.withAppiumJS(new File(config.getProperty("APPIUM_JS_PATH")));
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
    }

    public static void stopAppiumServer() {
        server.stop();
    }

}
