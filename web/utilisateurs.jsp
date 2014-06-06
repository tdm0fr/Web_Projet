<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<div id="contact-page" class="container">
    <div class="bg">
        <div class="row">    		
            <div class="col-sm-12">    		
                <div class="contact-form">
                    
                    <c:if test="${sessionScope.connecte}">
                        <h2 class="heading">Gestion des utilisateurs</h2>

                            <li><a href="index.jsp?page=utilisateurs&action=detailUtilisateurs">Afficher les détails d'un utilisateur</a></li>

                            <li><a href="index.jsp?page=utilisateurs&action=modifierUtilisateurs">Modifier un utilisateur</a></li>

                            <li><a href="index.jsp?page=utilisateurs&action=supprimer">Supprimer un utilisateur</a></li>
                        <ol>  

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
                                    Password : <input type="text" name="password"/><br>
                                    <input type="hidden" name="action" value="updateUtilisateur"/>  
                                    <input type="submit" value="Mettre à jour" name="submit"/>  
                                </form>  
                            </c:if>
                            
                           <c:if test="${param['action'] == 'supprimer'}" >     
                           <form action="ServletUsers" method="get">
                                Login : <input type="text" name="login"/><br>
                                <input type="hidden" name="action" value="deleteUser"/>
                                <input type="submit" value="Supprimer" name="submit"/>
                            </form> 
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