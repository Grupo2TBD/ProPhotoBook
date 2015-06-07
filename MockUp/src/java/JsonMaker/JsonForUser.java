/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonMaker;

import javax.json.Json;
import javax.json.JsonObject;
import javax.jws.WebMethod;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.Produces;
/**
 *
 * @author ian
 */


@Path("user")
public class JsonForUser {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "transcend2";
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE = "TBD";
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    public java.sql.Connection con;
    @GET 
    public JsonObject buildBook(){ 
          return Json.createObjectBuilder()
                        .add("Usuario", Json.createObjectBuilder()
                            .add("nombre", "sac")
                            .add("pass","osoflaite")
                            ).build();
    }

   /* @GET
    @Path("/respuesta")
    @Produces("text/html")
    @WebMethod(operationName = "retrive")
    public String retrive() 
    {
        ResultSet rs = null;
        String details = ""; 
        try 
        {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            String query = "select ID_USUARIO,NOMBRE_REAL_USUARIO from USUARIO";

            PreparedStatement st = con.prepareStatement(query);
            rs = st.executeQuery();

            details = "<html><body>"; 
            details = details + "<table border=1>";
            details = details + "<tr><td><Strong>Id </Strong></td>" +
                                    "<td><Strong>Name </Strong></td>" + "</tr>";
            while (rs.next()) 
            {
                details = details + "<tr><td>" + rs.getInt("ID_USUARIO") + "</td>" +
                                        "<td>" + rs.getString("NOMBRE_REAL_USUARIO") + "</td></tr>";
            }
            details += "</table></body></html>"; 
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }   
        return details;
    }
    */
    
    @POST
    @Path("/fetch")
    //@WebMethod(operationName = "insert")
    public String insert(@FormParam("id") String id) 
    {
        System.out.println(id);
        try 
        {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String query = "insert into USUARIO(ID_USUARIO)VALUES(?)";

            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,id);
            st.executeUpdate();     
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return"Record inserted successfully";
    }
   
    
    
}
