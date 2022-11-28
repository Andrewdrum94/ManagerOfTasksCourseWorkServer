package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    //...
    private final Set<String> tasks = new TreeSet<>();
    private final int maxNumOfTasks = 7;

    public boolean addTask(String task) {
        if (tasks.size() >= maxNumOfTasks) {
            return false;
        } else {
            tasks.add(task);
            return true;
        }
    }

    public boolean removeTask(String task) {
        boolean isRemoved = false;
        if (!(tasks.isEmpty())) {
            isRemoved = tasks.removeIf(task::equals);
        }
        return isRemoved;
    }

    public String getAllTasks() {
        return String.join(" ", tasks);
    }

}
