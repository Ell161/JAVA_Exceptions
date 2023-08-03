package Seminar3.Service;

import Seminar3.Model.Person;
import Seminar3.Model.ReadFileException;
import Seminar3.Model.SaveFileException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public void saveToFile(Person personData) throws SaveFileException {
        String filePath = personData.getLastName() + ".txt";
        try (PrintWriter pw = new PrintWriter(filePath)) {
            File file = new File(filePath);
            if (!file.exists()) file.createNewFile();
            String fileData = readFile(filePath);
            String userData = String.join(" ",
                    personData.getLastName(),
                    personData.getFirstName(),
                    personData.getPatronymic(),
                    personData.getBirthday(),
                    personData.getPhone(),
                    personData.getGender());
            if (fileData != null) {
                pw.write(fileData + "\n" + userData);
            } else pw.write(userData);
        } catch (IOException e) {
            throw new SaveFileException("Writing data to the file failed.", e);
        }
    }

    public String readFile(String filePath) throws ReadFileException {
        try {
            Charset charset = StandardCharsets.UTF_8;
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filePath), charset));
            return String.join("\n", lines);
        } catch (IOException e){
            throw new ReadFileException("Reading data from the file failed.", e);
        }
    }
}
