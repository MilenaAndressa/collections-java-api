package OrdenacaoNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoNumero {
    List<Integer> inteiroList;
    public OrdenacaoNumero() {
        this.inteiroList = new ArrayList<>();
    }

    public void idicionarNumero(int numero){
        inteiroList.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        //copia da lista original
        List<Integer> listaAscendente = new ArrayList<>(inteiroList);

        if (!listaAscendente.isEmpty()){
            Collections.sort(listaAscendente);
            return listaAscendente;
        }else {
            throw new RuntimeException("Lista vazia.");
        }
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> listaDescendente = new ArrayList<>(inteiroList);

        if (!listaDescendente.isEmpty()){
            /*Collections.sort(listaDescendente);
            Collections.reverse(listaDescendente);*/
            listaDescendente.sort(Collections.reverseOrder());
            return listaDescendente;
        }else{
            throw new RuntimeException("Lista vazia.");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumero ordenacaoNumero = new OrdenacaoNumero();
        ordenacaoNumero.idicionarNumero(2);
        ordenacaoNumero.idicionarNumero(0);
        ordenacaoNumero.idicionarNumero(20);
        ordenacaoNumero.idicionarNumero(-1);
        ordenacaoNumero.idicionarNumero(5);

        System.out.println(ordenacaoNumero.inteiroList);
        System.out.println(ordenacaoNumero.ordenarAscendente());
        System.out.println(ordenacaoNumero.ordenarDescendente());
    }
}

