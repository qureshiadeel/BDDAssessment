package org.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
@CucumberOptions(
//
        features = {"src/test/java/org/featurefiles/F1_login.feature","src/test/java/org/featurefiles/F2_checkout.feature"},
        glue = "org.stepdefination",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:test1-output",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}
)


@Test(priority = 1)
public class TestRunner extends AbstractTestNGCucumberTests {

}

