package set.PesquisaSet.agenda_contatos;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    //atributo
    Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numeroTelefone){
        contatoSet.add(new Contato(nome, numeroTelefone));
    }

    public void exibirContatos(){
        if (!contatoSet.isEmpty()) {
            System.out.println(contatoSet);
        }else{
            System.out.println("A lista está vazia.");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        if (!contatoSet.isEmpty()) {
            for (Contato contato : contatoSet) {
                // '.startsWith' serve para qualquer coisa que comece com o que está
                // dentro do parâmetro.
                if (contato.getNome().startsWith(nome)) {
                    contatosPorNome.add(contato);
                }
            }
            return contatosPorNome;
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public Contato atualizarNumeroContato(String nome, int numeroTelefoneAtualizado){
        Contato contatoAtualizado = null;

        if (!contatoSet.isEmpty()) {
            for (Contato contato : contatoSet) {
                if (contato.getNome().equalsIgnoreCase(nome)) {
                    contato.setNomeroTelefone(numeroTelefoneAtualizado);
                    contatoAtualizado = contato;
                    break;
                }
            }

            return contatoAtualizado;

        }else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Milena", 34867847);
        agendaContatos.adicionarContato("Milena Claro", 34757846);
        agendaContatos.adicionarContato("Alberto", 34898009);
        agendaContatos.adicionarContato("Alberto", 99847564);
        agendaContatos.adicionarContato("Elena", 86739857);

        agendaContatos.exibirContatos();

        System.out.println("Lista de contatos com o nome Milena:\n" + agendaContatos.pesquisarPorNome("Milena"));

        System.out.println("Atualizando contato do Alberto:\n" + agendaContatos.atualizarNumeroContato("Alberto", 96742625));
        System.out.println("Atualizando contato do Eduardo:\n" + agendaContatos.atualizarNumeroContato("Eduardo", 84776362));

    }
}
