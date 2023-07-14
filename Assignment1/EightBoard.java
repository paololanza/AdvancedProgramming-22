/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.eightboard;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author paololanza
 */
public class EightBoard extends javax.swing.JFrame implements PropertyChangeListener{
    
    private final ArrayList<EightTile> tiles;
    private int hole = 5;
    private final VetoableChangeSupport vceListeners;
    private final PropertyChangeSupport propertySupport;

    /**
     * Creates new form EightBoard
     */
    public EightBoard() {   
        
        System.out.println("EB: Component initialialization...");
        initComponents();
        
        this.vceListeners = new VetoableChangeSupport(this);
        
        this.propertySupport = new PropertyChangeSupport(this);
        this.propertySupport.addPropertyChangeListener(eightController1);
        
        tiles = new ArrayList();
        tiles.add(eightTile1);
        tiles.add(eightTile2);
        tiles.add(eightTile3);
        tiles.add(eightTile4);
        tiles.add(eightTile5);
        tiles.add(eightTile6);
        tiles.add(eightTile7);
        tiles.add(eightTile8);
        tiles.add(eightTile9);
        
        //todo: sistemare aggiunta property and vetoable with arraylist
        System.out.println("EB: Adding property change listeners...");
        for(int i = 0; i < 9; i++)
        {
            tiles.get(i).addPropertyChangeListener(this);
        }
        System.out.println("EB: Property change listeners added");
 
        System.out.println("EB: Adding vetoable change listeners...");
        for(int i = 0; i < 9; i++)
        {
            tiles.get(i).addVetoableChangeListener(eightController1);
        }
        this.addVetoableChangeListener(eightController1);
        System.out.println("EB: Vetoable listeners added");
        
        System.out.println("EB: Board ready!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        eightController1 = new com.mycompany.eightboard.EightController(5);
        restart = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        eightTile1 = new EightTile(1,1);
        eightTile2 = new EightTile(2,3);
        eightTile3 = new EightTile(3,5);
        eightTile4 = new EightTile(4,7);
        eightTile5 = new EightTile(5,9);
        eightTile6 = new EightTile(6,2);
        eightTile7 = new EightTile(7,4);
        eightTile8 = new EightTile(8,8);
        eightTile9 = new EightTile(9,6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.white);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(270, 30));
        jPanel2.setSize(new java.awt.Dimension(270, 30));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWeights = new double[] {0.25, 0.75, 0.25};
        jPanel2.setLayout(jPanel2Layout);

        eightController1.setBackground(new java.awt.Color(255, 255, 255));
        eightController1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightController1.setText("START");
        eightController1.setAlignmentY(0.0F);
        eightController1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.25;
        jPanel2.add(eightController1, gridBagConstraints);

        restart.setBackground(new java.awt.Color(255, 204, 51));
        restart.setText("RESTART");
        restart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        restart.setContentAreaFilled(false);
        restart.setOpaque(true);
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.75;
        gridBagConstraints.insets = new java.awt.Insets(-1, 0, -1, 0);
        jPanel2.add(restart, gridBagConstraints);

        jButton11.setBackground(new java.awt.Color(0, 153, 255));
        jButton11.setText("FLIP");
        jButton11.setContentAreaFilled(false);
        jButton11.setOpaque(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        jPanel2.add(jButton11, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setForeground(java.awt.Color.white);
        jPanel3.setToolTipText("");
        jPanel3.setAlignmentX(60.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        eightTile1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile1.setContentAreaFilled(false);
        eightTile1.setOpaque(true);
        eightTile1.setPreferredSize(null);
        eightTile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile1, gridBagConstraints);

        eightTile2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile2.setAlignmentY(0.0F);
        eightTile2.setContentAreaFilled(false);
        eightTile2.setOpaque(true);
        eightTile2.setPreferredSize(null);
        eightTile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile2, gridBagConstraints);

        eightTile3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile3.setAlignmentY(0.0F);
        eightTile3.setContentAreaFilled(false);
        eightTile3.setOpaque(true);
        eightTile3.setPreferredSize(null);
        eightTile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile3, gridBagConstraints);

        eightTile4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile4.setAlignmentY(0.0F);
        eightTile4.setContentAreaFilled(false);
        eightTile4.setOpaque(true);
        eightTile4.setPreferredSize(null);
        eightTile4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile4, gridBagConstraints);

        eightTile5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile5.setAlignmentY(0.0F);
        eightTile5.setContentAreaFilled(false);
        eightTile5.setOpaque(true);
        eightTile5.setPreferredSize(null);
        eightTile5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile5, gridBagConstraints);

        eightTile6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile6.setAlignmentY(0.0F);
        eightTile6.setContentAreaFilled(false);
        eightTile6.setOpaque(true);
        eightTile6.setPreferredSize(null);
        eightTile6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile6, gridBagConstraints);

        eightTile7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile7.setAlignmentY(0.0F);
        eightTile7.setContentAreaFilled(false);
        eightTile7.setOpaque(true);
        eightTile7.setPreferredSize(null);
        eightTile7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile7, gridBagConstraints);

        eightTile8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile8.setAlignmentY(0.0F);
        eightTile8.setContentAreaFilled(false);
        eightTile8.setOpaque(true);
        eightTile8.setPreferredSize(null);
        eightTile8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile8, gridBagConstraints);

        eightTile9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        eightTile9.setAlignmentY(0.0F);
        eightTile9.setContentAreaFilled(false);
        eightTile9.setOpaque(true);
        eightTile9.setPreferredSize(null);
        eightTile9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(-1, -1, -1, -1);
        jPanel3.add(eightTile9, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed
        //create a new permutation 
        ArrayList<Integer> permutationList = new ArrayList<>();
        permutationList = permutationList();
        
        System.out.println("EB: Restart button pushed!");
        for(int i = 0; i < 9; i++)
        {
            tiles.get(i).setLabel(permutationList.get(i), false);
            if(permutationList.get(i) == 9)
            {
                System.out.println("EB: Send to controller the new hole value...");
                this.hole = i + 1;
                this.propertySupport.firePropertyChange("hole", false, i+1);
            }
        }
        
    }//GEN-LAST:event_restartActionPerformed

    //flip operation action performed
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
                System.out.println("EB: Waiting the validation of the flip operation...");
                this.vceListeners.fireVetoableChange("flip", false, true);
                
                int label1 = this.eightTile1.getLabels();
                this.eightTile1.setLabel(this.eightTile2.getLabels(), false);
                this.eightTile2.setLabel(label1, false);
                
            }
            catch(PropertyVetoException e)
            {
                System.out.println(e.getMessage());
            }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void eightTile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile1ActionPerformed
        eightTile1.setLabel(9, true);
    }//GEN-LAST:event_eightTile1ActionPerformed

    private void eightTile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile2ActionPerformed
        eightTile2.setLabel(9, true);
    }//GEN-LAST:event_eightTile2ActionPerformed

    private void eightTile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile3ActionPerformed
        eightTile3.setLabel(9, true);
    }//GEN-LAST:event_eightTile3ActionPerformed

    private void eightTile4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile4ActionPerformed
        eightTile4.setLabel(9, true);
    }//GEN-LAST:event_eightTile4ActionPerformed

    private void eightTile5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile5ActionPerformed
        eightTile5.setLabel(9, true);
    }//GEN-LAST:event_eightTile5ActionPerformed

    private void eightTile6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile6ActionPerformed
        eightTile6.setLabel(9, true);
    }//GEN-LAST:event_eightTile6ActionPerformed

    private void eightTile7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile7ActionPerformed
        eightTile7.setLabel(9, true);
    }//GEN-LAST:event_eightTile7ActionPerformed

    private void eightTile8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile8ActionPerformed
        eightTile8.setLabel(9, true);
    }//GEN-LAST:event_eightTile8ActionPerformed

    private void eightTile9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile9ActionPerformed
        eightTile9.setLabel(9, true);
    }//GEN-LAST:event_eightTile9ActionPerformed

    /*
    Function that return a list that contains a permutation of the number in
    range from 1 to 9.
    */
    private ArrayList<Integer> permutationList()
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) 
        {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EightBoard().setVisible(true);
            }
        });
    }
    
    /*
    This function is performed when the "move" of the tile is approved and it's
    needed to swap the (old) hole tile with the tile moved. So, this function 
    is called by an EightTile when performs the firePropertyChange.
    */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("hole"))
        {
            //take the parameters
            int label = (int)evt.getNewValue();
                
            //fill the hole with the adjacent tile
            tiles.get(this.hole-1).setLabel(label, false);
            
            //update the hole on the board
            this.hole = eightController1.getHole();
        }
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.eightboard.EightController eightController1;
    private com.mycompany.eightboard.EightTile eightTile1;
    private com.mycompany.eightboard.EightTile eightTile2;
    private com.mycompany.eightboard.EightTile eightTile3;
    private com.mycompany.eightboard.EightTile eightTile4;
    private com.mycompany.eightboard.EightTile eightTile5;
    private com.mycompany.eightboard.EightTile eightTile6;
    private com.mycompany.eightboard.EightTile eightTile7;
    private com.mycompany.eightboard.EightTile eightTile8;
    private com.mycompany.eightboard.EightTile eightTile9;
    private javax.swing.JButton jButton11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton restart;
    // End of variables declaration//GEN-END:variables

    private synchronized void addVetoableChangeListener(VetoableChangeListener listener) 
    {
        this.vceListeners.addVetoableChangeListener(listener);
    }

}