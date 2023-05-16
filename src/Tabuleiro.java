public class Tabuleiro {
    static public int[][] table;
    private String[] desenhos;
    static public boolean continuar;
    private int disparos;
    private double proximidade;

    public Peca[] pecas = new Peca[] {
            new Peca(),
            new Peca(),
            new Peca(),
            new Peca(),
            new Peca(),
    };
    private int inimigos = pecas.length;

    public Tabuleiro() {
        this.table = new int[10][10];
        this.desenhos = new String[] {" .    ", " X    ", " *    "};
        this.continuar = true;
        this.disparos = 20;
    }


    public void disparo(int x,int y){
        double distancia = 100;
        proximidade = distancia;
        double d1 = 0;

        for (Peca p: pecas) {

            if(p.isVivo()){
                d1 = p.tiro(x,y);
                if(d1<distancia){
                    distancia = d1;
                    proximidade = d1;
                }
            }
        }

        if (distancia > 0){
            disparos--;
            Tabuleiro.table[x][y] = 1;

        }
        else {
            disparos--;
            Tabuleiro.table[x][y] = 2;
            inimigos--;
            if(inimigos == 0) {
                System.out.println("  ////////////////////////////////////////////");
                System.out.println(" ////////////////   YOU WIN   ///////////////");
                System.out.println("////////////////////////////////////////////");
                Tabuleiro.continuar = false;

            };
        }

        if (disparos == 0){
            System.out.println("  ////////////////////////////////////////////");
            System.out.println(" ////////////////  GAME OVER  ///////////////");
            System.out.println("////////////////////////////////////////////");
            Tabuleiro.continuar = false;
        };

        if(Tabuleiro.continuar) criaTabuleiro();
    }


    public void criaTabuleiro(){
        System.out.println("=========================================================");
        System.out.println("distancia: " + proximidade);
        System.out.println("=========================================================\n");


        for (int i = 0; i < 10; i++) {
            String linha = "";
            for (int j = 0; j < 10; j++) {
                if(j == 9) {
                    linha += desenhos[table[i][j]] + "\n";
                }
                else {
                    linha += desenhos[table[i][j]];
                }
            }
            System.out.println(linha);
        }
        System.out.println("_________________________________________________________");
        System.out.println("Inimigos restantes: " + inimigos);
        System.out.println("Tiros restantes: " + disparos);
    }

}
