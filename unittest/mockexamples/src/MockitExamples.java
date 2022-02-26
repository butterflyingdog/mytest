package unittest.mockexmaples;
  class Person {
    private final int id; 
    private final String name; 
    public Person(int id, String name) { 
        this.id = id; 
        this.name = name; 
        } 
    public int getId() { 
        return id; 
        } 
    public String getName() { 
        return name; 
        }
}

public interface PersonDao {
    Person getPerson(int id); 
    boolean update(Person person); 
    }

  class PersonService {
    private final PersonDao personDao; 
    public PersonService(PersonDao personDao) { 
        this.personDao = personDao; 
        } 
    public boolean update(int id, String name) { 
        Person person = personDao.getPerson(id); 
        if (person == null) 
        { return false; } 
        Person personUpdate = new Person(person.getId(), name); 
        return personDao.update(personUpdate); 
        }
}


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class MockitExample {

    private PersonDao     mockDao;
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        //模拟PersonDao对象
        mockDao = mock(PersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);

        personService = new PersonService(mockDao);
    }

    @Test
    public void testUpdate() throws Exception {
        boolean result = personService.update(1, "new name");
        assertTrue("must true", result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao, times(1)).update(isA(Person.class));
    }

    @Test
    public void testUpdateNotFind() throws Exception {
        boolean result = personService.update(2, "new name");
        assertFalse("must true", result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao, never()).update(isA(Person.class));
    }
}
 
