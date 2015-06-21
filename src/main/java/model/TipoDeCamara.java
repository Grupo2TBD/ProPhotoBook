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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "TIPO_DE_CAMARA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeCamara.findAll", query = "SELECT t FROM TipoDeCamara t"),
    @NamedQuery(name = "TipoDeCamara.findByIdTipoDeCamara", query = "SELECT t FROM TipoDeCamara t WHERE t.idTipoDeCamara = :idTipoDeCamara"),
    @NamedQuery(name = "TipoDeCamara.findByNombreTipoDeCamara", query = "SELECT t FROM TipoDeCamara t WHERE t.nombreTipoDeCamara = :nombreTipoDeCamara")})
public class TipoDeCamara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DE_CAMARA")
    private Integer idTipoDeCamara;
    @Column(name = "NOMBRE_TIPO_DE_CAMARA")
    private Integer nombreTipoDeCamara;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDeCamara")
    private Collection<Camara> camaraCollection;

    public TipoDeCamara() {
    }

    public TipoDeCamara(Integer idTipoDeCamara) {
        this.idTipoDeCamara = idTipoDeCamara;
    }

    public Integer getIdTipoDeCamara() {
        return idTipoDeCamara;
    }

    public void setIdTipoDeCamara(Integer idTipoDeCamara) {
        this.idTipoDeCamara = idTipoDeCamara;
    }

    public Integer getNombreTipoDeCamara() {
        return nombreTipoDeCamara;
    }

    public void setNombreTipoDeCamara(Integer nombreTipoDeCamara) {
        this.nombreTipoDeCamara = nombreTipoDeCamara;
    }

    @XmlTransient
    public Collection<Camara> getCamaraCollection() {
        return camaraCollection;
    }

    public void setCamaraCollection(Collection<Camara> camaraCollection) {
        this.camaraCollection = camaraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDeCamara != null ? idTipoDeCamara.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeCamara)) {
            return false;
        }
        TipoDeCamara other = (TipoDeCamara) object;
        if ((this.idTipoDeCamara == null && other.idTipoDeCamara != null) || (this.idTipoDeCamara != null && !this.idTipoDeCamara.equals(other.idTipoDeCamara))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoDeCamara[ idTipoDeCamara=" + idTipoDeCamara + " ]";
    }
    
}
