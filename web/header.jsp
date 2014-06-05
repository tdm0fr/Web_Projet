<%-- 
    Document   : header
    Created on : 27 mars 2014, 08:41:11
    Author     : naana_on
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<header class="header">
    <div class="header-content">
        <div class="container clearfix">
            <div class="logo">
                <a href="index.jsp">
                    <h1>MIAGE Music Project </h1>
                </a>
            </div>
            <c:if test="${!empty sessionScope.connecte}">
            <nav>
                <div class="expand-menu-icon"><a href="#"><i class="fa fa-bars"></i></a></div>
                <ul>
                    <li class="active"><a data-hover="Accueil" href="index.jsp?action=">Accueil</a></li>
                    <li><a data-hover="Abonnement" href="abonnement.jsp">Abonnement</a></li>                    
                    <li><a data-hover="Détails" href="index.jsp?action=detailUtilisateurs">Détails</a></li>
                    <li><a data-hover="Musiques" href="ServletArtists?action=listeMusiques">Musiques</a></li>
                    <li><a data-hover="Artistes" href="ServletArtists?action=listeArtistes">Artistes</a></li>
                </ul>
            </nav>
            </c:if>
            <div class="clear"></div>
        </div>
    </div>
</header>
