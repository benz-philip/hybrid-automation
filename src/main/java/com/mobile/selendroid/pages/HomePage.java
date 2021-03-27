package com.mobile.selendroid.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.framework.commonfunctions.CommonFunctions;
import com.framework.controller.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

    CommonFunctions commonFunctions;
    
    public HomePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.commonFunctions = new CommonFunctions();
    }

    @AndroidFindBy(xpath = "//*[@text='Hello Default Locale, Selendroid-test-app!']")
    private MobileElement titleTxt;
    @AndroidFindBy(xpath = "//*[@text='EN Button']")
    private MobileElement enButton;
    @AndroidFindBy(xpath = "//*[@text='Show Progress Bar for a while']")
    private MobileElement showProgressButton;
    @AndroidFindBy(xpath = "//*[@text='Type to throw unhandled exception']")
    private MobileElement exceptionTxtBox;
    @AndroidFindBy(xpath = "//*[@text='No, no']")
    private MobileElement noOptionButton;
    @AndroidFindBy(xpath = "//*[@text='Display Popup Window']")
    private MobileElement displayPopUpWindow;
    @AndroidFindBy(xpath = "//*[@text='Displays a Toast']")
    private MobileElement displayToastButton;
    @AndroidFindBy(xpath = "//*[@text='Press to throw unhandled exception']")
    private MobileElement pressUnhandledException;
    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    private MobileElement toastMessage;
    @AndroidFindBy(xpath = "//*[@text='selendroid-test-app has stopped']")
    private MobileElement stopAppTitle;
    @AndroidFindBy(xpath = "//*[@text='selendroid-test-app keeps stopping']")
    private MobileElement stoppingAppTitle;
    @AndroidFindBy(xpath = "//*[@text='Close app']")
    private MobileElement closeAppButton;
  

    public boolean verifyTitle() {
        commonFunctions.waitCondition(titleTxt, 30);
        return titleTxt.isDisplayed();
    }
    
    public boolean isPresentEnButton() {
        return enButton.isDisplayed();
    }
    
    public boolean isPresentShowProgressButton() {
        return showProgressButton.isDisplayed();
    }
    
    public void clickToastButton() {
        displayToastButton.click();
    }
    
    public void clickPopUpButton() {
        displayPopUpWindow.click();
    }
    
    public void clickUnhandledExceptionButton() {
        pressUnhandledException.click();
    }
    
    public boolean isPresentExceptionTextBox() {
        return exceptionTxtBox.isDisplayed();
    }
    
    public void clickEnButton() {
        enButton.click();
    }
    
    public boolean isPresentNoOption() {
        commonFunctions.waitCondition(noOptionButton, 10);
        return noOptionButton.isDisplayed();
    }
    
    public void enterExceptionText(String text) {
        try {
        exceptionTxtBox.sendKeys(text);
        }
        catch (Exception e) {
            isPresentAppKeepsCrashingTitle();
        }
    }
    
    public void clickNoOption() {
        noOptionButton.click();
    }
    
    public boolean isPresentAppCrashTitle() {
        return stopAppTitle.isDisplayed() && closeAppButton.isDisplayed();
    }
    
    public boolean isPresentAppKeepsCrashingTitle() {
        return stoppingAppTitle.isDisplayed() && closeAppButton.isDisplayed();
    }
    
    public void dismiss() throws InterruptedException {
        AppiumHelper.driverInit().findElement(By.name("Close")).click();
    }
    
    public boolean isPresentToastMessage(String toastMesssage) {
        return commonFunctions.validateText(toastMessage.getAttribute("name"), toastMesssage);
    }
}
