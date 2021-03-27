package sample.StepDefinition;

import static org.testng.Assert.assertTrue;

import com.framework.controller.AppiumHelper;
import com.mobile.selendroid.pages.HomePage;
import com.mobile.selendroid.pages.UserRegistrationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistration extends AppiumHelper {
    
    UserRegistrationPage userRegistrationPage = new UserRegistrationPage(driverInit());
    HomePage homePage = new HomePage(driverInit());
    
    @Then("user clicks on show progress for a while")
    public void user_clicks_on_show_progress_for_a_while() {
        userRegistrationPage.clickProgressBarButton();
    }

    @Then("user waits for the progress bar to get disappeared")
    public void user_waits_for_the_progress_bar_to_get_disappeared() {
        userRegistrationPage.waitTillProgressBar();
    }

    @Then("user verifies all the elements on the screen")
    public void user_verifies_all_the_elements_on_the_screen() {
       assertTrue(userRegistrationPage.isPresentRegisterUserTitle(), "Register User Title is not displayed");
       assertTrue(userRegistrationPage.isPresentUserName(), "Username is not displayed");
       assertTrue(userRegistrationPage.isPresentEmail(), "EMail is not displayed");
       assertTrue(userRegistrationPage.isPresentPassword(), "Password is not displayed");
       assertTrue(userRegistrationPage.isPresentName(), "Name is not displayed");
       assertTrue(userRegistrationPage.isPresentProgrammingLanguage(), "Programming Language is not displayed");
       assertTrue(userRegistrationPage.isPresentTnC(), "T & C is not displayed");
       assertTrue(userRegistrationPage.isPresentVerifyUser(), "Verify User Button is not displayed");
    }
    
    @Then("user clicks on file logo button")
    public void user_clicks_on_file_logo_button() {
      userRegistrationPage.clickFileLogoOption();
    }
    
    @And("user enters {string} and {string} and {string} and {string}")
    public void user_enters_username_email_password(String userName,String email,String password,String name) {
        userRegistrationPage.enterUsername(userName);
        userRegistrationPage.enterEmailId(email);
        userRegistrationPage.enterPassword(password);
        String pl = userRegistrationPage.getProgrammingLanguage();
        userRegistrationPage.clickIAgreeButton();
        userRegistrationPage.clickVerifyUserButton();
        userRegistrationPage.getFieldTextVerify(name,userName,email,password,pl);
    }
    
    @Then("user clicks on register user button")
    public void user_clicks_on_register_user_button() {
      userRegistrationPage.clickRegisterUserButton();
    }
    
    @When("user clicks on display toast button")
    public void user_clicks_on_display_toast_button() {
        homePage.clickToastButton();
    }

    @Then("user verifies for toast message on the screen")
    public void user_verifies_for_toast_message_on_the_screen() {
        assertTrue(homePage.isPresentToastMessage(StepListener.config.getProperty("TOAST_MSG")),"Toast Message is not Displayed");
    }
    
    @When("user clicks on display popup window")
    public void user_clicks_on_display_popup_window() {
        homePage.clickPopUpButton();
    }

    @Then("user dismisses popup window")
    public void user_dismisses_popup_window() throws InterruptedException {
        homePage.dismiss();
    }
    
    

}
