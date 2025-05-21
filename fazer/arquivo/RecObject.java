package arquivo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RecObject {

    Serial serial = new Serial(10);

    public RecObject(){}


    Path arq1 = Paths.get("calendar.bin");

    public void rec(Serial serial){
        try(ObjectOutputStream ork = new ObjectOutputStream(Files.newOutputStream(arq1))) {
            ork.writeObject(serial);
        }catch (IOException e){
            System.out.println("error not rec file" + e.getMessage());
        }
    }
}
