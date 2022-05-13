/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbapp;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author igor
 */
public class Dbapp {

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        create();
//    }
//
//    public static void create() {
//        Polozka p = new Polozka();
//        Faktura f = new Faktura();
//        f.getPolozky().add(p);
//        f.setZakaznik("Jozo");
//        f.setAktualizacia(new Date());
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        try {
//            em.persist(p);
//            em.persist(f);
//            em.getTransaction().commit();
//            System.out.println("HOTOVO");
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//    }

    public static int pocetFaktur(String z) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery tq = em.createQuery("select f from Faktura f where f.zakaznik='" + z + "'", Faktura.class);
        List<Faktura> fl = tq.getResultList();
        if (fl == null) {
            return 0;
        }
        return fl.size();
    }

    public static void pridajPolozku(int id, String produkt, double cena) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Faktura f = em.find(Faktura.class, id);
            if (f != null) {
                Polozka p = new Polozka();
                p.setCena(cena);
                p.setProdukt(produkt);
                em.persist(p);
                f.getPolozky().add(p);
                f.setAktualizacia(new Date());
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
