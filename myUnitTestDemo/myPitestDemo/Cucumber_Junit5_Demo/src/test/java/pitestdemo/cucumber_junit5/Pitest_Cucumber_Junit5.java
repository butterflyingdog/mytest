package pitestdemo.cucumber_junit5;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("../features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class Pitest_Cucumber_Junit5 {

}
