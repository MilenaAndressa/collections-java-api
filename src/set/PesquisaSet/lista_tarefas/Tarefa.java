package set.PesquisaSet.lista_tarefas;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean isTarefaConcluida;

    public Tarefa(String descricao, boolean isTarefaConcluida) {
        this.descricao = descricao;
        this.isTarefaConcluida = isTarefaConcluida;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", isTarefaConcluida=" + isTarefaConcluida +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescricao());
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isTarefaConcluida() {
        return isTarefaConcluida;
    }

    public void setTarefaConcluida(boolean tarefaConcluida) {
        isTarefaConcluida = tarefaConcluida;
    }
}
