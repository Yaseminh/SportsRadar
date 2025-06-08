import Entity.FileParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {
    @Test
    void testValidInputSingleBest() {
        String input = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3)";
        String result = FileParser.solve(input);
        assertEquals("1", result);  // Item 2 is too heavy, item 1 is best valid fit
    }
    @Test
    void testAdditionalInputs() {
        assertEquals("4", FileParser.solve("81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)"));
        assertEquals("-", FileParser.solve("8 : (1,15.3,€34)"));
        assertEquals("2,7", FileParser.solve("75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)"));
        assertEquals("8,9", FileParser.solve("56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)"));
    }

    // Changed here — expect no exception, but return "-"
    @Test
    void testEmptyInputLine() {
        String result = FileParser.solve("100 : ");
        assertEquals("-", result);
    }
    @Test
    void testWeightExceeded() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FileParser.solve("110 : (1,10.0,€10)");
        });
        assertEquals("Max package weight exceeded", exception.getMessage());
    }

    @Test
    void testItemConstraintViolated() {
        // weight > 100
        String input = "80 : (1,101.0,€50)";
        String result = FileParser.solve(input);
        assertEquals("-", result);  // Because no valid items will be parsed
    }

    @Test
    void testTooManyItems() {
        StringBuilder sb = new StringBuilder("90 : ");
        for (int i = 1; i <= 16; i++) {
            sb.append(String.format("(%d,1.0,€1) ", i));
        }
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FileParser.solve(sb.toString());
        });
        assertEquals("Too many items", exception.getMessage());
    }
    @Test
    void testNoValidCombination() {
        String input = "10 : (1,20.0,€30) (2,25.0,€40)";
        String result = FileParser.solve(input);
        assertEquals("-", result);  // All items are over the weight limit
    }
}
