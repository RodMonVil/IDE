package ide.ToJava;

import ide.File_Saver;
import ide.XML;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.*;

public class Project {

    ArrayList<String> files = new ArrayList<>();
    String projectName;

    public void createJavaFiles(File directory) {
        XML xml = new XML();
        projectName = directory.getName();
        for (final File file : directory.listFiles()) {
            if (!file.isDirectory()) {
                if (file.getName().toLowerCase().endsWith(".xml")) {
                    String fileNameWithOutExt = FilenameUtils.removeExtension(file.getAbsolutePath());
                    File_Saver.saveStringFile(fileNameWithOutExt + ".java", toJava(xml.createDoc(file)));
                    files.add(FilenameUtils.removeExtension(file.getName()));
                }
            }
        }
        createMain(directory);
    }

    public String createClassFiles(File directory) {
        String error = "";
        try {
            ProcessBuilder builder = new ProcessBuilder("sh", "-c", "javac *.java");
            builder.directory(new File(directory.getAbsolutePath()));
            builder.redirectErrorStream(true);
            Process process = builder.start();
            Scanner scanner = new Scanner(process.getInputStream());
            while (scanner.hasNextLine()) {
                error += scanner.nextLine() + "\n";
            }
            error = error.trim();
            scanner.close();
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        return error;
    }
    
    public String exportProject(File directory) {
        String error = "";
        String command = "jar cvfe " + directory.getName() + ".jar " + " MainClass *.class";
        try {
            ProcessBuilder builder = new ProcessBuilder("sh", "-c", command);
            builder.directory(new File(directory.getAbsolutePath()));
            builder.redirectErrorStream(true);
            Process process = builder.start();
            Scanner scanner = new Scanner(process.getInputStream());
            while (scanner.hasNextLine()) {
                error += scanner.nextLine() + "\n";
            }
            error = error.trim();
            scanner.close();
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        return error;
    }

    private void createMain(File directory) {
        String javaMain = "package " + projectName.toLowerCase() + ";\n";
        javaMain += "public class MainClass {\n";
        javaMain += "\tpublic static void main(String[] args) {\n";
        int i = 1;
        for (String file : files) {
            javaMain += "\t\t" + file + " " + file.toLowerCase() + " = new " + file + "();\n";
            i++;
        }
        javaMain += "\t}\n";
        javaMain += "}";
        File_Saver.saveStringFile(directory.getAbsolutePath() + "/MainClass.java", javaMain);
    }

    public String toJava(Document document) {
        String javaString = "";
        if (document.hasChildNodes()) {
            Klasse klasse = new Klasse(document.getDocumentElement());
            javaString = klasse.toJava();
        }
        return javaString;
    }

//    public String getJava() {
//        return this.javaCode;
//    }
}
