/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.service;

import Entity.Usuario;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ian
 */
@Stateless
@Path("entity.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {
     public static final String USERNAME = "root";
    public static final String PASSWORD = "transcend2";
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE = "TBD";
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    public java.sql.Connection con;
    @PersistenceContext(unitName = "MockUpPU")
    private EntityManager em;
    
    public UsuarioFacadeREST() {
        super(Usuario.class);
    }
    
    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    
    @POST
    @Path("/login")
    //@WebMethod(operationName = "insert")
    public String logger(@FormParam("id") String id,@FormParam("pass") String pass) 
    {
        try 
        {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Query query = em.createNamedQuery("Usuario.findAll");
            List<Usuario> list= query.getResultList();
            int largo=list.size();
            int contador=0;
            while(largo!=0){
                if(id.equals(list.get(contador).getCorreoElectronicoUsuario()) && pass.equals(list.get(contador).getContrasenaUsuario())){
                    
                    return "Ingresa al Sistema";
                    
                }
                contador++;
                largo--;
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
          
        return "El usuario o la contraseña son incorrectos";
    }
    
  /*  @POST
    @Path("/registro")
    //@WebMethod(operationName = "insert")
    public String registro(@FormParam("name") String name,@FormParam("lastname") String lastname,@FormParam("birthdate") String birthdate,@FormParam("email") String email,@FormParam("password") String password,@FormParam("alias") String alias) throws SQLException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException 
    {
        Query query;
        try 
        {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            query = em.createNamedQuery("Usuario.findAll");
            List<Usuario> list= query.getResultList();
            int largo=list.size();
            int contador=0;
            while(largo!=0){
                if(email.equals(list.get(contador).getCorreoElectronicoUsuario()) || alias.equals(list.get(contador).getAliasUsuario())){
                    return "ya esta el ql";
                }
                largo--;
                contador++;
            }
            
            
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        Usuario usuario=new Usuario();
        usuario.setNombreRealUsuario(name);
        usuario.setApellidoUsuario(lastname);
        usuario.setContrasenaUsuario(password);
        usuario.setAliasUsuario(alias);
        usuario.setFechaCumpleanos(null);
        usuario.setCorreoElectronicoUsuario(email);
        em.persist(usuario);
        
        
             
        return "ql insertado";
    }    
    
    */
    @POST
    @Path("/registro")
    //@WebMethod(operationName = "insert")
    public String registro(@FormParam("name") String name,@FormParam("lastname") String lastname,@FormParam("birthdate") String birthdate,@FormParam("email") String email,@FormParam("password") String password,@FormParam("alias") String alias) throws SQLException 
    {
        String query;
        
        try 
        {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement st=con.createStatement();
            ResultSet rs=null;
            query="select * from USUARIO";
            rs=st.executeQuery(query);
            while(rs.next()){
                if(email.equals(rs.getString("CORREO_ELECTRONICO_USUARIO")) || alias.equals(rs.getString("ALIAS_USUARIO"))){
                    return "El correo electronico utilizado ya se encuentra registrado";
                }
                
            }
            
            
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
        query="insert into USUARIO (NOMBRE_REAL_USUARIO, APELLIDO_USUARIO,CONTRASENA_USUARIO, ALIAS_USUARIO, FECHA_CUMPLEANOS, CORREO_ELECTRONICO_USUARIO) VALUES (?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);
            st.setString(1,name);
            st.setString(2,lastname);
            st.setString(3,password);
            st.setString(4,alias);
            st.setString(5,birthdate);
            st.setString(6,email);
            st.executeUpdate(); 
                
        return "Bienvenido a Pro PhotoBook";
    }    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
}
