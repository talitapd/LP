import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Random sortear = new Random();
        int menu;

        do {
            System.out.println("************************** \n");
            System.out.println("Menu LOTOFÁCIL: \n");
            System.out.println("1) Apostar de 0 a 100 \n");
            System.out.println("2) Apostar de A à Z \n");
            System.out.println("3) Apostar em par ou ímpar \n");
            System.out.println("0) Sair \n");
            System.out.println("************************** \n");

            menu = ler.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Apostando de 0 a 100");
                    int num;
                    int random;
                    System.out.println("Digite um numero entre 0-100: \n");
                    num = ler.nextInt();
                    random = sortear.nextInt(101);
                    if (num >= 0 && num <= 100) {
                        if (num == random) {
                            System.out.println("Você ganhou R$ 1.000,00 reais. \n");
                        } else {
                            System.out.println("Que pena! O número sorteado foi:" + random);
                        }
                    } else {
                        System.out.println("Número inválido!!");
                    }
                    break;
                case 2:
                    System.out.println("Apostando de A à Z");
                    int lerLetra;
                    System.out.println("Digite uma letra: \n");

                    try {
                        lerLetra = System.in.read();
                        char letra = (char) lerLetra;
                        char letraMaiuscula = Character.toUpperCase(letra);
                        char letraPremiada = 'G';
                        if (Character.isLetter(letraMaiuscula)) {
                            if (letraPremiada == letraMaiuscula){
                                System.out.println("Você ganhou R$ 500,00 reais.");
                            } else {
                                System.out.println("Que pena! A letra sorteada foi: " + letraPremiada);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Apostando em par ou ímpar \n");
                    System.out.println("Digite um numero Inteiro: \n");
                    int numeroInteiro = ler.nextInt();
                    int resultado;
                    resultado = numeroInteiro % 2;
                    if(resultado == 0){
                        System.out.println("Você ganhou R$ 100,00 reais.");
                    }else {
                        System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (menu != 0);

        ler.close();
    }
}
