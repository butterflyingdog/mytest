package mockitexamples;

import org.junit.jupiter.api.BeforeEach;

class PersonTest {

    private Person personUnderTest;

    @BeforeEach
    void setUp() {
        personUnderTest = new Person(0, "name");
    }
}
