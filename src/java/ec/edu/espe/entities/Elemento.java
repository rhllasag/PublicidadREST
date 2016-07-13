/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "ELEMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e"),
    @NamedQuery(name = "Elemento.findByIdElemento", query = "SELECT e FROM Elemento e WHERE e.idElemento = :idElemento"),
    @NamedQuery(name = "Elemento.findByNombre", query = "SELECT e FROM Elemento e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Elemento.findByPosicion", query = "SELECT e FROM Elemento e WHERE e.posicion = :posicion"),
    @NamedQuery(name = "Elemento.findByUrl", query = "SELECT e FROM Elemento e WHERE e.url = :url"),
    @NamedQuery(name = "Elemento.findByPath", query = "SELECT e FROM Elemento e WHERE e.path = :path")})
public class Elemento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="seq_elemento", sequenceName = "SEQUENCE_ELEMENTO",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_elemento")
    @NotNull
    @Column(name = "ID_ELEMENTO")
    private Integer idElemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "POSICION")
    private String posicion;
    @Size(max = 512)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "PATH")
    private String path;
    @Size(max = 800)
    @Column(name = "NOMBRE_IMAGEN")
    private String nombreImagen;
    @Size(max = 13)
    @Column(name = "RUC")
    private String ruc;
    @Size(max = 300)
    @Column(name = "PANTALLA")
    private String pantalla;

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elemento")
    private Collection<DetalleCampania> detalleCampaniaCollection;

    public Elemento() {
    }

    public Elemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public Elemento(Integer idElemento, String nombre, String posicion, String path) {
        this.idElemento = idElemento;
        this.nombre = nombre;
        this.posicion = posicion;
        this.path = path;
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @XmlTransient
    public Collection<DetalleCampania> getDetalleCampaniaCollection() {
        return detalleCampaniaCollection;
    }

    public void setDetalleCampaniaCollection(Collection<DetalleCampania> detalleCampaniaCollection) {
        this.detalleCampaniaCollection = detalleCampaniaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idElemento != null ? idElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.idElemento == null && other.idElemento != null) || (this.idElemento != null && !this.idElemento.equals(other.idElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.Elemento[ idElemento=" + idElemento + " ]";
    }
    
}
