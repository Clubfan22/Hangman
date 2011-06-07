/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author Ammon
 */
public class HibernateService {
    
    public void insert(String word) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WordsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Words wo = new Words(word);
        em.persist(wo);
        tx.commit(); 
        em.close();
        emf.close();
    }
    public Words select(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WordsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query qu = em.createQuery("select w from Words w where w.id = :id");
        qu.setParameter("id", id);
        Words word = (Words) qu.getSingleResult();
        return word;
    }
    public String selectWord(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WordsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query qu = em.createQuery("select w from Words w where w.id = :id");
        qu.setParameter("id", id);
        Words word = (Words) qu.getSingleResult();
        return word.getWord();
    }
    public List <Words> select() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WordsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select w from Words w");
        List <Words> wol = query.getResultList();
        tx.commit();
        em.close();
        emf.close();
        return wol;
    }
    public int getSize() {
        List word = select();
        return word.size();
    }
}
