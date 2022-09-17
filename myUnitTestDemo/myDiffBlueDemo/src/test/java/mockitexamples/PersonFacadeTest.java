package mockitexamples;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
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
        // Arrange
        // TODO: Populate arranged inputs
        PersonService personService = null;

        // Act
        PersonFacade actualPersonFacade = new PersonFacade(personService);
        PersonService personService1 = null;
        actualPersonFacade.setPersonService(personService1);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PersonFacade#PersonFacade(PersonService)}
     *   <li>{@link PersonFacade#setPersonService(PersonService)}
     * </ul>
     */
    @Test
    void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PersonFacade.mPersonService
        //     PersonService.mPersonDao

        PersonFacade actualPersonFacade = new PersonFacade(new PersonService(null));
        actualPersonFacade.setPersonService(new PersonService(null));
    }

    /**
     * Method under test: {@link PersonFacade#getPerson(int)}
     */
    //@Test
    void testGetPerson() {
        // Arrange
        // TODO: Populate arranged inputs
        PersonFacade personFacade = null;
        int id = 0;

        // Act
        Person actualPerson = personFacade.getPerson(id);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link PersonFacade#getPerson(int)}
     */
    @Test
    void testGetPerson2() {
        PersonDao personDao = mock(PersonDao.class);
        Person person = new Person(1, "Name");

        when(personDao.getPerson(anyInt())).thenReturn(person);
        assertSame(person, (new PersonFacade(new PersonService(personDao))).getPerson(1));
        verify(personDao).getPerson(anyInt());
    }

    /**
     * Method under test: {@link PersonFacade#getPerson(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPerson3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "mockitexamples.PersonService.getPerson(int)" because "this.mPersonService" is null
        //       at mockitexamples.PersonFacade.getPerson(PersonFacade.java:17)
        //   In order to prevent getPerson(int)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPerson(int).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PersonFacade(null)).getPerson(1);
    }
}

