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
@Table(name = "SEGUIDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguidor.findAll", query = "SELECT s FROM Seguidor s"),
    @NamedQuery(name = "Seguidor.findByIdUsuario", query = "SELECT s FROM Seguidor s WHERE s.seguidorPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Seguidor.findByUsuIdUsuario", query = "SELECT s FROM Seguidor s WHERE s.seguidorPK.usuIdUsuario = :usuIdUsuario"),
    @NamedQuery(name = "Seguidor.findByFechaFollow", query = "SELECT s FROM Seguidor s WHERE s.fechaFollow = :fechaFollow")})
public class Seguidor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguidorPK seguidorPK;
    @Column(name = "FECHA_FOLLOW")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFollow;

    public Seguidor() {
    }

    public Seguidor(SeguidorPK seguidorPK) {
        this.seguidorPK = seguidorPK;
    }

    public Seguidor(int idUsuario, int usuIdUsuario) {
        this.seguidorPK = new SeguidorPK(idUsuario, usuIdUsuario);
    }

    public SeguidorPK getSeguidorPK() {
        return seguidorPK;
    }

    public void setSeguidorPK(SeguidorPK seguidorPK) {
        this.seguidorPK = seguidorPK;
    }

    public Date getFechaFollow() {
        return fechaFollow;
    }

    public void setFechaFollow(Date fechaFollow) {
        this.fechaFollow = fechaFollow;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguidorPK != null ? seguidorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguidor)) {
            return false;
        }
        Seguidor other = (Seguidor) object;
        if ((this.seguidorPK == null && other.seguidorPK != null) || (this.seguidorPK != null && !this.seguidorPK.equals(other.seguidorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Seguidor[ seguidorPK=" + seguidorPK + " ]";
    }
    
}
