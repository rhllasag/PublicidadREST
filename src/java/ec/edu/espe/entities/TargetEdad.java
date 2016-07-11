/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "TARGET_EDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TargetEdad.findAll", query = "SELECT t FROM TargetEdad t"),
    @NamedQuery(name = "TargetEdad.findByRuc", query = "SELECT t FROM TargetEdad t WHERE t.targetEdadPK.ruc = :ruc"),
    @NamedQuery(name = "TargetEdad.findByIdTargetEdad", query = "SELECT t FROM TargetEdad t WHERE t.targetEdadPK.idTargetEdad = :idTargetEdad"),
    @NamedQuery(name = "TargetEdad.findByNombre", query = "SELECT t FROM TargetEdad t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TargetEdad.findByDescripcion", query = "SELECT t FROM TargetEdad t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TargetEdad.findByEdadMinima", query = "SELECT t FROM TargetEdad t WHERE t.edadMinima = :edadMinima"),
    @NamedQuery(name = "TargetEdad.findByEdadMaxima", query = "SELECT t FROM TargetEdad t WHERE t.edadMaxima = :edadMaxima"),
    @NamedQuery(name = "TargetEdad.findByGenero", query = "SELECT t FROM TargetEdad t WHERE t.genero = :genero")})
public class TargetEdad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TargetEdadPK targetEdadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 128)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDAD_MINIMA")
    private Integer edadMinima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDAD_MAXIMA")
    private Integer edadMaxima;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "GENERO")
    private String genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetEdad")
    private Collection<SegmentoDetalleCampania> segmentoDetalleCampaniaCollection;
    @JoinColumn(name = "RUC", referencedColumnName = "RUC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;

    public TargetEdad() {
    }

    public TargetEdad(TargetEdadPK targetEdadPK) {
        this.targetEdadPK = targetEdadPK;
    }

    public TargetEdad(TargetEdadPK targetEdadPK, String nombre, Integer edadMinima, Integer edadMaxima, String genero) {
        this.targetEdadPK = targetEdadPK;
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.genero = genero;
    }

    public TargetEdad(String ruc, Integer idTargetEdad) {
        this.targetEdadPK = new TargetEdadPK(ruc, idTargetEdad);
    }

    public TargetEdadPK getTargetEdadPK() {
        return targetEdadPK;
    }

    public void setTargetEdadPK(TargetEdadPK targetEdadPK) {
        this.targetEdadPK = targetEdadPK;
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

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Integer getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(Integer edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @XmlTransient
    public Collection<SegmentoDetalleCampania> getSegmentoDetalleCampaniaCollection() {
        return segmentoDetalleCampaniaCollection;
    }

    public void setSegmentoDetalleCampaniaCollection(Collection<SegmentoDetalleCampania> segmentoDetalleCampaniaCollection) {
        this.segmentoDetalleCampaniaCollection = segmentoDetalleCampaniaCollection;
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
        hash += (targetEdadPK != null ? targetEdadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TargetEdad)) {
            return false;
        }
        TargetEdad other = (TargetEdad) object;
        if ((this.targetEdadPK == null && other.targetEdadPK != null) || (this.targetEdadPK != null && !this.targetEdadPK.equals(other.targetEdadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.TargetEdad[ targetEdadPK=" + targetEdadPK + " ]";
    }
    
}
