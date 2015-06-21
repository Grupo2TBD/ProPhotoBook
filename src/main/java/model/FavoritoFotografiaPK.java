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
public class FavoritoFotografiaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FOTOGRAFIA")
    private int idFotografia;

    public FavoritoFotografiaPK() {
    }

    public FavoritoFotografiaPK(int idUsuario, int idFotografia) {
        this.idUsuario = idUsuario;
        this.idFotografia = idFotografia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFotografia() {
        return idFotografia;
    }

    public void setIdFotografia(int idFotografia) {
        this.idFotografia = idFotografia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idFotografia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritoFotografiaPK)) {
            return false;
        }
        FavoritoFotografiaPK other = (FavoritoFotografiaPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idFotografia != other.idFotografia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FavoritoFotografiaPK[ idUsuario=" + idUsuario + ", idFotografia=" + idFotografia + " ]";
    }
    
}
