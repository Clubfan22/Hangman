/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;

/**
 *
 * @author Ammon
 */
class region {
private int id;
private String regionname;
public region (int id, String regionname) {
this.id=id;
this.regionname=regionname;
}
public final String getRegionName() {
return regionname;
}
public final int getRegionID() {
return id;
}
public String toString() {
return regionname;
}
}