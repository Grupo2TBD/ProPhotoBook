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
@Table(name = "FOTOGRAFIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotografia.findAll", query = "SELECT f FROM Fotografia f"),
    @NamedQuery(name = "Fotografia.findByIdFotografia", query = "SELECT f FROM Fotografia f WHERE f.idFotografia = :idFotografia"),
    @NamedQuery(name = "Fotografia.findByFechaSubida", query = "SELECT f FROM Fotografia f WHERE f.fechaSubida = :fechaSubida"),
    @NamedQuery(name = "Fotografia.findByFechaTomada", query = "SELECT f FROM Fotografia f WHERE f.fechaTomada = :fechaTomada"),
    @NamedQuery(name = "Fotografia.findByVisitasFotografia", query = "SELECT f FROM Fotografia f WHERE f.visitasFotografia = :visitasFotografia"),
    @NamedQuery(name = "Fotografia.findByTituloFotografia", query = "SELECT f FROM Fotografia f WHERE f.tituloFotografia = :tituloFotografia"),
    @NamedQuery(name = "Fotografia.findByDescripcionFotografia", query = "SELECT f FROM Fotografia f WHERE f.descripcionFotografia = :descripcionFotografia"),
    @NamedQuery(name = "Fotografia.findByNumeroFavoritosFotografia", query = "SELECT f FROM Fotografia f WHERE f.numeroFavoritosFotografia = :numeroFavoritosFotografia"),
    @NamedQuery(name = "Fotografia.findByFormatoFotografia", query = "SELECT f FROM Fotografia f WHERE f.formatoFotografia = :formatoFotografia"),
    @NamedQuery(name = "Fotografia.findByDireccionFisicaFotografia", query = "SELECT f FROM Fotografia f WHERE f.direccionFisicaFotografia = :direccionFisicaFotografia"),
    @NamedQuery(name = "Fotografia.findByUltimaActualizacionFotografia", query = "SELECT f FROM Fotografia f WHERE f.ultimaActualizacionFotografia = :ultimaActualizacionFotografia"),
    @NamedQuery(name = "Fotografia.findByVecesCompartida", query = "SELECT f FROM Fotografia f WHERE f.vecesCompartida = :vecesCompartida"),
    @NamedQuery(name = "Fotografia.findByVecesDescargada", query = "SELECT f FROM Fotografia f WHERE f.vecesDescargada = :vecesDescargada"),
    @NamedQuery(name = "Fotografia.findByNumeroComentariosPositivos", query = "SELECT f FROM Fotografia f WHERE f.numeroComentariosPositivos = :numeroComentariosPositivos"),
    @NamedQuery(name = "Fotografia.findByNumeroComentariosNegativos", query = "SELECT f FROM Fotografia f WHERE f.numeroComentariosNegativos = :numeroComentariosNegativos"),
    @NamedQuery(name = "Fotografia.findByNumeroComentariosNeutros", query = "SELECT f FROM Fotografia f WHERE f.numeroComentariosNeutros = :numeroComentariosNeutros")})
public class Fotografia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FOTOGRAFIA")
    private Integer idFotografia;
    @Column(name = "FECHA_SUBIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSubida;
    @Column(name = "FECHA_TOMADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTomada;
    @Column(name = "VISITAS_FOTOGRAFIA")
    private Integer visitasFotografia;
    @Size(max = 20)
    @Column(name = "TITULO_FOTOGRAFIA")
    private String tituloFotografia;
    @Size(max = 50)
    @Column(name = "DESCRIPCION_FOTOGRAFIA")
    private String descripcionFotografia;
    @Column(name = "NUMERO_FAVORITOS_FOTOGRAFIA")
    private Integer numeroFavoritosFotografia;
    @Size(max = 20)
    @Column(name = "FORMATO_FOTOGRAFIA")
    private String formatoFotografia;
    @Size(max = 50)
    @Column(name = "DIRECCION_FISICA_FOTOGRAFIA")
    private String direccionFisicaFotografia;
    @Column(name = "ULTIMA_ACTUALIZACION_FOTOGRAFIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaActualizacionFotografia;
    @Column(name = "VECES_COMPARTIDA")
    private Integer vecesCompartida;
    @Column(name = "VECES_DESCARGADA")
    private Integer vecesDescargada;
    @Column(name = "NUMERO_COMENTARIOS_POSITIVOS")
    private Integer numeroComentariosPositivos;
    @Column(name = "NUMERO_COMENTARIOS_NEGATIVOS")
    private Integer numeroComentariosNegativos;
    @Column(name = "NUMERO_COMENTARIOS_NEUTROS")
    private Integer numeroComentariosNeutros;
    @JoinTable(name = "FOTOGRAFIA_TAG", joinColumns = {
        @JoinColumn(name = "ID_FOTOGRAFIA", referencedColumnName = "ID_FOTOGRAFIA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_TAG", referencedColumnName = "ID_TAG")})
    @ManyToMany
    private Collection<Tag> tagCollection;
    @ManyToMany(mappedBy = "fotografiaCollection")
    private Collection<Permiso> permisoCollection;
    @JoinColumn(name = "ID_CAMARA", referencedColumnName = "ID_CAMARA")
    @ManyToOne(optional = false)
    private Camara idCamara;
    @JoinColumn(name = "ID_LOCALIZACION", referencedColumnName = "ID_LOCALIZACION")
    @ManyToOne
    private Localizacion idLocalizacion;
    @JoinColumn(name = "ID_PRIVACIDAD", referencedColumnName = "ID_PRIVACIDAD")
    @ManyToOne(optional = false)
    private Privacidad idPrivacidad;
    @JoinColumn(name = "ID_TIPO_CLASIFICACION", referencedColumnName = "ID_TIPO_CLASIFICACION")
    @ManyToOne
    private TipoClasificacion idTipoClasificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fotografia")
    private Collection<AlbumFotografia> albumFotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFotografia")
    private Collection<ComentarioFotografia> comentarioFotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFotografia")
    private Collection<Exif> exifCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fotografia")
    private Collection<FavoritoFotografia> favoritoFotografiaCollection;

    public Fotografia() {
    }

    public Fotografia(Integer idFotografia) {
        this.idFotografia = idFotografia;
    }

    public Integer getIdFotografia() {
        return idFotografia;
    }

    public void setIdFotografia(Integer idFotografia) {
        this.idFotografia = idFotografia;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public Date getFechaTomada() {
        return fechaTomada;
    }

    public void setFechaTomada(Date fechaTomada) {
        this.fechaTomada = fechaTomada;
    }

    public Integer getVisitasFotografia() {
        return visitasFotografia;
    }

    public void setVisitasFotografia(Integer visitasFotografia) {
        this.visitasFotografia = visitasFotografia;
    }

    public String getTituloFotografia() {
        return tituloFotografia;
    }

    public void setTituloFotografia(String tituloFotografia) {
        this.tituloFotografia = tituloFotografia;
    }

    public String getDescripcionFotografia() {
        return descripcionFotografia;
    }

    public void setDescripcionFotografia(String descripcionFotografia) {
        this.descripcionFotografia = descripcionFotografia;
    }

    public Integer getNumeroFavoritosFotografia() {
        return numeroFavoritosFotografia;
    }

    public void setNumeroFavoritosFotografia(Integer numeroFavoritosFotografia) {
        this.numeroFavoritosFotografia = numeroFavoritosFotografia;
    }

    public String getFormatoFotografia() {
        return formatoFotografia;
    }

    public void setFormatoFotografia(String formatoFotografia) {
        this.formatoFotografia = formatoFotografia;
    }

    public String getDireccionFisicaFotografia() {
        return direccionFisicaFotografia;
    }

    public void setDireccionFisicaFotografia(String direccionFisicaFotografia) {
        this.direccionFisicaFotografia = direccionFisicaFotografia;
    }

    public Date getUltimaActualizacionFotografia() {
        return ultimaActualizacionFotografia;
    }

    public void setUltimaActualizacionFotografia(Date ultimaActualizacionFotografia) {
        this.ultimaActualizacionFotografia = ultimaActualizacionFotografia;
    }

    public Integer getVecesCompartida() {
        return vecesCompartida;
    }

    public void setVecesCompartida(Integer vecesCompartida) {
        this.vecesCompartida = vecesCompartida;
    }

    public Integer getVecesDescargada() {
        return vecesDescargada;
    }

    public void setVecesDescargada(Integer vecesDescargada) {
        this.vecesDescargada = vecesDescargada;
    }

    public Integer getNumeroComentariosPositivos() {
        return numeroComentariosPositivos;
    }

    public void setNumeroComentariosPositivos(Integer numeroComentariosPositivos) {
        this.numeroComentariosPositivos = numeroComentariosPositivos;
    }

    public Integer getNumeroComentariosNegativos() {
        return numeroComentariosNegativos;
    }

    public void setNumeroComentariosNegativos(Integer numeroComentariosNegativos) {
        this.numeroComentariosNegativos = numeroComentariosNegativos;
    }

    public Integer getNumeroComentariosNeutros() {
        return numeroComentariosNeutros;
    }

    public void setNumeroComentariosNeutros(Integer numeroComentariosNeutros) {
        this.numeroComentariosNeutros = numeroComentariosNeutros;
    }

    @XmlTransient
    public Collection<Tag> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(Collection<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    public Camara getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(Camara idCamara) {
        this.idCamara = idCamara;
    }

    public Localizacion getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(Localizacion idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public Privacidad getIdPrivacidad() {
        return idPrivacidad;
    }

    public void setIdPrivacidad(Privacidad idPrivacidad) {
        this.idPrivacidad = idPrivacidad;
    }

    public TipoClasificacion getIdTipoClasificacion() {
        return idTipoClasificacion;
    }

    public void setIdTipoClasificacion(TipoClasificacion idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }

    @XmlTransient
    public Collection<AlbumFotografia> getAlbumFotografiaCollection() {
        return albumFotografiaCollection;
    }

    public void setAlbumFotografiaCollection(Collection<AlbumFotografia> albumFotografiaCollection) {
        this.albumFotografiaCollection = albumFotografiaCollection;
    }

    @XmlTransient
    public Collection<ComentarioFotografia> getComentarioFotografiaCollection() {
        return comentarioFotografiaCollection;
    }

    public void setComentarioFotografiaCollection(Collection<ComentarioFotografia> comentarioFotografiaCollection) {
        this.comentarioFotografiaCollection = comentarioFotografiaCollection;
    }

    @XmlTransient
    public Collection<Exif> getExifCollection() {
        return exifCollection;
    }

    public void setExifCollection(Collection<Exif> exifCollection) {
        this.exifCollection = exifCollection;
    }

    @XmlTransient
    public Collection<FavoritoFotografia> getFavoritoFotografiaCollection() {
        return favoritoFotografiaCollection;
    }

    public void setFavoritoFotografiaCollection(Collection<FavoritoFotografia> favoritoFotografiaCollection) {
        this.favoritoFotografiaCollection = favoritoFotografiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFotografia != null ? idFotografia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotografia)) {
            return false;
        }
        Fotografia other = (Fotografia) object;
        if ((this.idFotografia == null && other.idFotografia != null) || (this.idFotografia != null && !this.idFotografia.equals(other.idFotografia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fotografia[ idFotografia=" + idFotografia + " ]";
    }
    
}
