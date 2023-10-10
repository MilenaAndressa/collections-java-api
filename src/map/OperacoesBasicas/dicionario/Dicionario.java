package map.OperacoesBasicas.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<String,String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionarioMap.put(palavra,definicao);
    }

    public void removerPalavra(String palavra){
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        }else{
            System.out.println("O map está vazio.");
        }
    }

    public void exibirPalavras(){
        if (!dicionarioMap.isEmpty()){
            System.out.println(dicionarioMap);
        }else{
            System.out.println("O map está vazio.");
        }
    }

    public String pesquisarPorPalavra(String palavra){
        String definicao = null;
        if (!dicionarioMap.isEmpty()){
            for (Map.Entry<String, String> entry: dicionarioMap.entrySet()){
                if (entry.getKey().equalsIgnoreCase(palavra)){
                    definicao = entry.getValue();
                    break;
                }
            }

            if (definicao == null){
                return "A palavra não foi encontrada.";
            }else{
                return definicao;
            }
        }else{
            throw new RuntimeException("O map está vazio.");
        }
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("Typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("Kotlin", "Linguagem moderna de programação para a JVM.");

        dicionario.exibirPalavras();

        System.out.println(dicionario.pesquisarPorPalavra("Java"));
        System.out.println(dicionario.pesquisarPorPalavra("kotlin"));
        System.out.println(dicionario.pesquisarPorPalavra("Collection"));

        dicionario.removerPalavra("Typescript");

        dicionario.exibirPalavras();
    }
}
