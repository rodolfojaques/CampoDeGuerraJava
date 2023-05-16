import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Tabuleiro table = new Tabuleiro();

        while (Tabuleiro.continuar){
            System.out.println("Entre com as posições x,y ou FIM para sair");
            String posicoesStr = entrada.nextLine();

            if (posicoesStr.equals("FIM"))break;

            String[] posicoes = posicoesStr.split(",");
            int x = Integer.parseInt(posicoes[0]);
            int y = Integer.parseInt(posicoes[1]);

            table.disparo(x,y);
        }
    }
}