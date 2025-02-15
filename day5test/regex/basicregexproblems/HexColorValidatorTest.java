package com.capgeminiTrainingPrograms.week4.day5.basicregexproblems;



import com.capgeminiTrainingPrograms.week4.day5.regex.basicregexproblems.HexColorValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HexColorValidatorTest {

    @Test
    void testValidHexColors() {
        assertTrue(HexColorValidator.isValidHexColor("#FFA500"), "#FFA500 should be valid");
        assertTrue(HexColorValidator.isValidHexColor("#ff4500"), "#ff4500 should be valid");
        assertTrue(HexColorValidator.isValidHexColor("#00FF00"), "#00FF00 should be valid");
    }

    @Test
    void testInvalidHexColors() {
        assertFalse(HexColorValidator.isValidHexColor("FFA500"), "FFA500 should be invalid (missing #)");
        assertFalse(HexColorValidator.isValidHexColor("#123"), "#123 should be invalid (too short)");
        assertFalse(HexColorValidator.isValidHexColor("#GGGGGG"), "#GGGGGG should be invalid (non-hex characters)");
        assertFalse(HexColorValidator.isValidHexColor("#1234567"), "#1234567 should be invalid (too long)");
    }
}
