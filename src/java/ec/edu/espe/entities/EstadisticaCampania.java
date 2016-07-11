/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "ESTADISTICA_CAMPANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadisticaCampania.findAll", query = "SELECT e FROM EstadisticaCampania e"),
    @NamedQuery(name = "EstadisticaCampania.findByRuc", query = "SELECT e FROM EstadisticaCampania e WHERE e.estadisticaCampaniaPK.ruc = :ruc"),
    @NamedQuery(name = "EstadisticaCampania.findBySecCampania", query = "SELECT e FROM EstadisticaCampania e WHERE e.estadisticaCampaniaPK.secCampania = :secCampania"),
    @NamedQuery(name = "EstadisticaCampania.findByDespliegues", query = "SELECT e FROM EstadisticaCampania e WHERE e.despliegues = :despliegues"),
    @NamedQuery(name = "EstadisticaCampania.findByClics", query = "SELECT e FROM EstadisticaCampania e WHERE e.clics = :clics")})
public class EstadisticaCampania implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadisticaCampaniaPK estadisticaCampaniaPK;
    @Column(name = "DESPLIEGUES")
    private BigInteger despliegues;
    @Column(name = "CLICS")
    private BigInteger clics;
    @JoinColumns({
        @JoinColumn(name = "RUC", referencedColumnName = "RUC", insertable = false, updatable = false),
        @JoinColumn(name = "SEC_CAMPANIA", referencedColumnName = "SEC_CAMPANIA", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Campania campania;

    public EstadisticaCampania() {
    }

    public EstadisticaCampania(EstadisticaCampaniaPK estadisticaCampaniaPK) {
        this.estadisticaCampaniaPK = estadisticaCampaniaPK;
    }

    public EstadisticaCampania(String ruc, Integer secCampania) {
        this.estadisticaCampaniaPK = new EstadisticaCampaniaPK(ruc, secCampania);
    }

    public EstadisticaCampaniaPK getEstadisticaCampaniaPK() {
        return estadisticaCampaniaPK;
    }

    public void setEstadisticaCampaniaPK(EstadisticaCampaniaPK estadisticaCampaniaPK) {
        this.estadisticaCampaniaPK = estadisticaCampaniaPK;
    }

    public BigInteger getDespliegues() {
        return despliegues;
    }

    public void setDespliegues(BigInteger despliegues) {
        this.despliegues = despliegues;
    }

    public BigInteger getClics() {
        return clics;
    }

    public void setClics(BigInteger clics) {
        this.clics = clics;
    }

    public Campania getCampania() {
        return campania;
    }

    public void setCampania(Campania campania) {
        this.campania = campania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadisticaCampaniaPK != null ? estadisticaCampaniaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaCampania)) {
            return false;
        }
        EstadisticaCampania other = (EstadisticaCampania) object;
        if ((this.estadisticaCampaniaPK == null && other.estadisticaCampaniaPK != null) || (this.estadisticaCampaniaPK != null && !this.estadisticaCampaniaPK.equals(other.estadisticaCampaniaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.EstadisticaCampania[ estadisticaCampaniaPK=" + estadisticaCampaniaPK + " ]";
    }
    
}
