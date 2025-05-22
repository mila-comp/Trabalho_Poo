package events;

import java.io.Serializable;

public class Evento implements events, Serializable {
    private static final long serialVersionUID = 1L;
    private String evento;
    private int dia;
    private int mes;
    private int ano;
    private TipoEvento tipoEvento;

    public Evento(String evento, int dia, int mes, int ano) {
        this.evento = evento;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.tipoEvento = TipoEvento.OUTRO; // Tipo padrão
    }

    public Evento(String evento, int dia, int mes, int ano, TipoEvento tipoEvento) {
        this.evento = evento;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.tipoEvento = tipoEvento;
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
    public int getMes() {
        return mes;
    }

    @Override
    public int getAno() {
        return ano;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public String toString() {
        return "Evento: " + this.evento + " (" + this.tipoEvento + ")" +
               "\n Data : " + this.dia + "/" + this.mes + "/" + this.ano;
    }
}
