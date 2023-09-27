package set.OperacoesBasicas.conjunto_palavras_unicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    Set<String> palavraUnica;
    public ConjuntoPalavrasUnicas() {
        this.palavraUnica = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavraUnica.add(palavra);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConjuntoPalavrasUnicas that)) return false;
        return Objects.equals(palavraUnica, that.palavraUnica);
    }
    @Override
    public int hashCode() {
        return Objects.hash(palavraUnica);
    }

    public void removerPalavra(String palavra){
        //String palavraParaRemover = null;

        if (!palavraUnica.isEmpty()){
            /*for (String p : palavraUnica){
                if (p.equalsIgnoreCase(palavra)){
                    palavraParaRemover = p;
                    break;
                }
            }
            palavraUnica.remove(palavraParaRemover);*/

            if(palavraUnica.contains(palavra)){
                palavraUnica.remove(palavra);
            }else{
                System.out.println("A palavra não existe");
            }
        }else{
            System.out.println("A lista está vazia.");
        }
    }

    public boolean verificarPalavra(String palavra){
        //boolean palavraPresente = false;
        if (!palavraUnica.isEmpty()){
            /*for (String p : palavraUnica){
                if (p.equalsIgnoreCase(palavra)){
                    palavraPresente = true;
                    break;
                }
            }
            return palavraPresente;
             */

            return palavraUnica.contains(palavra);
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    @Override
    public String toString() {
        return "[" + palavraUnica + "]";
    }

    public void exibirPalavrasUnicas(){
        if (!palavraUnica.isEmpty()){
            System.out.println(palavraUnica);
        }else{
            System.out.println("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();
        conjuntoPalavrasUnicas.adicionarPalavra("Milena");
        conjuntoPalavrasUnicas.adicionarPalavra("Brunno");
        conjuntoPalavrasUnicas.adicionarPalavra("Alberto");
        conjuntoPalavrasUnicas.adicionarPalavra("Eduardo");
        conjuntoPalavrasUnicas.adicionarPalavra("Elena");
        conjuntoPalavrasUnicas.adicionarPalavra("Alberto");

        System.out.println(conjuntoPalavrasUnicas);

        System.out.println("Essa palavra existe na lista? " + conjuntoPalavrasUnicas.verificarPalavra("Margareth"));

        System.out.println(conjuntoPalavrasUnicas);

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("Milena");

    }
}
