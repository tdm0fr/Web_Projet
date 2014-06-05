<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  

<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div class="main clearfix">
    <div class="content">
        <c:if test="${empty sessionScope.connecte}">
            <div class="content no-horizontal-padding">
                <div class="container">
                    <div class="contact">
                        <div class="contact-form">
                            <form action="ServletUsers" method="get">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label for="nom">Nom</label>
                                        <input type="text" name="nom"/><br>  

                                        <label for="prenom">Prénom</label>
                                        <input type="text" name="prenom"/><br>  

                                        <label for="loginConnexion">Mail</label>
                                        <input type="text" name="login"/><br>

                                        <label for="password">Mot de passe</label>
                                        <input type="password" name="password"/><br>

                                        <label for="ville">Adresse</label>
                                        <input type="text" name="ville"/><br> 

                                        <label for="postal">Code postal</label>
                                        <input type="text" name="postal"/><br>

                                        <input type="hidden" name="action" value="creerUnUtilisateur"/>  
                                        <button type="submit" value="Valider l'inscription" name="submit">Valider l'inscription</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>