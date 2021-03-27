package sample.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.web.jqueryui.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WebSteps {
    
    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);

    @Given("user launches the website")
    public void user_launches_the_website() {
        driver.get(StepListener.config.getProperty("WEB_URL"));
        driver.manage().window().maximize();
    }

    @Given("user navigates to dropable from left menu")
    public void user_navigates_to_dropable_from_left_menu() {
        homePage.clickDroppableMenu();
    }

    @Then("user should be able to successfully drags and drop to the destination")
    public void user_should_be_able_to_successfully_drags_and_drop_to_the_destination() {
        homePage.dragNDrop(driver);
    }

    @Given("user navigates to Selectable from left menu")
    public void user_navigates_to_Selectable_from_left_menu() {
        homePage.clickSelectMenu();
    }

    @Then("user selects the items from given menu")
    public void user_selects_the_items_from_given_menu() {
        homePage.clickSelectItems(driver);
    }

    @Given("user navigates to Controlgroup from left menu")
    public void user_navigates_to_Controlgroup_from_left_menu() {
        homePage.clickControlMenu();
    }

    @Then("user select the car details as {string} and {string}")
    public void user_select_the_car_details(String suvCount,String truckCount) {
        homePage.selectCarDetails(driver,suvCount,truckCount);
    }

    @Then("user books the car")
    public void user_books_the_car() {
        homePage.clickBookBtn();
    }
    
    @Then("user closes the browser")
    public void user_closes_the_browser() {
        driver.close();
    }
  
}
