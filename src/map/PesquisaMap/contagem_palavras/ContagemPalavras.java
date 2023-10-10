package map.PesquisaMap.contagem_palavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras() {
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavras(String palavra, Integer contagem){
        contagemPalavrasMap.put(palavra,contagem);
    }

    public void removerPalavra(String palavra){
        if (!contagemPalavrasMap.isEmpty()){
            contagemPalavrasMap.remove(palavra);
        }else{
            System.out.println("O map está vazio.");
        }
    }

    public void exibirContagemPalavras(){
        if (!contagemPalavrasMap.isEmpty()){
            int contagemTotalPalavras = 0;
            for (int contagem : contagemPalavrasMap.values()){
                contagemTotalPalavras += contagem;
            }

            System.out.println(contagemPalavrasMap);
            System.out.println("Contagem total = " + contagemTotalPalavras);

        }else{
            System.out.println("O map está vazio.");
        }
    }

    public String encontraPalavraMaisFrequente(){
        String palavraMaisFrequente = null;
        if (!contagemPalavrasMap.isEmpty()){
            int maisFrequente = Integer.MIN_VALUE;
            for (Map.Entry<String,Integer> entry : contagemPalavrasMap.entrySet()){
                if (entry.getValue() > maisFrequente){
                    maisFrequente = entry.getValue();
                    palavraMaisFrequente = entry.getKey() + " = " + entry.getValue();
                }
            }
            return palavraMaisFrequente;
        }else{
            throw new RuntimeException("O map está vazio.");
        }
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        contagemLinguagens.adicionarPalavras("Java", 2);
        contagemLinguagens.adicionarPalavras("Python", 8);
        contagemLinguagens.adicionarPalavras("JavaScript", 1);
        contagemLinguagens.adicionarPalavras("C#", 6);

        contagemLinguagens.exibirContagemPalavras();

        System.out.println(contagemLinguagens.encontraPalavraMaisFrequente());
    }
}
