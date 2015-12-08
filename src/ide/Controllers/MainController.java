package ide.Controllers;

import ide.Views.*;
import ide.*;
import ide.ToJava.Project;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import org.w3c.dom.Document;

public class MainController {

    private MainFrame mainFrame;
    private String rootDirectory = "projects_DestructiveC/";
    private String projectPath, tokenInformation, fileName, projectName;
    private CreateFileController createFileController;
    private CreateProjectController createProjectController;
    private int activeProject;
    private int activeFile;

    public MainController() {
        mainFrame = new MainFrame(this);
        this.setMouseListener(mainFrame.getProjectList());
        this.setKeyListener(mainFrame.getTextArea());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        getProjects();
        backUpProjects();

//        ArrayList<Row> rowList = DatabaseManager.read("xmlFiles", "*");
//        for (Row row : rowList) {
//            System.out.println(row.toString());
//        }
//        System.out.println();
    }

    public void setActiveProject(int id_project) {
        activeProject = id_project;
    }

    public String getRootDirectory() {
        return this.rootDirectory;
    }

    public void setActiveFile(int id_xmlFile) {
        activeFile = id_xmlFile;
        mainFrame.enableFileOptions(true);
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public JFrame getFrame() {
        return this.mainFrame;
    }

    public void createFile(JFrame frame) {
        createFileController = new CreateFileController(frame, mainFrame, this);
        mainFrame.setFileText(fileName);
    }

    public void createProject(JFrame frame) {
        createProjectController = new CreateProjectController(frame, this);
    }
    
    public String getProjectName() {
        return this.projectName;
    }
    
    public String getProjectPath() {
        return this.projectPath;
    }
    
    public int getProjectID() {
        return this.activeProject;
    }

    public void setProjectPath(String path, String name) {
        mainFrame.setProjectText(name);
        projectName = name;
        projectPath = path + name;
        mainFrame.enableProjectOptions(true);
    }

    public void setProjectInfo(String information) {
        tokenInformation = information;
    }

    public void validateSyntax() {
        String filePath = projectPath + "/" + fileName + ".xml";
        String xsdPath = "src/ide/destructiveC.xsd";
        XMLValidator xmlValidator = new XMLValidator(xsdPath, filePath);
        if (xmlValidator.isValid()) {
            JOptionPane.showMessageDialog(mainFrame, "XML is Valid", "Syntax Validator", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(mainFrame, xmlValidator.getErrorMsg(), "Syntax Validator", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void saveFile() {
        String filePath = projectPath + "/" + fileName + ".xml";
        if (File_Saver.saveStringFile(filePath, mainFrame.getTextAreaText())) {
            getFiles(activeProject);
        }
    }

    public void backUpFile() {
        if (File_Saver.backUpFile(projectPath, fileName)) {
            JOptionPane.showMessageDialog(mainFrame, "BackUp Successful", "BackUp", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(mainFrame, "BackUp Error", "BackUp", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void backUpProjects() {
        ThreadExecuter thread = new ThreadExecuter(rootDirectory);
        thread.start();
    }

    public void copyFile() {
        CopyFileController copyController = new CopyFileController(mainFrame, this, projectPath, fileName);
        upToProjects();
    }
    
    public void exportProject() {
        Project project = new Project();
        project.exportProject(new File(projectPath));
    }

    public void importFile() {
        if (File_Saver.importFile(projectPath, mainFrame, activeProject)) {
            JOptionPane.showMessageDialog(mainFrame, "Import Successful", "Import File", JOptionPane.INFORMATION_MESSAGE);
            getFiles(activeProject);
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Import Error", "Import File", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void upToProjects() {
        mainFrame.getProjectList().setModel(FileDBLoader.getProjects());
        mainFrame.enableMoveUp(false);
        mainFrame.setProjectText("Projects");
        mainFrame.enableProjectOptions(false);
    }

    public void getProjects() {
        mainFrame.getProjectList().setModel(FileDBLoader.getProjects());
    }

    public void getFiles(int id_project) {
        mainFrame.getProjectList().setModel(FileDBLoader.getFiles(id_project));
        mainFrame.enableMoveUp(true);
    }

    public void setMouseListener(JList list) {
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.getSelectedIndex();
                    if (mainFrame.isFilesList()) {
                        fileName = list.getSelectedValue().toString();
                        mainFrame.setFileText(fileName);
                        loadXML(index);
                    } else {
                        setProjectPath(rootDirectory, list.getSelectedValue().toString());
                        loadFiles(index);
                    }
                }
            }
        };
        list.addMouseListener(mouseListener);
    }

    public void setKeyListener(JTextArea textArea) {
        KeyListener keyListener = new KeyListener() {
            boolean validKey = true;

            @Override
            public void keyTyped(KeyEvent e) {
                if (!validKey) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int position = textArea.getCaretPosition();
                int charPosition = position - 1;
                String text = mainFrame.getTextAreaText();
                if (charPosition > 0 && position < text.length()) {
                    for (int i = charPosition; i >= 0; i--) {
                        if (text.charAt(i) == '<') {
//                            System.out.println("No Editable");
                            validKey = false;
                            break;
                        } else if (text.charAt(i) == '>') {
                            validKey = true;
//                            System.out.println("Editable");
                            break;
                        }
                    }
                } else {
                    validKey = false;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //Nothing
            }
        };
        textArea.addKeyListener(keyListener);
    }

    public void loadXML(int index) {
        int key = FileDBLoader.getDatabaseID(index);
        String xmlPath = "";
        xmlPath = FileDBLoader.getXMLPath(index);
        if (xmlPath != null) {
            mainFrame.setTextAreaText(File_Reader.getFileString(xmlPath));
            mainFrame.enableFileOptions(true);
            setActiveFile(key);
        }
    }

    public void loadFiles(int index) {
        int key = FileDBLoader.getDatabaseID(index);
        mainFrame.getProjectList().setModel(FileDBLoader.getFiles(key));
        mainFrame.enableMoveUp(true);
        setActiveProject(key);
    }

    public void showTokenInfo() {
        XML xml = new XML();
        Document document = xml.createDoc(mainFrame.getTextAreaText());
        tokenInformation = xml.analizeXML(document);
        TokenAnalizerDialog tokenDialog = new TokenAnalizerDialog(mainFrame, true);
        tokenDialog.setInformationText(tokenInformation);
        tokenDialog.setVisible(true);
    }
    
    public void translateProject() {
//        XML xml = new XML();
//        System.out.println(projectPath + "/" + fileName + ".xml");
//        Project project = new Project(xml.createDoc(new File(projectPath + "/" + fileName + ".xml")));
        Project project = new Project();
        project.createJavaFiles(new File(projectPath));
//        System.out.println(project.getJava());
    }
    
    public void compileProject() {
        Project project = new Project();
        String result = project.createClassFiles(new File(projectPath));
        System.out.println(result);
    }
}
