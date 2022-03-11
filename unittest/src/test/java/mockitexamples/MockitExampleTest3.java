package mockitexamples;

import mockitexamples.Person;
import mockitexamples.PersonDao;
import mockitexamples.PersonService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitExampleTest3 {

    @Mock
    private PersonDao     mockDao;
    
    @InjectMocks
    private PersonService personService;

    @Before
    public void setUp() throws Exception {


        //when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
        when(mockDao.getPerson(2)).thenReturn(new Person(2, "Person2"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);


    }

    @Test
    public void testUpdate() throws Exception {
        boolean result = personService.update(2, "new name");
        System.out.println("MockitExample3.testUpdate flag0");
        assertTrue("must true", result);
        System.out.println("MockitExample3.testUpdate flag1");
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(2));
        //verify(mockDao, times(1)).getPerson(2);
        System.out.println("MockitExample3.testUpdate flag2");
        //验证是否执行过一次update
        verify(mockDao, times(1)).update(isA(Person.class));
        System.out.println("MockitExample3.testUpdate flag3");
    }
}