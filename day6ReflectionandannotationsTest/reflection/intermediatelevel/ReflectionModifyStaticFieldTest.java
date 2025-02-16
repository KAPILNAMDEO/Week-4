package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.intermediatelevel;

import java.lang.reflect.Field;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionModifyStaticFieldTest {
    @Test
    void testModifyStaticField() throws Exception {
        // Get the private static field
        Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);

        // Modify the static field value
        apiKeyField.set(null, "TEST_API_KEY");

        // Verify the modified value
        assertEquals("TEST_API_KEY", Configuration.getApiKey());
    }
}
