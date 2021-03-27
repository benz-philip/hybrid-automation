package com.framework.commonfunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.framework.controller.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CommonFunctions {

    AppiumDriver<MobileElement> driver;
    
    public CommonFunctions() {
        this.driver = AppiumHelper.driverInit();
    }

    /**
     * Method to wait till particular timeout
     * @param ae Mobile Element Object
     * @param driver
     */
    public void waitCondition(MobileElement ae, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOf(ae));
    }

    /**
     * Method to wait till fixed timeout 
     * @param ae Mobile Element Object
     * @param driver
     */
    public void waitCondition(MobileElement ae) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(ae));
    }

    /**
     * Method to clear and Type.
     *
     * @param: Element
     *             for the text field
     * @param: Text
     *             to enter
     */
    public void clearType(MobileElement ae, String text) {
        ae.sendKeys(text);
        hideKeyBoard();
    }
    
    public void hideKeyBoard() {
        if (driver instanceof AndroidDriver<?>) {
            ((AndroidDriver<MobileElement>) driver).isKeyboardShown();
            driver.hideKeyboard();
        }
    }

    /**
     * Method to valdate text.
     *
     * @param: Element
     *             for the text field
     * @param: Text
     *             to verify
     */
    public boolean validateText(String ae, String text) {
        if (ae.equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void waitTillProgressIconIsDisabled(MobileElement mobileElement, int timeInSecondsToWait) {
        for (int counter = 0; counter < timeInSecondsToWait; counter++) {
            try {
                WebDriverWait wait = new WebDriverWait(this.driver, 1);
                wait.until(ExpectedConditions.visibilityOf(mobileElement));
            } catch (Exception e) {
                break;
            }
        }
    }
    
}
