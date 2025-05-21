package leitor_register;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class register {

    public void gerarRelatorio(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Calendario");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

