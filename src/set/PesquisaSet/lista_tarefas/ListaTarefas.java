package set.PesquisaSet.lista_tarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao,false));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaRemover = null;
        if (!tarefaSet.isEmpty()){
            for (Tarefa tarefa: tarefaSet){
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaRemover = tarefa;
                    break;
                }
            }

            if (tarefaRemover != null){
                tarefaSet.remove(tarefaRemover);
                System.out.println("Tarefa removida com sucesso.");
            }else{
                System.out.println("Não existe esta tarefa na lista.");
            }

        }else{
            System.out.println("A lista está vazia.");
        }
    }

    public void exibirTarefas(){
        if (!tarefaSet.isEmpty()){
            System.out.println(tarefaSet);
        }else{
            System.out.println("A lista está vazia.");
        }
    }

    public int contarTarefas(){
        if (!tarefaSet.isEmpty()) {
            return tarefaSet.size();
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        if (!tarefaSet.isEmpty()){
            for (Tarefa tarefa : tarefaSet){
                if (tarefa.isTarefaConcluida() == true){
                    tarefasConcluidas.add(tarefa);
                }
            }
            return tarefasConcluidas;
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (!tarefaSet.isEmpty()){
            for (Tarefa tarefa : tarefaSet){
                if (tarefa.isTarefaConcluida() == false){
                    tarefasPendentes.add(tarefa);
                }
            }
            return tarefasPendentes;
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void marcarTarefaConcluida(String descricao){
        if (!tarefaSet.isEmpty()){
            for (Tarefa tarefa : tarefaSet){
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                    if (!tarefa.isTarefaConcluida()){
                        tarefa.setTarefaConcluida(true);
                    }
                    break;
                }
            }
        }else {
            System.out.println("A lista está vazia.");
        }
    }
    public void marcarTarefaPendente(String descricao){
        if (!tarefaSet.isEmpty()){
            for (Tarefa tarefa : tarefaSet){
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                    if (tarefa.isTarefaConcluida()){
                        tarefa.setTarefaConcluida(false);
                    }
                    break;
                }
            }
        }else {
            System.out.println("A lista está vazia.");
        }
    }

    public void limparListaTarefas(){
        Set<Tarefa> listaParaRemover = new HashSet<>(tarefaSet);
        if (!tarefaSet.isEmpty()){
            tarefaSet.removeAll(listaParaRemover);
            System.out.println("Lista removida com sucesso.");
        }else{
            System.out.println("Lista de tarefas já está vazia.");
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        listaTarefas.adicionarTarefa("Limpar a Casa");
        listaTarefas.adicionarTarefa("Lavar a roupa");
        listaTarefas.adicionarTarefa("Lavar a roupa");
        listaTarefas.adicionarTarefa("Lavar o banheiro");
        listaTarefas.adicionarTarefa("Lavar a louça");
        listaTarefas.adicionarTarefa("Tirar poeira dos móveis");
        listaTarefas.adicionarTarefa("Arrumar as camas");

        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("Arrumar as camas");

        listaTarefas.exibirTarefas();

        System.out.println(listaTarefas.contarTarefas());

        listaTarefas.marcarTarefaConcluida("Lavar a louça");
        listaTarefas.marcarTarefaConcluida("Limpar a Casa");
        listaTarefas.marcarTarefaConcluida("Lavar a roupa");

        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaPendente("Lavar a roupa");

        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.limparListaTarefas();


    }
}
