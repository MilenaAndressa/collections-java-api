package OrdenacaoPessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoaList;
    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenadoPorIdade(){
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura(){
        //duplicando esta lista
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        // tenho que passar o Comparator, caso não seja passado será feito por Comparable
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());

        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();
        ordenacaoPessoas.adicionarPessoa("Nome1", 20, 1.70);
        ordenacaoPessoas.adicionarPessoa("Nome2", 10, 1.65);
        ordenacaoPessoas.adicionarPessoa("Nome3", 2, 0.90);
        ordenacaoPessoas.adicionarPessoa("Nome4", 50, 1.57);

        System.out.println(ordenacaoPessoas.ordenadoPorIdade());
        System.out.println(ordenacaoPessoas.ordenarPorAltura());
        System.out.println(ordenacaoPessoas.pessoaList);
    }
}
