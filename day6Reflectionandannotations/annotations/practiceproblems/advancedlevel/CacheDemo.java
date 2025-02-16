package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.advancedlevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@Target(ElementType.METHOD) // Can only be applied to methods
@interface CacheResult {}



class CacheHandler {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeWithCache(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getMethod(methodName, getParameterTypes(args));

            if (method.isAnnotationPresent(CacheResult.class)) {
                String cacheKey = generateCacheKey(methodName, args);

                if (cache.containsKey(cacheKey)) {
                    System.out.println("Returning cached result for: " + methodName);
                    return cache.get(cacheKey);
                }

                Object result = method.invoke(obj, args);
                cache.put(cacheKey, result);
                return result;
            }

            // If method is not annotated, invoke normally
            return method.invoke(obj, args);

        } catch (Exception e) {
            throw new RuntimeException("Error invoking method: " + e.getMessage(), e);
        }
    }

    private static String generateCacheKey(String methodName, Object... args) {
        StringBuilder key = new StringBuilder(methodName);
        for (Object arg : args) {
            key.append("-").append(arg.toString());
        }
        return key.toString();
    }

    private static Class<?>[] getParameterTypes(Object... args) {
        return java.util.Arrays.stream(args)
                .map(Object::getClass)
                .toArray(Class<?>[]::new);
    }
}

class ExpensiveComputation {

    @CacheResult
    public int computeFactorial(Integer n) { // Change int → Integer
        System.out.println("Computing factorial for: " + n);
        return (n == 0 || n == 1) ? 1 : n * computeFactorial(n - 1);
    }

}

public class CacheDemo {
    public static void main(String[] args) {
        ExpensiveComputation computation = new ExpensiveComputation();

        System.out.println("First Call: " + CacheHandler.invokeWithCache(computation, "computeFactorial", 5));
        System.out.println("Second Call: " + CacheHandler.invokeWithCache(computation, "computeFactorial", 5)); // Should use cache
        System.out.println("Different Call: " + CacheHandler.invokeWithCache(computation, "computeFactorial", 6)); // New computation
    }
}
