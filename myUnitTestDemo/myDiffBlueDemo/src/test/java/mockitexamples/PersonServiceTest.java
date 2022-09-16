package mockitexamples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    /**
     * Method under test: {@link PersonService#update(int, String)}
     */
    @Test
    void testUpdate() {
        PersonDao personDao = mock(PersonDao.class);
        when(personDao.update((Person) any())).thenReturn(true);
        when(personDao.getPerson(anyInt())).thenReturn(new Person(1, "Name"));
        assertTrue((new PersonService(personDao)).update(1, "Name"));
        verify(personDao).update((Person) any());
        verify(personDao).getPerson(anyInt());
    }

    /**
     * Method under test: {@link PersonService#update(int, String)}
     */
    @Test
    void testUpdate2() {
        PersonDao personDao = mock(PersonDao.class);
        when(personDao.update((Person) any())).thenReturn(false);
        when(personDao.getPerson(anyInt())).thenReturn(new Person(1, "Name"));
        assertFalse((new PersonService(personDao)).update(1, "Name"));
        verify(personDao).update((Person) any());
        verify(personDao).getPerson(anyInt());
    }

    /**
     * Method under test: {@link PersonService#update(int, String)}
     */
    @Test
    void testUpdate3() {
        PersonDao personDao = mock(PersonDao.class);
        when(personDao.update((Person) any())).thenReturn(true);
        when(personDao.getPerson(anyInt())).thenReturn(null);
        assertFalse((new PersonService(personDao)).update(1, "Name"));
        verify(personDao).getPerson(anyInt());
    }

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

