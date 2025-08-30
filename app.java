package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== BOARD DE TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Remover tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    board.addTask(descricao);
                }
                case 2 -> board.showTasks();
                case 3 -> {
                    System.out.print("Digite o número da tarefa para remover: ");
                    int index = scanner.nextInt();
                    board.removeTask(index);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

class Board {
    private List<String> tasks;

    public Board() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Tarefa adicionada!");
    }

    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }
        System.out.println("\nTarefas:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + " - " + tasks.get(i));
        }
    }

    public void removeTask(int index) {
        if (index > 0 && index <= tasks.size()) {
            String removed = tasks.remove(index - 1);
            System.out.println("Tarefa removida: " + removed);
        } else {
            System.out.println("Número inválido!");
        }
    }
}
