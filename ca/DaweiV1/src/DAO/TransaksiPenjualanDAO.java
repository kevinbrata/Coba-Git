/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entity.TransaksiPenjualan;
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
public class TransaksiPenjualanDAO {
    
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction et;

    public TransaksiPenjualanDAO() {
        emf = Persistence.createEntityManagerFactory("DaweiV1PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }
    
    
    public List<TransaksiPenjualan> selectAll(){
        Query query = em.createQuery("SELECT tpj FROM TransaksiPenjualan tpj ORDER BY tpj.kodeBarang");
        return (List<TransaksiPenjualan>) query.getResultList();
    }
    
   
    public TransaksiPenjualan selectByKode(String kode){
        Query query = em.createQuery("SELECT tpj FROM TransaksiPenjualan tpj WHERE tpj.kodeBarang = '" + kode+"'");
        return (TransaksiPenjualan) query.getSingleResult();
    }
    public void insert(TransaksiPenjualan transaksiPenjualan){
        et.begin();
        em.persist(transaksiPenjualan);
        et.commit();
    }
    
    public void update(TransaksiPenjualan transaksiPenjualan){
        et.begin();
        em.merge(transaksiPenjualan);
        et.commit();
    }
    
    public void delete(TransaksiPenjualan transaksiPenjualan){
        et.begin();
        em.remove(em.merge(transaksiPenjualan));
        et.commit();
    }
    
}
