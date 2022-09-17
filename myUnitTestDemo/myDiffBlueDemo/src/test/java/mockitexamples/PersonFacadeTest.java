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
     * Method under test: {@link PersonFacade#getPerson(int)}
     */
    @Test
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
}

