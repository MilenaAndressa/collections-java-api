package map.OrdenacaoMap.livraria_online;

import java.util.*;

public class LivrariaOnline {
    Map<String,Livro> livrariaOnlineMap;

    public LivrariaOnline() {
        this.livrariaOnlineMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livrariaOnlineMap.put(link, new Livro(titulo,autor,preco));
    }

    public void removerLivro(String titulo){
        List<String> chaveDeLivrosParaRemover = null;
        if (!livrariaOnlineMap.isEmpty()){
            for (Map.Entry<String,Livro> entry : livrariaOnlineMap.entrySet()){
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    chaveDeLivrosParaRemover.add(entry.getKey());
                }
            }

            if (!chaveDeLivrosParaRemover.isEmpty()){
                livrariaOnlineMap.remove(chaveDeLivrosParaRemover);
                System.out.println("Livro removido com sucesso.");
            }else{
                System.out.println("Não foi encontrado livros com este título.");
            }

        }else{
            System.out.println("Livraria online não possui livros para ser removidos.");
        }
    }

    public Map<String,Livro> exibirLivrosOrdenadosPorPreco(){
        if (!livrariaOnlineMap.isEmpty()){
            List<Map.Entry<String,Livro>> livrosOrdenadosPorPreco = new ArrayList<>(livrariaOnlineMap.entrySet());

            //organizando em ordem por preço
            Collections.sort(livrosOrdenadosPorPreco,new ComparatorPorPreco());

            //Passando para um map
            Map<String,Livro> livrosOrdenadosPorPrecoMap = new LinkedHashMap<>();

            for (Map.Entry<String,Livro> entry : livrosOrdenadosPorPreco){
                livrosOrdenadosPorPrecoMap.put(entry.getKey(),entry.getValue());
            }
            return livrosOrdenadosPorPrecoMap;
        }else{
            throw new RuntimeException("A livraria está vazia.");
        }
    }


    public Map<String, Livro> pesquisaLivrosPorAutor(String autor){
        if (!livrariaOnlineMap.isEmpty()){
            Map<String,Livro> livrosPorAutor = new TreeMap<>();
            for (Map.Entry<String,Livro> entry : livrariaOnlineMap.entrySet()){
                if (entry.getValue().getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.put(entry.getKey(),entry.getValue());
                }
            }
            return livrosPorAutor;
        }else{
            throw new RuntimeException("A livraria está vazia.");
        }
        /*if (!livrariaOnlineMap.isEmpty()) {
            List<Livro> livrosPorAutor = new ArrayList<>();
            for (Livro livro : livrariaOnlineMap.values()) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(livro);
                }
            }
            return livrosPorAutor;
        }else{
            throw new RuntimeException("A livraria está vazia.");
        }
         */
    }

    public List<Livro> obterLivroMaisCaro(){
        if (!livrariaOnlineMap.isEmpty()) {
            List<Livro> livrosMaisCaro = new ArrayList<>();
            double precoMaisCaro = Double.MIN_VALUE;

            for (Livro livro : livrariaOnlineMap.values()){
                if (livro.getPreco() >= precoMaisCaro){
                    precoMaisCaro = livro.getPreco();
                }
            }
            for (Livro livro : livrariaOnlineMap.values()){
                if (livro.getPreco() >= precoMaisCaro){
                    livrosMaisCaro.add(livro);
                }
            }
            return livrosMaisCaro;
        }else{
            throw new RuntimeException("A livraria online está sem livros.");
        }
    }

    public List<Livro> exibirLivroMaisBarato(){
        if (!livrariaOnlineMap.isEmpty()) {
            List<Livro> livrosMaisBaratos = new ArrayList<>();
            double precoMaisBarato = Double.MAX_VALUE;

            for (Livro livro : livrariaOnlineMap.values()){
                if (livro.getPreco() < precoMaisBarato){
                    precoMaisBarato = livro.getPreco();
                }
            }

            for (Livro livro : livrariaOnlineMap.values()){
                if (livro.getPreco() <= precoMaisBarato){
                    livrosMaisBaratos.add(livro);
                }
            }

            return livrosMaisBaratos;
        }else{
            throw new RuntimeException("A livraria online está sem livros.");
        }
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z","1984", "George Orwell", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05d);
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6","Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5d);
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5d);

        //System.out.println(livrariaOnline.obterLivroMaisCaro());
        //System.out.println(livrariaOnline.exibirLivroMaisBarato());
        //System.out.println(livrariaOnline.pesquisaLivrosPorAutor("George Orwell"));

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
    }
}
