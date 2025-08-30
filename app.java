package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        board.addTask("Aprender Git");
        board.addTask("Criar projeto de board de tarefas");
        board.showTasks();
    }
}

class Board {
    private List<String> tasks;

    public Board() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void showTasks() {
        System.out.println("Tarefas no Board:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }
}
