package ide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;

public class FileDBLoader {

    private static Map<Integer, String> files = new HashMap<>();
    private static Map<Integer, Integer> filesOnList = new HashMap<>();

    public static DefaultListModel getProjects() {
        DatabaseManager.getConnection();
        files = new HashMap<>();
        filesOnList = new HashMap<>();
        ArrayList<Row> rowList = DatabaseManager.read("xmlProjects", "*");
        for (Row row : rowList) {
            files.put(Integer.parseInt(row.get("id_xmlProject")), row.get("name"));
        }
        DefaultListModel listModel = new DefaultListModel();
        int i = 0;
        for (int key : files.keySet()) {
            listModel.addElement(files.get(key));
            filesOnList.put(i, key);
            i++;
        }
        return listModel;
    }

    public static DefaultListModel getFiles(int id_project) {
        DatabaseManager.getConnection();
        files = new HashMap<>();
        filesOnList = new HashMap<>();
        ArrayList<Row> rowList = DatabaseManager.read("xmlFiles", "*", "id_xmlProject =" + id_project);
        for (Row row : rowList) {
            files.put(Integer.parseInt(row.get("id_xmlFile")), row.get("xmlName"));
        }
        DefaultListModel listModel = new DefaultListModel();
        int i = 0;
        for (int key : files.keySet()) {
            listModel.addElement(files.get(key));
            filesOnList.put(i, key);
            i++;
        }
        return listModel;
    }
    
    public static int getDatabaseID(int index) {
        return filesOnList.get(index);
    }

    public static String getXMLPath(int index) {
        XML xml = new XML();
        int key = filesOnList.get(index);
        String xmlPath = "";
        DatabaseManager.getConnection();
        ArrayList<Row> rowList = DatabaseManager.read("xmlFiles", "xmlPath", "id_xmlFile = " + key);
        if (rowList.size() > 0) {
            xmlPath = rowList.get(0).get("xmlPath");
            return xmlPath.trim();
        }
        return null;
    }
}
