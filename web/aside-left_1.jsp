<%-- 
    Document   : aside-left
    Created on : 27 mars 2014, 08:41:30
    Author     : naana_on
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<aside class="left-side sidebar-offcanvas">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left info">
                <c:if test="${!empty sessionScope.connecte}">
                    <p id="connect">Bonjour, ${login}</p><br>
                    <a id="deconnexion" href="ServletUsers?action=deconnexion">Déconnexion</a>
                </c:if>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li>
                <a href="ServletUsers?action=listerLesUtilisateurs&page=1">Afficher les utilisateurs</a>
            </li>
            <li>
                <a href="ServletUsers?action=creerUtilisateursDeTest">Créer 4 utilisateurs de test</a>
            </li>  
            <li>
                <a href="index.jsp?action=creerUtilisateurs">Créer un utilisateur</a>
            </li>  
            <li>
                <a href="index.jsp?action=detailUtilisateurs">Afficher les détails d'un utilisateur</a>
            </li>  
            <li>
                <a href="index.jsp?action=modifierUtilisateurs">Modifier les détails d'un utilisateur</a>
            </li>  
            <li>
                <a href="index.jsp?action=supprimerUtilisateurs">Supprimer un utilisateur</a>
            </li>  
            <li>
                <a href='https://www.facebook.com/GrinnyH'>Suceuse de bites</a>
            </li> 
            
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
