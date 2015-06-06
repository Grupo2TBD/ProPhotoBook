
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByCuentaUsuario", query = "SELECT u FROM Usuario u WHERE u.cuentaUsuario = :cuentaUsuario"),
    @NamedQuery(name = "Usuario.findByContrasenaUsuario", query = "SELECT u FROM Usuario u WHERE u.contrasenaUsuario = :contrasenaUsuario"),
    @NamedQuery(name = "Usuario.findByFechaCreacionCuenta", query = "SELECT u FROM Usuario u WHERE u.fechaCreacionCuenta = :fechaCreacionCuenta"),
    @NamedQuery(name = "Usuario.findByAliasUsuario", query = "SELECT u FROM Usuario u WHERE u.aliasUsuario = :aliasUsuario"),
    @NamedQuery(name = "Usuario.findByNombreRealUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreRealUsuario = :nombreRealUsuario"),
    @NamedQuery(name = "Usuario.findByDireccionFotoPerfilUsuario", query = "SELECT u FROM Usuario u WHERE u.direccionFotoPerfilUsuario = :direccionFotoPerfilUsuario"),
    @NamedQuery(name = "Usuario.findByApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.apellidoUsuario = :apellidoUsuario"),
    @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuario.findByDireccionFotoPortada", query = "SELECT u FROM Usuario u WHERE u.direccionFotoPortada = :direccionFotoPortada"),
    @NamedQuery(name = "Usuario.findByFechaCumpleanos", query = "SELECT u FROM Usuario u WHERE u.fechaCumpleanos = :fechaCumpleanos"),
    @NamedQuery(name = "Usuario.findByCorreoElectronicoUsuario", query = "SELECT u FROM Usuario u WHERE u.correoElectronicoUsuario = :correoElectronicoUsuario"),
    @NamedQuery(name = "Usuario.findByFechaUltimaActualizacion", query = "SELECT u FROM Usuario u WHERE u.fechaUltimaActualizacion = :fechaUltimaActualizacion"),
    @NamedQuery(name = "Usuario.findByCantidadDeFotografiaSubidas", query = "SELECT u FROM Usuario u WHERE u.cantidadDeFotografiaSubidas = :cantidadDeFotografiaSubidas"),
    @NamedQuery(name = "Usuario.findByCantidadDeAlbumesCreados", query = "SELECT u FROM Usuario u WHERE u.cantidadDeAlbumesCreados = :cantidadDeAlbumesCreados"),
    @NamedQuery(name = "Usuario.findByCantidadDeSeguidores", query = "SELECT u FROM Usuario u WHERE u.cantidadDeSeguidores = :cantidadDeSeguidores"),
    @NamedQuery(name = "Usuario.findByCantidadDeSeguidos", query = "SELECT u FROM Usuario u WHERE u.cantidadDeSeguidos = :cantidadDeSeguidos")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Size(max = 20)
    @Column(name = "CUENTA_USUARIO")
    private String cuentaUsuario;
    @Size(max = 20)
    @Column(name = "CONTRASENA_USUARIO")
    private String contrasenaUsuario;
    @Column(name = "FECHA_CREACION_CUENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionCuenta;
    @Size(max = 20)
    @Column(name = "ALIAS_USUARIO")
    private String aliasUsuario;
    @Size(max = 20)
    @Column(name = "NOMBRE_REAL_USUARIO")
    private String nombreRealUsuario;
    @Size(max = 50)
    @Column(name = "DIRECCION_FOTO_PERFIL_USUARIO")
    private String direccionFotoPerfilUsuario;
    @Size(max = 20)
    @Column(name = "APELLIDO_USUARIO")
    private String apellidoUsuario;
    @Size(max = 8)
    @Column(name = "SEXO")
    private String sexo;
    @Size(max = 50)
    @Column(name = "DIRECCION_FOTO_PORTADA")
    private String direccionFotoPortada;
    @Column(name = "FECHA_CUMPLEANOS")
    @Temporal(TemporalType.DATE)
    private Date fechaCumpleanos;
    @Size(max = 30)
    @Column(name = "CORREO_ELECTRONICO_USUARIO")
    private String correoElectronicoUsuario;
    @Column(name = "FECHA_ULTIMA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaActualizacion;
    @Column(name = "CANTIDAD_DE_FOTOGRAFIA_SUBIDAS")
    private Integer cantidadDeFotografiaSubidas;
    @Column(name = "CANTIDAD_DE_ALBUMES_CREADOS")
    private Integer cantidadDeAlbumesCreados;
    @Column(name = "CANTIDAD_DE_SEGUIDORES")
    private Integer cantidadDeSeguidores;
    @Column(name = "CANTIDAD_DE_SEGUIDOS")
    private Integer cantidadDeSeguidos;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(String cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Date getFechaCreacionCuenta() {
        return fechaCreacionCuenta;
    }

    public void setFechaCreacionCuenta(Date fechaCreacionCuenta) {
        this.fechaCreacionCuenta = fechaCreacionCuenta;
    }

    public String getAliasUsuario() {
        return aliasUsuario;
    }

    public void setAliasUsuario(String aliasUsuario) {
        this.aliasUsuario = aliasUsuario;
    }

    public String getNombreRealUsuario() {
        return nombreRealUsuario;
    }

    public void setNombreRealUsuario(String nombreRealUsuario) {
        this.nombreRealUsuario = nombreRealUsuario;
    }

    public String getDireccionFotoPerfilUsuario() {
        return direccionFotoPerfilUsuario;
    }

    public void setDireccionFotoPerfilUsuario(String direccionFotoPerfilUsuario) {
        this.direccionFotoPerfilUsuario = direccionFotoPerfilUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccionFotoPortada() {
        return direccionFotoPortada;
    }

    public void setDireccionFotoPortada(String direccionFotoPortada) {
        this.direccionFotoPortada = direccionFotoPortada;
    }

    public Date getFechaCumpleanos() {
        return fechaCumpleanos;
    }

    public void setFechaCumpleanos(Date fechaCumpleanos) {
        this.fechaCumpleanos = fechaCumpleanos;
    }

    public String getCorreoElectronicoUsuario() {
        return correoElectronicoUsuario;
    }

    public void setCorreoElectronicoUsuario(String correoElectronicoUsuario) {
        this.correoElectronicoUsuario = correoElectronicoUsuario;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Integer getCantidadDeFotografiaSubidas() {
        return cantidadDeFotografiaSubidas;
    }

    public void setCantidadDeFotografiaSubidas(Integer cantidadDeFotografiaSubidas) {
        this.cantidadDeFotografiaSubidas = cantidadDeFotografiaSubidas;
    }

    public Integer getCantidadDeAlbumesCreados() {
        return cantidadDeAlbumesCreados;
    }

    public void setCantidadDeAlbumesCreados(Integer cantidadDeAlbumesCreados) {
        this.cantidadDeAlbumesCreados = cantidadDeAlbumesCreados;
    }

    public Integer getCantidadDeSeguidores() {
        return cantidadDeSeguidores;
    }

    public void setCantidadDeSeguidores(Integer cantidadDeSeguidores) {
        this.cantidadDeSeguidores = cantidadDeSeguidores;
    }

    public Integer getCantidadDeSeguidos() {
        return cantidadDeSeguidos;
    }

    public void setCantidadDeSeguidos(Integer cantidadDeSeguidos) {
        this.cantidadDeSeguidos = cantidadDeSeguidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
