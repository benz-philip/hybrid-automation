package sample.StepDefinition;

import static org.testng.Assert.assertTrue;
import com.framework.controller.AppiumHelper;
import com.mobile.selendroid.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Registration extends AppiumHelper {
     
    HomePage homePage = new HomePage(driverInit());
   
    @Given("Mobile app is launch and verifies the title screen")
    public void mobile_app_is_launch_and_verifies_the_title_screen() {
        assertTrue(homePage.verifyTitle(),"Tittle is not displayed");
    }

    @Then("User verifies the home screen")
    public void user_verifies_the_home_screen() {
        assertTrue(homePage.isPresentEnButton(),"En Button is not displayed");
        assertTrue(homePage.isPresentShowProgressButton(),"Progress Button is not displayed");
        assertTrue(homePage.isPresentExceptionTextBox(),"Exception Text Box is not displayed");
    }
    
    @And("user clicks on EN button")
    public void user_clicks_on_EN_button() {
        homePage.clickEnButton();
    }
    
    @Then("user selects option No")
    public void user_selects_option_No() {
        assertTrue(homePage.isPresentNoOption(),"No Option Button is not displayed");
        homePage.clickNoOption();
    }
}
