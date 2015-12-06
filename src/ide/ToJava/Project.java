package ide.ToJava;

import ide.File_Saver;
import ide.XML;
import java.io.File;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.*;

public class Project {
    
//    String javaCode = "";
    XML xml;

    public Project(Document document) {
        toJava(document);
    }

    public Project(File directory) {
        xml = new XML();
        for (final File file : directory.listFiles()) {
            if (!file.isDirectory()) {
                if(file.getName().toLowerCase().endsWith(".xml")) {
//                    javaCode += toJava(xml.createDoc(file));
                    String fileNameWithOutExt = FilenameUtils.removeExtension(file.getAbsolutePath());
                    File_Saver.saveStringFile(fileNameWithOutExt + ".java", toJava(xml.createDoc(file)));
                }
            }
        }
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
