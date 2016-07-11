/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author homer
 */
@Embeddable
public class SegmentoDetalleCampaniaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "RUC")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEC_CAMPANIA")
    private Integer secCampania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ELEMENTO")
    private Integer idElemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "TAR_RUC")
    private String tarRuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TARGET_EDAD")
    private Integer idTargetEdad;

    public SegmentoDetalleCampaniaPK() {
    }

    public SegmentoDetalleCampaniaPK(String ruc, Integer secCampania, Integer idElemento, String tarRuc, Integer idTargetEdad) {
        this.ruc = ruc;
        this.secCampania = secCampania;
        this.idElemento = idElemento;
        this.tarRuc = tarRuc;
        this.idTargetEdad = idTargetEdad;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Integer getSecCampania() {
        return secCampania;
    }

    public void setSecCampania(Integer secCampania) {
        this.secCampania = secCampania;
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public String getTarRuc() {
        return tarRuc;
    }

    public void setTarRuc(String tarRuc) {
        this.tarRuc = tarRuc;
    }

    public Integer getIdTargetEdad() {
        return idTargetEdad;
    }

    public void setIdTargetEdad(Integer idTargetEdad) {
        this.idTargetEdad = idTargetEdad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        hash += (secCampania != null ? secCampania.hashCode() : 0);
        hash += (idElemento != null ? idElemento.hashCode() : 0);
        hash += (tarRuc != null ? tarRuc.hashCode() : 0);
        hash += (idTargetEdad != null ? idTargetEdad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegmentoDetalleCampaniaPK)) {
            return false;
        }
        SegmentoDetalleCampaniaPK other = (SegmentoDetalleCampaniaPK) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        if ((this.secCampania == null && other.secCampania != null) || (this.secCampania != null && !this.secCampania.equals(other.secCampania))) {
            return false;
        }
        if ((this.idElemento == null && other.idElemento != null) || (this.idElemento != null && !this.idElemento.equals(other.idElemento))) {
            return false;
        }
        if ((this.tarRuc == null && other.tarRuc != null) || (this.tarRuc != null && !this.tarRuc.equals(other.tarRuc))) {
            return false;
        }
        if ((this.idTargetEdad == null && other.idTargetEdad != null) || (this.idTargetEdad != null && !this.idTargetEdad.equals(other.idTargetEdad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.SegmentoDetalleCampaniaPK[ ruc=" + ruc + ", secCampania=" + secCampania + ", idElemento=" + idElemento + ", tarRuc=" + tarRuc + ", idTargetEdad=" + idTargetEdad + " ]";
    }
    
}
