package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    //Conjunto de convidados --- SET
    //atributo
    private Set<Convidado> convidadoSet;
    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidadoParaRemover = null;
        for(Convidado convidado : convidadoSet){
            if (convidado.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = convidado;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Milena", 01);
        conjuntoConvidados.adicionarConvidado("Milena", 02);
        conjuntoConvidados.adicionarConvidado("Brunno", 02);
        conjuntoConvidados.adicionarConvidado("Elena", 03);
        conjuntoConvidados.adicionarConvidado("Alberto", 04);

        conjuntoConvidados.removerConvidadoPorCodigoConvite(02);
        System.out.println(conjuntoConvidados.contarConvidados());
        conjuntoConvidados.exibirConvidados();
    }
}
