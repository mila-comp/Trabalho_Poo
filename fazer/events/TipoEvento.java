package events;

import java.io.Serializable;


public enum TipoEvento implements Serializable {
    ANIVERSARIO("Aniversário"),
    REUNIAO("Reunião"),
    COMPROMISSO("Compromisso"),
    FERIADO("Feriado"),
    LEMBRETE("Lembrete"),
    OUTRO("Outro");

    private final String descricao;

    TipoEvento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
