package arquivo;

import events.Evento;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CriarArquivo {
    public static void criar(){
        Scanner entrada = new Scanner(System.in);
        String texto;

        System.out.println("Digite qual o evento: ");
        String nome = entrada.nextLine();
        System.out.println("Qual o dia, mês e ano do evento? ");
        int dia = entrada.nextInt();
        int mes = entrada.nextInt();
        int ano = entrada.nextInt();

        Evento evento = new Evento(nome, dia, mes, ano);

        //entrada.nextLine(); // Limpa o buffer (ENTER) - não precisou até o momento

        try{
            FileWriter arq = new FileWriter("testeCalendario.txt", true); //Modo append (true) pra adicionar ao final do arquivo
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(evento.toString()); //escreve a linha do texto no arquivo
            gravarArq.close(); //fecha o arquivo para garantir a gravação
            System.out.println("Texto gravado com sucesso!");
        } catch(
                IOException e)

        {
            System.err.format("Erro de E/S: %s%n", e);
        }

        System.out.println("Deseja limpar o arquivo agora ou encerrar o programa? (1- limpar, 2- encerrar)");
        int ans = entrada.nextInt();

        if(ans == 1){
            LimparArquivo.limparArquivo();
        } else if(ans == 2){
            System.out.println("Encerrando o programa...");
            entrada.close(); // Fecha o Scanner
        } else{
            System.out.println("Digitou errado, fechando o programa por precaução...");
            entrada.close();
        }


    }

}
/* OUTRA OPÇÃO *
        System.out.println("Digite o texto que deseja gravar no arquivo:"); //vai ser usado LER NO TERMINAL
        String texto = entrada.nextLine(); //Lê o texto digitado no terminal

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("texto");
            //writer.nextLine();
            /*gerarMatrizConsumo(writer);
            writer.newLine();

            gerarMaiorConsumo(writer);
            writer.newLine();

            gerarMenorConsumo(writer);
            writer.newLine();

            gerarTotalAnual(writer);
            writer.newLine();

            gerarMediaMensal(writer);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter arq = new FileWriter("teste.txt", true); //Modo append (true) pra adicionar ao final do arquivo
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto); //escreve a linha do texto no arquivo
            gravarArq.close(); //fecha o arquivo para garantir a gravação
            System.out.println("Texto gravado com sucesso!");
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

        LimparArquivo.limparArquivo();

        System.out.println("Encerrando o programa...");


        entrada.close(); // Fecha o Scanner
        */
