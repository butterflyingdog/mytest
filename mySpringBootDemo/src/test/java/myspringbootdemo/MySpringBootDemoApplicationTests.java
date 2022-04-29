package myspringbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MySpringBootDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
