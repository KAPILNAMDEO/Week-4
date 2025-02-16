package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.basiclevel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ClassInspectorTest {
    @Test
    void testValidClass() {
        assertDoesNotThrow(() -> Class.forName("java.util.ArrayList"));
    }

    @Test
    void testInvalidClass() {
        assertThrows(ClassNotFoundException.class, () -> Class.forName("invalid.ClassName"));
    }
}
