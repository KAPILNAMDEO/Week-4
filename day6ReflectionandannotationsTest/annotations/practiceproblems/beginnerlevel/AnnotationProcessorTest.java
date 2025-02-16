package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.beginnerlevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class ImportantMethodTest {
    @Test
    void testImportantMethodAnnotation() throws NoSuchMethodException {
        Method processMethod = Application.class.getMethod("processData");
        Method saveMethod = Application.class.getMethod("saveData");
        Method logMethod = Application.class.getMethod("logData");

        assertTrue(processMethod.isAnnotationPresent(ImportantMethod.class));
        assertTrue(saveMethod.isAnnotationPresent(ImportantMethod.class));
        assertFalse(logMethod.isAnnotationPresent(ImportantMethod.class));

        ImportantMethod processAnnotation = processMethod.getAnnotation(ImportantMethod.class);
        ImportantMethod saveAnnotation = saveMethod.getAnnotation(ImportantMethod.class);

        assertEquals("CRITICAL", processAnnotation.level());
        assertEquals("HIGH", saveAnnotation.level()); // Default value
    }
}
