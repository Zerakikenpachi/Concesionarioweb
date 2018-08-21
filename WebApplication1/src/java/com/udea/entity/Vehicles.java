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
import javax.persistence.Lob;
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
@Table(name = "vehicles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicles.findAll", query = "SELECT v FROM Vehicles v")
    , @NamedQuery(name = "Vehicles.findByEnrollment", query = "SELECT v FROM Vehicles v WHERE v.enrollment = :enrollment")
    , @NamedQuery(name = "Vehicles.findByBrand", query = "SELECT v FROM Vehicles v WHERE v.brand = :brand")
    , @NamedQuery(name = "Vehicles.findByModel", query = "SELECT v FROM Vehicles v WHERE v.model = :model")
    , @NamedQuery(name = "Vehicles.findByValor", query = "SELECT v FROM Vehicles v WHERE v.valor = :valor")})
public class Vehicles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "enrollment")
    private String enrollment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;

    public Vehicles() {
    }

    public Vehicles(String enrollment) {
        this.enrollment = enrollment;
    }

    public Vehicles(String enrollment, String brand, String model, byte[] image, int valor) {
        this.enrollment = enrollment;
        this.brand = brand;
        this.model = model;
        this.image = image;
        this.valor = valor;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollment != null ? enrollment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicles)) {
            return false;
        }
        Vehicles other = (Vehicles) object;
        if ((this.enrollment == null && other.enrollment != null) || (this.enrollment != null && !this.enrollment.equals(other.enrollment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Vehicles[ enrollment=" + enrollment + " ]";
    }
    
}
