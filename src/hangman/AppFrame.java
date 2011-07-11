/*
 * AppFrame.java
 *
 * Created on 20.12.2010, 17:39:55
 */

package hangman;



import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;
import java.util.*;


/**
 *
 * @author Marco Ammon
 */
public class AppFrame extends javax.swing.JFrame {
    boolean packFrame = false;
    String word;
    String sub;
    char first;
    char last;
    String sub2;
    char[] searchword;
    int clicks;
    char[] wordarray;
    String swAlsString;
    int mistakes = 0;
    Image img;
    final String version = "1_9_3Stable";
    HibernateService hs;
    Wordchoose main;


final static ResourceBundle rb = ResourceBundle.getBundle("version");
    static Properties basicProperties = new Properties();
    /** Creates new form AppFrame */
    public AppFrame() {
        hs = new HibernateService();

        

 img = new ImageIcon(getClass().getResource("/hangman/ressources/icon.png")).getImage();



        
        initComponents();
        //this.setVisible(false);
        //System.out.println("Started!");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
           frameSize.height = screenSize.height;
       }
       if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
       }
       setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
       setVisible(true);
       main = new Wordchoose(this, false);
        

        

       
    }
    public void insert( String word) {
        hs.insert(word);
    }
    
    public static final String getRbTok(String propToken) {
        // TODO Zusammenlegung mit basic.properties
String msg = "";
try {
msg = rb.getString(propToken);
} catch (MissingResourceException e) {
System.err.println("Token ".concat(propToken).concat(" not in Propertyfile!"));
}
System.out.println(msg);
return msg;
}
    public void export() throws IOException{
        SimpleDateFormat formatter = new SimpleDateFormat ("dd.MM.yyyy");
        Date currentTime = new Date();
        String text3 = formatter.format(currentTime);
        File outputFile = new File("Wortliste "+text3+".txt");
        FileWriter out = new FileWriter(outputFile);
        //System.out.println("Export starten!");
        //System.out.println(rfquery2.FahrtgebietName.size());
         java.util.List <String> words = hs.selectWords();
         for (String wor : words) {
            out.write(wor);
            out.write(System.getProperty("line.separator"));
        }
        out.close();
      
    }
    
    public void importing() throws FileNotFoundException, IOException{
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Text Dateien", "txt");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(this);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("Du hast diese Datei ausgewählt: " +
            chooser.getSelectedFile());
       File inputfile=  chooser.getSelectedFile();
       String s = null;
        StringBuffer datei = new StringBuffer();
        BufferedReader in = new BufferedReader(new FileReader(inputfile));
        while((s = in.readLine()) != null){
            //System.out.println(s);
            insert(s);

         //sqlcon.SqlAccess sql = new sqlcon.SqlAccess("INSERT INTO Words (Id, Word) VALUES (null, '"+s+"');");
         //System.out.println("Hi");
        }
        in.close();

    }
    }
    

    public void word(String w){
        word = w;
        //System.out.println(w);
        int length = word.length() -1 ;
        sub = word.substring(1, length);
        //System.out.println(sub);
        first = word.charAt(0);
        last = word.charAt(length);
        sub2 = sub.replaceAll(".", "_ ");
        String wo = first+sub2+last;
        jLabel2.setText(wo);

    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        letterf = new javax.swing.JTextField(1);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hangmanBean1 = new hangmanbeans.HangmanBean();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        LicenseInfos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman");
        setIconImage(img);

        letterf.setDocument(new SetMaxText(1));
        letterf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letterfActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("Wort");

        jLabel3.setText("Neuer Buchstabe:");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Benutzte Buchstaben:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(109, 109, 109))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(53, 53, 53)
                                .addComponent(letterf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(hangmanBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(letterf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(375, 375, 375))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(hangmanBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuItem5.setText("Neues Wort");
        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Wortliste importieren");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Wortliste exportieren");
        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Beenden");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu1.setText("Datei");

        jMenuBar1.add(jMenu1);

        jMenu2.setText("?");

        jMenuItem6.setText("Einstellungen");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem1.setText("Versionshinweise");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuItem1.setText("Versionshinweise");
        jMenu2.add(jMenuItem1);

        LicenseInfos.setText("Lizenzinformationen");
        LicenseInfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LicenseInfosActionPerformed(evt);
            }
        });
        jMenu2.add(LicenseInfos);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void letterfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letterfActionPerformed

    }//GEN-LAST:event_letterfActionPerformed
    private void winopen(String end){

          Win win = new Win(this, false,end);
          win.setTitle(end);
           if (packFrame) {
      win.pack();
    }
    else {
      win.validate();
    }
    //Das Fenster zentrieren
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = win.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    win.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    win.setVisible(true);

    }
   
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       clicks++;
       //char[] searchword;
       //System.out.println(clicks);
        //Auslesen des Buchstabens aus letterf
       String letter = letterf.getText();
       
           //Prüfe, ob Methode daserstemal ausgeführt wird
           if (clicks==1){
           //Länge des Mittelstrings sub
           int length = sub.length() ;
           //System.out.println(sub+" sub");
           // char[] Array des Mittelstrings

           searchword = new char[length];

           //jedes Zeichen vorläufig durcch "_ " ersetzen
           for ( int i = 0; i < searchword.length; i++ ){
               searchword[i]='_';
               
               
               
               
           }
           

           wordarray = sub.toCharArray();

           }
       if (!jLabel5.getText().contains(letter)){


       //Auslesen, ob letter in Mittelstring enthalten ist
       if (sub.contains(letter)){
           //System.out.println("else"); //Debug
           //Umwandlung String -> char
           char c = letter.charAt(0);
           
           //System.out.println(c);
           for ( int i = 0; i < wordarray.length; i++ ){
               //System.out.println(i);
               //System.out.println(wordarray[i]);
               if (wordarray[i]==c){
                  //System.out.println("True");
                  searchword[i]=c;
                  
               }
           }
           swAlsString=String.valueOf(searchword);
           //System.out.print(swAlsString);
           jLabel2.setText(first+swAlsString+last);
       }
       else {
           mistakes++;
           hangmanBean1.setImage(mistakes);
           if (hangmanBean1.getactualID()==10) {
               winopen("Verloren!!!");
           }
       }
       jLabel5.setText(jLabel5.getText()+letter+", ");
        }
       else {
           JOptionPane.showConfirmDialog(null,
                    "Buchstabe schon benutzt",
                    "Hangman", JOptionPane.CLOSED_OPTION,
                    JOptionPane.WARNING_MESSAGE);
       }
      letterf.setText("");
      String waAlsString= String.valueOf(wordarray);
      //System.out.println(waAlsString);
      //System.out.println(swAlsString);
      if(waAlsString.equals(swAlsString)){
          //System.out.println("Gewonnen!");
          winopen("Gewonnen!!!");
          clicks=0;


      }
      //String letters = jLabel5.getText();
      

       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            export();
            JOptionPane.showConfirmDialog(null,
                    "Export der Wortliste gelungen!",
                    "Hangman", JOptionPane.CLOSED_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException io){
            System.out.print(io);
            JOptionPane.showConfirmDialog(null,
                    "Export der Wortliste nicht gelungen!",
                    "Hangman", JOptionPane.CLOSED_OPTION,
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            importing();
            JOptionPane.showConfirmDialog(null,
                    "Import der Wortliste gelungen!",
                    "Hangman", JOptionPane.CLOSED_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException io){
            System.out.println(io);
            JOptionPane.showConfirmDialog(null,
                    "Import der Wortliste nicht gelungen!",
                    "Hangman", JOptionPane.CLOSED_OPTION,
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        main.setVisible(false);
        main = new Wordchoose(this, false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null,
                    "Version: " + version+System.getProperty("line.separator") + "Build: "+ getRbTok("BUILD"),
                    "Hangman",
                    JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       new SettingsDlg(this, true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void LicenseInfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LicenseInfosActionPerformed
        JOptionPane.showMessageDialog(null,
                    "Lizenz: GNU Public License " + System.getProperty("line.separator") + "Verion: 3 "+System.getProperty("line.separator")+"Dieses Programm wird ohne jegliche Garantie ausgeliefert."+ System.getProperty("line.separator")+" Eine Version der Lizenz sollte im Programmordner sein, fals nicht: <http://www.gnu.org/licenses/>"+System.getProperty("line.separator")+"\u00A9 2010 - 2011 Marco Ammon",
                    "Hangman",
                    JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_LicenseInfosActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem LicenseInfos;
    private hangmanbeans.HangmanBean hangmanBean1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    javax.swing.JTextField letterf;
    // End of variables declaration//GEN-END:variables

}
