package arquivo;

import events.Evento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SerializacaoEvento {
    private static final String ARQUIVO_EVENTOS = "eventos.bin";


    public static void salvarEventos(List<Evento> eventos) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(ARQUIVO_EVENTOS))) {
            outputStream.writeObject(eventos);
            System.out.println("Eventos salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar eventos: " + e.getMessage());
        }
    }


    public static void salvarEvento(Evento evento) {
        List<Evento> eventos = carregarEventos();
        eventos.add(evento);
        salvarEventos(eventos);
    }


    @SuppressWarnings("unchecked")
    public static List<Evento> carregarEventos() {
        List<Evento> eventos = new ArrayList<>();

        File arquivo = new File(ARQUIVO_EVENTOS);
        if (!arquivo.exists()) {
            return eventos;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(ARQUIVO_EVENTOS))) {

            Object obj = inputStream.readObject();
            if (obj instanceof List<?>) {
                eventos = (List<Evento>) obj;
                System.out.println("Eventos carregados com sucesso!");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar eventos: " + e.getMessage());
        }

        return eventos;
    }


    public static void limparEventos() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(ARQUIVO_EVENTOS))) {
            outputStream.writeObject(new ArrayList<Evento>());
            System.out.println("Todos os eventos foram removidos!");
        } catch (IOException e) {
            System.err.println("Erro ao limpar eventos: " + e.getMessage());
        }
    }
}
