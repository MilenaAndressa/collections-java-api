import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    List<Integer> numerosInteirosList;

    public SomaNumeros() {
        this.numerosInteirosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numerosInteirosList.add(numero);
    }

    public int calcularSoma(){
        int resultado = 0;

        if (!numerosInteirosList.isEmpty()){
            for (Integer numero : numerosInteirosList){
                resultado += numero;
            }
        }
        return resultado;
    }

    public int encontraMaiorNumero(){
        int maiorNumero = Integer.MIN_VALUE;
        if (!numerosInteirosList.isEmpty()){
            for (int numero : numerosInteirosList){
                if (numero > maiorNumero){
                    maiorNumero = numero;
                }
            }
            return maiorNumero;
        }else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public int encontraMenorNumero(){
        int menorNumero = Integer.MAX_VALUE;
        if(!numerosInteirosList.isEmpty()) {
            for (int numero : numerosInteirosList) {
                if (numero < menorNumero) {
                    menorNumero = numero;
                }
            }
            return menorNumero;
        }else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void exibirNumeros(){
        if (!numerosInteirosList.isEmpty()) {
            for (int i = 0; i < numerosInteirosList.size(); i++) {
                System.out.printf("Posição %d: %d\n", i, numerosInteirosList.get(i));
            }
        }else{
            System.out.println("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(1000);
        somaNumeros.adicionarNumero(-100);
        somaNumeros.adicionarNumero(87);
        somaNumeros.adicionarNumero(1);

        somaNumeros.exibirNumeros();

        System.out.println("A soma de todos os números é igual a " + somaNumeros.calcularSoma());
        System.out.println("O maior número da lista é " + somaNumeros.encontraMaiorNumero());
        System.out.println("O menor número da lista é " + somaNumeros.encontraMenorNumero());

    }
}
