/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "DETALLE_CAMPANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCampania.findAll", query = "SELECT d FROM DetalleCampania d"),
    @NamedQuery(name = "DetalleCampania.findByRuc", query = "SELECT d FROM DetalleCampania d WHERE d.detalleCampaniaPK.ruc = :ruc"),
    @NamedQuery(name = "DetalleCampania.findBySecCampania", query = "SELECT d FROM DetalleCampania d WHERE d.detalleCampaniaPK.secCampania = :secCampania"),
    @NamedQuery(name = "DetalleCampania.findByIdElemento", query = "SELECT d FROM DetalleCampania d WHERE d.detalleCampaniaPK.idElemento = :idElemento"),
    @NamedQuery(name = "DetalleCampania.findByDespliegues", query = "SELECT d FROM DetalleCampania d WHERE d.despliegues = :despliegues"),
    @NamedQuery(name = "DetalleCampania.findByClics", query = "SELECT d FROM DetalleCampania d WHERE d.clics = :clics"),
    @NamedQuery(name = "DetalleCampania.findByModoFacturacion", query = "SELECT d FROM DetalleCampania d WHERE d.modoFacturacion = :modoFacturacion")})
public class DetalleCampania implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCampaniaPK detalleCampaniaPK;
    @Column(name = "DESPLIEGUES")
    private BigInteger despliegues;
    @Column(name = "CLICS")
    private BigInteger clics;
    @Column(name = "PRECIO_UNITARIO")
    private BigDecimal precioUnitario;
    @Size(max = 3)
    @Column(name = "MODO_FACTURACION")
    private String modoFacturacion;
    @JoinColumns({
        @JoinColumn(name = "RUC", referencedColumnName = "RUC", insertable = false, updatable = false),
        @JoinColumn(name = "SEC_CAMPANIA", referencedColumnName = "SEC_CAMPANIA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Campania campania;
    @JoinColumn(name = "ID_ELEMENTO", referencedColumnName = "ID_ELEMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Elemento elemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleCampania")
    private Collection<SegmentoDetalleCampania> segmentoDetalleCampaniaCollection;

    public DetalleCampania() {
    }

    public DetalleCampania(DetalleCampaniaPK detalleCampaniaPK) {
        this.detalleCampaniaPK = detalleCampaniaPK;
    }

    public DetalleCampania(String ruc, Integer secCampania, Integer idElemento) {
        this.detalleCampaniaPK = new DetalleCampaniaPK(ruc, secCampania, idElemento);
    }

    public DetalleCampaniaPK getDetalleCampaniaPK() {
        return detalleCampaniaPK;
    }

    public void setDetalleCampaniaPK(DetalleCampaniaPK detalleCampaniaPK) {
        this.detalleCampaniaPK = detalleCampaniaPK;
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

    public String getModoFacturacion() {
        return modoFacturacion;
    }

    public void setModoFacturacion(String modoFacturacion) {
        this.modoFacturacion = modoFacturacion;
    }

    public Campania getCampania() {
        return campania;
    }

    public void setCampania(Campania campania) {
        this.campania = campania;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @XmlTransient
    public Collection<SegmentoDetalleCampania> getSegmentoDetalleCampaniaCollection() {
        return segmentoDetalleCampaniaCollection;
    }

    public void setSegmentoDetalleCampaniaCollection(Collection<SegmentoDetalleCampania> segmentoDetalleCampaniaCollection) {
        this.segmentoDetalleCampaniaCollection = segmentoDetalleCampaniaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCampaniaPK != null ? detalleCampaniaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCampania)) {
            return false;
        }
        DetalleCampania other = (DetalleCampania) object;
        if ((this.detalleCampaniaPK == null && other.detalleCampaniaPK != null) || (this.detalleCampaniaPK != null && !this.detalleCampaniaPK.equals(other.detalleCampaniaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.DetalleCampania[ detalleCampaniaPK=" + detalleCampaniaPK + " ]";
    }

}
