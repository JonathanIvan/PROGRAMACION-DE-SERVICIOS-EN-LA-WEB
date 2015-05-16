/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author Invitado
 */
@WebServlet(urlPatterns = {"/Nuevo"})
public class Nuevo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8"); 
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
                              out.println("<html>");            
                              out.println("<head>");            
                              out.println("<title>Juegos Dados</title>"); 
                              out.println("<META HTTP-EQUIV='REFRESH' CONTENT='3;URL=http://localhost:8080/ProyectoWEB/Mysql.jsp'>");
                              out.println("</head>");            
                              out.println("<body bgcolor='#6775a2'>");
                              out.println("Se agrego con exito a " + request.getParameter("nom"));
                              out.println("</body>");
                              out.println("</html>");
           Connection con = null; 
              Statement  stmt = null; 
  
              try { 
                  String nombre = request.getParameter("nom");
                  String pass = request.getParameter("pass");
                  String url = "jdbc:mysql://localhost:3306/juegodados"; 
                  String usuario = "root"; 
                  String contra = ""; 
                  Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                  con = DriverManager.getConnection(url,usuario,contra); 
                  if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos " +  
                                       "\n " + url ); 
                  stmt = con.createStatement(); 
                  stmt.executeUpdate("INSERT INTO usuarios VALUES (NULL,'" + nombre + "','" + pass + "','100','50',NOW())"); 
                  
                  //System.out.println("Los valores han sido agregados a la base de datos "); 
                  } 
                  catch( SQLException e ) { 
                      //e.printStackTrace(); 
                  } 
  
              finally { 
                  if ( con != null ) { 
                      try    { 
                          con.close(); 
                          stmt.close(); 
                      } catch( Exception e ) { 
                          System.out.println( e.getMessage()); 
                      } 
                  } 
              }
        }      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            //System.out.println("Intentando Conexion");
        }
        //System.out.println("SI");
        
	          } 

    @Override
    public String getServletInfo() {
        return "";
    }
}