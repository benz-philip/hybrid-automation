package sample.StepDefinition;

import static org.testng.Assert.assertTrue;
import com.framework.controller.AppiumHelper;
import com.mobile.selendroid.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExceptionHandled extends AppiumHelper {
    
    HomePage homePage = new HomePage(driverInit());
        
    @When("user clicks on throw unhandled exception")
    public void user_clicks_on_throw_unhandled_exception() {
        homePage.clickUnhandledExceptionButton();
    }

    @Then("user verifies for app crash screen")
    public void user_verifies_for_app_crash_screen() {
        assertTrue(homePage.isPresentAppCrashTitle(), "App Crash Message is not Displayed");
    }
    
    @When("user enters {string} in type to throw unhandled exception")
    public void user_enters_in_type_to_throw_unhandled_exception(String text) {
        homePage.enterExceptionText(text);
    }
}
