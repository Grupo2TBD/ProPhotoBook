/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "EXIF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exif.findAll", query = "SELECT e FROM Exif e"),
    @NamedQuery(name = "Exif.findByIdExif", query = "SELECT e FROM Exif e WHERE e.idExif = :idExif"),
    @NamedQuery(name = "Exif.findByAperturaExif", query = "SELECT e FROM Exif e WHERE e.aperturaExif = :aperturaExif"),
    @NamedQuery(name = "Exif.findByLongitudExif", query = "SELECT e FROM Exif e WHERE e.longitudExif = :longitudExif"),
    @NamedQuery(name = "Exif.findByLargoFocoExif", query = "SELECT e FROM Exif e WHERE e.largoFocoExif = :largoFocoExif"),
    @NamedQuery(name = "Exif.findByTemporizadorExif", query = "SELECT e FROM Exif e WHERE e.temporizadorExif = :temporizadorExif"),
    @NamedQuery(name = "Exif.findByFlashExif", query = "SELECT e FROM Exif e WHERE e.flashExif = :flashExif")})
public class Exif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXIF")
    private Integer idExif;
    @Size(max = 20)
    @Column(name = "APERTURA_EXIF")
    private String aperturaExif;
    @Size(max = 20)
    @Column(name = "LONGITUD_EXIF")
    private String longitudExif;
    @Column(name = "LARGO_FOCO_EXIF")
    private Integer largoFocoExif;
    @Column(name = "TEMPORIZADOR_EXIF")
    private Integer temporizadorExif;
    @Column(name = "FLASH_EXIF")
    private Boolean flashExif;
    @JoinColumn(name = "ID_CAMARA", referencedColumnName = "ID_CAMARA")
    @ManyToOne(optional = false)
    private Camara idCamara;
    @JoinColumn(name = "ID_FOTOGRAFIA", referencedColumnName = "ID_FOTOGRAFIA")
    @ManyToOne(optional = false)
    private Fotografia idFotografia;

    public Exif() {
    }

    public Exif(Integer idExif) {
        this.idExif = idExif;
    }

    public Integer getIdExif() {
        return idExif;
    }

    public void setIdExif(Integer idExif) {
        this.idExif = idExif;
    }

    public String getAperturaExif() {
        return aperturaExif;
    }

    public void setAperturaExif(String aperturaExif) {
        this.aperturaExif = aperturaExif;
    }

    public String getLongitudExif() {
        return longitudExif;
    }

    public void setLongitudExif(String longitudExif) {
        this.longitudExif = longitudExif;
    }

    public Integer getLargoFocoExif() {
        return largoFocoExif;
    }

    public void setLargoFocoExif(Integer largoFocoExif) {
        this.largoFocoExif = largoFocoExif;
    }

    public Integer getTemporizadorExif() {
        return temporizadorExif;
    }

    public void setTemporizadorExif(Integer temporizadorExif) {
        this.temporizadorExif = temporizadorExif;
    }

    public Boolean getFlashExif() {
        return flashExif;
    }

    public void setFlashExif(Boolean flashExif) {
        this.flashExif = flashExif;
    }

    public Camara getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(Camara idCamara) {
        this.idCamara = idCamara;
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
        hash += (idExif != null ? idExif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exif)) {
            return false;
        }
        Exif other = (Exif) object;
        if ((this.idExif == null && other.idExif != null) || (this.idExif != null && !this.idExif.equals(other.idExif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exif[ idExif=" + idExif + " ]";
    }
    
}
