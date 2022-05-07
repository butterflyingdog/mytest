package  assertdemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import   org.hamcrest.text.IsEqualIgnoringWhiteSpace;


  class JUnit5AssertionsDemo2 {


    @Test
   // @Description("查询部门")
  //  @DisplayName("查询部门")
    void listDepartment() {
        // JUit5 使用assertAll 将所有assert结果
        assertAll("返回值校验",
                ()->assertEquals("1", "1".toString())
                // JUnit5 不再提供assertThat方法，使用Hamcrest中的assetThat
                ,()->assertThat( "1", equalTo("2")  )
                //,()->assertEquals(createName+"1", listResponse.path("department.name[0]").toString())
                //,()->assertEquals(createNameEn+"1", listResponse.path("department.name_en[0]").toString())
                );

    }

  }