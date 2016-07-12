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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author homer
 */
@Embeddable
public class TargetEdadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "RUC")
    private String ruc;
    @Basic(optional = false)
    @SequenceGenerator(name = "seq_target", sequenceName = "SEQUENCE_TARGET", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_target")
    @Column(name = "ID_TARGET_EDAD")
    private Integer idTargetEdad;

    public TargetEdadPK() {
    }

    public TargetEdadPK(String ruc, Integer idTargetEdad) {
        this.ruc = ruc;
        this.idTargetEdad = idTargetEdad;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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
        hash += (idTargetEdad != null ? idTargetEdad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TargetEdadPK)) {
            return false;
        }
        TargetEdadPK other = (TargetEdadPK) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        if ((this.idTargetEdad == null && other.idTargetEdad != null) || (this.idTargetEdad != null && !this.idTargetEdad.equals(other.idTargetEdad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + ruc + "-" + idTargetEdad;
    }

}
