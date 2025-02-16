package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Proxy;
import static org.junit.jupiter.api.Assertions.*;

class LoggingProxyTest {
    @Test
    void testProxyLogsMethodCall() {
        Greeting greeting = new GreetingImpl();

        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(greeting)
        );

        String response = proxyInstance.sayHello("Bob");
        assertEquals("Hello, Bob!", response);
    }

    @Test
    void testProxyInstanceType() {
        Greeting greeting = new GreetingImpl();

        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(greeting)
        );

        assertTrue(Proxy.isProxyClass(proxyInstance.getClass()));
        assertTrue(proxyInstance instanceof Greeting);
    }
}
