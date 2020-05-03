package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features/activities",
        dryRun = false,
        strict = false,
        tags = "@view_calendar_events",
        plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json"
        }


)



        public class ActivitiesTestRunner {
}
