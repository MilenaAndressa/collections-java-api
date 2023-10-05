package map.OperacoesBasicas.agenda_contatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String,Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome,telefone);
    }

    public void removerContato(String nome){
        if (!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }else{
            System.out.println("O map está vazio.");
        }
    }

    public void exibirContato(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        if (!agendaContatoMap.isEmpty()){
            return agendaContatoMap.get(nome);
        }else{
            throw new RuntimeException("O map está vazio.");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Milena", 61986768);
        agendaContatos.adicionarContato("Mila", 613958698);
        agendaContatos.adicionarContato("Pai", 615453647);
        agendaContatos.adicionarContato("Milena Andressa", 84758473);

        //put serve tanto para adicionar, quanto para atualizar as informações, pois ele guarda o útlimo valor adicionado

        agendaContatos.exibirContato();

        agendaContatos.removerContato("Mila");
        agendaContatos.exibirContato();

        System.out.println(agendaContatos.pesquisarPorNome("Milena Andressa"));
    }
}
