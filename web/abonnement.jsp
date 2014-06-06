<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
               
<div id="contact-page" class="container">
    <div class="bg">
            <div class="row">    		
                <div class="col-sm-12">    			   			
                    <h2 class="heading">Abonnez-vous !</h2>    			    				    				
                </div>
            </div>			 		

            <div class="row">  	
                <div class="col-sm-12">    			   			
                    <h2 class="heading"><a href="#">Abonnement de 2 jours, uniquement le week-end - 2€</a></h2>    
                    <span>Offre spéciale week-end pour découvrir notre service</span>
            </div>                
            <form action="ServletUsers" method="get">
                <div class="row">
                    <div class="col-md-12">
                        <input type="hidden" name="action" value="creerUnUtilisateur"/>  
                        <button type="submit" value="Valider l'inscription" name="submit">Valider l'inscription</button>
                    </div>
                </div>
            </form>    
                
                
                
              
    </div>
</div>