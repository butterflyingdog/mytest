package mockitexamples;

import mockitexamples.Person;
import mockitexamples.PersonDao;
import mockitexamples.PersonService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

public class testPersonFacade {
    @Mock
    private PersonDao     mockDao;
    
    @InjectMocks
    private PersonFacade personFacade;

    @Before
    public void setUp() throws Exception {


        //when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
        when(mockDao.getPerson(2)).thenReturn(new Person(2, "Person2"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);


    }

    @Test
    public void verifyPass() throws Exception {
       
       
        assertNull("result should be null", personFacade.getPerson(3));
    }
}
