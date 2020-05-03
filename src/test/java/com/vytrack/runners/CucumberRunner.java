package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features",
        dryRun = true,
        strict = false,
        tags = "@scenario_outline",
        plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json"
        }


)



public class CucumberRunner {
}
