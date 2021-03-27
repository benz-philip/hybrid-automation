package com.mobile.selendroid.pages;

import org.openqa.selenium.support.PageFactory;
import com.framework.commonfunctions.CommonFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UserRegistrationPage {

    CommonFunctions commonFunctions;

    public UserRegistrationPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.commonFunctions = new CommonFunctions();
    }

    @AndroidFindBy(xpath = "//*[@text='Waiting Dialog']")
    private MobileElement waitDialogTxt;
    @AndroidFindBy(id = "startUserRegistration")
    private MobileElement fileLogoButton;
    @AndroidFindBy(xpath = "//*[@text='Show Progress Bar for a while']")
    private MobileElement showProgressBarButton;
    @AndroidFindBy(xpath = "//*[@text='Welcome to register a new User']")
    private MobileElement registerNewUserTitle;
    @AndroidFindBy(xpath = "//*[@text='Username']")
    private MobileElement userNameLabel;
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText'][1]")
    private MobileElement userNameTextBox;
    @AndroidFindBy(xpath = "//*[@text='E-Mail']")
    private MobileElement emailLabel;
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText'][2]")
    private MobileElement emailTextBox;
    @AndroidFindBy(xpath = "//*[@text='Password']")
    private MobileElement passwordLabel;;
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText'][3]")
    private MobileElement passwordTextBox;;
    @AndroidFindBy(xpath = "//*[@text='Name']")
    private MobileElement nameLabel;
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText'][4]")
    private MobileElement nameTextBox;
    @AndroidFindBy(xpath = "//*[@text='Programming Languge']")
    private MobileElement plLabel;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Spinner']")
    private MobileElement plSpinner;
    @AndroidFindBy(xpath = "//*[@text='TandC']")
    private MobileElement tncLabel;
    @AndroidFindBy(xpath = "//*[@text='I accept adds']")
    private MobileElement iacceptCheckbox;
    @AndroidFindBy(xpath = "//*[@text='Register User (verify)']")
    private MobileElement userVerifyButton;
    @AndroidFindBy(id = "label_name_data")
    private MobileElement nameFieldText;
    @AndroidFindBy(id = "label_username_data")
    private MobileElement userNameFieldText;
    @AndroidFindBy(id = "label_password_data")
    private MobileElement passwordFieldText;
    @AndroidFindBy(id = "label_email_data")
    private MobileElement emailFieldText;
    @AndroidFindBy(id = "label_preferedProgrammingLanguage_data")
    private MobileElement plFieldText;
    @AndroidFindBy(xpath = "//*[@text='Register User']")
    private MobileElement registerUserButton;
    

    public void waitTillProgressBar() {
        commonFunctions.waitTillProgressIconIsDisabled(waitDialogTxt, 15);
    }

    public boolean isPresentRegisterUserTitle() {
        commonFunctions.waitCondition(registerNewUserTitle, 30);
        commonFunctions.hideKeyBoard();
        return registerNewUserTitle.isDisplayed();
    }

    public boolean isPresentUserName() {
        return userNameLabel.isDisplayed() && userNameTextBox.isDisplayed();
    }

    public boolean isPresentEmail() {
        return emailLabel.isDisplayed() && emailTextBox.isDisplayed();
    }

    public boolean isPresentPassword() {
        return passwordLabel.isDisplayed() && passwordTextBox.isDisplayed();
    }

    public boolean isPresentName() {
        return nameLabel.isDisplayed() && nameTextBox.isDisplayed();
    }

    public boolean isPresentProgrammingLanguage() {
        return plLabel.isDisplayed() && plSpinner.isDisplayed();
    }

    public boolean isPresentTnC() {
        return tncLabel.isDisplayed() && iacceptCheckbox.isDisplayed();
    }

    public boolean isPresentVerifyUser() {
        return userVerifyButton.isDisplayed();
    }

    public void clickProgressBarButton() {
        showProgressBarButton.click();
    }

    public void enterUsername(String userName) {
        userNameTextBox.sendKeys(userName);
    }

    public void enterEmailId(String emailId) {
        emailTextBox.sendKeys(emailId);
    }

    public String getProgrammingLanguage() {
        return plSpinner.getText();
    }
    
    public void clickFileLogoOption() {
        fileLogoButton.click();
    }
    
    public void clickVerifyUserButton() {
        userVerifyButton.click();
    }
    
    public void clickIAgreeButton() {
        iacceptCheckbox.click();
    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }
    
    public void clickRegisterUserButton() {
        registerUserButton.click();
    }
    
    public boolean getFieldTextVerify(String name,String userName,String emailId,String password,String pl) {
        return commonFunctions.validateText(nameFieldText.getText(), name) &&
               commonFunctions.validateText(userNameFieldText.getText(), userName) &&
               commonFunctions.validateText(emailFieldText.getText(), emailId) &&
               commonFunctions.validateText(passwordFieldText.getText(), password) &&
               commonFunctions.validateText(plFieldText.getText(), pl);
    }

}
