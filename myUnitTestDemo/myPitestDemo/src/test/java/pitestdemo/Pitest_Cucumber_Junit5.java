package pitestdemo;

import io.cucumber.java.en.When;
import mycode.Calculator;
import static org.junit.jupiter.api.Assertions.*;

public class Pitest_Cucumber_Junit5 {
    @When("PiTestDemoStep")
    public void PiTestDemoStep() {

        assertEquals(Calculator.greaterThan(5, 6), 11);
    }
}
