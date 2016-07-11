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
public class DetalleCampaniaPK implements Serializable {

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

    public DetalleCampaniaPK() {
    }

    public DetalleCampaniaPK(String ruc, Integer secCampania, Integer idElemento) {
        this.ruc = ruc;
        this.secCampania = secCampania;
        this.idElemento = idElemento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        hash += (secCampania != null ? secCampania.hashCode() : 0);
        hash += (idElemento != null ? idElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCampaniaPK)) {
            return false;
        }
        DetalleCampaniaPK other = (DetalleCampaniaPK) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        if ((this.secCampania == null && other.secCampania != null) || (this.secCampania != null && !this.secCampania.equals(other.secCampania))) {
            return false;
        }
        if ((this.idElemento == null && other.idElemento != null) || (this.idElemento != null && !this.idElemento.equals(other.idElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.model.DetalleCampaniaPK[ ruc=" + ruc + ", secCampania=" + secCampania + ", idElemento=" + idElemento + " ]";
    }
    
}
