package arquivo;

import calendario.Calendar;
import events.Evento;
import events.TipoEvento;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class CriarArquivo {
    public static void criar(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite qual o evento: ");
        String nome = entrada.nextLine();

        System.out.println("Escolha o tipo de evento:");
        System.out.println("1 - Aniversário");
        System.out.println("2 - Reunião");
        System.out.println("3 - Compromisso");
        System.out.println("4 - Feriado");
        System.out.println("5 - Lembrete");
        System.out.println("6 - Outro");
        int tipoEscolhido = entrada.nextInt();
        entrada.nextLine(); // Limpa o buffer

        TipoEvento tipoEvento;
        switch (tipoEscolhido) {
            case 1:
                tipoEvento = TipoEvento.ANIVERSARIO;
                break;
            case 2:
                tipoEvento = TipoEvento.REUNIAO;
                break;
            case 3:
                tipoEvento = TipoEvento.COMPROMISSO;
                break;
            case 4:
                tipoEvento = TipoEvento.FERIADO;
                break;
            case 5:
                tipoEvento = TipoEvento.LEMBRETE;
                break;
            default:
                tipoEvento = TipoEvento.OUTRO;
                break;
        }

        System.out.println("Digite a data do evento (formato dd/MM/YYYY): ");
        String dataCompleta = entrada.nextLine();

        // Separando a data em dia, mês e ano
        String[] partesData = dataCompleta.split("/");
        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);

        Evento evento = new Evento(nome, dia, mes, ano, tipoEvento);

        // Salva o evento usando serialização
        SerializacaoEvento.salvarEvento(evento);

        // Também salva no arquivo de texto para compatibilidade
        try{
            FileWriter arq = new FileWriter("testeCalendario.txt", true); //Modo append (true) pra adicionar ao final do arquivo
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(evento.toString()); //escreve a linha do texto no arquivo
            gravarArq.close(); //fecha o arquivo para garantir a gravação
            System.out.println("Texto gravado com sucesso!");
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

        System.out.println("Deseja visualizar todos os eventos, limpar o arquivo ou encerrar o programa?");
        System.out.println("1- Ver eventos, 2- limpar, 3- encerrar");
        int ans = entrada.nextInt();

        if (ans == 1) {
            mostrarEventos();
            System.out.println("Pressione ENTER para continuar...");
            entrada.nextLine(); // Consome o enter anterior
            entrada.nextLine(); // Aguarda um ENTER do usuário
            criar(); // Volta ao menu principal
        } else if(ans == 2){
            LimparArquivo.limparArquivo();
            SerializacaoEvento.limparEventos(); // Também limpa os eventos serializados
        } else if(ans == 3){
            System.out.println("Encerrando o programa...");
            entrada.close(); // Fecha o Scanner
        } else{
            System.out.println("Digitou errado, fechando o programa por precaução...");
            entrada.close();
        }
    }

    private static void mostrarEventos() {
        List<Evento> eventos = SerializacaoEvento.carregarEventos();

        if (eventos.isEmpty()) {
            System.out.println("Não há eventos cadastrados.");
            return;
        }

        System.out.println("\n===== EVENTOS CADASTRADOS =====");
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            System.out.println("Evento #" + (i+1) + ":");
            System.out.println("Nome: " + evento.getEvento());
            System.out.println("Tipo: " + evento.getTipoEvento().getDescricao());
            System.out.println("Data: " + evento.getDia() + "/" + evento.getMes() + "/" + evento.getAno());
            System.out.println("---------------------------");
        }
    }
}

