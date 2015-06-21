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
public class AlbumFotografiaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALBUM")
    private int idAlbum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FOTOGRAFIA")
    private int idFotografia;

    public AlbumFotografiaPK() {
    }

    public AlbumFotografiaPK(int idAlbum, int idFotografia) {
        this.idAlbum = idAlbum;
        this.idFotografia = idFotografia;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
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
        hash += (int) idAlbum;
        hash += (int) idFotografia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlbumFotografiaPK)) {
            return false;
        }
        AlbumFotografiaPK other = (AlbumFotografiaPK) object;
        if (this.idAlbum != other.idAlbum) {
            return false;
        }
        if (this.idFotografia != other.idFotografia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AlbumFotografiaPK[ idAlbum=" + idAlbum + ", idFotografia=" + idFotografia + " ]";
    }
    
}
