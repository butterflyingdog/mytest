package mockitexmaples;
 
 
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.utils.List;
  
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

    @Test
    public void testmockit(){
        List list = new LinkedList();

//监控一个真实对象

List spy = spy(list);

//你可以为某些函数打桩

when(spy.size()).thenReturn(100);

//使用这个将调用真实对象的函数

spy.add("one");

spy.add("two");

//打印"one"

System.out.println(spy.get(0));

//size() 将打印100

System.out.println(spy.size());

//交互验证

verify(spy).add("one"); 
verify(spy).add("two");
    }

    
    /*

    @Test
    public void testmockit2(){

        // 模拟LinkedList 的一个对象

LinkedList mockedList = mock(LinkedList.class);

// 此时调用get方法，会返回null，因为还没有对方法调用的返回值做模拟

System.out.println(mockedList.get(0));

// 模拟方法调用的返回值

// 模拟获取第一个元素时，返回字符串first。 给特定的方法调用返回固定值在官方说法中称为stub。

when(mockedList.get(0)).thenReturn("first");

// 此时打印输出first

System.out.println(mockedList.get(0));

// 模拟方法调用抛出异常

// 模拟获取第二个元素时，抛出RuntimeException

when(mockedList.get(1)).thenThrow(new RuntimeException());

// 此时将会抛出RuntimeException

System.out.println(mockedList.get(1));

// 如果一个函数没有返回值类型，那么可以使用此方法模拟异常抛出

doThrow(new RuntimeException("clear exception")).when(mockedList).clear();

mockedList.clear();

//模拟调用方法时的参数匹配

// anyInt()匹配任何int参数，这意味着参数为任意值，其返回值均是element

when(mockedList.get(anyInt())).thenReturn("element");

// 此时打印是element

System.out.println(mockedList.get(999));

//模拟方法调用次数

// 调用add一次

mockedList.add("once");

// 下面两个写法验证效果一样，均验证add方法是否被调用了一次

verify(mockedList).add("once");

verify(mockedList, times(1)).add("once");

//校验行为

// mock creation

List mockedList = mock(List.class);

// using mock object

mockedList.add("one");

mockedList.clear();

//verification

verify(mockedList).add("one");

verify(mockedList).clear();

//模拟方法调用(Stubbing)

//You can mock concrete classes, not just interfaces

LinkedList mockedList = mock(LinkedList.class);

//stubbing

when(mockedList.get(0)).thenReturn("first");

when(mockedList.get(1)).thenThrow(new RuntimeException());

//following prints "first"

System.out.println(mockedList.get(0));

//following throws runtime exception

System.out.println(mockedList.get(1));

//following prints "null" because get(999) was not stubbed

System.out.println(mockedList.get(999));

verify(mockedList).get(0);

//参数匹配

//stubbing using built-in anyInt() argument matcher

when(mockedList.get(anyInt())).thenReturn("element");

//stubbing using custom matcher (let's say isValid() returns your own matcher implementation):

when(mockedList.contains(argThat(isValid()))).thenReturn("element");

//following prints "element"

System.out.println(mockedList.get(999));

//you can also verify using an argument matcher

verify(mockedList).get(anyInt());

//argument matchers can also be written as Java 8 Lambdas

verify(mockedList).add(someString -> someString.length() > 5);

//校验方法调用次数

//using mock

mockedList.add("once");

mockedList.add("twice");

mockedList.add("twice");

mockedList.add("three times");

mockedList.add("three times");

mockedList.add("three times");

//following two verifications work exactly the same - times(1) is used by default

verify(mockedList).add("once");

verify(mockedList, times(1)).add("once");

//exact number of invocations verification

verify(mockedList, times(2)).add("twice");

verify(mockedList, times(3)).add("three times");

//verification using never(). never() is an alias to times(0)

verify(mockedList, never()).add("never happened");

//verification using atLeast()/atMost()

verify(mockedList, atLeastOnce()).add("three times");

verify(mockedList, atLeast(2)).add("five times");

verify(mockedList, atMost(5)).add("three times");

//模拟无返回方法抛出异常

doThrow(new RuntimeException()).when(mockedList).clear();

//following throws RuntimeException:

mockedList.clear();

//校验方法调用顺序

// A. Single mock whose methods must be invoked in a particular order

List singleMock = mock(List.class);

//using a single mock

singleMock.add("was added first");

singleMock.add("was added second");

//create an inOrder verifier for a single mock

InOrder inOrder = inOrder(singleMock);

//following will make sure that add is first called with "was added first, then with "was added second"

inOrder.verify(singleMock).add("was added first");

inOrder.verify(singleMock).add("was added second");

// B. Multiple mocks that must be used in a particular order

List firstMock = mock(List.class);

List secondMock = mock(List.class);

//using mocks

firstMock.add("was called first");

secondMock.add("was called second");

//create inOrder object passing any mocks that need to be verified in order

InOrder inOrder = inOrder(firstMock, secondMock);

//following will make sure that firstMock was called before secondMock

inOrder.verify(firstMock).add("was called first");

inOrder.verify(secondMock).add("was called second");

// Oh, and A + B can be mixed together at will

////校验方法是否从未调用

//using mocks - only mockOne is interacted

mockOne.add("one");

//ordinary verification

verify(mockOne).add("one");

//verify that method was never called on a mock

verify(mockOne, never()).add("two");

//verify that other mocks were not interacted

verifyZeroInteractions(mockTwo, mockThree); 
    }
*/

}
 
