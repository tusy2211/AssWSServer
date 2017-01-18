/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author khanh
 */
@Entity
@Table(name = "lichsugd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lichsugd.findAll", query = "SELECT l FROM Lichsugd l")
    , @NamedQuery(name = "Lichsugd.findByMagiaodich", query = "SELECT l FROM Lichsugd l WHERE l.magiaodich = :magiaodich")
    , @NamedQuery(name = "Lichsugd.findByNguoigui", query = "SELECT l FROM Lichsugd l WHERE l.nguoigui = :nguoigui")
    , @NamedQuery(name = "Lichsugd.findByNguoinhan", query = "SELECT l FROM Lichsugd l WHERE l.nguoinhan = :nguoinhan")
    , @NamedQuery(name = "Lichsugd.findByThoigiangiaodich", query = "SELECT l FROM Lichsugd l WHERE l.thoigiangiaodich = :thoigiangiaodich")
    , @NamedQuery(name = "Lichsugd.findBySotiengiaodich", query = "SELECT l FROM Lichsugd l WHERE l.sotiengiaodich = :sotiengiaodich")
    , @NamedQuery(name = "Lichsugd.findByPhigiaodich", query = "SELECT l FROM Lichsugd l WHERE l.phigiaodich = :phigiaodich")
    , @NamedQuery(name = "Lichsugd.findBySogd", query = "SELECT l FROM Lichsugd l WHERE l.sogd = :sogd")})
public class Lichsugd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "magiaodich")
    private Integer magiaodich;
    @Column(name = "nguoigui")
    private String nguoigui;
    @Column(name = "nguoinhan")
    private String nguoinhan;
    @Column(name = "thoigiangiaodich")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiangiaodich;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sotiengiaodich")
    private Double sotiengiaodich;
    @Column(name = "phigiaodich")
    private Double phigiaodich;
    @Column(name = "sogd")
    private Integer sogd;

    public Lichsugd() {
    }

    public Lichsugd(Integer magiaodich) {
        this.magiaodich = magiaodich;
    }

    public Integer getMagiaodich() {
        return magiaodich;
    }

    public void setMagiaodich(Integer magiaodich) {
        this.magiaodich = magiaodich;
    }

    public String getNguoigui() {
        return nguoigui;
    }

    public void setNguoigui(String nguoigui) {
        this.nguoigui = nguoigui;
    }

    public String getNguoinhan() {
        return nguoinhan;
    }

    public void setNguoinhan(String nguoinhan) {
        this.nguoinhan = nguoinhan;
    }

    public Date getThoigiangiaodich() {
        return thoigiangiaodich;
    }

    public void setThoigiangiaodich(Date thoigiangiaodich) {
        this.thoigiangiaodich = thoigiangiaodich;
    }

    public Double getSotiengiaodich() {
        return sotiengiaodich;
    }

    public void setSotiengiaodich(Double sotiengiaodich) {
        this.sotiengiaodich = sotiengiaodich;
    }

    public Double getPhigiaodich() {
        return phigiaodich;
    }

    public void setPhigiaodich(Double phigiaodich) {
        this.phigiaodich = phigiaodich;
    }

    public Integer getSogd() {
        return sogd;
    }

    public void setSogd(Integer sogd) {
        this.sogd = sogd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (magiaodich != null ? magiaodich.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lichsugd)) {
            return false;
        }
        Lichsugd other = (Lichsugd) object;
        if ((this.magiaodich == null && other.magiaodich != null) || (this.magiaodich != null && !this.magiaodich.equals(other.magiaodich))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lichsugd[ magiaodich=" + magiaodich + " ]";
    }
    
}
