package pitestdemo.cucumber_junit4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.en.When;
import mycode.Calculator;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "pretty:target/Cucumber_Junit4_PiTest_Report/cucumber/pretty-report.log",
        "html:target/Cucumber_Junit4_PiTest_Report/cucumber/report.html",
        "json:target/Cucumber_Junit4_PiTest_Report/cucumber/report.json",
        "junit:target/Cucumber_Junit4_PiTest_Report/cucumber/report.xml",
        "pretty"
}, features = { "../features/PiTest.feature" }, glue = { "pitestdemo.cucumber_junit4" })

public class Pitest_Cucumber_Junit4 {

}