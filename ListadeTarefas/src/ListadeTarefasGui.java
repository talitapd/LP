package ListadeTarefas;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ListadeTarefasGui extends JFrame {

    ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

    private JPanel painel = new JPanel();
    private JButton botao1 = new JButton("Adicionar Tarefa");
    private JButton botao2 = new JButton("Remover Tarefa");
    private JButton botao3 = new JButton("Listar Tarefas");
    private JButton botao4 = new JButton("Sair");

    public ListadeTarefasGui() {
        this.setTitle("LISTA DE TAREFAS");
        this.setSize(400, 205);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 15));
        painel.setBackground(new Color(255, 255, 255));
        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTarefa();
            }
        });
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTarefa();
            }
        });
        botao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraTarefas();
            }
        });
        botao4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTarefasJson();
                sair();

            }
        });
        painel.add(botao1);
        painel.add(botao2);
        painel.add(botao3);
        painel.add(botao4);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void addTarefasJson() {
        Gson gson = new Gson();
        String json = gson.toJson(tarefas);
        try (FileWriter writer = new FileWriter("tarefas.json")) {
            writer.write(json);
            System.out.println("Arquivo json gravado com sucesso");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Carregue as tarefas do arquivo JSON e atualize sua lista
        try (BufferedReader br = new BufferedReader(new FileReader("tarefas.json"))) {
            ArrayList<Tarefa> tarefasJson = new ArrayList<Tarefa>();
            tarefasJson = gson.fromJson(br, ArrayList.class);
            System.out.println("Tarefas lidas do JSON: " + tarefasJson.toString());
            br.close();
        } catch (IOException e) {
            // Lida com erros de leitura do arquivo JSON
        }
    }


    private void addTarefa() {
        try {
            String descricao = JOptionPane.showInputDialog(null, "Digite a tarefa a ser adicionada:", "LISTA DE TAREFAS", JOptionPane.INFORMATION_MESSAGE);
            if (descricao != null && !descricao.isEmpty()) {
                Tarefa novaTarefa = new Tarefa(descricao);
                tarefas.add(novaTarefa);
                JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso.", "LISTA DE TAREFAS", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Tarefa foi digitada.", "LISTA DE TAREFAS", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR TAREFA", "LISTA DE TAREFA", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeTarefa() {
        int opcao = 0;
        do {
            if (tarefas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "A lista de tarefas está vazia.", "LISTA DE TAREFAS", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o índice da tarefa a ser removida: ", "LISTA DE TAREFAS", JOptionPane.INFORMATION_MESSAGE));
                if (indice >= 0 && indice < tarefas.size()) {
                    String tarefasSelecionada = tarefas.get(indice).toString();
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Você tem certeza de que deseja remover a tarefa selecionada? \n\nTarefa:  " + tarefasSelecionada, "CONFIRMAR REMOÇÃO", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        tarefas.remove(indice);
                        JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso.", "LISTA DE TAREFAS", JOptionPane.WARNING_MESSAGE);
                        opcao = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Remoção cancelada pelo usuário.", "LISTA DE TAREFAS", JOptionPane.INFORMATION_MESSAGE);
                        opcao = 1;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Índice inválido. Por favor, insira um índice válido.", "LISTA DE TAREFAS", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Indice INVÁLIDO", "LISTA DE TAREFAS", JOptionPane.ERROR_MESSAGE);
            }
        }while (opcao == 0);
    }
    private void mostraTarefas() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de tarefas está vazia.", "LISTA DE TAREFAS", JOptionPane.WARNING_MESSAGE);
            return;
        }
            String mostraTarefa= "";
            for (Tarefa descricao : tarefas) {
                mostraTarefa += descricao + "\n";
            }
        JOptionPane.showMessageDialog(null, mostraTarefa, "LISTA DE TAREFAS", JOptionPane.INFORMATION_MESSAGE);
        }
        private void sair() {
            dispose();
        }

    public static void main(String[] args) {
        new ListadeTarefasGui();
    }
}


