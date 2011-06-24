
package hangman;

/**
 *
 * @author Marco Ammon
 */
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.util.*;
public class Main {
    
 static Properties basicProperties = new Properties();
  public Main() {
      new AppFrame();
  }

    
    @SuppressWarnings("empty-statement")
  public static void main(String[] args) {
        File f = new File("basic.properties");
        System.out.println(f.getAbsolutePath());
        try {
Thread.sleep(1000);
} catch (Exception ex) {
System.out.println(ex);
}
        try {
      basicProperties.load(new FileInputStream("basic.properties"));
    }
    catch (java.io.IOException clientException) {
      JOptionPane.showConfirmDialog(null, "Fehler beim Einlesen der Anwendungeseinstellungen. Programm wird mit Standardeinstellungen gestartet.", "Hangman",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
      System.out.println(clientException);
      clientException.printStackTrace();
    }
    try {
        
      System.out.println(basicProperties.getProperty("LookAndFeel"));
      UIManager.setLookAndFeel(basicProperties.getProperty("LookAndFeel"));
    }
    catch(Exception e) {
      e.printStackTrace();
      try {
          UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );

      }
      catch(Exception e2){
          e2.printStackTrace();
      }
      
    }
    new AppFrame();

  }
 }
