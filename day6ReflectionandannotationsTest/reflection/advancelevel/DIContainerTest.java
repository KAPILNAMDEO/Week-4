package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class DIContainerTest {
    @Test
    void testDependencyInjection() throws Exception {
        Client client = new Client();
        DIContainer.injectDependencies(client);

        // Get injected field using reflection
        Field serviceField = Client.class.getDeclaredField("service");
        serviceField.setAccessible(true);
        Object injectedService = serviceField.get(client);

        assertNotNull(injectedService);
        assertTrue(injectedService instanceof ServiceImpl);
    }

    @Test
    void testServiceExecution() {
        Client client = new Client();
        DIContainer.injectDependencies(client);

        // Ensure no exception occurs when executing service
        assertDoesNotThrow(client::run);
    }
}
