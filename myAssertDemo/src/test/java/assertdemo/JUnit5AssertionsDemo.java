  package  assertdemo;

  import static org.junit.jupiter.api.Assertions.*;
  import org.junit.jupiter.api.Test;
  
  class JUnit5AssertionsDemo2 {


    @Test
   // @Description("查询部门")
  //  @DisplayName("查询部门")
    void listDepartment() {
        

         assertAll("返回值校验",
                ()->assertEquals("1", "1".toString())
                //,()->assertEquals(departmentId+"1", listResponse.path("department.id[0]").toString())
                //,()->assertEquals(createName+"1", listResponse.path("department.name[0]").toString())
                //,()->assertEquals(createNameEn+"1", listResponse.path("department.name_en[0]").toString())
                );

    }

  }