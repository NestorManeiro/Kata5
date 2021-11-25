package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {

    public static List<String> read(String nameFile) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (line.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {
                    list.add(line);
                }

            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error MailHistogramReader::read (FileNotFoundException)" + exception);
        } catch (IOException exception) {
            System.out.println("Error MailHistogramReader::read (IOException)");
        }
        return list;
    }
}
