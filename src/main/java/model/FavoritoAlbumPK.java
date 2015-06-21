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
public class FavoritoAlbumPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALBUM")
    private int idAlbum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private int idUsuario;

    public FavoritoAlbumPK() {
    }

    public FavoritoAlbumPK(int idAlbum, int idUsuario) {
        this.idAlbum = idAlbum;
        this.idUsuario = idUsuario;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlbum;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritoAlbumPK)) {
            return false;
        }
        FavoritoAlbumPK other = (FavoritoAlbumPK) object;
        if (this.idAlbum != other.idAlbum) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FavoritoAlbumPK[ idAlbum=" + idAlbum + ", idUsuario=" + idUsuario + " ]";
    }
    
}
