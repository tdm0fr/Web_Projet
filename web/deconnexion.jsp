<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="contact-page" class="container">
    <div class="bg">
        <div class="row">    		
            <div class="col-sm-12">
                <h3>
                    <span id="connect">Bonjour ${login}</span>
                    <span style="float:right;"> <a id="deconnexion" href="ServletUsers?action=deconnexion">Déconnexion</a></span>
                <h3>
            </div>
        </div>
    </div>    			
</div>