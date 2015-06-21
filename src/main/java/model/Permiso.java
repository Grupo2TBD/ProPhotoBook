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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "PERMISO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByIdPermiso", query = "SELECT p FROM Permiso p WHERE p.idPermiso = :idPermiso"),
    @NamedQuery(name = "Permiso.findByCanshare", query = "SELECT p FROM Permiso p WHERE p.canshare = :canshare"),
    @NamedQuery(name = "Permiso.findByCancomment", query = "SELECT p FROM Permiso p WHERE p.cancomment = :cancomment"),
    @NamedQuery(name = "Permiso.findByCandownload", query = "SELECT p FROM Permiso p WHERE p.candownload = :candownload")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERMISO")
    private Integer idPermiso;
    @Column(name = "CANSHARE")
    private Boolean canshare;
    @Column(name = "CANCOMMENT")
    private Boolean cancomment;
    @Column(name = "CANDOWNLOAD")
    private Boolean candownload;
    @ManyToMany(mappedBy = "permisoCollection")
    private Collection<Album> albumCollection;
    @JoinTable(name = "FOTOGRAFIA_PERMISO", joinColumns = {
        @JoinColumn(name = "ID_PERMISO", referencedColumnName = "ID_PERMISO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_FOTOGRAFIA", referencedColumnName = "ID_FOTOGRAFIA")})
    @ManyToMany
    private Collection<Fotografia> fotografiaCollection;

    public Permiso() {
    }

    public Permiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Boolean getCanshare() {
        return canshare;
    }

    public void setCanshare(Boolean canshare) {
        this.canshare = canshare;
    }

    public Boolean getCancomment() {
        return cancomment;
    }

    public void setCancomment(Boolean cancomment) {
        this.cancomment = cancomment;
    }

    public Boolean getCandownload() {
        return candownload;
    }

    public void setCandownload(Boolean candownload) {
        this.candownload = candownload;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @XmlTransient
    public Collection<Fotografia> getFotografiaCollection() {
        return fotografiaCollection;
    }

    public void setFotografiaCollection(Collection<Fotografia> fotografiaCollection) {
        this.fotografiaCollection = fotografiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Permiso[ idPermiso=" + idPermiso + " ]";
    }
    
}
