package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.advancedlevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@Target(ElementType.METHOD) // Can only be applied to methods
@interface RoleAllowed {
    String value(); // Defines the required role
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}



class SecureService {

    @RoleAllowed("ADMIN") // Only admins can execute this method
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER") // Only regular users can execute this method
    public void userTask() {
        System.out.println("User task executed successfully!");
    }
}


public class RoleAccessController {

    public static void invokeMethod(User user, Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);

                if (annotation.value().equals(user.getRole())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! User role '" + user.getRole() +
                            "' is not authorized to execute '" + methodName + "'.");
                }
            } else {
                method.invoke(obj); // No restriction, execute normally
            }
        } catch (Exception e) {
            System.out.println("Error invoking method: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SecureService service = new SecureService();

        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        System.out.println("Admin trying to access adminTask:");
        invokeMethod(adminUser, service, "adminTask"); // Should work

        System.out.println("\nUser trying to access adminTask:");
        invokeMethod(normalUser, service, "adminTask"); // Should be denied

        System.out.println("\nUser trying to access userTask:");
        invokeMethod(normalUser, service, "userTask"); // Should work
    }
}
