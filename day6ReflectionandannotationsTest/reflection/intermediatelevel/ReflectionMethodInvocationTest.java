package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.intermediatelevel;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionMethodInvocationTest {
    @Test
    void testAddMethodInvocation() throws Exception {
        MathOperations mathOperations = new MathOperations();
        Method addMethod = MathOperations.class.getMethod("add", int.class, int.class);

        int result = (int) addMethod.invoke(mathOperations, 5, 3);

        assertEquals(8, result);
    }

    @Test
    void testSubtractMethodInvocation() throws Exception {
        MathOperations mathOperations = new MathOperations();
        Method subtractMethod = MathOperations.class.getMethod("subtract", int.class, int.class);

        int result = (int) subtractMethod.invoke(mathOperations, 10, 4);

        assertEquals(6, result);
    }

    @Test
    void testMultiplyMethodInvocation() throws Exception {
        MathOperations mathOperations = new MathOperations();
        Method multiplyMethod = MathOperations.class.getMethod("multiply", int.class, int.class);

        int result = (int) multiplyMethod.invoke(mathOperations, 6, 7);

        assertEquals(42, result);
    }

    @Test
    void testInvalidMethod() {
        assertThrows(NoSuchMethodException.class, () -> {
            MathOperations.class.getMethod("divide", int.class, int.class);
        });
    }
}