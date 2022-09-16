package mockitexamples;

import org.junit.jupiter.api.Test;

class PersonFacadeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PersonFacade#PersonFacade(PersonService)}
     *   <li>{@link PersonFacade#setPersonService(PersonService)}
     * </ul>
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PersonFacade.mPersonService

        PersonFacade actualPersonFacade = new PersonFacade(new PersonService(null));
        actualPersonFacade.setPersonService(new PersonService(null));
    }
}

