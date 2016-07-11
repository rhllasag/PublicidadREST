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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "SEGMENTO_DETALLE_CAMPANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegmentoDetalleCampania.findAll", query = "SELECT s FROM SegmentoDetalleCampania s"),
    @NamedQuery(name = "SegmentoDetalleCampania.findByRuc", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.segmentoDetalleCampaniaPK.ruc = :ruc"),
    @NamedQuery(name = "SegmentoDetalleCampania.findBySecCampania", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.segmentoDetalleCampaniaPK.secCampania = :secCampania"),
    @NamedQuery(name = "SegmentoDetalleCampania.findByIdElemento", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.segmentoDetalleCampaniaPK.idElemento = :idElemento"),
    @NamedQuery(name = "SegmentoDetalleCampania.findByTarRuc", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.segmentoDetalleCampaniaPK.tarRuc = :tarRuc"),
    @NamedQuery(name = "SegmentoDetalleCampania.findByIdTargetEdad", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.segmentoDetalleCampaniaPK.idTargetEdad = :idTargetEdad"),
    @NamedQuery(name = "SegmentoDetalleCampania.findByHoraInicio", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.horaInicio = :horaInicio"),
    @NamedQuery(name = "SegmentoDetalleCampania.findByHoraFin", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.horaFin = :horaFin"),
    @NamedQuery(name = "SegmentoDetalleCampania.findByMaximoHora", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.maximoHora = :maximoHora"),
    @NamedQuery(name = "SegmentoDetalleCampania.findByMinimoHora", query = "SELECT s FROM SegmentoDetalleCampania s WHERE s.minimoHora = :minimoHora")})
public class SegmentoDetalleCampania implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegmentoDetalleCampaniaPK segmentoDetalleCampaniaPK;
    @Size(max = 5)
    @Column(name = "HORA_INICIO")
    private String horaInicio;
    @Size(max = 5)
    @Column(name = "HORA_FIN")
    private String horaFin;
    @Size(max = 5)
    @Column(name = "MAXIMO_HORA")
    private String maximoHora;
    @Size(max = 5)
    @Column(name = "MINIMO_HORA")
    private String minimoHora;
    @JoinColumns({
        @JoinColumn(name = "RUC", referencedColumnName = "RUC", insertable = false, updatable = false),
        @JoinColumn(name = "SEC_CAMPANIA", referencedColumnName = "SEC_CAMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "ID_ELEMENTO", referencedColumnName = "ID_ELEMENTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DetalleCampania detalleCampania;
    @JoinColumns({
        @JoinColumn(name = "TAR_RUC", referencedColumnName = "RUC", insertable = false, updatable = false),
        @JoinColumn(name = "ID_TARGET_EDAD", referencedColumnName = "ID_TARGET_EDAD", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TargetEdad targetEdad;

    public SegmentoDetalleCampania() {
    }

    public SegmentoDetalleCampania(SegmentoDetalleCampaniaPK segmentoDetalleCampaniaPK) {
        this.segmentoDetalleCampaniaPK = segmentoDetalleCampaniaPK;
    }

    public SegmentoDetalleCampania(String ruc, Integer secCampania, Integer idElemento, String tarRuc, Integer idTargetEdad) {
        this.segmentoDetalleCampaniaPK = new SegmentoDetalleCampaniaPK(ruc, secCampania, idElemento, tarRuc, idTargetEdad);
    }

    public SegmentoDetalleCampaniaPK getSegmentoDetalleCampaniaPK() {
        return segmentoDetalleCampaniaPK;
    }

    public void setSegmentoDetalleCampaniaPK(SegmentoDetalleCampaniaPK segmentoDetalleCampaniaPK) {
        this.segmentoDetalleCampaniaPK = segmentoDetalleCampaniaPK;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getMaximoHora() {
        return maximoHora;
    }

    public void setMaximoHora(String maximoHora) {
        this.maximoHora = maximoHora;
    }

    public String getMinimoHora() {
        return minimoHora;
    }

    public void setMinimoHora(String minimoHora) {
        this.minimoHora = minimoHora;
    }

    public DetalleCampania getDetalleCampania() {
        return detalleCampania;
    }

    public void setDetalleCampania(DetalleCampania detalleCampania) {
        this.detalleCampania = detalleCampania;
    }

    public TargetEdad getTargetEdad() {
        return targetEdad;
    }

    public void setTargetEdad(TargetEdad targetEdad) {
        this.targetEdad = targetEdad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segmentoDetalleCampaniaPK != null ? segmentoDetalleCampaniaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegmentoDetalleCampania)) {
            return false;
        }
        SegmentoDetalleCampania other = (SegmentoDetalleCampania) object;
        if ((this.segmentoDetalleCampaniaPK == null && other.segmentoDetalleCampaniaPK != null) || (this.segmentoDetalleCampaniaPK != null && !this.segmentoDetalleCampaniaPK.equals(other.segmentoDetalleCampaniaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.SegmentoDetalleCampania[ segmentoDetalleCampaniaPK=" + segmentoDetalleCampaniaPK + " ]";
    }
    
}
