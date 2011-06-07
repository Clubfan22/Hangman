
package hangman;

/**
 *
 * @author Ammon
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.util.*;
public class Main {
    boolean packFrame = false;
 static Properties basicProperties = new Properties();
 public Main(){
     HibernateService hs = new HibernateService();
     System.out.println(hs.getSize());
     //System.out.println(hs.selectWord(1));

      AppFrame main = new AppFrame();
      main.setVisible(false);
    //Frames ueberpruefen, die voreingestellte Groesse haben
    //Frames packen, die nutzbare bevorzugte Groeßeninformationen
    //enthalten, z.B. aus ihrem Layout
    if (packFrame) {
      main.pack();
    }
    else {
      main.validate();
    }
    //Das Fenster zentrieren
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = main.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    main.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    main.setVisible(true);
   }
 

    
    @SuppressWarnings("empty-statement")
  public static void main(String[] args) {
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
    new Main();

  }
 }
