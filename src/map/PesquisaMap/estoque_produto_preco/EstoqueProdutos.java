package map.PesquisaMap.estoque_produto_preco;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long,Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(codigo, new Produto(nome,preco,quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto produto : estoqueProdutosMap.values()){
                valorTotalEstoque += produto.getPreco() * produto.getQuantidade();
            }
            return valorTotalEstoque;
        }else{
            throw new RuntimeException("O map está vazio.");
        }
    }
    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueProdutosMap.isEmpty()){
            for (Produto produto : estoqueProdutosMap.values()){
                if (produto.getPreco() > maiorPreco){
                    maiorPreco = produto.getPreco();
                    produtoMaisCaro = produto;
                }
            }
            return produtoMaisCaro;
        }else{
            throw new RuntimeException("O map está vazio.");
        }
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        Double precoMaisBarato = Double.MAX_VALUE;

        if (!estoqueProdutosMap.isEmpty()){
            for (Produto produto : estoqueProdutosMap.values()){
                if (produto.getPreco() < precoMaisBarato){
                    precoMaisBarato = produto.getPreco();
                    produtoMaisBarato = produto;
                }
            }
            return produtoMaisBarato;
        }else{
            throw new RuntimeException("O map está vazio.");
        }
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoMaiorValorTotalEstoque = null;
        double maiorValorEstoque = Double.MIN_VALUE;
        double auxiliarValorTotalProduto = 0d;

        if (!estoqueProdutosMap.isEmpty()){
            for (Produto produto : estoqueProdutosMap.values()){
                auxiliarValorTotalProduto = produto.getPreco() * produto.getQuantidade();
                if (auxiliarValorTotalProduto > maiorValorEstoque){
                    maiorValorEstoque = auxiliarValorTotalProduto;
                    produtoMaiorValorTotalEstoque = produto;
                }
            }
            return produtoMaiorValorTotalEstoque;
        }else{
            throw new RuntimeException("O map está vazio.");
        }
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.exibirProdutos();

        estoque.adicionarProduto(1L, "Produto A", 10, 5.0);
        estoque.adicionarProduto(2L, "Produto B", 6, 10.0);
        estoque.adicionarProduto(3L, "Produto C", 2, 15.0);

        estoque.exibirProdutos();

        System.out.println(estoque.calcularValorTotalEstoque());
        System.out.println(estoque.obterProdutoMaisCaro());
        System.out.println(estoque.obterProdutoMaisBarato());
        System.out.println(estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}

