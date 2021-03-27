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
        tags = "@MobileSmokeTest"
)
public class Orchestrator extends AbstractTestNGCucumberTests {

}