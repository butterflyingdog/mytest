package pitestdemo.cucumber_junit5;

import io.cucumber.java8.En;
import io.cucumber.java.en.When;
import mycode.Calculator;
import static org.junit.jupiter.api.Assertions.*;

public class Pitest_CucumberStep_Junit5 implements En{

    @When("test_A_LessThan_B_And_B_isNot_0_should_plus")
    public void test_A_LessThan_B_And_B_isNot_0_should_plus() {

        assertEquals(Calculator.greaterThan(5, 6), 11);
    }

    @When("test_A_GreatThan_B_And_B_isNot_0_should_divide")
    public void test_A_GreatThan_B_And_B_isNot_0_should_divide() {

        assertEquals(Calculator.greaterThan(9, 6), 1);
    }

    @When("test_A_GreatThan_B_And_B_is_0_should_A")
    public void test_A_GreatThan_B_And_B_is_0_should_A() {

        assertEquals(Calculator.greaterThan(9, 0), 9);
    }
}