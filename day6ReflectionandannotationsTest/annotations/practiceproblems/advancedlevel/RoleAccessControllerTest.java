package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.advancedlevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class RoleAccessTest {

    @Test
    void testAdminAccessAllowed() {
        SecureService service = new SecureService();
        User adminUser = new User("ADMIN");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RoleAccessController.invokeMethod(adminUser, service, "adminTask");

        assertTrue(outContent.toString().contains("Admin task executed successfully!"));
    }

    @Test
    void testUserAccessDeniedForAdminTask() {
        SecureService service = new SecureService();
        User normalUser = new User("USER");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RoleAccessController.invokeMethod(normalUser, service, "adminTask");

        assertTrue(outContent.toString().contains("Access Denied!"));
    }

    @Test
    void testUserAccessAllowedForUserTask() {
        SecureService service = new SecureService();
        User normalUser = new User("USER");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RoleAccessController.invokeMethod(normalUser, service, "userTask");

        assertTrue(outContent.toString().contains("User task executed successfully!"));
    }
}
