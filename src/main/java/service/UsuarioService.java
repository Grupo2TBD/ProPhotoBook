/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.UsuarioEJBLocal;
import model.Usuario;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.ApplicationPath;
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
@Path("/user")
//@ApplicationPath("/")
public class UsuarioService {
@EJB
    UsuarioEJBLocal usuarioEJB;
    
    @GET
    @Produces({"application/json"})
    public Usuario sac() {
        return usuarioEJB.test();
    }
	
    @POST
    @Path("/login")
    @Produces({"application/json"})
    public void loginService(){
       // return usuarioEJB.Login(mail, pass);
         usuarioEJB.Login("ian@tbd.com", "orellana18");
    }
}
