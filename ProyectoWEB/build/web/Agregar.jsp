<%-- 
    Document   : Agregar
    Created on : 27-nov-2014, 20:07:17
    Author     : Alám
--%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Juegos Trigonometricos</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!-- templatemo 347 dark pro -->
<!-- 
Dark Pro Template 
http://www.templatemo.com/preview/templatemo_347_dark_pro 
-->
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

<link rel="stylesheet" type="text/css" href="css/style1.css" />
<script language="javascript" type="text/javascript" src="js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="js/jquery.easing.js"></script>
<script language="javascript" type="text/javascript" src="js/script.js"></script>
<script type="text/javascript">
 $(document).ready( function(){	
		var buttons = { previous:$('#lofslidecontent45 .lof-previous') ,
						next:$('#lofslidecontent45 .lof-next') };
						
		$obj = $('#lofslidecontent45').lofJSidernews( { interval : 4000,
												direction		: 'opacitys',	
											 	easing			: 'easeInOutExpo',
												duration		: 1200,
												auto		 	: false,
												maxItemDisplay  : 4,
												navPosition     : 'horizontal', // horizontal
												navigatorHeight : 32,
												navigatorWidth  : 80,
												mainWidth:940,
												buttons			: buttons} );	
	});
</script>
 
</head>

<body>

<div id="templatemo_wrapper">
	
    <div id="templatmeo_header">
    	<div id="Juegos Trigonometricos"><h1><a rel="nofollow" href="">Juegos Trigonometricos</a></h1></div>
        
        
        <div class="cleaner"></div>
    </div> <!-- END of header -->
    
    <div id="templatemo_menu" class="ddsmoothmenu">
        <ul>
            <li><a href="Mysql.jsp" class="selected">Inicio</a></li>
            <li><a href="Agregar.jsp">Registro</a>
               
            </li>
            <li><a href="">Juegos</a>
                <ul>
                    
                   <FORM action=Eleccion.jsp method=POST>
                    <li><input type=hidden name="eleccion" value="1">
            <Input type='submit' name='Dados' value="Dados"></li>
                       </FORM> 
                    <FORM action=Eleccion.jsp method=POST>
                    <li><input type=hidden name="eleccion" value="2">
            
            <input type="submit" name ="jugar" value="Memorama"></li>
                     </FORM> 
                        
               </ul>
			</li>
			
			
        </ul>
        <br style="clear: left" />
    </div> <!-- END of menu -->

    
	<!-- END MAIN CONTENT --> 
    <!-- NAVIGATOR -->
		
    </div>
    
   
        
        
             <title>Nuevo Usuario</title>
    </head>
    <body>
        <FORM action=Nuevo method=POST>
            Dame tus Datos: <BR>
            Nombre: <Input type='text' name="nom" color="blue"><BR><BR>
            Contraseña: <Input type='text' name="pass" color="blue"><BR><BR>
            
            <Input type='submit' name='Enviar'>
            </FORM>
  
        
        

        
        <div class="cleaner"></div>
    
    </div> <!-- END of main -->
    
</div> <!-- END of wrapper -->

<div id="templatemo_footer_wrapper">
	<div id="templatemo_footer">
    	
		
       
			
			<div class="cleaner h20"></div>
            <div class="footer_social_button">
                <a href="#"><img src="images/facebook.png" title="Facebook" alt="Facebook" /></a>
                <a href="#"><img src="images/twitter.png" title="Twitter" alt="Twitter" /></a>
                <a href="#"><img src="images/youtube.png" title="Youtube" alt="Youtube" /></a>
               
			</div>
            
           
			
			<div class="cleaner"></div>
        </div>
		
        <div class="cleaner"></div>
    </div> <!-- END of footer -->
</div> <!-- END of footer wrapper -->
</body>
</html>





