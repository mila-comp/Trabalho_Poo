package events;

import calendario.Calendar;

public interface events {
    //vai obrigar o usuário a colocar o evento que quer (ex.: aniversário, data, mes, ano)
    String getEvento(); //fala o nome do evento
    int getDia(); //qual dia vai ser
    int getMes(); //qual mes vai ser
    int getAno(); //qual ano vai ser
    TipoEvento getTipoEvento(); //retorna o tipo do evento
}
