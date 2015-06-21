/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ian
 */
@Embeddable
public class SeguidorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID_USUARIO")
    private int usuIdUsuario;

    public SeguidorPK() {
    }

    public SeguidorPK(int idUsuario, int usuIdUsuario) {
        this.idUsuario = idUsuario;
        this.usuIdUsuario = usuIdUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getUsuIdUsuario() {
        return usuIdUsuario;
    }

    public void setUsuIdUsuario(int usuIdUsuario) {
        this.usuIdUsuario = usuIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) usuIdUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguidorPK)) {
            return false;
        }
        SeguidorPK other = (SeguidorPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.usuIdUsuario != other.usuIdUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SeguidorPK[ idUsuario=" + idUsuario + ", usuIdUsuario=" + usuIdUsuario + " ]";
    }
    
}
