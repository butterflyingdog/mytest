package mockitexamples;

import mockitexamples.Person;
import mockitexamples.PersonDao;
import mockitexamples.PersonService;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
 
import static org.mockito.Mockito.when;

import org.hamcrest.MatcherAssert;


import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 

/**
 * PersonFacade 依赖 PersonService, PersonServie 依赖 PersonDao
 */
 
public class Mockito_GrandChildRef {
    @Mock
    private PersonDao     mockedDao;
    @InjectMocks
    private PersonService personService;
    @InjectMocks
    private PersonFacade personFacade;

    @Before
    public void setUp_by_MockitoAnnotations() throws Exception {
        // 使用MockitoAnnotations初始化hmock
        MockitoAnnotations.openMocks(this);

        personFacade.setPersonService(personService);

    }

    @Test
    public void nonMockedData() throws Exception {
        when(mockedDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
        
        // Person(1) is Mocked
        assertNotNull("result should not be null", personFacade.getPerson(1));
    
        // Person(3) is not Mocked
        assertNull("result should be null", personFacade.getPerson(3));
      
    } 
}
