/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "HISTORIAL_CAMPANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialCampania.findAll", query = "SELECT h FROM HistorialCampania h"),
    @NamedQuery(name = "HistorialCampania.findByIdHistorialCampania", query = "SELECT h FROM HistorialCampania h WHERE h.idHistorialCampania = :idHistorialCampania"),
    @NamedQuery(name = "HistorialCampania.findByFechaCompra", query = "SELECT h FROM HistorialCampania h WHERE h.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "HistorialCampania.findByClics", query = "SELECT h FROM HistorialCampania h WHERE h.clics = :clics"),
    @NamedQuery(name = "HistorialCampania.findByCostoClic", query = "SELECT h FROM HistorialCampania h WHERE h.costoClic = :costoClic"),
    @NamedQuery(name = "HistorialCampania.findByDespliegues", query = "SELECT h FROM HistorialCampania h WHERE h.despliegues = :despliegues"),
    @NamedQuery(name = "HistorialCampania.findByCostoDespliegue", query = "SELECT h FROM HistorialCampania h WHERE h.costoDespliegue = :costoDespliegue")})
public class HistorialCampania implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="seq_id_historial_campania", sequenceName = "SEQUENCE_ID_HISTORIAL_CAMPANIA",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_historial_campania")
    @NotNull
    @Column(name = "ID_HISTORIAL_CAMPANIA")
    private Integer idHistorialCampania;
    @Column(name = "FECHA_COMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @Column(name = "CLICS")
    private BigInteger clics;
    @Column(name = "COSTO_CLIC")
    private BigDecimal costoClic;
    @Column(name = "DESPLIEGUES")
    private BigInteger despliegues;
    @Column(name = "COSTO_DESPLIEGUE")
    private BigDecimal costoDespliegue;
    @JoinColumns({
        @JoinColumn(name = "RUC", referencedColumnName = "RUC"),
        @JoinColumn(name = "SEC_CAMPANIA", referencedColumnName = "SEC_CAMPANIA")})
    @ManyToOne
    private Campania campania;

    public HistorialCampania() {
    }

    public HistorialCampania(Integer idHistorialCampania) {
        this.idHistorialCampania = idHistorialCampania;
    }

    public Integer getIdHistorialCampania() {
        return idHistorialCampania;
    }

    public void setIdHistorialCampania(Integer idHistorialCampania) {
        this.idHistorialCampania = idHistorialCampania;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigInteger getClics() {
        return clics;
    }

    public void setClics(BigInteger clics) {
        this.clics = clics;
    }

    public BigDecimal getCostoClic() {
        return costoClic;
    }

    public void setCostoClic(BigDecimal costoClic) {
        this.costoClic = costoClic;
    }

    public BigInteger getDespliegues() {
        return despliegues;
    }

    public void setDespliegues(BigInteger despliegues) {
        this.despliegues = despliegues;
    }

    public BigDecimal getCostoDespliegue() {
        return costoDespliegue;
    }

    public void setCostoDespliegue(BigDecimal costoDespliegue) {
        this.costoDespliegue = costoDespliegue;
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
        hash += (idHistorialCampania != null ? idHistorialCampania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialCampania)) {
            return false;
        }
        HistorialCampania other = (HistorialCampania) object;
        if ((this.idHistorialCampania == null && other.idHistorialCampania != null) || (this.idHistorialCampania != null && !this.idHistorialCampania.equals(other.idHistorialCampania))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.HistorialCampania[ idHistorialCampania=" + idHistorialCampania + " ]";
    }
    
}
