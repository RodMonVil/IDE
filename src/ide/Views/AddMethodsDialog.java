package ide.Views;

import ide.Controllers.AddMethodController;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

public class AddMethodsDialog extends javax.swing.JDialog {
    
    AddMethodController controller;

    public AddMethodsDialog(JFrame parent, boolean modal, AddMethodController controller) {
        super(parent, modal);
        initComponents();
        this.controller = controller;
    }
    
    public void setReturnModel(String[] variables) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(variables);
        returnComboBox.setModel(model);
    }
    
    public String getNameText() {
        return nameText.getText();
    }
    
    public boolean getConstructorCheck() {
        return constructorCheck.isSelected();
    }
    
    public boolean getVoidCheck() {
        return voidCheck.isSelected();
    }
    
    public boolean getVariablesCheck() {
        return variablesCheck.isSelected();
    }
    
    public String getReturnText() {
        return returnComboBox.getSelectedItem().toString();
    }
    
    public void clear() {
        nameText.setText("");
        voidCheck.setSelected(false);
        variablesCheck.setSelected(false);
        returnComboBox.setSelectedIndex(0);
        constructorCheck.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        voidCheck = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        variablesCheck = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        returnComboBox = new javax.swing.JComboBox();
        constructorCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Add Metapod");

        voidCheck.setText("Volsch Metapod");
        voidCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                voidCheckItemStateChanged(evt);
            }
        });

        jLabel2.setText("Return Type");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        variablesCheck.setText("Varis");

        jLabel3.setText("Name");

        returnComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        constructorCheck.setText("Startzen");
        constructorCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                constructorCheckItemStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(92, 92, 92)
                                .add(jLabel1))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(jLabel3)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(nameText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(constructorCheck)
                                        .add(57, 57, 57)))))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .add(jLabel2)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(returnComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createSequentialGroup()
                            .add(14, 14, 14)
                            .add(voidCheck)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(variablesCheck)))
                    .add(layout.createSequentialGroup()
                        .add(85, 85, 85)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(doneButton)
                            .add(addButton))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(nameText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(constructorCheck)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(returnComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(voidCheck)
                    .add(variablesCheck))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(addButton)
                .add(18, 18, 18)
                .add(doneButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        controller.done();
    }//GEN-LAST:event_doneButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        controller.createMethod();
        clear();
    }//GEN-LAST:event_addButtonActionPerformed

    private void voidCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_voidCheckItemStateChanged
        if(evt.getStateChange() == 1) {
            returnComboBox.setEnabled(false);
        } else {
            returnComboBox.setEnabled(true);
        }
    }//GEN-LAST:event_voidCheckItemStateChanged

    private void constructorCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_constructorCheckItemStateChanged
        if(evt.getStateChange() == 1) {
            returnComboBox.setEnabled(false);
            voidCheck.setEnabled(false);
            variablesCheck.setEnabled(false);
            nameText.setEnabled(false);
        } else {
            returnComboBox.setEnabled(true);
            voidCheck.setEnabled(true);
            variablesCheck.setEnabled(true);
            nameText.setEnabled(true);
        }
    }//GEN-LAST:event_constructorCheckItemStateChanged

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddMethodsDialog().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JCheckBox constructorCheck;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nameText;
    private javax.swing.JComboBox returnComboBox;
    private javax.swing.JCheckBox variablesCheck;
    private javax.swing.JCheckBox voidCheck;
    // End of variables declaration//GEN-END:variables
}
