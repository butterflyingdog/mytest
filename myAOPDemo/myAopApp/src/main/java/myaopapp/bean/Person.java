package myaopapp.bean;



import myaopframework.annotations.InOutLog;
import myaopframework.annotations.MyAutowired;
import myaopframework.annotations.MyComponent;

/**
 * 被代理类
 */
@MyComponent
public class Person implements Subject{

    @MyAutowired
    private Student student;

    @InOutLog
    public void test(){
        System.out.println(this + ".test() : " + student);
    }
}   

