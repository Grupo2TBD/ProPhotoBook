/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "COMENTARIO_FOTOGRAFIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioFotografia.findAll", query = "SELECT c FROM ComentarioFotografia c"),
    @NamedQuery(name = "ComentarioFotografia.findByIdComentarioFotografia", query = "SELECT c FROM ComentarioFotografia c WHERE c.idComentarioFotografia = :idComentarioFotografia"),
    @NamedQuery(name = "ComentarioFotografia.findByDescripcionComentario", query = "SELECT c FROM ComentarioFotografia c WHERE c.descripcionComentario = :descripcionComentario"),
    @NamedQuery(name = "ComentarioFotografia.findByFechaPublicacionComentario", query = "SELECT c FROM ComentarioFotografia c WHERE c.fechaPublicacionComentario = :fechaPublicacionComentario")})
public class ComentarioFotografia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMENTARIO_FOTOGRAFIA")
    private Integer idComentarioFotografia;
    @Size(max = 150)
    @Column(name = "DESCRIPCION_COMENTARIO")
    private String descripcionComentario;
    @Column(name = "FECHA_PUBLICACION_COMENTARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacionComentario;
    @JoinColumn(name = "ID_TIPO_CLASIFICACION", referencedColumnName = "ID_TIPO_CLASIFICACION")
    @ManyToOne
    private TipoClasificacion idTipoClasificacion;
    @JoinColumn(name = "ID_FOTOGRAFIA", referencedColumnName = "ID_FOTOGRAFIA")
    @ManyToOne(optional = false)
    private Fotografia idFotografia;

    public ComentarioFotografia() {
    }

    public ComentarioFotografia(Integer idComentarioFotografia) {
        this.idComentarioFotografia = idComentarioFotografia;
    }

    public Integer getIdComentarioFotografia() {
        return idComentarioFotografia;
    }

    public void setIdComentarioFotografia(Integer idComentarioFotografia) {
        this.idComentarioFotografia = idComentarioFotografia;
    }

    public String getDescripcionComentario() {
        return descripcionComentario;
    }

    public void setDescripcionComentario(String descripcionComentario) {
        this.descripcionComentario = descripcionComentario;
    }

    public Date getFechaPublicacionComentario() {
        return fechaPublicacionComentario;
    }

    public void setFechaPublicacionComentario(Date fechaPublicacionComentario) {
        this.fechaPublicacionComentario = fechaPublicacionComentario;
    }

    public TipoClasificacion getIdTipoClasificacion() {
        return idTipoClasificacion;
    }

    public void setIdTipoClasificacion(TipoClasificacion idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }

    public Fotografia getIdFotografia() {
        return idFotografia;
    }

    public void setIdFotografia(Fotografia idFotografia) {
        this.idFotografia = idFotografia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentarioFotografia != null ? idComentarioFotografia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioFotografia)) {
            return false;
        }
        ComentarioFotografia other = (ComentarioFotografia) object;
        if ((this.idComentarioFotografia == null && other.idComentarioFotografia != null) || (this.idComentarioFotografia != null && !this.idComentarioFotografia.equals(other.idComentarioFotografia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ComentarioFotografia[ idComentarioFotografia=" + idComentarioFotografia + " ]";
    }
    
}
