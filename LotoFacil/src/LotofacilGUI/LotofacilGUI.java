package LotofacilGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;
import javax.swing.*;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public class LotofacilGUI extends JFrame {
    // Atributos
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");

    // Construtor
    public LotofacilGUI() {

        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400, 200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));
        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta1();
            }
        });
        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta2();
            }
        });
        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta3();
            }
        });
        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela

    }

    private void aposta1() {

        ImageIcon icon = new ImageIcon("C:\\Users\\talit\\IdeaProjects\\LotoFacil\\src\\LotofacilGUI\\sorteio.png.png");
        JLabel label = new JLabel("Digite um número de 0 a 100:");
        label.setIcon(icon);
        String aposta = JOptionPane.showInputDialog(null,label, "Aposta 1", JOptionPane.PLAIN_MESSAGE);
        Random rnd = new Random();
        int sorteio = rnd.nextInt(101);
        int numeroApostado = Integer.parseInt(aposta);
        if (numeroApostado == sorteio) {
            JOptionPane.showMessageDialog(null, "Você ganhou milzão.",
                    "Aposta 1", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            JOptionPane.showMessageDialog(null, "Você perdeu! O número sorteado foi: " + sorteio,
                    "Aposta 1", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }

    private void aposta2() {

        String aposta2 = JOptionPane.showInputDialog(null, "Digite uma letra de A a Z");
        char letraSorteada = 'T';
        char letraApostada = aposta2.charAt(0);
        if (Character.isLetter(letraApostada)) {
            char letraApostadaMaiusculo = Character.toUpperCase(letraApostada);
            if (letraApostadaMaiusculo == letraSorteada) {
                JOptionPane.showMessageDialog(null, "Você ganhou quinhentão.\n");
            } else {
                JOptionPane.showMessageDialog(null, "Você perdeu! A letra sorteada foi: " + letraSorteada + "\n");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não é uma letra válida.");
        }
    }

    private void aposta3() {
        String aposta3 = JOptionPane.showInputDialog(null, "Digite um número ");
        int numeroDigitado = Integer.parseInt(aposta3);
        if (numeroDigitado % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Você ganhou cenzão.");
        } else {
            JOptionPane.showMessageDialog(null, "Você perdeu!");
        }
    }

    public static void main(String[] args) {
        new LotofacilGUI();
    }
}