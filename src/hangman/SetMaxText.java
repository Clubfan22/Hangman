/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;

/**
 *
 * @author Ammon
 */

import javax.swing.text.*;

public class SetMaxText extends PlainDocument {
  private int limit;
  // optional uppercase conversion
  private boolean toUppercase = false;

  SetMaxText(int limit) {
   super();
   this.limit = limit;
   }

  SetMaxText(int limit, boolean upper) {
   super();
   this.limit = limit;
   toUppercase = upper;
   }

    @Override
  public void insertString
    (int offset, String  str, AttributeSet attr)
      throws BadLocationException {
   if (str == null) return;

   if ((getLength() + str.length()) <= limit) {
     if (toUppercase) str = str.toUpperCase();
     super.insertString(offset, str, attr);
     }
   }
}
