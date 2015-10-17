package ide.Controllers;

import ide.*;
import ide.Views.TokenAnalizerDialog;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import org.w3c.dom.Document;

public class MainController {

    private Main main;
    private String projectPath, projectInformation;
    private CreateFileController createFileController;
    private boolean activeProject;
    private DatabaseManager connection = new DatabaseManager("jdbc:mysql://localhost:3306/", "projects", "root", "root");
    private Map<Integer, String> projects = new HashMap<>();
    private Map<Integer, Integer> projectsOnList = new HashMap<>();

    public MainController(Main main) {
        this.main = main;
        activeProject = false;
        getProjects();
        
        
        Connection con = connection.getConnection();
        ArrayList<Row> rowList = connection.read("xmlProjects", "id_xmlProject,xmlName,xmlPath");
        for(Row row: rowList) {
            System.out.println(row.toString());
        }
        System.out.println();
    }
    
    public void setActiveProject(boolean active) {
        activeProject = active;
        main.enableTokenAnalizer(active);
    }

    public void createFile(JFrame frame) {
        createFileController = new CreateFileController(frame, main, this, connection);
    }
    
    public void setProjectPath(String path) {
        projectPath = path;
    }
    
    public void setProjectInfo(String information) {
        projectInformation = information;
    }
    
    public void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter(projectPath);
            fileWriter.write(main.getTextAreaText());
            fileWriter.close();
            getProjects();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getProjects() {
        try {
            String query = "SELECT * FROM xmlProjects";
            connection.OpenConnection();
            ResultSet rs = connection.Select(query);
            while (rs.next()) {
                projects.put(rs.getInt("id_xmlProject"), rs.getString("xmlName"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultListModel listModel = new DefaultListModel();
        int i = 0;
        for (int key : projects.keySet()) {
            listModel.addElement(projects.get(key));
            projectsOnList.put(i, key);
            i++;
        }
        main.setJListContent(listModel);
    }

    public void setMouseListener(JList list) {
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.getSelectedIndex();
                    loadXML(projectsOnList.get(index));
                }
            }
        };
        list.addMouseListener(mouseListener);
    }

    public void loadXML(int key) {
        XML xml = new XML();
        try {
            String query = "SELECT xmlPath FROM xmlProjects WHERE id_xmlProject = " + key;
            connection.OpenConnection();
            ResultSet rs = connection.Select(query);
            String xmlPath = "";
            while (rs.next()) {
                xmlPath = rs.getString("xmlPath");
            }
            xmlPath = xmlPath.trim();
            rs.close();
            setProjectPath(xmlPath);
//            File xmlFile = File_Reader.getFile(xmlPath);
//            Document document = xml.createDoc(xmlFile);
//            projectInformation = xml.analizeXML(document);
//            System.out.println(projectInformation);
            main.setTextAreaText(File_Reader.getFileString(xmlPath));
            setActiveProject(true);
        } catch (SQLException ex) {
            setActiveProject(false);
            main.setTextAreaText("");
            projectInformation = "";
            projectPath = "";
        }
    }

    public void showProjectInfo() {
        XML xml = new XML();
        Document document = xml.createDoc(main.getTextAreaText());
        projectInformation = xml.analizeXML(document);
        TokenAnalizerDialog tokenDialog = new TokenAnalizerDialog(main, true);
        tokenDialog.setInformationText(projectInformation);
        tokenDialog.setVisible(true);
    }
}