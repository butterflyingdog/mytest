package myaopdemo.bean;



import myaopdemo.annotations.InOutLog;
import myaopdemo.annotations.MyAutowired;
import myaopdemo.annotations.MyComponent;

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

