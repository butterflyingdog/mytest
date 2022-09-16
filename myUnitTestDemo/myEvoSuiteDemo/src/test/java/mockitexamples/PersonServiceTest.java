package mockitexamples;

import org.junit.jupiter.api.Test;

class PersonServiceTest {
    /**
     * Method under test: default or parameterless constructor of {@link PersonService}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PersonService.mPersonDao

        new PersonService(null);
    }
}

