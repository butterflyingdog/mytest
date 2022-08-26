package pitestdemo.cucumber_junit4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.en.When;
import mycode.Calculator;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
                "pretty:target/cucumber/pretty-report.log",
                "html:target/cucumber/report.html",
                "json:target/cucumber/report.json",
                "junit:target/cucumber/report.xml",
                "pretty"
}, features = { "src/test/resources/PiTest.feature" }, glue = { "pitestdemo.cucumber_junit4" })

public class Pitest_Cucumber_Junit4 {

}