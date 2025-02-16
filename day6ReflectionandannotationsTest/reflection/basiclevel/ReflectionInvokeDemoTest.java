package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.basiclevel;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionInvokeDemoTest {
    @Test
    void testInvokePrivateMethod() throws Exception {
        Calculator calculator = new Calculator();

        // Access private method "multiply"
        Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);

        // Invoke method and get result
        int result = (int) multiplyMethod.invoke(calculator, 3, 4);

        // Validate result
        assertEquals(12, result);
    }

    @Test
    void testMultiplyWithZero() throws Exception {
        Calculator calculator = new Calculator();
        Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);

        // Test with zero
        int result = (int) multiplyMethod.invoke(calculator, 0, 5);

        assertEquals(0, result);
    }
}
