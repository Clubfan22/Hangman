/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Ammon
 */
@Entity
@Table (name = "Words")
//@Table (name = "Words", uniqueConstraints = {@UniqueConstraint(columnNames={"word"})})
public class Words implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column ( name = "id")
    private Integer id;
    
    @Column (name= "word")
    private String word;
    
    
    protected Words() {
    }
    public Words(String word){
        this.word=word;
        
    }
        public Integer getId(){
        return id;
    }
    protected void setId(Integer id){
        this.id=id;
    }
        public String getWord(){
        return word;
    }
    public void setWord(String word){
        this.word=word;
    }
    @Override
    public boolean equals(Object o){
      if (this == o)return true;
      if (o == null|| getClass() != o.getClass()) return false;
      Words w = (Words) o;
      return !(id != null ? !id.equals(w.id) : w.id != null);
    }
    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() :0;
    }
    @Override
    public String toString(){
        return "Words [id: "+id+" word: "+word+"]";
    }
}
