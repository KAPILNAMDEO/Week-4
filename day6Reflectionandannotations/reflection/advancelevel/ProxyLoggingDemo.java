package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an Interface
interface Greeting {
    String sayHello(String name);
}

// Step 2: Implement the Interface
class GreetingImpl implements Greeting {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}

// Step 3: Create a Dynamic Proxy for Logging
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

// Step 4: Create a Proxy Instance
public class ProxyLoggingDemo {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();

        // Create a dynamic proxy
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(greeting)
        );

        // Call the method via proxy
        String message = proxyInstance.sayHello("Alice");
        System.out.println(message);
    }
}

