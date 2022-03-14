package myaopframework;

import java.lang.reflect.*;

import myaopframework.annotations.*;

public class MyInvocationHandler2 implements InvocationHandler{
    private Object object;//被代理类
    private Object invoke;
    public void setObject(Object object) {
        this.object = object;
    }
    
    /**
     *  在BeanFactory中，方法上有@InOutLog注解，则生成动态代理方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里做判断，看是否需要做下面的输出
        Boolean bool = false;
        //！！！注意，要用被代理类的对象去判断其method方法上是否有@InOutLog注解，而不是用入参method对象（该method对象是被代理类的接口的）
        //怎么处理入参的类型：见MyAOP2.这里没有做入参处理，可能会报方法找不到异常，注意！！！
        Method declaredMethod = object.getClass().getDeclaredMethod(method.getName());
        if(null != declaredMethod.getAnnotation(InOutLog.class)) {
            System.out.println("我是日志输出~~~start~~~");
            bool = true;
        }
        
        invoke = method.invoke(object, args);
        
        //这里做判断，同上
        if(bool) {
            System.out.println("我是日志输出~~~end~~~");
            System.out.println("------------------------------------------------------------------------------");
        }
        return invoke;
    }
}