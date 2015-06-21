/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "PRIVACIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privacidad.findAll", query = "SELECT p FROM Privacidad p"),
    @NamedQuery(name = "Privacidad.findByIdPrivacidad", query = "SELECT p FROM Privacidad p WHERE p.idPrivacidad = :idPrivacidad"),
    @NamedQuery(name = "Privacidad.findByTipoPrivacidad", query = "SELECT p FROM Privacidad p WHERE p.tipoPrivacidad = :tipoPrivacidad")})
public class Privacidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRIVACIDAD")
    private Integer idPrivacidad;
    @Size(max = 20)
    @Column(name = "TIPO_PRIVACIDAD")
    private String tipoPrivacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrivacidad")
    private Collection<Fotografia> fotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrivacidad")
    private Collection<Album> albumCollection;

    public Privacidad() {
    }

    public Privacidad(Integer idPrivacidad) {
        this.idPrivacidad = idPrivacidad;
    }

    public Integer getIdPrivacidad() {
        return idPrivacidad;
    }

    public void setIdPrivacidad(Integer idPrivacidad) {
        this.idPrivacidad = idPrivacidad;
    }

    public String getTipoPrivacidad() {
        return tipoPrivacidad;
    }

    public void setTipoPrivacidad(String tipoPrivacidad) {
        this.tipoPrivacidad = tipoPrivacidad;
    }

    @XmlTransient
    public Collection<Fotografia> getFotografiaCollection() {
        return fotografiaCollection;
    }

    public void setFotografiaCollection(Collection<Fotografia> fotografiaCollection) {
        this.fotografiaCollection = fotografiaCollection;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivacidad != null ? idPrivacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privacidad)) {
            return false;
        }
        Privacidad other = (Privacidad) object;
        if ((this.idPrivacidad == null && other.idPrivacidad != null) || (this.idPrivacidad != null && !this.idPrivacidad.equals(other.idPrivacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Privacidad[ idPrivacidad=" + idPrivacidad + " ]";
    }
    
}
