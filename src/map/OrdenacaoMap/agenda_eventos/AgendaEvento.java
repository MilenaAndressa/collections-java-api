package map.OrdenacaoMap.agenda_eventos;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEvento {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEvento() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventoMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        /*Set<LocalDate> dataSet = eventoMap.keySet();
        Collection<Evento> values = eventoMap.values();
         */

        //Data atual
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        for (Map.Entry<LocalDate, Evento> entry : eventoTreeMap.entrySet()){
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O proximo evento: " + entry.getValue() + " acontecerá na data " + entry.getKey());
                break;
            }
        }
    }
    public static void main(String[] args) {
        AgendaEvento agendaEvento = new AgendaEvento();
        agendaEvento.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento 1", "Atração 1");
        agendaEvento.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento 2", "Atração 2");
        agendaEvento.adicionarEvento(LocalDate.of(2000, Month.JANUARY, 10), "Evento 3", "Atração 3");
        agendaEvento.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 05), "Evento 4", "Atração 4");
        agendaEvento.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 06), "Evento 5", "Atração 5");
        agendaEvento.adicionarEvento(LocalDate.of(2024, Month.SEPTEMBER, 20), "Evento 6", "Atração 6");

        agendaEvento.exibirAgenda();

        agendaEvento.obterProximoEvento();

    }
}
