# Project Title

This Project is based on Cucumber TestNG Maven using Allure Report.

# Getting Started

Download the project & import the project in your IDE

mvn clean test will build the project


# Prerequisites for running tests using Cucumber TestNG Maven:

Environment Setup 

# Java Installation
   
   i.   For Windows :
   
   You can download Java for Windows from [here](http://www.java.com/en/download/manual.jsp)
   
   Run the installer and follow the setup wizard to install Java.
   
   create a new JAVA_HOME environment variable and set variable value as path value to JDK folder.
   
   #### This is Windows environment variable location :
   ```
   Control Panel > All Control Panel Items > System > Advanced system settings > Environment Variables
   ```
   
   ![altext](https://github.com/keshavissar001/images/blob/master/Img1.png)
   
   ii. For Linux :
   
   use this command :
   ```
   sudo apt-get install openjdk-8-jre
   ```
   iii. For Mac
   
   Java should already be present on Mac OS X by default
   
   ### 2. Maven Installation
   
   Install Maven from [here](https://maven.apache.org/install.html)
   
# Setup

   You can download the file. To do this click on “Clone or download” button. You can download zip file.
   
   Right click on this zip file and extract files in your desired location.

   Go to “cucumber-testng-sample-master” folder and copy its path.
   Open command prompt and run :
   
    cd <path> (that you have copied)
    
    (please ignore "<" , ">" symbols)
    

![altext](https://github.com/keshavissar001/images/blob/master/SetPathCucumber.png)


	To clone the file, click on “Clone or download” button and copy the link.

	Then open the command prompt in the folder you want to clone the file. Run the command:

      git clone <paste link here>
      
  You may also want to run the command below to check for outdated dependencies. Please be sure to verify and review updates before editing your pom.xml file as they may not be compatible with your code.
   
    ```
    $ mvn versions:display-dependency-updates
    ```
    
  ![altext](https://github.com/keshavissar001/images/blob/master/mvnUpdate.png)
  
  
# Running Tests

Let’ start with a simple Selenium Remote Webdriver test first. The project-assignment script below tests a simple website application with basic functionalities like selecting car options,drag n drop items etc.

Feature: Test to add item Scenario: Test sample-todo-app Given

I go to sample-todo-app to add item 

Then I Click on first checkbox and second checkbox

Then I enter item to add When I click add button 

Then I should verify the added item

Here is the sample feature file for Cucumber :

.....

	Feature: Regression test of jqueryui web application
	Background: Browser is launched
	Given user launches the website

	Scenario: Verify user should be able Drag and Drop
	And user navigates to dropable from left menu
	Then user should be able to successfully drags and drop to the destination
	Then user closes the browser
	
.....	

Here is the TestRunner file to automate our feature file using TestNG :

......

	package sample.Runner;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	import org.testng.annotations.Test;

	@Test
	@CucumberOptions(
        features = "src/test/java/sample/Feature",
        plugin = {
            "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
            "progress",
            "summary"},
        dryRun = false,
        glue = {"sample/StepDefinition"},
        tags = "@WebSmokeTest"
	)
	public class Orchestrator extends AbstractTestNGCucumberTests {

	}

.......

Below are the step definitions :

.........

	package sample.StepDefinition;

	import static org.testng.Assert.assertTrue;
	import com.framework.controller.AppiumHelper;
	import com.mobile.selendroid.pages.ApplyCarPage;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;

	public class ApplyCar extends AppiumHelper {

.....
    
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
	
......

 To Run Your Test, use following command :
    
    ```
    $ mvn test or you can can run using testng-suite.xml
    ```

	
