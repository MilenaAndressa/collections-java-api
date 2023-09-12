import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {//representando carrinho de compras online

    //Criando lista de ITENS para o carrinho de compras
    List<Item> listaItens;

    //sempre que for criado um construtor, já terá uma lista de itens vazia pronta para ser preenchida.
    public CarrinhoDeCompras() {
        this.listaItens = new ArrayList<>();
    }

    //adicionar item ao carrinho
    public void adicionarItem(String nome, double preco, int quantidade){
        listaItens.add(new Item(nome,preco,quantidade));
    }

    //remover item do carrinho com base no nome do item
    public void removerItem(String nome){
        /* Como em uma lista podem haver nomes repetidos, pode ser feito
        uma lista de item para ser removido, para daí remover do principal
         */
        List<Item> itensParaRemover = new ArrayList<>();
        if(!listaItens.isEmpty()) {
            for (Item itemParaRemover : listaItens) {
                if (itemParaRemover.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(itemParaRemover);
                }
            }
            //remover toda a lista
            listaItens.removeAll(itensParaRemover);
        }else{
            System.out.println("Lista Vazia.");
        }
    }

    public double calcularValorTotal(){
        double total = 0;
        if (!listaItens.isEmpty()){
            for(Item itensNoCarrinho : listaItens){
                total += (itensNoCarrinho.getPreco() * itensNoCarrinho.getQuantidade());
            }
        }else{
            System.out.println("Lista Vazia.");
        }
        return total;
    }

    public void exibirItens(){
        if (!listaItens.isEmpty()){
            for (Item item : listaItens) {
                System.out.println("NOME: " + item.getNome() + "\nPREÇO: " + item.getPreco() + "\nQUANTIDADE: " + item.getQuantidade() + ".\n");
            }
        }else{
            System.out.println("Lista Vazia.");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        System.out.println("TOTAL DO CARRINHO: " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.removerItem("arroz");
        carrinhoDeCompras.exibirItens();
    }
}
