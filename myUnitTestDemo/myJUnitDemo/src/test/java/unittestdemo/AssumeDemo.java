package  unittestdemo;

import org.junit.jupiter.api.Test;

import  org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Assumptions;

import static org.hamcrest.core.IsEqual.equalTo;

 


 public class AssumeDemo {

    @Test
    void assumeTrue_Message_demo() {
        // 第一个参数中单条件不成立时，输出第二个参数中自定义的错误信息
        Assumptions.assumeTrue(3<5,
         "Aborting test: not on developer workstation");

        Assumptions.assumeTrue(3<5,
                              () -> "Aborting test: not on developer workstation");
        //下面的代码变为在上面假设的条件成立后执行
        System.out.println("满足 assumeTrue_Message条件后执行");
    }
    @Test
    void assumeTrue_BooleanSupplier_Demo(){
        //这个方法的第一个参数为函数式接口，通过看起源码可以发现无参数，返回值为boolean
        Assumptions.assumeTrue(()->{
            System.out.println(" AssumeTrue_BooleanSupplier 中返回 true");
            return true;
        });
        System.out.println("满足 assumeTrue_BooleanSupplier 条件的后续行为");
    }

    @Test
    void assumeTrue_MessageSupplier_Demo() {
         Assumptions.assumeTrue( false ,
                 ()->{ 
                         System.out.println("不满足 assumeTrue 的条件，跳过测试");
                         return "不满足 assumeTrue 的条件，跳过测试" ; 
                     } );
        System.out.println("满足 assumeTrue_MessageSupplier 条件的后续行为");
    }


    @Test
    void assumpingThat_AssertAll_Demo() {

        // assumingThat 用于在给定的条件成立的情况下，执行特定代码
        Assumptions.assumingThat( 1 == 1,
                () -> {
                    // perform these assertions only on the CI server
                    System.out.println("满足 assumeThat 条件，设置环境变量");
                 
                }
        ); 
        // assumingThat 在给定的条件不成立时，不执行特定代码，但不影响案例继续运行
        Assumptions.assumingThat(
            ()->{return false;},
            () -> {
                System.out.println("满足 assumeThat 条件，执行代码");
            
            }
        ); 
    }

    @Test
    void testAssumTrue() {
        System.out.println("test");
        //assumeTrue该语句并不会影响其前面的语句执行
        //可以将3>5改成3<5自行测试成功的效果
        Assumptions.assumeTrue(3>5);
        //该方法中下面所有的代码变为在上面假设的条件成立后执行
        // 如果上述假设不成立，则会忽略执行该行下面的代码，并报错
        System.out.println("assume is true!");
    }


  

  }