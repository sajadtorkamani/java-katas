package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CentParserTest {
    @Test
    void toCents_returnsCorrectResult() {
        assertEquals(Integer.valueOf(123), CentParser.toCents("$1.23"));
        assertEquals(Integer.valueOf(9999), CentParser.toCents("$99.99"));
        assertEquals(Integer.valueOf(1234567890), CentParser.toCents("$12345678.90"));
        assertEquals(Integer.valueOf(969), CentParser.toCents("$9.69"));
        assertEquals(Integer.valueOf(970), CentParser.toCents("$9.70"));
        assertEquals(Integer.valueOf(971), CentParser.toCents("$9.71"));
        assertEquals(Integer.valueOf(69), CentParser.toCents("$0.69"));
    }

    @Test
    void toCents_handlesInvalidInputs() {
        assertNull(CentParser.toCents(""));
        assertNull(CentParser.toCents("1"));
        assertNull(CentParser.toCents("1.23"));
        assertNull(CentParser.toCents("$1"));
        assertNull(CentParser.toCents("$1.23\n"));
        assertNull(CentParser.toCents("\n$1.23"));
        assertNull(CentParser.toCents("$9.69$4.3.7"));
        assertNull(CentParser.toCents("$9.692"));
    }
}
