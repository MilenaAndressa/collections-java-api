import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    List<Livro> livrosList;

    public CatalogoLivros() {
        this.livrosList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livrosList.add(new Livro(titulo,autor,anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();

        if (!livrosList.isEmpty()){
            for (Livro livro: livrosList){
                if (livro.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(livro);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisaPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorAno = new ArrayList<>();
        if (!livrosList.isEmpty()){
            for (Livro livro : livrosList){
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal){
                    livrosPorAno.add(livro);
                }
            }
        }
        return livrosPorAno;
    }

    public Livro pesquisaPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if (!livrosList.isEmpty()){
            for (Livro livro : livrosList){
                if (livro.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = livro;
                    break;
                }
            }
        }

        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro1", "Autor1", 1998);
        catalogoLivros.adicionarLivro("Livro1", "Autor2", 1997);
        catalogoLivros.adicionarLivro("Livro2", "Autor2", 2003);
        catalogoLivros.adicionarLivro("Livro3", "Autor3", 2006);
        catalogoLivros.adicionarLivro("Livro4", "Autor4", 2009);

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor4"));
        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(1997, 2004));
        System.out.println(catalogoLivros.pesquisaPorTitulo("Livro1"));
    }
}
