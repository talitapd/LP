import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListadeTarefasGui extends JFrame {

    ArrayList<String> tarefas = new ArrayList<String>();

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


    private void addTarefa() {
        try {
            String tarefa = JOptionPane.showInputDialog(null, "Digite a tarefa a ser adicionada:", "LISTA DE TAREFAS", JOptionPane.INFORMATION_MESSAGE);
            if (tarefa != null && !tarefa.isEmpty()) {
                tarefas.add(tarefa);
                JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso.", "LISTA DE TAREFAS", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Tarefa foi digitada.", "LISTA DE TAREFAS", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR TAREFA", "LISTA DE TAREFA", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeTarefa() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de tarefas está vazia.", "LISTA DE TAREFAS", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o índice da tarefa a ser removida: ", "LISTA DE TAREFAS", JOptionPane.INFORMATION_MESSAGE));
            if (indice >= 0 && indice < tarefas.size()) {
                String tarefasSelecionada = tarefas.get(indice);
                int confirmacao = JOptionPane.showConfirmDialog(null, "Você tem certeza de que deseja remover a tarefa selecionada? \n\nTarefa:  " + tarefasSelecionada, "CONFIRMAR REMOÇÃO", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    tarefas.remove(indice);
                    JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso.", "LISTA DE TAREFAS", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Remoção cancelada pelo usuário.", "LISTA DE TAREFAS", JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                    JOptionPane.showMessageDialog(null, "Índice inválido. Por favor, insira um índice válido.", "LISTA DE TAREFAS", JOptionPane.ERROR_MESSAGE);
                }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Indice INVÁLIDO", "LISTA DE TAREFAS", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void mostraTarefas() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de tarefas está vazia.", "LISTA DE TAREFAS", JOptionPane.WARNING_MESSAGE);
            return;
        }
            String mostraTarefa= "";
            for (String tarefa : tarefas) {
                mostraTarefa += tarefa + "\n";
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


