package set.PesquisaSet.agenda_contatos;

import java.util.Objects;

public class Contato {
    private String nome;
    private int nomeroTelefone;

    public Contato(String nome, int nomeroTelefone) {
        this.nome = nome;
        this.nomeroTelefone = nomeroTelefone;
    }

    public String getNome() {
        return nome;
    }

    public int getNomeroTelefone() {
        return nomeroTelefone;
    }

    public void setNomeroTelefone(int nomeroTelefone) {
        this.nomeroTelefone = nomeroTelefone;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", nomeroTelefone=" + nomeroTelefone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return Objects.equals(getNome(), contato.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

}
