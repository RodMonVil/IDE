package ide.Controllers;

import ide.Views.CreateFileDialog;
import ide.DatabaseManager;
import ide.Views.MainFrame;
import ide.XML;
import javax.swing.JFrame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateFileController {

    private MainFrame main;
    private JFrame mainFrame;
    private MainController mainController;
    private CreateFileDialog fileDialog;
    private XML xml;
    private String xmlString, fileName, className, projectPath, projectName;
    private Document xmlDocument;
    private boolean globalVariablesCheck, methodsCheck;
    private int id_project, id_file;

    public CreateFileController(JFrame frame, MainFrame main, MainController mainController) {
        this.mainFrame = frame;
        this.main = main;
        this.mainController = mainController;
        this.id_project = mainController.getProjectID();
        this.projectPath = mainController.getProjectPath();
        this.projectName = mainController.getProjectName();
        DatabaseManager.getConnection();
        fileDialog = new CreateFileDialog(frame, true, this);
        fileDialog.setLocationRelativeTo(null);
        fileDialog.setVisible(true);
    }

    public void createFile() {
//        String query = "INSERT INTO xmlFiles (xmlName, xmlPath) values (?, ?)";
        className = fileDialog.getClassName();
        fileName = fileDialog.getFileName();
        globalVariablesCheck = fileDialog.getGlobalVariablesCheck();
        methodsCheck = fileDialog.getMethodsCheck();
        fileDialog.dispose();
        xml = new XML();
        xmlDocument = xml.createDoc();
        
        Element packageElement = xml.createNode(xmlDocument, "paketsen");
        xml.setAttribute(packageElement, "name", projectName.toLowerCase());
        
        Element classElement = xml.createNode(xmlDocument, "klasse");
        xml.setAttribute(classElement, "name", className);
        if (globalVariablesCheck) {
            createVariables(classElement);
        }
        if (methodsCheck) {
            createMethods(classElement);
        }
        xml.appendNode(classElement, packageElement);
        xml.appendNode(xmlDocument, classElement);
        xmlString = xml.createXMLString(xmlDocument);
        String xmlPath = xml.createXMLFile(xmlDocument, projectPath, fileName);
//        connection.InsertXML(query, fileName, xmlPath);
//        DatabaseManager.InsertXML(query, fileName, xmlPath);
        id_file = DatabaseManager.create("xmlFiles", "xmlName, xmlPath, id_xmlProject", "'" + fileName + "', '" + xmlPath + "', " + id_project); //Falta validar si hubo problema
//        mainController.setProjectPath(xmlPath);
        mainController.setProjectInfo(xml.analizeXML(xmlDocument));
//        mainController.setActiveProject(id_project);
        mainController.setActiveFile(id_file);
        mainController.setFileName(fileName);
        main.setTextAreaText(xmlString);
        mainController.getFiles(id_project);
    }

    public void createVariables(Element element) {
        Element variables = xml.createNode(xmlDocument, "varis");
        AddVariableController addVarController = new AddVariableController(mainFrame, this, xml, xmlDocument, variables);
        xml.appendNode(element, variables);
    }

    private void createMethods(Element element) {
        AddMethodController addMethController = new AddMethodController(mainFrame, this, xml, xmlDocument, element);
    }
    
    private void getProjectName() {
        
    }

}
