<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MIAGE Music Project</title>

        <!-- Fonts -->
        <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat+Alternates:400,700" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic" rel="stylesheet" type="text/css">

        <link href="css/linecons.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/mediaelementplayer-theme.css">
        <link rel="stylesheet" href="css/bxslider-theme.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/core/modernizr.js"></script>
    </head>
    <body>

        <c:import url="header.jsp"/>

        <c:if test="${!empty sessionScope.connecte}">
            <div class="main clearfix">
                <c:import url="content_abonnement.jsp"/>
            </div>
        </c:if>

        <c:import url="footer.jsp"/>

        <!-- Scripts -->
        <script src="js/core/jquery-1.11.0.min.js"></script>
        <script src="js/core/bootstrap.min.js"></script>

        <script src="js/plugins/html5slider.js"></script>
        <script src="js/plugins/mediaelement-and-player.min.js"></script>
        <script src="js/plugins/jquery.bxslider.min.js"></script>
        <script src="js/plugins/jquery.removeWhitespace.min.js"></script>
        <script src="js/plugins/jquery.collagePlus.min.js"></script>

        <script src="js/scripts/audio.js"></script>
        <script src="js/scripts/init.js"></script>
        <script src="js/scripts/main.js"></script>

    </body>
</html>
