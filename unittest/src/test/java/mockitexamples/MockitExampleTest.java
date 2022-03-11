package mockitexamples;
 
 
import org.junit.Before;
import org.junit.Test;

import mockitexamples.Person;
import mockitexamples.PersonDao;
import mockitexamples.PersonService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;
 
@DisplayName("Use Mockito.mock")
public class MockitExampleTest {

    private PersonDao     mockDao;
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        //模拟PersonDao对象
        mockDao = mock(PersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
        when(mockDao.getPerson(2)).thenReturn(new Person(2, "Person2"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);

        personService = new PersonService(mockDao);
    }

    @Test
    public void testUpdate() throws Exception {
        boolean result = personService.update(2, "new name");
        System.out.println("MockitExample.testUpdate flag0");
        assertTrue("must true", result);
        System.out.println("MockitExample.testUpdate flag1");
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        System.out.println("MockitExample.testUpdate flag2");
        //验证是否执行过一次update
        verify(mockDao, times(1)).update(isA(Person.class));
        System.out.println("MockitExample.testUpdate flag3");
    }

    @Test
    public void testUpdateNotFind() throws Exception {
        boolean result = personService.update(3, "new name");
        System.out.println("MockitExample.testUpdateNotFind flag0, result="+result);
        assertFalse("result should be false", result);
        System.out.println("MockitExample.testUpdateNotFind flag1");
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        System.out.println("MockitExample flag2");
        //验证是否执行过一次update
        verify(mockDao, never()).update(isA(Person.class));
        System.out.println("MockitExample flag3");
    }

    @Test
    public void testGetPerson() throws Exception {
        assertNull ( "should be null", personService.getPerson(3 ));
    }
}
