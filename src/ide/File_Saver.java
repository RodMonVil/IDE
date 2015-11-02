package ide;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File_Saver {

    public static boolean saveStringFile(String path, String content) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(content);
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(File_Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean copyFile(String originalPath, String copyPath) {
        try {
            Path originalFile = new File(originalPath).toPath();
            Path newFile = new File(copyPath).toPath();
            Files.copy(originalFile, newFile, COPY_ATTRIBUTES);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(File_Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean backUpFile(String path, String fileName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String dateFile = dateFormat.format(date);
        try {
            String backUpFolder = path + "/backups";
            File directory = new File(backUpFolder);
            Path originalFile = new File(path + "/" + fileName + ".xml").toPath();
            Path newFile = new File(backUpFolder + "/" + fileName + "_" + dateFile + ".xml").toPath();
            
            directory.mkdir();
            Files.copy(originalFile, newFile, REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(File_Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
