package ide.Views;

import ide.Controllers.MainController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MainFrame extends javax.swing.JFrame {
    
    private MainController controller;

    public MainFrame(MainController controller) {
        this.controller = controller;
        initComponents();
    }
    
    public String getTextAreaText() {
        return textArea.getText();
    }
    
    public void setTextAreaText(String text) {
        textArea.setText(text);
    }
    
//    public void setJListContent(DefaultListModel model) {
//        projectList.setModel(model);
//    }
    
    public void enableFileOptions(boolean enable) {
        tokenAnalizerOption.setEnabled(enable);
        saveFileOption.setEnabled(enable);
        backupFileOption.setEnabled(enable);
        copyOption.setEnabled(enable);
    }
    
    public JTextArea getTextArea() {
        return this.textArea;
    }
    
    public JList getProjectList() {
        return this.projectList;
    }
    
    public boolean isFilesList() {
        return moveUpButton.isEnabled();
    }
    
    public void enableMoveUp(boolean enable) {
        moveUpButton.setEnabled(enable);
    }
    
    public void setProjectText(String text) {
        projectNameText.setText(text);
    }
    
    public void setFileText(String text) {
        fileNameText.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        projectList = new javax.swing.JList();
        moveUpButton = new javax.swing.JButton();
        projectNameText = new javax.swing.JLabel();
        fileNameText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        createProjectOption = new javax.swing.JMenuItem();
        createFileOption = new javax.swing.JMenuItem();
        openProjectOption = new javax.swing.JMenuItem();
        saveFileOption = new javax.swing.JMenuItem();
        copyOption = new javax.swing.JMenuItem();
        backupMenu = new javax.swing.JMenu();
        backupProjectOption = new javax.swing.JMenuItem();
        backupFileOption = new javax.swing.JMenuItem();
        exportProjectOption = new javax.swing.JMenuItem();
        importMenu = new javax.swing.JMenu();
        importProjectOption = new javax.swing.JMenuItem();
        importFileOption = new javax.swing.JMenuItem();
        exitOption = new javax.swing.JMenuItem();
        codeMenu = new javax.swing.JMenu();
        tokenAnalizerOption = new javax.swing.JMenuItem();
        validateMenu = new javax.swing.JMenu();
        syntaxValidateOption = new javax.swing.JMenuItem();
        semanticsValidateOption = new javax.swing.JMenuItem();
        traductionOption = new javax.swing.JMenuItem();
        compileOption = new javax.swing.JMenuItem();
        refactorOption = new javax.swing.JMenuItem();
        smartCodeOption = new javax.swing.JMenuItem();
        projectMenu = new javax.swing.JMenu();
        configurationOption = new javax.swing.JMenuItem();
        aboutOption = new javax.swing.JMenuItem();
        testOption = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jScrollPane2.setViewportView(projectList);

        moveUpButton.setText("⇧");
        moveUpButton.setEnabled(false);
        moveUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpButtonActionPerformed(evt);
            }
        });

        projectNameText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectNameText.setText("Projects");

        fileNameText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileNameText.setText("Archivo");

        fileMenu.setText("File");

        createProjectOption.setText("Create New Project");
        createProjectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProjectOptionActionPerformed(evt);
            }
        });
        fileMenu.add(createProjectOption);

        createFileOption.setText("Create New File");
        createFileOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFileOptionActionPerformed(evt);
            }
        });
        fileMenu.add(createFileOption);

        openProjectOption.setText("Open Project");
        openProjectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProjectOptionActionPerformed(evt);
            }
        });
        fileMenu.add(openProjectOption);

        saveFileOption.setText("Save File");
        saveFileOption.setEnabled(false);
        saveFileOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileOptionActionPerformed(evt);
            }
        });
        fileMenu.add(saveFileOption);

        copyOption.setText("Copy File");
        copyOption.setEnabled(false);
        copyOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyOptionActionPerformed(evt);
            }
        });
        fileMenu.add(copyOption);

        backupMenu.setText("Backup");

        backupProjectOption.setText("Backup Project");
        backupProjectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupProjectOptionActionPerformed(evt);
            }
        });
        backupMenu.add(backupProjectOption);

        backupFileOption.setText("Backup File");
        backupFileOption.setEnabled(false);
        backupFileOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupFileOptionActionPerformed(evt);
            }
        });
        backupMenu.add(backupFileOption);

        fileMenu.add(backupMenu);

        exportProjectOption.setText("Export Project");
        exportProjectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportProjectOptionActionPerformed(evt);
            }
        });
        fileMenu.add(exportProjectOption);

        importMenu.setText("Import");

        importProjectOption.setText("Import Project");
        importProjectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importProjectOptionActionPerformed(evt);
            }
        });
        importMenu.add(importProjectOption);

        importFileOption.setText("Import File");
        importFileOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importFileOptionActionPerformed(evt);
            }
        });
        importMenu.add(importFileOption);

        fileMenu.add(importMenu);

        exitOption.setText("Exit");
        exitOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitOptionActionPerformed(evt);
            }
        });
        fileMenu.add(exitOption);

        jMenuBar1.add(fileMenu);

        codeMenu.setText("Code");

        tokenAnalizerOption.setText("Token Analizer");
        tokenAnalizerOption.setEnabled(false);
        tokenAnalizerOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokenAnalizerOptionActionPerformed(evt);
            }
        });
        codeMenu.add(tokenAnalizerOption);

        validateMenu.setText("Validate");

        syntaxValidateOption.setText("Syntax");
        syntaxValidateOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syntaxValidateOptionActionPerformed(evt);
            }
        });
        validateMenu.add(syntaxValidateOption);

        semanticsValidateOption.setText("Semantics");
        semanticsValidateOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semanticsValidateOptionActionPerformed(evt);
            }
        });
        validateMenu.add(semanticsValidateOption);

        codeMenu.add(validateMenu);

        traductionOption.setText("Traduction");
        traductionOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traductionOptionActionPerformed(evt);
            }
        });
        codeMenu.add(traductionOption);

        compileOption.setText("Compile");
        compileOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileOptionActionPerformed(evt);
            }
        });
        codeMenu.add(compileOption);

        refactorOption.setText("Refactor");
        refactorOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refactorOptionActionPerformed(evt);
            }
        });
        codeMenu.add(refactorOption);

        smartCodeOption.setText("Smart Code Generator");
        smartCodeOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smartCodeOptionActionPerformed(evt);
            }
        });
        codeMenu.add(smartCodeOption);

        jMenuBar1.add(codeMenu);

        projectMenu.setText("Project");

        configurationOption.setText("Configuration");
        configurationOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configurationOptionActionPerformed(evt);
            }
        });
        projectMenu.add(configurationOption);

        aboutOption.setText("About");
        aboutOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutOptionActionPerformed(evt);
            }
        });
        projectMenu.add(aboutOption);

        testOption.setText("Test");
        testOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testOptionActionPerformed(evt);
            }
        });
        projectMenu.add(testOption);

        jMenuBar1.add(projectMenu);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .add(moveUpButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(projectNameText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .add(fileNameText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(7, 7, 7)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(projectNameText)
                    .add(fileNameText))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(moveUpButton)
                        .add(4, 4, 4)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(316, Short.MAX_VALUE))
                    .add(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitOptionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitOptionActionPerformed

    private void createFileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFileOptionActionPerformed
        controller.createFile(this);
    }//GEN-LAST:event_createFileOptionActionPerformed

    private void saveFileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileOptionActionPerformed
        controller.saveFile();
    }//GEN-LAST:event_saveFileOptionActionPerformed

    private void tokenAnalizerOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokenAnalizerOptionActionPerformed
        controller.showTokenInfo();
    }//GEN-LAST:event_tokenAnalizerOptionActionPerformed

    private void createProjectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectOptionActionPerformed
        controller.createProject(this);
    }//GEN-LAST:event_createProjectOptionActionPerformed

    private void openProjectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_openProjectOptionActionPerformed

    private void copyOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyOptionActionPerformed
        controller.copyFile();
    }//GEN-LAST:event_copyOptionActionPerformed

    private void backupProjectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupProjectOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_backupProjectOptionActionPerformed

    private void backupFileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupFileOptionActionPerformed
        controller.backUpFile();
    }//GEN-LAST:event_backupFileOptionActionPerformed

    private void exportProjectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportProjectOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_exportProjectOptionActionPerformed

    private void importProjectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importProjectOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_importProjectOptionActionPerformed

    private void importFileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFileOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_importFileOptionActionPerformed

    private void semanticsValidateOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semanticsValidateOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_semanticsValidateOptionActionPerformed

    private void syntaxValidateOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syntaxValidateOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_syntaxValidateOptionActionPerformed

    private void traductionOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traductionOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_traductionOptionActionPerformed

    private void compileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_compileOptionActionPerformed

    private void refactorOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refactorOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refactorOptionActionPerformed

    private void smartCodeOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smartCodeOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_smartCodeOptionActionPerformed

    private void configurationOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configurationOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_configurationOptionActionPerformed

    private void aboutOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutOptionActionPerformed

    private void testOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testOptionActionPerformed
//        int posicion = textArea.getCaretPosition();
//        System.out.println(posicion);
//        String name = JOptionPane.showInputDialog(this, "Give Input Text:");
//        textArea.insert(name, posicion);
    }//GEN-LAST:event_testOptionActionPerformed

    private void moveUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpButtonActionPerformed
        controller.upToProjects();
    }//GEN-LAST:event_moveUpButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutOption;
    private javax.swing.JMenuItem backupFileOption;
    private javax.swing.JMenu backupMenu;
    private javax.swing.JMenuItem backupProjectOption;
    private javax.swing.JMenu codeMenu;
    private javax.swing.JMenuItem compileOption;
    private javax.swing.JMenuItem configurationOption;
    private javax.swing.JMenuItem copyOption;
    private javax.swing.JMenuItem createFileOption;
    private javax.swing.JMenuItem createProjectOption;
    private javax.swing.JMenuItem exitOption;
    private javax.swing.JMenuItem exportProjectOption;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel fileNameText;
    private javax.swing.JMenuItem importFileOption;
    private javax.swing.JMenu importMenu;
    private javax.swing.JMenuItem importProjectOption;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton moveUpButton;
    private javax.swing.JMenuItem openProjectOption;
    private javax.swing.JList projectList;
    private javax.swing.JMenu projectMenu;
    private javax.swing.JLabel projectNameText;
    private javax.swing.JMenuItem refactorOption;
    private javax.swing.JMenuItem saveFileOption;
    private javax.swing.JMenuItem semanticsValidateOption;
    private javax.swing.JMenuItem smartCodeOption;
    private javax.swing.JMenuItem syntaxValidateOption;
    private javax.swing.JMenuItem testOption;
    private javax.swing.JTextArea textArea;
    private javax.swing.JMenuItem tokenAnalizerOption;
    private javax.swing.JMenuItem traductionOption;
    private javax.swing.JMenu validateMenu;
    // End of variables declaration//GEN-END:variables
}