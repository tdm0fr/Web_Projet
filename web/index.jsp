<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>The Sound</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">    
        <link href="css/prettyPhoto.css" rel="stylesheet"> 
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/sc-player-standard.css" rel="stylesheet">
            <link href="css/main.css" rel="stylesheet">
            <link href="css/responsive.css" rel="stylesheet">
            <link href="css/presets/preset1.css" id="preset" rel="stylesheet" type="text/css">
            <link href="css/switcher.css" rel="stylesheet" type="text/css">

        <!--[if lt IE 9]>
                <script src="js/html5shiv.js"></script>
                <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.html">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.html">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.html">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.html">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.html">
    </head><!--/head-->
    <body>

        <c:import url="header.jsp"/>

        <%-- Si on est connecté --%>
        <c:if test="${!empty sessionScope.connecte}"> 
            <c:import url="deconnexion.jsp"/>
            
            <c:if test="${param['page'] == 'details'}">
                <c:import url="details.jsp"/>
            </c:if>

            <c:if test="${param['page'] == 'musiques'}">
                <c:import url="musiques.jsp"/>
            </c:if>
            
            <c:if test="${param['page'] == 'abonnement'}">
                <c:import url="abonnement.jsp"/>
            </c:if>
        </c:if>
        
        <%-- Si on est pas connecté --%>
        <c:if test="${empty sessionScope.connecte}">
            <c:import url="accueil.jsp"/>
            
            <c:if test="${param['action'] == 'connexion'}">
                <c:import url="connexion.jsp"/>
            </c:if>

            <c:if test="${param['action'] == 'inscription'}">
                <c:import url="inscription.jsp"/>
            </c:if>
        </c:if>
        
        <c:import url="footer.jsp"/>

        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/sc-player.js"></script> 
        <script type="text/javascript" src="js/soundcloud.player.api.js"></script> 
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
        <script type="text/javascript" src="js/jquery.fitvids.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script type="text/javascript" src="js/coundown-timer.js"></script>
        <script type="text/javascript" src="js/jquery.flexslider.js"></script>
        <script type="text/javascript" src="js/jquery.backstretch.min.js"></script>
        <script type="text/javascript" src="js/switcher.js"></script>
        <script type="text/javascript">
                jQuery(document).ready(function($){
                        $(window).load(function() {
                                // The slider being synced must be initialized first
                                $('#carousel').flexslider({
                                        animation: "slide",
                                        controlNav: false,
                                        animationLoop: false,
                                        slideshow: false,
                                        itemWidth: 41,
                                        itemMargin: 0,
                                        asNavFor: '#slider'
                                });

                                $('#slider').flexslider({
                                        directionNav: false,
                                        animation: "fade",
                                        controlNav: false,
                                        animationLoop: false,
                                        slideshow: false,
                                        sync: "#carousel"
                                });
                        });
                });

        </script>

    </body>
</html>
