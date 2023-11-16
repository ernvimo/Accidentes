public class Accidente {
    private int id;
    private int cod_coche1;
    private int cod_coche2;
    private int num_muertos;

    public Accidente(int id, int cod_coche1, int cod_coche2, int num_muertos) {
        this.id = id;
        this.cod_coche1 = cod_coche1;
        this.cod_coche2 = cod_coche2;
        this.num_muertos = num_muertos;
    }

    public Accidente() {

    }

    public int getId() {
        return id;
    }

    public int getCod_coche1() {
        return cod_coche1;
    }

    public int getCod_coche2() {
        return cod_coche2;
    }

    public int getNum_muertos() {
        return num_muertos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCod_coche1(int cod_coche1) {
        this.cod_coche1 = cod_coche1;
    }

    public void setCod_coche2(int cod_coche2) {
        this.cod_coche2 = cod_coche2;
    }

    public void setNum_muertos(int num_muertos) {
        this.num_muertos = num_muertos;
    }

    @Override
    public String toString() {
        return "Accidente{" +
                "id=" + id +
                ", cod_coche1=" + cod_coche1 +
                ", cod_coche2=" + cod_coche2 +
                ", num_muertos=" + num_muertos +
                '}';
    }
}
