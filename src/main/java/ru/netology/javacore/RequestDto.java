package ru.netology.javacore;

public class RequestDto {

    private String type;
    private String task;

    public RequestDto(String type, String task) {
        this.type = type;
        this.task = task;
    }

    public RequestDto() {

    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean processingRequest(Todos todos) {
        boolean isProcessed = false;
        if (type.equals("ADD")) {
            isProcessed = todos.addTask(task);
        } else if (type.equals("REMOVE")) {
            isProcessed = todos.removeTask(task);
        }
        return isProcessed;
    }
}
