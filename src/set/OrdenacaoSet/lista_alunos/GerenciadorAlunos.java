package set.OrdenacaoSet.lista_alunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, String matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(String matricula){
        Aluno alunoRemover = null;

        if (!alunoSet.isEmpty()){
            for (Aluno aluno : alunoSet){
                if (aluno.getMatricula().equalsIgnoreCase(matricula)){
                    alunoRemover = aluno;
                    break;
                }
            }

            if (alunoRemover != null){
                alunoSet.remove(alunoRemover);
                System.out.println("Aluno removido com sucesso.");
            }else{
                System.out.println("Não foi encontrado esta matricula.");
            }
        }else{
            System.out.println("A lista está vazia.");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        if (!alunoSet.isEmpty()){
            //utilizando o Comparable
            Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet); //treeSet já organiza da forma correta
            return alunosPorNome;
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public Set<Aluno> exibirAlunosPorNota(){
        if (!alunoSet.isEmpty()){
            //atilizando o Comparator
            Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
            alunosPorNota.addAll(alunoSet);
            return alunosPorNota;
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }
    public void exibirAlunos(){
        if (!alunoSet.isEmpty()){
            System.out.println(alunoSet);
        }else{
            System.out.println("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Milena", "150016881", 9.8);
        gerenciadorAlunos.adicionarAluno("Alberto", "150018274", 9.1);
        gerenciadorAlunos.adicionarAluno("Elena", "190184775", 9.9);
        gerenciadorAlunos.adicionarAluno("Brunno", "140132649", 9.8);
        gerenciadorAlunos.adicionarAluno("Eduardo", "250019898", 9.5);
        gerenciadorAlunos.adicionarAluno("Paulo", "1501857898", 6.0);

        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.removerAluno("1501857898");
        gerenciadorAlunos.removerAluno("150016881");

        gerenciadorAlunos.exibirAlunos();

        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());


    }
}
