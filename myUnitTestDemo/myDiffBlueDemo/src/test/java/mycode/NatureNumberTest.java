package mycode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class NatureNumberTest {

    @Test
    void testIsNatureNumber() {
        assertFalse(NatureNumber.isNatureNumber(0));
    }
}
