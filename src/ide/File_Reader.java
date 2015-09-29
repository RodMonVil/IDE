package ide;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class File_Reader {

    public static String getSelectedFile() {
        String document = "";
        try {
            Scanner scan = new Scanner(selectFile());
            while (scan.hasNextLine()) {
                document += scan.nextLine() + "\n";
            }
            document = document.trim();
            scan.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex);
        }
        return document;
    }
    
    public static String getFileString(String path) {
        File file = new File(path);
        String document = "";
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                document += scan.nextLine() + "\n";
            }
            document = document.trim();
            scan.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex);
        }
        return document;
    }
    
    public static File getFile(String path) {
        File file = new File(path);
        return file;
    }
    
    public static File selectFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        File selectedFile;
        int result = fileChooser.showOpenDialog(new JPanel());
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            return selectedFile;
        } else {
            return null;
        }
    }

    //Codigo si se desea validar EOF en el archivo
    //                    if (line.endsWith("EOF") || line.endsWith("eof")) {
//                        this.document.set(i, this.document.get(i) + line.replace(line.substring(line.length() - 3, line.length()), ""));
//                    } else {
//                        this.document.set(i, this.document.get(i) + line + "\n");
//                    }
}
