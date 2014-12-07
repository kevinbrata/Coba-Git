/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "transaksi_penjualan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaksiPenjualan.findAll", query = "SELECT t FROM TransaksiPenjualan t"),
    @NamedQuery(name = "TransaksiPenjualan.findById", query = "SELECT t FROM TransaksiPenjualan t WHERE t.id = :id"),
    @NamedQuery(name = "TransaksiPenjualan.findByKodeBarang", query = "SELECT t FROM TransaksiPenjualan t WHERE t.kodeBarang = :kodeBarang"),
    @NamedQuery(name = "TransaksiPenjualan.findByNamaBarang", query = "SELECT t FROM TransaksiPenjualan t WHERE t.namaBarang = :namaBarang"),
    @NamedQuery(name = "TransaksiPenjualan.findByJumlahJual", query = "SELECT t FROM TransaksiPenjualan t WHERE t.jumlahJual = :jumlahJual"),
    @NamedQuery(name = "TransaksiPenjualan.findBySubtotal", query = "SELECT t FROM TransaksiPenjualan t WHERE t.subtotal = :subtotal"),
    @NamedQuery(name = "TransaksiPenjualan.findByHarga", query = "SELECT t FROM TransaksiPenjualan t WHERE t.harga = :harga")})
public class TransaksiPenjualan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "kode_barang")
    private String kodeBarang;
    @Basic(optional = false)
    @Column(name = "nama_barang")
    private String namaBarang;
    @Basic(optional = false)
    @Column(name = "jumlah_jual")
    private int jumlahJual;
    @Basic(optional = false)
    @Column(name = "subtotal")
    private int subtotal;
    @Basic(optional = false)
    @Column(name = "harga")
    private int harga;

    public TransaksiPenjualan() {
    }

    public TransaksiPenjualan(Integer id) {
        this.id = id;
    }

    public TransaksiPenjualan(Integer id, String kodeBarang, String namaBarang, int jumlahJual, int subtotal, int harga) {
        this.id = id;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jumlahJual = jumlahJual;
        this.subtotal = subtotal;
        this.harga = harga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getJumlahJual() {
        return jumlahJual;
    }

    public void setJumlahJual(int jumlahJual) {
        this.jumlahJual = jumlahJual;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaksiPenjualan)) {
            return false;
        }
        TransaksiPenjualan other = (TransaksiPenjualan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TransaksiPenjualan[ id=" + id + " ]";
    }
    
}
