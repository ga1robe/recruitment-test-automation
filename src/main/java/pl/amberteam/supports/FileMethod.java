package pl.amberteam.supports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMethod {
    private static File file;
    private static FileWriter writer;

    public static String generateAndGetCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
        Date date = new Date();
        return dateFormat.format(date).replace(" ", "_");
    }

    public static void createFile(){
        File directory = new File("." + File.separator + "AmberTeamTestsResults");
        if (! directory.exists()){
            directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
        file = new File(directory + File.separator + generateAndGetCurrentDate() + ".txt");
        try {
            writer = new FileWriter(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void writeToFile(String textToWrite){
        try {
            writer.write(textToWrite + "\n");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void closeWriter(){
        try {
            writer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
