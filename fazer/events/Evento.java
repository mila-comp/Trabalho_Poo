package events;

import calendario.Calendar;

public class Evento implements events {
    private String evento;
    private int dia;
    private Calendar mes;
    private int ano;

    public Evento(String evento, int dia, Calendar mes, int ano) {
        this.evento = evento;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    @Override
    public String getEvento() {
        return evento;
    }

    @Override
    public int getDia() {
        return dia;
    }

    @Override
    public Calendar getMes() {
        return mes;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Evento: " + this.evento + "\n Data : " + this.dia + "/" + this.mes + "/" + this.ano;
    }

}
