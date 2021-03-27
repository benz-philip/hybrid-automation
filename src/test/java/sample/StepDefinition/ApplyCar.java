package sample.StepDefinition;

import static org.testng.Assert.assertTrue;
import com.framework.controller.AppiumHelper;
import com.mobile.selendroid.pages.ApplyCarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ApplyCar extends AppiumHelper {
    
    ApplyCarPage applyCarPage = new ApplyCarPage(driverInit());
    
    private String defaultCar,selectedCar,enteredName;
    
    @Given("user clicks on google chrome logo")
    public void user_clicks_on_google_chrome_logo() {
        assertTrue(applyCarPage.isPresentGoogleChromeButton(), "Chrome Button is not Displayed");
        applyCarPage.clickChromeButton();
    }

    @Then("user verifies tittle")
    public void user_verifies_tittle() {
        assertTrue(applyCarPage.isPresentWebViewTitleTextButton(), "Web View Title Text is not Displayed");
    }

    @Then("user verifies the text")
    public void user_verifies_the_text() {
        assertTrue(applyCarPage.isPresentNameText(), "Tell me your name is not Displayed");
    }
    
    @Then("user enters the name in the textbox")
    public void user_enters_the_name_in_the_textbox() {
        enteredName = applyCarPage.enterName(StepListener.config.getProperty("TEXT_NAME"));
    }

    @Then("user selects the preferred car as mercedes")
    public void user_selects_the_preferred_car_as_mercedes() {
       defaultCar =  applyCarPage.getSelectedCarName();
       applyCarPage.clickPreferedCar();
       assertTrue(applyCarPage.isDefaultCarSelected(), "Default Car is not selected"); 
       selectedCar = applyCarPage.clickMercedesCar();
    }

    @Then("user clicks on send me your name button")
    public void user_clicks_on_send_me_your_name_button() {
       applyCarPage.clickSendMeUrNameButton();
    }

    @Then("verifies the confirmation text")
    public void verifies_the_confirmation_text() {
        assertTrue(applyCarPage.isPresentHelloTitleTxt(),"Hello Text is not displayed");
    }

    @Then("user verifies the entered name and prefered car selected")
    public void user_verifies_the_entered_name_and_prefered_car_selected() {
       assertTrue(applyCarPage.validateNameAndCarName(enteredName, selectedCar),"Name & Car is displayed incorrectly");
    }

    @Then("user clicks on botton link")
    public void user_clicks_on_botton_link() {
       applyCarPage.clickHereLink();
    }

    @Then("user verifies for the default selected car")
    public void user_verifies_for_the_default_selected_car() {
       assertTrue(applyCarPage.getSelectedCarName().equals(defaultCar));
    }
   
}
