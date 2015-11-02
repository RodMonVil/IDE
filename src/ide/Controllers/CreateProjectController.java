package ide.Controllers;

import ide.DatabaseManager;
import ide.Views.CreateProjectDialog;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateProjectController {

    private MainController mainController;
    private CreateProjectDialog projectDialog;
    private String projectName;
    private String rootDirectory = "projects_DestructiveC/";
    private int id_project;

    public CreateProjectController(JFrame frame, MainController mainController) {
        this.mainController = mainController;
        projectDialog = new CreateProjectDialog(frame, true, this);
        projectDialog.setLocationRelativeTo(null);
        projectDialog.setVisible(true);
    }

    public void createProject() {
        this.projectName = projectDialog.getProjectName();
        projectDialog.dispose();
        String path = rootDirectory + projectName;
        if(createDirectory(path)) {
            id_project = DatabaseManager.create("xmlProjects", "name, path", "'" + projectName + "', '" + path + "/'"); //Falta validar si hubo problema
            mainController.setActiveProject(id_project);
            mainController.setProjectPath(rootDirectory, this.projectName);
            mainController.getFiles(id_project);
        } else {
            JOptionPane.showMessageDialog(mainController.getFrame(), "The Project Already Exists!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean createDirectory(String path) {
        File directory = new File(path);
        try {
            if (directory.mkdir()) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainController.getFrame(), e, "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
}
