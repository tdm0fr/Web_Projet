<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div class="main clearfix">
    <div class="content">
        <c:if test="${empty sessionScope.connecte}">
            <div class="content no-horizontal-padding">
                <div class="container">
                    <div class="contact">
                        <div class="contact-form">
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
        </c:if>
    </div>
</div>