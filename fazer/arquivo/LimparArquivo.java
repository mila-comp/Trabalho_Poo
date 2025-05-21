package arquivo;

import java.io.FileWriter;
import java.io.IOException;

public class LimparArquivo {
    public static void limparArquivo() {
        try {
            FileWriter arq = new FileWriter("teste.txt"); // Sem 'true' → sobrescreve
            arq.write(""); // Escreve nada, limpando o conteúdo
            arq.close();
            System.out.println("Arquivo limpo com sucesso!");
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }
    public static String tabuada(int numero) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("------ Tabuada do ").append(numero).append(" ------\n");
        for (int i = 1; i <= 10; i++) {
            resultado.append(numero).append(" x ").append(i)
                    .append(" = ").append(numero * i).append("\n");
        }
        return resultado.toString();
    }
}
