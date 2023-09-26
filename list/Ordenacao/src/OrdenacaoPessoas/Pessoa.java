package OrdenacaoPessoas;

import java.util.Comparator;

//O Comparable modifica a classe, então basta implementá-lo e criar a forma de ordenação
public class Pessoa implements Comparable<Pessoa>{
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return Integer.compare(idade, pessoa.getIdade());
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "OrdenacaoPessoas.Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }
}


//Para utilizar o Comparator, deve-se criar uma classe separada
class ComparatorPorAltura implements Comparator<Pessoa>{
    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}
