package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {

    private Todos todos;
    private String task;

    @BeforeEach
    void setTodos() {
        this.todos = new Todos();
        task = "Testing";
    }

    @Test
    void addTask() {
        boolean expectedResult = true;
        Assertions.assertEquals(expectedResult, this.todos.addTask(task));
    }

    @Test
    void addEighthTask() {
        todos.addTask("Первая");
        todos.addTask("Вторая");
        todos.addTask("Третья");
        todos.addTask("Четвертая");
        todos.addTask("Пятая");
        todos.addTask("Шестая");
        todos.addTask("Седьмая");
        boolean expectedResult = false;
        Assertions.assertEquals(expectedResult, todos.addTask(task));
    }

    @Test
    void removeTask() {
        todos.addTask("Первая");
        todos.addTask(task);
        boolean expected = true;
        Assertions.assertEquals(expected, todos.removeTask(task));
    }

    @Test
    void removeWhenSetIsEmpty() {
        boolean expected = false;
        Assertions.assertEquals(expected, todos.removeTask(task));
    }

    @Test
    void removeNonexistentTask() {
        boolean expected = false;
        todos.addTask("One");
        Assertions.assertEquals(expected, todos.removeTask(task));
    }
}
