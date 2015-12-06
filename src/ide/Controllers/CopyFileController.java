package ide.Controllers;

import ide.DatabaseManager;
import ide.FileDBLoader;
import ide.File_Saver;
import ide.Views.CopyFileDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class CopyFileController {
    
    private MainController mainController;
    private CopyFileDialog copyDialog;
    private String originalPath, fileName;
    private int id_project;
    
    public CopyFileController(JFrame frame, MainController mainController, String originalPath, String fileName) {
        this.mainController = mainController;
        this.originalPath = originalPath + "/" + fileName + ".xml";
        this.fileName = fileName;
        copyDialog = new CopyFileDialog(frame, true, this);
        this.setMouseListener(copyDialog.getProjectList());
        getProjects();
        copyDialog.setLocationRelativeTo(null);
        copyDialog.setVisible(true);
        
    }
    
    public void copyFile() {
        String selectedProject = copyDialog.getProjectList().getSelectedValue().toString();
        String newPath = mainController.getRootDirectory() + selectedProject + "/" + fileName + ".xml";
        int id_file = DatabaseManager.create("xmlFiles", "xmlName, xmlPath, id_xmlProject", "'" + fileName + "', '" + newPath + "', " + id_project); //Falta validar si hubo problema
        if(File_Saver.copyFile(originalPath, newPath)) {
            JOptionPane.showMessageDialog(copyDialog, "Copy Successful", "Copy File", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(copyDialog, "Copy Error", "Copy File", JOptionPane.INFORMATION_MESSAGE);
        }
        copyDialog.dispose();
    }
    
    public void getProjects() {
        copyDialog.getProjectList().setModel(FileDBLoader.getProjects());
    }
    
    public void setMouseListener(JList list) {
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if(!list.isSelectionEmpty()) {
                    int index = list.getSelectedIndex();
                    id_project = FileDBLoader.getDatabaseID(index);
                    copyDialog.enableCopyButton(true);
                    
                } else {
                    copyDialog.enableCopyButton(false);
                }
            }
        };
        list.addMouseListener(mouseListener);
    }
    
}