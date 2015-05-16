/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josefernando
 */
@WebServlet(urlPatterns = {"/jugar"})
public class jugar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        int vector[]=new int [12]; 
        int i=0,j; 
        vector[i]=(int)(Math.random()*12); 
        for(i=1;i<12;i++) 
        { 
            vector[i]=(int)(Math.random()*12); 
            for(j=0;j<i;j++) 
            { 
                if(vector[i]==vector[j]) 
                { 
                    i--; 
                } 
            } 
        } 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
                  PreparedStatement Consulta = con.prepareStatement("SELECT * FROM usuarios WHERE Nombre='" + nombre + "' AND Pass='" + pass + "';");
                  
                  ResultSet datos = Consulta.executeQuery(); 
                  if(datos.next())
                          {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet jugar</title>");            
            out.println("</head>");
            out.println("<body bgcolor='#6775a2'>");
            out.println("<table border='4'>");
            out.println("<tr>");
            for(int k=0; k<12;k++){
                out.println("<td>");
                out.println("<img id='img"+vector[k]+"' src='interrogacion1.jpg' onclick='alertame("+vector[k]+");'>");
                out.println("</td>");
                if(k==3){
                   out.println("</tr>");
                   out.println("<tr>");
                }
                else if(k==7){
                   out.println("</tr>");
                   out.println("<tr>");
                }
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("<script type='text/javascript'>");
            out.println("var bandera=0;");
            out.println("var puntos=0;");
            out.println("var contador=0;");
            out.println("var a, b");
            out.println("function alertame(vectorimg){");
            out.println("if (bandera==0){");
            out.println("document.getElementById('img'+vectorimg+'').src = 'img'+vectorimg+'.png';");
            out.println("a=vectorimg;");
            out.println("bandera=1;");
            out.println("}");
            out.println("else{");
            out.println("document.getElementById('img'+vectorimg+'').src = 'img'+vectorimg+'.png';");
            out.println("b=vectorimg;");
            out.println("if(a==b){");
            out.println("}");
            out.println("else{");
            out.println("bandera=0;");
            out.println("if(a==0 && b==6 || a==1 && b==7 || a==2 && b==8 || a==3 && b==9 || a==4 && b==10 || a==5 && b==11 || a==6 && b==0 || a==7 && b==1 || a==8 && b==2 || a==9 && b==3 || a==10 && b==4 || a==11 && b==5){");
            out.println("puntos=puntos+3");
            out.println("contador+=1;");
            out.println("alert('Ganas! Tus puntos son: '+puntos);");
            out.println("document.getElementById('img'+a+'').src = 'paloma_nike.jpg';");
            out.println("document.getElementById('img'+a+'').id = 'img_gane';");
            out.println("document.getElementById('img'+b+'').src = 'paloma_nike.jpg';");
            out.println("document.getElementById('img'+b+'').id = 'img_gane';");
            out.println("}");
            out.println("else{");
            out.println("puntos=puntos-1");
            out.println("alert('Pierdes, puntos: '+puntos);");
            out.println("document.getElementById('img'+a+'').src = 'interrogacion1.jpg';");
            out.println("document.getElementById('img'+b+'').src = 'interrogacion1.jpg';");
            out.println("}");
            out.println("if (contador==6){");
            out.println("valida(contador);");
            out.println("}");
            out.println("}");
            out.println("}");
            out.println("}");
            out.println("function valida(contador1){");
            out.println("if(contador1==6){");
            out.println("alert('Juego terminado total de puntos: '+puntos);");
            out.println("javascript:location.reload()");
            out.println("}");
            out.println("}");
            out.println("</script>");
            out.println("<td>");
            out.println("</body>");
            out.println("</html>");
                          }  else
                  {
                      out.println("<!DOCTYPE html>");
                      out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Juegos Dados</title>");    
                        out.println("<meta http-equiv=\"Refresh\" content=\"3;url=http://localhost:8080/ProyectoWEB/Mysql.jsp\">");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("No se encontro el usuario indicado, redireccionando a la pagina principal");
                        out.println("</body>");
                        out.println("</html>");
                  }
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
              
            out.println("</body>");
            out.println("</html>");
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jugar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jugar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jugar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jugar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alertame(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        try (PrintWriter out = response.getWriter()) {
            out.println("<p>Exitooooooo</p>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jugar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jugar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jugar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jugar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
