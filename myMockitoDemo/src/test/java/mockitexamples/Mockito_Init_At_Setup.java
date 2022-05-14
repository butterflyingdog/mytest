package mockitexamples;
 
 
import org.junit.Before;
import org.junit.Test;

import mockitexamples.Person;
import mockitexamples.PersonDao;
import mockitexamples.PersonService;

import static org.junit.Assert.*;
import  org.mockito.Mockito;
import java.util.*;
 
//@DisplayName("Use Mockito.mock")
public class Mockito_Init_At_Setup {

    private PersonDao     mockedObject;
    private PersonService serviceUsingMockedObject;

    @Before
    public void setUp() throws Exception {
        //模拟PersonDao对象
        mockedObject = Mockito.mock(PersonDao.class);
        Mockito.when(mockedObject.getPerson(1)).thenReturn(new Person(1, "Person1"));
        Mockito.when(mockedObject.getPerson(2)).thenReturn(new Person(2, "Person2"));
        Mockito.when(mockedObject.update(Mockito.isA(Person.class))).thenReturn(true);

        serviceUsingMockedObject = new PersonService(mockedObject);
    }

    @Test
    public void testUpdate() throws Exception {
        boolean result = serviceUsingMockedObject.update(2, "new name");
        System.out.println("Mockito_Init_At_Setup.testUpdate flag0");
        assertTrue("must true", result);
        System.out.println("Mockito_Init_At_Setup.testUpdate flag1");
        //验证是否执行过一次getPerson(1)
        Mockito.verify(mockedObject, Mockito.times(1)).getPerson(Mockito.eq(2));
        System.out.println("Mockito_Init_At_Setup.testUpdate flag2");
        //验证是否执行过一次update
        Mockito.verify(mockedObject, Mockito.times(1)).update(Mockito.isA(Person.class));
        System.out.println("Mockito_Init_At_Setup.testUpdate flag3");
    }

    @Test
    public void verifyFail() throws Exception {
       
       
        assertNull("result should be null", serviceUsingMockedObject.getPerson(3));
        System.out.println("Mockito_Init_At_Setup.noMockedMethodDemo flag1");
        //验证是否执行过一次getPerson(1)
        Mockito.verify(mockedObject, Mockito.times(1)).getPerson(Mockito.eq(3));
        System.out.println("Mockito_Init_At_Setup.noMockedMethodDemo flag2");
        //验证是否执行过一次update
        Mockito.verify(mockedObject, Mockito.never()).update(Mockito.isA(Person.class));
        System.out.println("Mockito_Init_At_Setup.noMockedMethodDemo flag3");
    }

    @Test
    public void noMockedMethod() throws Exception {
        assertNull ( "should be null", serviceUsingMockedObject.getPerson(3 ));
    }
}
