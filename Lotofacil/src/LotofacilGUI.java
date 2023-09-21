import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class LotofacilGUI extends JFrame{
    // Atributos
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");
    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");
    // Construtor
    public LotofacilGUI(){
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400,200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        painel.add(jButtonAposta1);
        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null,"Digite um número de 0 a 100");
                Random rnd = new Random();
                int sorteio = rnd.nextInt(101);
                int numeroApostado = Integer.parseInt(aposta);
                if(numeroApostado == sorteio){
                    JOptionPane.showMessageDialog(null,"Você ganhou milzão.");
                }else {
                    JOptionPane.showMessageDialog(null,"Você perdeu! o número sorteado foi: " + sorteio);
                }

            }
        });
        painel.add(jButtonAposta2);
        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta2 = JOptionPane.showInputDialog(null,"Digite um número de A a Z");
                char letraSorteada = 'T';
                char letraApostada = aposta2.charAt(0);
                if(Character.isLetter(letraApostada)){
                    char letraApostadaMaiusculo = Character.toUpperCase(letraApostada);
                    if(letraApostadaMaiusculo == letraSorteada){
                        JOptionPane.showMessageDialog(null,"Você ganhou quinhentão.\n");
                    }else {
                        JOptionPane.showMessageDialog(null,"Você perdeu! a letra sorteada foi: " + letraSorteada + "\n");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Não é uma letra válida.");
                }

            }
        });
        painel.add(jButtonAposta3);
        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta3 = JOptionPane.showInputDialog(null, "Digite um número ");
                int numeroDigitado = Integer.parseInt(aposta3);
                if(numeroDigitado % 2 == 0){
                    JOptionPane.showMessageDialog(null,"Você ganhou cenzão.");
                }else{
                    JOptionPane.showMessageDialog(null,"Você perdeu!");
                }
            }
        });
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela
    }
    public static void main(String[] args) {
        new LotofacilGUI();}
}
