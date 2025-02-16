package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.beginnerlevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    @Test
    void testTodoAnnotation() throws NoSuchMethodException {
        Method authMethod = Project.class.getMethod("authenticateUser");
        Method dbMethod = Project.class.getMethod("optimizeDatabase");
        Method uiMethod = Project.class.getMethod("improveUI");

        assertTrue(authMethod.isAnnotationPresent(Todo.class));
        assertTrue(dbMethod.isAnnotationPresent(Todo.class));
        assertTrue(uiMethod.isAnnotationPresent(Todo.class));

        Todo authTodo = authMethod.getAnnotation(Todo.class);
        Todo dbTodo = dbMethod.getAnnotation(Todo.class);
        Todo uiTodo = uiMethod.getAnnotation(Todo.class);

        assertEquals("Implement user authentication", authTodo.task());
        assertEquals("Alice", authTodo.assignedTo());
        assertEquals("HIGH", authTodo.priority());

        assertEquals("Optimize database queries", dbTodo.task());
        assertEquals("Bob", dbTodo.assignedTo());
        assertEquals("MEDIUM", dbTodo.priority()); // Default value

        assertEquals("Improve UI responsiveness", uiTodo.task());
        assertEquals("Charlie", uiTodo.assignedTo());
        assertEquals("LOW", uiTodo.priority());
    }
}
