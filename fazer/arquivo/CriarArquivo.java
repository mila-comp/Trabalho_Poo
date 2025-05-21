package arquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CriarArquivo {
    public void criar(){
        Scanner entrada = new Scanner(System.in);
        String texto;


        System.out.println("\nDigite:");
        texto = entrada.nextLine(); //só para teste, pode ser mudado
        entrada.nextLine(); // Limpa o buffer (ENTER)

        try{
            FileWriter arq = new FileWriter("testeCalendario.txt", true); //Modo append (true) pra adicionar ao final do arquivo
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto); //escreve a linha do texto no arquivo
            gravarArq.close(); //fecha o arquivo para garantir a gravação
            System.out.println("Texto gravado com sucesso!");
        } catch(
                IOException e)

        {
            System.err.format("Erro de E/S: %s%n", e);
        }

        LimparArquivo.limparArquivo();

        System.out.println("Encerrando o programa...");


        entrada.close(); // Fecha o Scanner

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
