package pitestdemo.cucumber_junit4;

import io.cucumber.java.en.When;
import mycode.Calculator;
import static org.junit.Assert.*;

public class Pitest_CucumberStep_Junit4 {
    @When("PiTestDemoStep")
    public void PiTestDemoStep() {

        assertEquals(Calculator.greaterThan(5, 6), 11);
    }
}