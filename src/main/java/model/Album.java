/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByIdAlbum", query = "SELECT a FROM Album a WHERE a.idAlbum = :idAlbum"),
    @NamedQuery(name = "Album.findByNombreAlbum", query = "SELECT a FROM Album a WHERE a.nombreAlbum = :nombreAlbum"),
    @NamedQuery(name = "Album.findByFechaCreacionAlbum", query = "SELECT a FROM Album a WHERE a.fechaCreacionAlbum = :fechaCreacionAlbum"),
    @NamedQuery(name = "Album.findByDescripcionAlbum", query = "SELECT a FROM Album a WHERE a.descripcionAlbum = :descripcionAlbum"),
    @NamedQuery(name = "Album.findByDireccionFisicaFotoPortadaAlbum", query = "SELECT a FROM Album a WHERE a.direccionFisicaFotoPortadaAlbum = :direccionFisicaFotoPortadaAlbum"),
    @NamedQuery(name = "Album.findByCantidadDeFotografiasAlbum", query = "SELECT a FROM Album a WHERE a.cantidadDeFotografiasAlbum = :cantidadDeFotografiasAlbum"),
    @NamedQuery(name = "Album.findByCantidadDeFavoritos", query = "SELECT a FROM Album a WHERE a.cantidadDeFavoritos = :cantidadDeFavoritos"),
    @NamedQuery(name = "Album.findByCantidadDeComentarios", query = "SELECT a FROM Album a WHERE a.cantidadDeComentarios = :cantidadDeComentarios"),
    @NamedQuery(name = "Album.findByUltimaActualizacionAlbum", query = "SELECT a FROM Album a WHERE a.ultimaActualizacionAlbum = :ultimaActualizacionAlbum")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALBUM")
    private Integer idAlbum;
    @Size(max = 20)
    @Column(name = "NOMBRE_ALBUM")
    private String nombreAlbum;
    @Column(name = "FECHA_CREACION_ALBUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionAlbum;
    @Size(max = 30)
    @Column(name = "DESCRIPCION_ALBUM")
    private String descripcionAlbum;
    @Size(max = 50)
    @Column(name = "DIRECCION_FISICA_FOTO_PORTADA_ALBUM")
    private String direccionFisicaFotoPortadaAlbum;
    @Column(name = "CANTIDAD_DE_FOTOGRAFIAS_ALBUM")
    private Integer cantidadDeFotografiasAlbum;
    @Column(name = "CANTIDAD_DE_FAVORITOS")
    private Integer cantidadDeFavoritos;
    @Column(name = "CANTIDAD_DE_COMENTARIOS")
    private Integer cantidadDeComentarios;
    @Column(name = "ULTIMA_ACTUALIZACION_ALBUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaActualizacionAlbum;
    @JoinTable(name = "ALBUM_PERMISO", joinColumns = {
        @JoinColumn(name = "ID_ALBUM", referencedColumnName = "ID_ALBUM")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PERMISO", referencedColumnName = "ID_PERMISO")})
    @ManyToMany
    private Collection<Permiso> permisoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private Collection<FavoritoAlbum> favoritoAlbumCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private Collection<AlbumFotografia> albumFotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlbum")
    private Collection<ComentarioAlbum> comentarioAlbumCollection;
    @JoinColumn(name = "ID_PRIVACIDAD", referencedColumnName = "ID_PRIVACIDAD")
    @ManyToOne(optional = false)
    private Privacidad idPrivacidad;

    public Album() {
    }

    public Album(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public Date getFechaCreacionAlbum() {
        return fechaCreacionAlbum;
    }

    public void setFechaCreacionAlbum(Date fechaCreacionAlbum) {
        this.fechaCreacionAlbum = fechaCreacionAlbum;
    }

    public String getDescripcionAlbum() {
        return descripcionAlbum;
    }

    public void setDescripcionAlbum(String descripcionAlbum) {
        this.descripcionAlbum = descripcionAlbum;
    }

    public String getDireccionFisicaFotoPortadaAlbum() {
        return direccionFisicaFotoPortadaAlbum;
    }

    public void setDireccionFisicaFotoPortadaAlbum(String direccionFisicaFotoPortadaAlbum) {
        this.direccionFisicaFotoPortadaAlbum = direccionFisicaFotoPortadaAlbum;
    }

    public Integer getCantidadDeFotografiasAlbum() {
        return cantidadDeFotografiasAlbum;
    }

    public void setCantidadDeFotografiasAlbum(Integer cantidadDeFotografiasAlbum) {
        this.cantidadDeFotografiasAlbum = cantidadDeFotografiasAlbum;
    }

    public Integer getCantidadDeFavoritos() {
        return cantidadDeFavoritos;
    }

    public void setCantidadDeFavoritos(Integer cantidadDeFavoritos) {
        this.cantidadDeFavoritos = cantidadDeFavoritos;
    }

    public Integer getCantidadDeComentarios() {
        return cantidadDeComentarios;
    }

    public void setCantidadDeComentarios(Integer cantidadDeComentarios) {
        this.cantidadDeComentarios = cantidadDeComentarios;
    }

    public Date getUltimaActualizacionAlbum() {
        return ultimaActualizacionAlbum;
    }

    public void setUltimaActualizacionAlbum(Date ultimaActualizacionAlbum) {
        this.ultimaActualizacionAlbum = ultimaActualizacionAlbum;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @XmlTransient
    public Collection<FavoritoAlbum> getFavoritoAlbumCollection() {
        return favoritoAlbumCollection;
    }

    public void setFavoritoAlbumCollection(Collection<FavoritoAlbum> favoritoAlbumCollection) {
        this.favoritoAlbumCollection = favoritoAlbumCollection;
    }

    @XmlTransient
    public Collection<AlbumFotografia> getAlbumFotografiaCollection() {
        return albumFotografiaCollection;
    }

    public void setAlbumFotografiaCollection(Collection<AlbumFotografia> albumFotografiaCollection) {
        this.albumFotografiaCollection = albumFotografiaCollection;
    }

    @XmlTransient
    public Collection<ComentarioAlbum> getComentarioAlbumCollection() {
        return comentarioAlbumCollection;
    }

    public void setComentarioAlbumCollection(Collection<ComentarioAlbum> comentarioAlbumCollection) {
        this.comentarioAlbumCollection = comentarioAlbumCollection;
    }

    public Privacidad getIdPrivacidad() {
        return idPrivacidad;
    }

    public void setIdPrivacidad(Privacidad idPrivacidad) {
        this.idPrivacidad = idPrivacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlbum != null ? idAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.idAlbum == null && other.idAlbum != null) || (this.idAlbum != null && !this.idAlbum.equals(other.idAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Album[ idAlbum=" + idAlbum + " ]";
    }
    
}
