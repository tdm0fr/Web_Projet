<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:if test="${empty sessionScope.connecte}">
    <div id="contact-page" class="container">
        <div class="bg">
            <div class="row">    		
                <div class="col-sm-12">    		
                    <div class="contact-form">

                        <h3>Connexion</h3>
                        
                        <form action="ServletUsers" method="get" id="connexion">
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="loginConnexion">Login</label>
                                    <input type="text" name="login" id="loginConnexion"/>
                                    <label for="password">Mot de passe</label>
                                    <input type="password" name="password" id="passwordConnexion"/>
                                    <input type="hidden" name="action" value="authentifier"/>  
                                    <button type="submit" value="Se connecter" name="submit">Se connecter</button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>