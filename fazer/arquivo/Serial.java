package arquivo;

import java.io.Serializable;

public class Serial implements Serializable {
    private int dados;

    public Serial(int dados){
        this.dados = dados;
    }

    public int getDados() {
        return dados;
    }

    public void setDados(int dados) {
        this.dados = dados;
    }
}
