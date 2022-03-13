package myaopdemo;

import java.lang.reflect.*;

public class MyProxy2 {
    
    /**
     * 动态的创建一个代理类的对象
     * MyProxy动态创建的“代理类的对象”：
     *     class A implements Subject{
     *         private Handler  handler;
     *         public void test() {
     *             //获得到当前方法名
     *             handler.invoke();
     *         }
     *     }
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler2 handler = new MyInvocationHandler2();
        handler.setObject(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
    
    /**
     * 对于有@InOutLog注解的，用代理类的bean来替代BeanFactory中的被代理类的bean。
     * 这一步很重要，因为当执行到bean.method()，执行的就一定是bean对应的method()方法，
     * 如果此时没有用代理类对象去替换，那么执行的就是没有InOutLog的原来的那个方法。
     */
    public static void updateBean(String completeClassName, Object object) {
        MyIOC.updateBeanFromBeanFactory(completeClassName, getProxyInstance(object));//(全类名，代理类的bean)
    }
}