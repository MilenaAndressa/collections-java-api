package set.OrdenacaoSet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(nome,codigo,preco,quantidade));
    }

    public Set<Produto> exibirProdutoPorNome(){
        //TreeSet utilizado para organizar também
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet); //queremos organizado
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutoPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }
    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(104, "Fone de Ouvido", 25, 5);
        cadastroProdutos.adicionarProduto(3155, "Fone de Ouvido", 15, 5);
        cadastroProdutos.adicionarProduto(6013, "Cabo V8", 15, 5);
        cadastroProdutos.adicionarProduto(01, "Cabo TC", 15, 5);

        System.out.println(cadastroProdutos.produtoSet);

        System.out.println(cadastroProdutos.exibirProdutoPorNome());
        System.out.println(cadastroProdutos.exibirProdutoPorPreco());
    }
}
