import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrimeiroPrjGUI extends Jframe {

    //Atributos
    private JPanel painel = new Jpanel ():
    private JButton jButtonLimpar = new JButton("Limpar");
    private JTextField jTextFieldTexto = new JtextField("Teste", 20);
    private JLabel jLabeMensagem = new Jlabel("Exemplo Simples de Janela");

    // Construtor

    public PrimeiroPrjGUI(){
        this.setTitle("Texto da Barra de Título");
        this.setSize(300,200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        painel.setBackground(new Color(255,255,255));
        painel.add(jTextFieldTexto);
        painel.add(jButtonLimpar);
        painel.add(jLabeMensagem);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar Janela
        this.setVisible(true); // exibir janela
    }

    public static void main(String [] args) {
        new PrimeiroPrjGUI();
    }
}
