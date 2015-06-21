/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "FAVORITO_ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FavoritoAlbum.findAll", query = "SELECT f FROM FavoritoAlbum f"),
    @NamedQuery(name = "FavoritoAlbum.findByIdAlbum", query = "SELECT f FROM FavoritoAlbum f WHERE f.favoritoAlbumPK.idAlbum = :idAlbum"),
    @NamedQuery(name = "FavoritoAlbum.findByIdUsuario", query = "SELECT f FROM FavoritoAlbum f WHERE f.favoritoAlbumPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "FavoritoAlbum.findByFechaFavoritoAlbum", query = "SELECT f FROM FavoritoAlbum f WHERE f.fechaFavoritoAlbum = :fechaFavoritoAlbum")})
public class FavoritoAlbum implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavoritoAlbumPK favoritoAlbumPK;
    @Column(name = "FECHA_FAVORITO_ALBUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFavoritoAlbum;
    @JoinColumn(name = "ID_ALBUM", referencedColumnName = "ID_ALBUM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Album album;

    public FavoritoAlbum() {
    }

    public FavoritoAlbum(FavoritoAlbumPK favoritoAlbumPK) {
        this.favoritoAlbumPK = favoritoAlbumPK;
    }

    public FavoritoAlbum(int idAlbum, int idUsuario) {
        this.favoritoAlbumPK = new FavoritoAlbumPK(idAlbum, idUsuario);
    }

    public FavoritoAlbumPK getFavoritoAlbumPK() {
        return favoritoAlbumPK;
    }

    public void setFavoritoAlbumPK(FavoritoAlbumPK favoritoAlbumPK) {
        this.favoritoAlbumPK = favoritoAlbumPK;
    }

    public Date getFechaFavoritoAlbum() {
        return fechaFavoritoAlbum;
    }

    public void setFechaFavoritoAlbum(Date fechaFavoritoAlbum) {
        this.fechaFavoritoAlbum = fechaFavoritoAlbum;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favoritoAlbumPK != null ? favoritoAlbumPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritoAlbum)) {
            return false;
        }
        FavoritoAlbum other = (FavoritoAlbum) object;
        if ((this.favoritoAlbumPK == null && other.favoritoAlbumPK != null) || (this.favoritoAlbumPK != null && !this.favoritoAlbumPK.equals(other.favoritoAlbumPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FavoritoAlbum[ favoritoAlbumPK=" + favoritoAlbumPK + " ]";
    }
    
}
