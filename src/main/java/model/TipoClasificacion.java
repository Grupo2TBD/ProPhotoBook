/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "TIPO_CLASIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoClasificacion.findAll", query = "SELECT t FROM TipoClasificacion t"),
    @NamedQuery(name = "TipoClasificacion.findByIdTipoClasificacion", query = "SELECT t FROM TipoClasificacion t WHERE t.idTipoClasificacion = :idTipoClasificacion"),
    @NamedQuery(name = "TipoClasificacion.findByNombreTipoClasificacion", query = "SELECT t FROM TipoClasificacion t WHERE t.nombreTipoClasificacion = :nombreTipoClasificacion")})
public class TipoClasificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CLASIFICACION")
    private Integer idTipoClasificacion;
    @Size(max = 20)
    @Column(name = "NOMBRE_TIPO_CLASIFICACION")
    private String nombreTipoClasificacion;
    @OneToMany(mappedBy = "idTipoClasificacion")
    private Collection<Fotografia> fotografiaCollection;
    @OneToMany(mappedBy = "idTipoClasificacion")
    private Collection<ComentarioFotografia> comentarioFotografiaCollection;

    public TipoClasificacion() {
    }

    public TipoClasificacion(Integer idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }

    public Integer getIdTipoClasificacion() {
        return idTipoClasificacion;
    }

    public void setIdTipoClasificacion(Integer idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }

    public String getNombreTipoClasificacion() {
        return nombreTipoClasificacion;
    }

    public void setNombreTipoClasificacion(String nombreTipoClasificacion) {
        this.nombreTipoClasificacion = nombreTipoClasificacion;
    }

    @XmlTransient
    public Collection<Fotografia> getFotografiaCollection() {
        return fotografiaCollection;
    }

    public void setFotografiaCollection(Collection<Fotografia> fotografiaCollection) {
        this.fotografiaCollection = fotografiaCollection;
    }

    @XmlTransient
    public Collection<ComentarioFotografia> getComentarioFotografiaCollection() {
        return comentarioFotografiaCollection;
    }

    public void setComentarioFotografiaCollection(Collection<ComentarioFotografia> comentarioFotografiaCollection) {
        this.comentarioFotografiaCollection = comentarioFotografiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoClasificacion != null ? idTipoClasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoClasificacion)) {
            return false;
        }
        TipoClasificacion other = (TipoClasificacion) object;
        if ((this.idTipoClasificacion == null && other.idTipoClasificacion != null) || (this.idTipoClasificacion != null && !this.idTipoClasificacion.equals(other.idTipoClasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoClasificacion[ idTipoClasificacion=" + idTipoClasificacion + " ]";
    }
    
}
