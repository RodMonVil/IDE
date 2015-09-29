package ide;

import ide.Controllers.MainController;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    
    private MainController controller;

    public Main() {
        initComponents();
        controller = new MainController(this);
        controller.setMouseListener(projectList);
        this.setLocationRelativeTo(null);
    }
    
    public String getTextAreaText() {
        return textArea.getText();
    }
    
    public void setTextAreaText(String text) {
        textArea.setText(text);
    }
    
    public void setJListContent(DefaultListModel model) {
        projectList.setModel(model);
    }
    
    public void enableTokenAnalizer(boolean enable) {
        tokenAnalizerOption.setEnabled(enable);
        saveFileOption.setEnabled(enable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        projectList = new javax.swing.JList();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        projectList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(projectList);

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

        jMenuBar1.add(projectMenu);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 600, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
        controller.showProjectInfo();
    }//GEN-LAST:event_tokenAnalizerOptionActionPerformed

    private void createProjectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_createProjectOptionActionPerformed

    private void openProjectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_openProjectOptionActionPerformed

    private void copyOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_copyOptionActionPerformed

    private void backupProjectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupProjectOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_backupProjectOptionActionPerformed

    private void backupFileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupFileOptionActionPerformed
        JOptionPane.showMessageDialog(this, evt.getActionCommand(), "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

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
    private javax.swing.JMenuItem importFileOption;
    private javax.swing.JMenu importMenu;
    private javax.swing.JMenuItem importProjectOption;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem openProjectOption;
    private javax.swing.JList projectList;
    private javax.swing.JMenu projectMenu;
    private javax.swing.JMenuItem refactorOption;
    private javax.swing.JMenuItem saveFileOption;
    private javax.swing.JMenuItem semanticsValidateOption;
    private javax.swing.JMenuItem smartCodeOption;
    private javax.swing.JMenuItem syntaxValidateOption;
    private javax.swing.JTextArea textArea;
    private javax.swing.JMenuItem tokenAnalizerOption;
    private javax.swing.JMenuItem traductionOption;
    private javax.swing.JMenu validateMenu;
    // End of variables declaration//GEN-END:variables
}