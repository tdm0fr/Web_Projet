<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%--
<div class="wrapper">

    <div class="page-header page-header-home clearfix">
        <div class="col-md-4 col-sm-6">
            <div class="search">
                <form action="#">
                    <input type="text" x-webkit-speech>
                </form>
            </div>
        </div>
    --%>

<div id="contact-page" class="container">
    <div class="bg">
        <div class="row">    		
            <div class="col-sm-12">    		
                <div class="contact-form">
                    
                    <c:if test="${sessionScope.connecte}">
                        <section class="content-header"><h1>Menu de gestion des utilisateurs</h1></section>

                        Liste des fonctionnalités à implémenter dans la Servlet (note : après chaque action cette page sera rappelée par la servlet avec la liste des utilisateurs raffraichie et un message de confirmation  
                        <ol>  
                            <c:if test="${param['action'] == 'creerUtilisateursDeTest'}" >
                                <li>
                                    <a href="ServletUsers?action=creerUtilisateursDeTest">
                                        Créer 4 utilisateurs de test
                                    </a>
                                </li>
                            </c:if>

                            <c:if test="${param['action'] == 'detailUtilisateurs'}" >
                                <li>Afficher les détails d'un utilisateur</li>  
                                <form action="ServletUsers" method="get">  
                                    login : <input type="text" name="login"/><br>  
                                    <input type="hidden" name="action" value="chercherParLogin"/>  
                                    <input type="submit" value="Chercher" name="submit"/>  
                                </form>  
                            </c:if>

                            <c:if test="${param['action'] == 'modifierUtilisateurs'}" >
                                <li>Modifier les détails d'un utilisateur :</li>  
                                <form action="ServletUsers" method="get">  
                                    Login : <input type="text" name="login"/><br>  
                                    Nom : <input type="text" name="nom"/><br>  
                                    Prénom : <input type="text" name="prenom"/><br>  
                                    <input type="hidden" name="action" value="updateUtilisateur"/>  
                                    <input type="submit" value="Mettre à jour" name="submit"/>  
                                </form>  
                            </c:if>

                            <c:if test="${param['action'] == 'supprimerUtilisateurs'}" >
                                <li>Supprimer un utilisateur</li>  
                                <form action="ServletUsers" method="get">  
                                    login : <input type="text" name="login"/><br>  
                                    <input type="hidden" name="action" value="supprimer"/>  
                                    <input type="submit" value="Supprimer" name="submit"/>  
                                </form>  
                            </ol>  
                        </c:if>
                        <!-- Fin du menu -->  

                        <!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->  
                        <c:if test="${param['action'] == 'listerLesUtilisateurs'}" >  
                            <h2>Liste des utilisateurs</h2>  

                            <table border="1" style="text-align: center;">  
                                <!-- La ligne de titre du tableau des comptes -->  
                                <tr>  
                                    <td><b>Login</b></td>  
                                    <td><b>Prénom</b></td>  
                                    <td><b>Nom</b></td>
                                    <td><b>Password</b></td>
                                    <td><b>Ville</b></td>  
                                    <td><b>Code postal</b></td> 
                                    <td><b>abonnement</b></td> 
                                </tr>  

                                <!-- Ici on affiche les lignes, une par utilisateur -->  
                                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  


                                <c:forEach var="u" items="${requestScope['listeDesUsers']}"> 
                                    <tr>  
                                        <td>${u.login}</td>  
                                        <td>${u.firstname}</td>  
                                        <td>${u.lastname}</td>
                                        <td>${u.password}</td>
                                        <td>
                                            <a href="ServletUsers?action=listerUtilisateursParVille&idville=${u.adresse.id}">
                                                ${u.adresse.ville}
                                            </a>
                                        </td> 
                                        <td>${u.adresse.codePostal}</td> 
                                        <td>${u.abonnement}</td>
                                    </tr>  
                                </c:forEach>  
                                <!-- Affichage du solde total dans la dernière ligne du tableau -->  
                                <tr><td><b>TOTAL</b></td><td></td><td><b>${requestScope['length']}</b></td></tr>  


                            </table> 

                            <c:if test="${requestScope['totalPages'] != null}" >
                                <c:forEach var="i" begin="1" end="${requestScope['totalPages']}"> 
                                    <c:if test="${i == 1}" > 
                                        <a href="ServletUsers?action=listerLesUtilisateurs&page=${i}">${i}-${i}0</a> 
                                    </c:if>  
                                    <c:if test="${i != 1}" > 
                                        <a href="ServletUsers?action=listerLesUtilisateurs&page=${i}">${i-1}1-${i}0</a> 
                                    </c:if>       
                                </c:forEach>  

                            </c:if>


                        </c:if>  

                        <c:if test="${param['action'] == 'chercherParLogin'}" >  
                            <h2>Liste des utilisateurs</h2>  

                            <table border="0" style="text-align: center; ">
                                <!-- La ligne de titre du tableau des comptes -->  
                                <tr>  
                                    <td><b>Login</b></td>  
                                    <td><b>Nom</b></td>  
                                    <td><b>Prénom</b></td>  
                                </tr>  

                                <!-- Ici on affiche les lignes, une par utilisateur -->  
                                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  


                                <c:forEach var="u" items="${requestScope['listeDesUsers']}"> 
                                    <tr>  
                                        <td>${u.login}</td>  
                                        <td>${u.firstname}</td>  
                                        <td>${u.lastname}</td> 
                                    </tr>  
                                </c:forEach>  
                                <!-- Affichage du solde total dans la dernière ligne du tableau -->  
                                <tr><td><b>TOTAL</b></td><td></td><td><b>${requestScope['length']}</b></td></tr>  


                            </table> 

                            <c:if test="${requestScope['totalPages'] != null}" >
                                <c:if test="${param['page'] > 1}">
                                    <a href="ServletUsers?action=listerLesUtilisateurs&page=${param['page']-1}">
                                        Précédent
                                    </a>
                                </c:if>
                                <c:forEach var="i" begin="1" end="${requestScope['totalPages']}"> 
                                    <a href="ServletUsers?action=listerLesUtilisateurs&page=${i}">${i}</a>     
                                </c:forEach>  
                                <c:if test="${param['page'] < requestScope['totalPages']}">
                                    <a href="ServletUsers?action=listerLesUtilisateurs&page=${param['page']+1}">
                                        Suivant
                                    </a>
                                </c:if>
                            </c:if>             
                        </c:if>                   

                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>