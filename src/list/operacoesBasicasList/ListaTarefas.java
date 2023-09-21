package list.operacoesBasicasList;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefas> tarefasList;

    /* Construtor para sempre que for chamado o Objeto ListaTarefas
       já possui uma list vazia.
     */
    public ListaTarefas() {
        this.tarefasList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefasList.add(new Tarefas(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefas> tarefasPararemover = new ArrayList<>();
        for (Tarefas tarefa: tarefasList) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefasPararemover.add(tarefa);
            }
        }

        tarefasList.removeAll(tarefasPararemover);
    }

    public int obterNumeroTotalTarefas(){
        return tarefasList.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefasList);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 3");

        System.out.println(listaTarefas.obterNumeroTotalTarefas());

        listaTarefas.removerTarefa("Tarefa 1");

        System.out.println(listaTarefas.obterNumeroTotalTarefas());
        listaTarefas.obterDescricoesTarefas();
    }

}