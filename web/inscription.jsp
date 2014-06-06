<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:if test="${empty sessionScope.connecte}">
    <div id="contact-page" class="container">
        <div class="bg">
            <div class="row">    		
                <div class="col-sm-12">    		
                    <div class="contact-form">
                        
                        <h3>Inscription</h3>
                        
                        <form action="ServletUsers" method="get">
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="nom">Nom</label>
                                    <input type="text" name="nom"/><br>  

                                    <label for="prenom">Prénom</label>
                                    <input type="text" name="prenom"/><br>  

                                    <label for="loginConnexion">login</label>
                                    <input type="text" name="login"/><br>

                                    <label for="password">Mot de passe</label>
                                    <input type="password" name="password"/><br>

                                    <input type="hidden" name="action" value="creerUnUtilisateur"/>  
                                    <button type="submit" value="Valider l'inscription" name="submit">Valider l'inscription</button>
                                </div>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>