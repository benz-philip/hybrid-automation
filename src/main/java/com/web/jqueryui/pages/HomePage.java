package com.web.jqueryui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.framework.commonfunctions.CommonFunctions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

    CommonFunctions commonFunctions;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.commonFunctions = new CommonFunctions();
    }

    @FindBy(xpath = "//*[@id='sidebar']/aside[1]/ul/li[4]/a")
    private WebElement selectableMenu;
    @FindBy(xpath = "//*[@id='selectable']/li[1]")
    private WebElement selectItem1;
    @FindBy(xpath = "//*[@id='selectable']/li[3]")
    private WebElement selectItem3;
    @FindBy(xpath = "//*[@id='selectable']/li[7]")
    private WebElement selectItem7;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/aside[2]/ul/li[5]/a")
    private WebElement controlGroupMenu;
    @FindBy(xpath = "//*[@id='car-type-button']")
    private WebElement carTypeBtn;
    @FindBy(xpath = "//*[@id='ui-id-4']")
    private WebElement selectCarType;
    @FindBy(xpath = "/html/body/div[1]/fieldset[1]/div/label[2]/span[1]")
    private WebElement selectAutomatic;
    @FindBy(xpath = "/html/body/div[1]/fieldset[1]/div/label[3]/span[1]")
    private WebElement selectInsurance;
    @FindBy(xpath = "//*[@id='ui-id-8-button']")
    private WebElement selectOtherCarOption;
    @FindBy(xpath = "//*[@id='ui-id-14']")
    private WebElement selectCarTypeTruck;
    @FindBy(xpath = "/html/body/div[1]/fieldset[2]/div/label[1]")
    private WebElement standardBtn;
    @FindBy(xpath = "/html/body/div[1]/fieldset[2]/div/label[3]")
    private WebElement insuranceBtn;
    @FindBy(xpath = "/html/body/div[1]/fieldset[1]/div/span[2]/input")
    private WebElement suvCarCountTextBox;
    @FindBy(xpath = "/html/body/div[1]/fieldset[2]/div/span[2]/input")
    private WebElement truckCarCountTxtBox;
    @FindBy(xpath = "/html/body/div[1]/fieldset[2]/div/button")
    private WebElement bookNowBtn;
    @FindBy(xpath = "//*[@id='sidebar']/aside[1]/ul/li[2]/a")
    private WebElement dropableMenu;
    @FindBy(xpath = "/html/body/div[1]")
    private WebElement dragSelect;
    @FindBy(xpath = "/html/body/div[2]")
    private WebElement dropSelect;

    public void clickSelectMenu() {
        selectableMenu.click();
    }

    public void clickSelectItems(WebDriver driver) {
        driver.switchTo().frame(0);
        selectItem1.click();
        selectItem3.click();
        selectItem7.click();
    }

    public void clickControlMenu() {
        controlGroupMenu.click();
    }

    public void selectCarDetails(WebDriver driver,String suvCarCount,String truckCarCount) {
        driver.switchTo().frame(0);
        carTypeBtn.isDisplayed();
        carTypeBtn.click();
        selectCarType.click();
        selectAutomatic.click();
        selectInsurance.click();
        suvCarCountTextBox.sendKeys(suvCarCount);
        selectOtherCarOption.click();
        selectCarTypeTruck.click();
        standardBtn.click();
        insuranceBtn.click();
        truckCarCountTxtBox.sendKeys(truckCarCount);
    }
    
    public void clickBookBtn() {
        bookNowBtn.click();
    }
    
    
    public void clickDroppableMenu() {
        dropableMenu.click();
    }

    public void dragNDrop(WebDriver driver) {
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragSelect,dropSelect).build().perform();
    }
    
    

}
