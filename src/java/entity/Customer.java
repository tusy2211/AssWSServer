/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author khanh
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByMakhachhang", query = "SELECT c FROM Customer c WHERE c.makhachhang = :makhachhang")
    , @NamedQuery(name = "Customer.findByMatkhau", query = "SELECT c FROM Customer c WHERE c.matkhau = :matkhau")
    , @NamedQuery(name = "Customer.findByMataikhoan", query = "SELECT c FROM Customer c WHERE c.mataikhoan = :mataikhoan")
    , @NamedQuery(name = "Customer.findBySodu", query = "SELECT c FROM Customer c WHERE c.sodu = :sodu")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "makhachhang")
    private String makhachhang;
    @Column(name = "matkhau")
    private String matkhau;
    @Column(name = "mataikhoan")
    private String mataikhoan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sodu")
    private Double sodu;

    public Customer() {
    }

    public Customer(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(String mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public Double getSodu() {
        return sodu;
    }

    public void setSodu(Double sodu) {
        this.sodu = sodu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (makhachhang != null ? makhachhang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.makhachhang == null && other.makhachhang != null) || (this.makhachhang != null && !this.makhachhang.equals(other.makhachhang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ makhachhang=" + makhachhang + " ]";
    }
    
}
