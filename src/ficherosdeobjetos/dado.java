package ficherosdeobjetos;

import java.io.Serializable;

public class dado implements Serializable {
    public static final int CARAS = 6;
    private int tirada;

    public dado(int tirada) {
        this.tirada = tirada;
    }

    public int getTirada() {
        return tirada;
    }

    public void setTirada(int tirada) {
        this.tirada = tirada;
    }


}
