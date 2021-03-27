package com.mobile.selendroid.pages;

import org.openqa.selenium.support.PageFactory;

import com.framework.commonfunctions.CommonFunctions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApplyCarPage {

    CommonFunctions commonFunctions;

    public ApplyCarPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.commonFunctions = new CommonFunctions();
    }

    @AndroidFindBy(id = "buttonStartWebview")
    private MobileElement googleChromeButton;
    @AndroidFindBy(xpath = "//*[@text='Web View Interaction']")
    private MobileElement webViewTitleText;
    @AndroidFindBy(xpath = "//*[@text='Hello, can you please tell me your name?']")
    private MobileElement nameText;
    @AndroidFindBy(xpath = "//*[@resource-id='name_input']")
    private MobileElement enterNameTextBox;
    @AndroidFindBy(xpath = "(//*[@text='Prefered Car:']/following-sibling::android.view.View)[2]")
    private MobileElement preferedCar;
    @AndroidFindBy(xpath = "//*[@text='Volvo' and @checked='true']")
    private MobileElement volvoCarSelection;
    @AndroidFindBy(xpath = "//*[@text='Mercedes']")
    private MobileElement mercedesCarSelection;
    @AndroidFindBy(xpath = "//*[@text='Send me your name!']")
    private MobileElement sendMeUrNameButton;
    @AndroidFindBy(xpath = "//*[@text='This is my way of saying hello']")
    private MobileElement helloTitleText;
    @AndroidFindBy(xpath = "(//*[@text='Your name is:']/following-sibling::android.widget.TextView)[1]")
    private MobileElement enteredName;
    @AndroidFindBy(xpath = "(//*[@text='Your prefered car is:']/following-sibling::android.widget.TextView)[1]")
    private MobileElement selectedCar;
    @AndroidFindBy(xpath = "//*[@text='here']")
    private MobileElement hereLink;

    public boolean isPresentGoogleChromeButton() {
        commonFunctions.waitCondition(googleChromeButton, 20);
        return googleChromeButton.isDisplayed();
    }

    public boolean isPresentWebViewTitleTextButton() {
        commonFunctions.waitCondition(webViewTitleText, 10);
        return webViewTitleText.isDisplayed();
    }

    public void clickChromeButton() {
        googleChromeButton.click();
    }

    public boolean isPresentNameText() {
        return nameText.isDisplayed();
    }

    public String enterName(String name) {
        enterNameTextBox.clear();
        enterNameTextBox.sendKeys(name);
        return name;
    }

    public String getSelectedCarName() {
        System.out.println(preferedCar.getText());
        return preferedCar.getText();
    }

    public void clickPreferedCar() {
        preferedCar.click();
    }

    public boolean isDefaultCarSelected() {
        commonFunctions.waitCondition(volvoCarSelection, 10);
        return volvoCarSelection.isDisplayed();
    }

    public String clickMercedesCar() {
        mercedesCarSelection.click();
        return mercedesCarSelection.getText();
    }

    public void clickSendMeUrNameButton() {
        sendMeUrNameButton.click();
    }
    
    public boolean isPresentHelloTitleTxt() {
        commonFunctions.waitCondition(helloTitleText, 20);
        return helloTitleText.isDisplayed();
    }
    
    public boolean validateNameAndCarName(String name,String carName) {
        System.out.println(enteredName.getText().replaceAll("\"", "")+ name);
        System.out.println(selectedCar.getText().replaceAll("\"", "")+ carName);
        return commonFunctions.validateText(enteredName.getText().replaceAll("\"", ""), name) && commonFunctions.validateText(selectedCar.getText().replaceAll("\"", ""),carName);
    }
    
    public void clickHereLink() {
        hereLink.click();
    }

}
