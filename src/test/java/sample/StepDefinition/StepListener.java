package sample.StepDefinition;

import java.io.File;
import java.util.Properties;
import com.framework.config.Config;
import com.framework.controller.AppiumController;
import com.framework.logger.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class StepListener {

    static Properties config;

    @Before
    public void setUp(Scenario scenario) {
        
        Log.startTestCase(scenario.getName());
        
        config = Config.initializeConfig();
        if (scenario.getSourceTagNames().contains("@WebSmokeTest")) {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + File.separator + "src/main/resources/geckodriver");
        } else {
            AppiumController.instance.appLaunch(config);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (!scenario.getSourceTagNames().contains("@WebSmokeTest")) {
            AppiumController.instance.appClose();
        }
        Log.endTestCase();
    }
}
