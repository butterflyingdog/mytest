package MyIOCAndMyAop;

import java.util.Map;
import java.lang.reflect.*;
import  MyIOCAndMyAop.bean.*;
import MyIOCAndMyAop.Annotations.*;

public class MyAOP2 {
    public static void main(String[] args) {
        /**
         * 使用步骤：
         * ① 給指定类的某个方法加@InOutLog注解；
         * ② 通过BeanFactory或的该类的实例；
         * ③ 执行bean.method()；
         * 效果：method()方法的前后有了log的输出。
         */
        String completeClassName = "MyIOCAndMyAop.bean.Person";
        Object bean = MyIOC.getBean(completeClassName);
        Subject person = (Subject)bean;
        person.test();
    }
    
    static {
        init();
    }
    
    public static void init() {
        updateBeanFromBeanFactory();
    }
    
    /**
     * 扫描BeanFactory，找出方法上有@InOutLog注解的bean，为其创建代理类对象，并替代原bean。
     */
    public static void updateBeanFromBeanFactory() {
        for(Map.Entry<String, Object> entry : MyIOC.getBeanFactory().entrySet()) {
            for(Method method : entry.getValue().getClass().getDeclaredMethods()) {
                if(null != method.getAnnotation(InOutLog.class)) {
                    MyProxy2.updateBean(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}