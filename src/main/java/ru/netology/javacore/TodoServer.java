package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    //...
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        //...
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        System.out.println("Starting server at " + port + "...");
        //...
        try (ServerSocket serverSocket = new ServerSocket(8989)) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                        Scanner scanner = new Scanner(System.in)
                ) {
                    Gson gson = new Gson();
                    RequestDto dto = gson.fromJson(in.readLine(), RequestDto.class);
                    if (dto.getType().equals("RESTORE")) {
                        StackOfRequests.restoreDto(todos);
                    } else {
                        if (dto.processingRequest(todos)) StackOfRequests.saveRequest(dto);
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }


}
