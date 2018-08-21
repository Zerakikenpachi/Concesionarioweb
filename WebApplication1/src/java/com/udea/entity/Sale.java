/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor restrepo
 */
@Entity
@Table(name = "sale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")
    , @NamedQuery(name = "Sale.findById", query = "SELECT s FROM Sale s WHERE s.id = :id")
    , @NamedQuery(name = "Sale.findByClient", query = "SELECT s FROM Sale s WHERE s.client = :client")
    , @NamedQuery(name = "Sale.findByEnrollment", query = "SELECT s FROM Sale s WHERE s.enrollment = :enrollment")
    , @NamedQuery(name = "Sale.findByPayment", query = "SELECT s FROM Sale s WHERE s.payment = :payment")
    , @NamedQuery(name = "Sale.findByGiveback", query = "SELECT s FROM Sale s WHERE s.giveback = :giveback")})
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "client")
    private String client;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "enrollment")
    private String enrollment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "payment")
    private String payment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "giveback")
    private String giveback;

    public Sale() {
    }

    public Sale(String id) {
        this.id = id;
    }

    public Sale(String id, String client, String enrollment, String payment, String giveback) {
        this.id = id;
        this.client = client;
        this.enrollment = enrollment;
        this.payment = payment;
        this.giveback = giveback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getGiveback() {
        return giveback;
    }

    public void setGiveback(String giveback) {
        this.giveback = giveback;
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
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Sale[ id=" + id + " ]";
    }
    
}
