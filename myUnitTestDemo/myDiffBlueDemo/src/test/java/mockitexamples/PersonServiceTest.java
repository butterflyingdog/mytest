package mockitexamples;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class PersonServiceTest {
    /**
     * Method under test: {@link PersonService#getPerson(int)}
     */
    @Test
    void testGetPerson() {
        PersonDao personDao = mock(PersonDao.class);
        Person person = new Person(1, "Name");

        when(personDao.getPerson(anyInt())).thenReturn(person);
        assertSame(person, (new PersonService(personDao)).getPerson(1));
        verify(personDao).getPerson(anyInt());
    }
}

