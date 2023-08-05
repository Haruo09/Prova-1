package project.classes;

public class Gato {
    private final int ID;
    private String nomeGato;
    private String nomeDono;

    public Gato() {
        this.ID = 0;
        this.nomeGato = "";
        this.nomeDono = "";
    }

    public Gato(int ID, String nomeGato, String nomeDono) {
        this.ID = ID;
        this.nomeGato = nomeGato;
        this.nomeDono = nomeDono;
    }

    public String toString() {
        return String.format(
            """
            ID: %d
            Nome: %s
            Dono: %s
            """,
            this.ID, this.nomeGato, this.nomeDono
        );
    }

    public int getID() {
        return ID;
    }

    public String getNomeGato() {
        return nomeGato;
    }

    public void setNomeGato(String nomeGato) {
        this.nomeGato = nomeGato;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }
}
