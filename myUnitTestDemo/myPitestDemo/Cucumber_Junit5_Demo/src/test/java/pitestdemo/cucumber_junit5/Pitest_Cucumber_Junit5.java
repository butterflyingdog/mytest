package pitestdemo.cucumber_junit5;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("./")
@ConfigurationParameters({
                @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty:target/cucumber/pretty-report.log, html:target/cucumber/report.html,json:target/cucumber/report.json, junit:target/cucumber/report.xml, pretty")
})

public class Pitest_Cucumber_Junit5 {

}
