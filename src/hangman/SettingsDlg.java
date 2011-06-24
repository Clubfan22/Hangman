/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SettingsDlg.java
 *
 * Created on 09.02.2011, 16:46:06
 */

package hangman;



import java.awt.Dimension;
import java.awt.Point;
import javax.swing.*;

import java.io.*;

import java.util.Properties;

/**
 *
 * @author Ammon
 */
public class SettingsDlg extends javax.swing.JDialog {
    private UIManager.LookAndFeelInfo lookAndFeels[];
    Properties basicProperties = new Properties();
    AppFrame app;
    boolean packFrame = false;
    
    

    /** Creates new form SettingsDlg */
    public SettingsDlg(AppFrame parent, boolean modal) {
        super(parent, modal);
        prp();
        app = parent;
        
        initComponents();
        Dimension wndSize = getSize();
        Dimension parentSize = getParent().getSize();
        Point loc = getParent().getLocation();
        setLocation((parentSize.width  - wndSize.width)  / 2 + loc.x,
                    (parentSize.height - wndSize.height) / 2 + loc.y);
        setVisible(true);
    }
    public void prp(){
        try {
      basicProperties.load(new FileInputStream("basic.properties"));
    }
    catch (java.io.IOException clientException) {
      JOptionPane.showConfirmDialog(this, "Fehler beim Einlesen der Anwendungeseinstellungen.", "Hangman",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
      System.out.println(clientException);
    }


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lookAndFeelCbx = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Einstellungen");

        jLabel1.setText("Aussehen des Programms:");

        /*
        * LookAndFeelCbx: Ermittle installierte L&Fs
        */
        lookAndFeels = UIManager.getInstalledLookAndFeels();
        int index = 0;
        String selectedLuF = basicProperties.getProperty("LookAndFeel");

        for (int lafCounter = 0; lafCounter != lookAndFeels.length; lafCounter++) {
            if (lookAndFeels[lafCounter].getClassName().startsWith(selectedLuF)) {
                index = lafCounter; // Ausgewaehlten Index merken
            }
            // Alle Elemente hinzufuegen
            lookAndFeelCbx.addItem( (Object) lookAndFeels[lafCounter].getName());
        }

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lookAndFeelCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(jLabel1)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lookAndFeelCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Look & Feel sichern
    int selectedIndex = lookAndFeelCbx.getSelectedIndex();
    String selectedLaf = lookAndFeels[selectedIndex].getClassName();
    try {
      
        UIManager.setLookAndFeel(selectedLaf);
        // Alle Konponenten erneuern ...
        SwingUtilities.updateComponentTreeUI(getParent());
        // und sichern
        System.out.println(selectedLaf);
        basicProperties.setProperty("LookAndFeel", selectedLaf);
      System.out.println(basicProperties.getProperty("LookAndFeel"));
    }
    catch (Exception ex) { // Bug in der JVM abfangen
      JOptionPane.showConfirmDialog(null, lookAndFeels[selectedIndex].getName() +
          "-Look & Feel nicht unterst\u00fctzt unter " +
          System.getProperty("os.name") + " " +
          System.getProperty("os.version"), "Einstellungsfehler",
          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
      System.out.println("Logging: Fehler, Beschreibung: " + ex);
    }
    try{
            basicProperties.store(new FileOutputStream("basic.properties"),
                            "basic.properties, (c) Marco Ammon");
        } catch(IOException io) {
            System.out.println(io);
            JOptionPane.showConfirmDialog(this, "Fehler beim Abspeichern der Anwendungeseinstellungen.", "Hangman",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE);

        }

    
    Main start = new Main();
      this.dispose();
      app.setVisible(false);
      



    

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox lookAndFeelCbx;
    // End of variables declaration//GEN-END:variables

}
