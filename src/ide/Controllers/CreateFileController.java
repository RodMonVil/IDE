package ide.Controllers;

import ide.Views.CreateFileDialog;
import ide.DatabaseConnection;
import ide.Main;
import ide.XML;
import javax.swing.JFrame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateFileController {

    private Main main;
    private JFrame mainFrame;
    private MainController mainController;
//    private AddVariableController addVarController;
//    private AddMethodController addMethController;
    private CreateFileDialog fileDialog;
    private XML xml;
    private DatabaseConnection connection;
    private String xmlString, projectName, className;
    private Document xmlDocument;
    private boolean globalVariablesCheck, methodsCheck;
    
    public CreateFileController(JFrame frame, Main main, MainController mainController, DatabaseConnection connection) {
        this.mainFrame = frame;
        this.main = main;
        this.mainController = mainController;
        this.connection = connection;
        this.connection.Connect();
        fileDialog = new CreateFileDialog(frame, true, this);
        fileDialog.setLocationRelativeTo(null);
        fileDialog.setVisible(true);
    }

    public void createFile() {
        String query = "INSERT INTO xmlProjects (xmlName, xmlPath) values (?, ?)";
        className = fileDialog.getClassName();
        projectName = fileDialog.getProjectName();
        globalVariablesCheck = fileDialog.getGlobalVariablesCheck();
        methodsCheck = fileDialog.getMethodsCheck();
        fileDialog.dispose();
        xml = new XML();
        xmlDocument = xml.createDoc();
        Element classElement = xml.createNode(xmlDocument, "Klasse");
        xml.setAttribute(classElement, "name", className);
        if (globalVariablesCheck) {
            createVariables(classElement);
        }
        if(methodsCheck) {
            createMethods(classElement);
        }
        xml.appendNode(xmlDocument, classElement);
        xmlString = xml.createXMLString(xmlDocument);
        String xmlPath = xml.createXMLFile(xmlDocument, projectName);
        connection.InsertXML(query, projectName, xmlPath);
        mainController.setProjectPath(xmlPath);
        mainController.setProjectInfo(xml.analizeXML(xmlDocument));
        mainController.setActiveProject(true);
        main.setTextAreaText(xmlString);
    }
    
    public void createVariables(Element element) {
        Element variables = xml.createNode(xmlDocument, "Variables");
        AddVariableController addVarController = new AddVariableController(mainFrame, this, xml, xmlDocument, variables);
        xml.appendNode(element, variables);
    }
    
    public void createMethods(Element element) {
        AddMethodController addMethController = new AddMethodController(mainFrame, this, xml, xmlDocument, element);
    }

}
