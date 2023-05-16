import java.util.Random;

public class Peca {
    public int x;

    public int y;

    public boolean isVivo() {
        return vivo;
    }

    private boolean vivo;

    public Peca() {
        Random random = new Random();
        this.y = random.nextInt(10);
        this.x = random.nextInt(10);
        this.vivo = true;
    }

    public double tiro(int x, int y){
        double distancia = Math.sqrt((x - this.x) * (x - this.x) + (y- this.y) * (y - this.y));
        if(distancia == 0) this.vivo = false;
        return distancia;
    }

}
