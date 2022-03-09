package butterflyingdog.mySpringBootDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import butterflyingdog.mySpringBootDemo.Dao.PersonDao;

public class PersonDaoTest {

    //使用MockBean是因为此时容器中没有UserMapper这个对象
    @MockBean
    public PersonDao userDao;

    //使用BDDMockito对行为进行预测，
    @BeforeAll
    public void init(){
        BDDMockito.given(userDao.createUser("admin")).willReturn(1);
        BDDMockito.given(userDao.createUser("")).willReturn(0);
        BDDMockito.given(userDao.createUser(null)).willThrow(NullPointerException.class);
    }

    @Test//(expected=NullPointerException.class)
    public void testCreateUser() {
        Assertions.assertEquals(Integer.valueOf(1),userDao.createUser("admin")) ;
        Assertions.assertEquals(Integer.valueOf(0),userDao.createUser("")) ;
        Assertions.assertEquals(Integer.valueOf(1),userDao.createUser(null)) ;
    }
}