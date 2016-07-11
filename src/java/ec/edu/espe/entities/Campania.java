/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "CAMPANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campania.findAll", query = "SELECT c FROM Campania c"),
    @NamedQuery(name = "Campania.findByRuc", query = "SELECT c FROM Campania c WHERE c.campaniaPK.ruc = :ruc"),
    @NamedQuery(name = "Campania.findBySecCampania", query = "SELECT c FROM Campania c WHERE c.campaniaPK.secCampania = :secCampania"),
    @NamedQuery(name = "Campania.findByNombre", query = "SELECT c FROM Campania c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Campania.findByDescripcion", query = "SELECT c FROM Campania c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Campania.findByFechaCreacion", query = "SELECT c FROM Campania c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Campania.findByFechaInicio", query = "SELECT c FROM Campania c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Campania.findByFechaFin", query = "SELECT c FROM Campania c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "Campania.findByEstado", query = "SELECT c FROM Campania c WHERE c.estado = :estado")})
public class Campania implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CampaniaPK campaniaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "campania")
    private EstadisticaCampania estadisticaCampania;
    @OneToMany(mappedBy = "campania")
    private Collection<HistorialCampania> historialCampaniaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campania")
    private Collection<DetalleCampania> detalleCampaniaCollection;
    @JoinColumn(name = "RUC", referencedColumnName = "RUC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Campania() {
    }

    public Campania(CampaniaPK campaniaPK) {
        this.campaniaPK = campaniaPK;
    }

    public Campania(CampaniaPK campaniaPK, String nombre, String descripcion, Date fechaCreacion, Date fechaInicio, Date fechaFin, String estado) {
        this.campaniaPK = campaniaPK;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Campania(String ruc, Integer secCampania) {
        this.campaniaPK = new CampaniaPK(ruc, secCampania);
    }

    public CampaniaPK getCampaniaPK() {
        return campaniaPK;
    }

    public void setCampaniaPK(CampaniaPK campaniaPK) {
        this.campaniaPK = campaniaPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadisticaCampania getEstadisticaCampania() {
        return estadisticaCampania;
    }

    public void setEstadisticaCampania(EstadisticaCampania estadisticaCampania) {
        this.estadisticaCampania = estadisticaCampania;
    }

    @XmlTransient
    public Collection<HistorialCampania> getHistorialCampaniaCollection() {
        return historialCampaniaCollection;
    }

    public void setHistorialCampaniaCollection(Collection<HistorialCampania> historialCampaniaCollection) {
        this.historialCampaniaCollection = historialCampaniaCollection;
    }

    @XmlTransient
    public Collection<DetalleCampania> getDetalleCampaniaCollection() {
        return detalleCampaniaCollection;
    }

    public void setDetalleCampaniaCollection(Collection<DetalleCampania> detalleCampaniaCollection) {
        this.detalleCampaniaCollection = detalleCampaniaCollection;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campaniaPK != null ? campaniaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campania)) {
            return false;
        }
        Campania other = (Campania) object;
        if ((this.campaniaPK == null && other.campaniaPK != null) || (this.campaniaPK != null && !this.campaniaPK.equals(other.campaniaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.Campania[ campaniaPK=" + campaniaPK + " ]";
    }
    
}
