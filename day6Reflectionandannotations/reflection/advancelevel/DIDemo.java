package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Annotation for Dependency Injection
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

// Service Interface
interface Service {
    void execute();
}

// Concrete Implementation of Service
class ServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("Service Executed!");
    }
}

// Client Class with Dependency
class Client {
    @Inject
    private Service service;  // This needs to be injected

    public void run() {
        service.execute();
    }
}

// Dependency Injection Container
class DIContainer {
    public static void injectDependencies(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                try {
                    // Instead of trying to instantiate an interface, map it to an implementation
                    Object dependency;
                    if (field.getType() == Service.class) {
                        dependency = new ServiceImpl();  // Correct mapping
                    } else {
                        dependency = field.getType().getDeclaredConstructor().newInstance();
                    }

                    field.setAccessible(true);
                    field.set(obj, dependency);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to inject dependency for " + field.getName(), e);
                }
            }
        }
    }
}

// Main Class to Run DI
public class DIDemo {
    public static void main(String[] args) {
        Client client = new Client();
        DIContainer.injectDependencies(client);
        client.run();
    }
}

