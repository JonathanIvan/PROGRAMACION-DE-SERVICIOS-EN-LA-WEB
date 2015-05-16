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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Invitado
 */
@WebServlet(urlPatterns = {"/ConexionBaseDatos"})
public class ConexionBaseDatos extends HttpServlet {
    
    boolean bandera=false;
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8"); 
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
           Connection con = null; 
              Statement  stmt = null; 
              bandera=true;
  
              try { 
                  String nombre = request.getParameter("nom");
                  String pass = request.getParameter("pass");
                  String url = "jdbc:mysql://localhost:3306/juegodados"; 
                  String usuario = "root"; 
                  String contra = ""; 
                  Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                  con = DriverManager.getConnection(url,usuario,contra); 
                  if ( con != null ) 
                    System.out.println("Se ha establecido una conexiÃ³n a la base de datos " +  
                                       "\n " + url ); 
                  stmt = con.createStatement(); 
                  PreparedStatement Consulta = con.prepareStatement("SELECT * FROM usuarios WHERE Nombre='" + nombre + "' AND Pass='" + pass + "';");
                  
                  ResultSet datos = Consulta.executeQuery(); 
                  if(datos.next())
                          {
                              int a=0, b=6, c=12;
                              int p = Integer.parseInt(datos.getString("Puntos"));
                              int turno=10;
                              out.println("<!DOCTYPE html>");
                              out.println("<html>");            
                              out.println("<head>");            
                              out.println("<title>Juegos Dados</title>"); 
                              out.println("</head>");            
                              out.println("<body bgcolor='#6775a2'>");
                              out.println("<img id=img1 src=\"dado1.gif\">");
                              out.println("<img id=img2 src=\"dado2.gif\">");
                              out.println("<img id=img3 src=\"dado3.gif\"><BR>");
                              out.println("Bienvenido: " + datos.getString("Nombre") + "<BR>");
                              out.println("<form action='ConexionBaseDatos' method='POST'>");
                              out.println("<INPUT TYPE=hidden NAME='user' VALUE='"+nombre+"'>");
                              out.println("<INPUT TYPE=hidden NAME='pass' VALUE='"+pass+"'>");
                              out.println("<INPUT TYPE=hidden id='puntaje' NAME='puntaje'>");
                              out.println("<label id=puntos >Tus Puntos: " + datos.getString("Puntos")+ "</label><BR>");
                              out.println("<label id=turnos>Te quedan "+turno+" turnos</label><BR>");
                              //PreparedStatement Consulta2 = con.prepareStatement("UPDATE usuarios SET Puntos=90 WHERE Nombre='" + datos.getString("Nombre") + "'");
                              out.println("<input type='button' id='juega' onClick='mensaje("+a+", "+b+","+c+")' value='Lanzar dados!!!'>");
                              
                              out.println("<SCRIPT LANGUAGE=JavaScript>");
                              out.println("var turno=10;");
                              out.println("var puntos="+p+";");
                              out.println("function mensaje(num1, num2, num3){");    
                              out.println("num1=Math.floor((Math.random() * (6-0)) + 0);");
                              out.println("num2=Math.floor((Math.random() * (12-6)) + 6);");
                              out.println("num3=Math.floor((Math.random() * (18-12)) + 12);");
                              
                              out.println("document.getElementById('img1').src = 'cara'+num1+'.png';");
                              out.println("document.getElementById('img1').height='200';");
                              out.println("document.getElementById('img1').width='200';");
                              out.println("document.getElementById('img2').src = 'cara'+num2+'.png';");
                              out.println("document.getElementById('img2').height='200';");
                              out.println("document.getElementById('img2').width='200';");
                              out.println("document.getElementById('img3').src = 'cara'+num3+'.png';");
                              out.println("document.getElementById('img3').height='200';");
                              out.println("document.getElementById('img3').width='200';");
                              out.println("valida_dados(num1, num2, num3)");
                              out.println("}");
                              out.println("function valida_dados(a, b, c) {");
                              out.println("if(a==0 && b==6 || a==0 && c==12 || a==1 && b==7 || a==1 && c==13 || a==2 && b==8 || a==2 && c==14 || a==3 && b==9 || a==3 && c==15 || a==4 && b==10 || a==4 && c==16 || a==5 && b==11 || a==5 && c==17 || c==12 && b==6 || b==7 && c==13 || b==8 && c==14 || b==9 && c==15 || b==10 && c==16 || b==11 && c==17){");
                              out.println("if(a==0 && b==6 && c==12 || a==1 && b==7 && c==13 || a==2 && b==8 && c==14 || a==3 && b==9 && c==15 || a==4 && b==10 && c==16 || a==5 && b==11 && c==17){");
                              out.println("alert('3 lados iguales!! Ganas 100');");
                              out.println("turno--;");
                              out.println("puntos+=100;");
                              out.println("document.getElementById('turnos').innerHTML = 'Te quedan '+turno+' turnos';");
                              out.println("document.getElementById('puntos').innerHTML = 'Tus puntos: '+puntos+'';");
                              out.println("}");
                              out.println("else{");
                              out.println("alert('2 lados iguales, ganas 20');");
                              out.println("puntos+=20;");
                              out.println("turno--;");
                              out.println("document.getElementById('turnos').innerHTML = 'Te quedan '+turno+' turnos';");
                              out.println("document.getElementById('puntos').innerHTML = 'Tus puntos: '+puntos+'';");
                              out.println("}");
                              out.println("}");
                              out.println("else{");
                              out.println("alert('No hay coincidencias, pierdes 10');");
                              out.println("turno--;");
                              out.println("puntos-=10;");
                              out.println("document.getElementById('turnos').innerHTML = 'Te quedan: '+turno+' turnos';");
                              out.println("document.getElementById('puntos').innerHTML = 'Tus puntos: '+puntos+'';");
                              out.println("}");
                              out.println("if(turno==0){");
                              out.println("document.getElementById('puntaje').value= ''+puntos+'';");
                              out.println("document.getElementById('juega').disabled=true;");
                              out.println("document.getElementById('envialo').disabled=false;");
                              out.println("}");
                              /*out.println("document.getElementById('img1').src = 'dado1.gif';");
                              out.println("document.getElementById('img2').src = 'dado2.gif';");
                              out.println("document.getElementById('img3').src = 'dado3.gif';");*/
                              out.println("}");
                              out.println("</SCRIPT>");
                              out.println("<input type='submit' id='envialo' value='Enviar' disabled>");
                              out.println("</form>");
                              
                              
                               out.println("<table border = \"1\" >");
      out.println("<tr bgcolor = \" #6666ff \"><th>Funcion</th><th>Relacion</th><th>Inversa</th></tr>");
    //Sen
       	out.println("<tr >");
          
      	out.println("<td bgcolor = \' #95deb5 \'>Sen</td>" );
         
      	out.println("<td bgcolor = \' #95deb5 \'>a/c</td>" );
          
        out.println("<td bgcolor = \' #95deb5 \'>1/Csc</td>" );
          
        out.println("</tr>");
        
       //Cos
             	out.println("<tr >");
         
      	out.println("<td bgcolor = \' #de959a \'>Cos</td>" );
          
      	out.println("<td bgcolor = \' #de959a \'>b/c</td>" );
         
        out.println("<td bgcolor = \' #de959a \'>1/Sec</td>" );
          
        out.println("</tr>");
        
        //Tan
        out.println("<tr >");
          
      	out.println("<td bgcolor = \' #9ade95 \'>Tan</td>" );
          
      	out.println("<td bgcolor = \' #9ade95 \'>a/b</td>" );
         
        out.println("<td bgcolor = \' #9ade95 \'>1/Cot</td>" );
          
        out.println("</tr>");
        
         //Csc
        out.println("<tr >");
          
      	out.println("<td bgcolor = \' #ffcc33 \'>Csc</td>" );
         
      	out.println("<td bgcolor = \' #ffcc33 \'>c/a</td>" );
          
          
        out.println("<td bgcolor = \' #ffcc33 \'>1/Sen</td>" );
        
        out.println("</tr>");
     //Sec
        out.println("<tr >");
          
      	out.println("<td bgcolor = \' #ff9900 \'>Sec</td>" );
          
      	out.println("<td bgcolor = \' #ff9900 \'>c/b</td>" );
         
        out.println("<td bgcolor = \' #ff9900 \'>1/Cos</td>" );
         
        out.println("</tr>");
        //Cot
        out.println("<tr >");
          
      	out.println("<td bgcolor = \' #ff3300 \'>Cot</td>" );
         
      	out.println("<td bgcolor = \' #ff3300 \'>b/a</td>" );
          
        out.println("<td bgcolor = \' #ff3300 \'>1/Tan</td>" );
         
        out.println("</tr>");
      out.println("</table>");
                              
                              
                              out.println("</body>");
                              out.println("</html>");
                          }
                  else
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
              }
            out.println("</body>");
            out.println("</html>");
        }
        
         
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if(!bandera){
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            //System.out.println("Intentando Conexion");
        }
        //System.out.println("SI");
       }
        else{
            Connection con = null; 
            Statement  stmt = null; 
            bandera=false;
            try (PrintWriter out = response.getWriter()) {
                String nombre = request.getParameter("user");
                  String pass = request.getParameter("pass");
                  String puntos= request.getParameter("puntaje");
                  if(nombre!=null){
                  String url = "jdbc:mysql://localhost:3306/juegodados"; 
                  String usuario = "root"; 
                  String contra = ""; 
                  Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                  con = DriverManager.getConnection(url,usuario,contra);
                  if ( con != null ){
                  stmt = con.createStatement(); 
                  PreparedStatement Consulta = con.prepareStatement("UPDATE usuarios SET Puntos=" + puntos +" WHERE Nombre='" + nombre + "'");
                  Consulta.executeUpdate();
                  out.println("<!DOCTYPE html>");
                      out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Juegos Dados</title>");    
                        out.println("<meta http-equiv=\"Refresh\" content=\"3;url=http://localhost:8080/ProyectoWEB/Mysql.jsp\">");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("Datos Guardados! Redireccionando a la pagina principal");
                        out.println("</body>");
                        out.println("</html>");
                  }
                  }
                  else{
                      out.println("<!DOCTYPE html>");
                      out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Juegos Dados</title>");    
                        out.println("<meta http-equiv=\"Refresh\" content=\"3;url=http://localhost:8080/ProyectoWEB/Mysql.jsp\">");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("Redireccionando a la pagina principal, espera por favor");
                        out.println("</body>");
                        out.println("</html>");
                  }
                  
            }
            catch( SQLException e ) { 
                      //e.printStackTrace(); 
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }

    @Override
    public String getServletInfo() {
        return "";
    }
}