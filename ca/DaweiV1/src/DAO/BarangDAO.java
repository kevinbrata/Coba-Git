/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Barang;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Cavin Wijaya
 */
public class BarangDAO {
    
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction et;

    public BarangDAO() {
        emf = Persistence.createEntityManagerFactory("DaweiV1PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }
    
    public List<Barang> select(String parameter){
        Query query = em.createQuery("SELECT b FROM Barang b WHERE b.kodeBarang LIKE '%"+parameter+"%' "+
                                          "ORDER BY b.kodeBarang");
        return (List<Barang>) query.getResultList();
    }
    
    public List<Barang> selectAll(){
        Query query = em.createQuery("SELECT b FROM Barang b ORDER BY b.kodeBarang");
        return (List<Barang>) query.getResultList();
    }
    
   
    public Barang selectByKode(String kode){
        Query query = em.createQuery("SELECT b FROM Barang b WHERE b.namaBarang = '" + kode+"'");
        return (Barang) query.getSingleResult();
    }
    public Barang cobaCoba(String kode){
        Query query = em.createQuery("SELECT b.stok FROM Barang b WHERE b.kodeBarang = '" + kode+"'");
        return (Barang) query.getSingleResult();
        // apa bedanya? wkwkkwkwkww tar
    }
    public int updateByKode(int jmlhstk, String kode){
        Query query = em.createQuery("UPDATE Barang b SET b.stok = b.stok - "+jmlhstk+" WHERE b.kodeBarang = '" + kode+"'");
        return query.executeUpdate();
    }
    public void insert(Barang barang){
        et.begin();
        em.persist(barang);
        et.commit();
    }
    
    public void update(Barang barang){
        et.begin();
        em.merge(barang);//liat koding bang dika yang update jtablenya
        et.commit();
    }
    
    public void delete(Barang barang){
        et.begin();
        em.remove(em.merge(barang));
        et.commit();
    }
    
}
