package mockitexamples;

import mockitexamples.Person;
import mockitexamples.PersonDao;
import mockitexamples.PersonService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;
 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 


 
public class Mockito_GrandChildRef {
    @Mock
    private PersonDao     mockDao;
    @InjectMocks
    private PersonService personService;
    @InjectMocks
    private PersonFacade personFacade;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        personFacade.setPersonService(personService);
        
         when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
    

    }

    @Test
    public void nonMockedData() throws Exception {
    
        assertNull("result should be null", personFacade.getPerson(3));
    }
    @Test
    public void mockedData() throws Exception {
    
        assertNotNull("result should not be null", personFacade.getPerson(1));
    }
}
