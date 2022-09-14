package pitestdemo.cucumber_junit4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import mycode.Calculator;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "pretty:target/cucumber/pretty-report.log",
        "html:target/cucumber/report",
        "json:target/cucumber/report.json",
        "junit:target/cucumber/report.xml",
        "pretty"
}, features = { "./src/test/resources/features/PiTest.feature" }, glue = { "pitestdemo.cucumber_junit4" })

public class Pitest_Cucumber_Junit4 {

}