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
                    <span>Offre spéciale week-end pour découvrir notre service</span><br /> 
                </div>               
                <form action="ServletUsers" method="get">
                    <div class="row">
                        <div class="col-md-12">
                            <input type="hidden" name="action" value="abonnement_2jours"/>  <br />
                            <button type="submit" value="S'abonner" name="submit">S'abonner pour un week end</button>
                        </div>
                    </div>
                </form>    
            </div><br /> <br /> 
        
            <div class="row">  	
                <div class="col-sm-12">    			   			
                    <h2 class="heading"><a href="#">Abonnement d'une semaine - 5€</a></h2>    
                    <span>Utiliser notre service pendant une semaine</span>
                </div>                
                <form action="ServletUsers" method="get">
                    <div class="row">
                        <div class="col-md-12">
                            <input type="hidden" name="action" value="abonnement_7jours"/>  <br /> 
                            <button type="submit" value="S'abonner" name="submit">S'abonner pour une semaine</button>
                        </div>
                    </div>
                </form>     
           </div><br /> <br /> 
        
            <div class="row">  	
                <div class="col-sm-12">    			   			
                    <h2 class="heading"><a href="#">Abonnement d'une mois - 18€</a></h2>    
                    <span>Utiliser notre service pendant un mois</span>
                </div>                
                <form action="ServletUsers" method="get">
                    <div class="row">
                        <div class="col-md-12">
                            <input type="hidden" name="action" value="abonnement_30jours"/>  <br /> 
                            <button type="submit" value="S'abonner" name="submit">S'abonner pour un mois</button>
                        </div>
                    </div>
                </form>      
            </div><br /> <br /> 
            
            <div class="row">  	
                <div class="col-sm-12">    			   			
                    <h2 class="heading"><a href="#">Abonnement d'an - 200€</a></h2>    
                    <span>Utiliser notre service pendant un an</span>
                </div>                
                <form action="ServletUsers" method="get">
                    <div class="row">
                        <div class="col-md-12">
                            <input type="hidden" name="action" value="abonnement_365jours"/>  <br /> 
                            <button type="submit" value="S'abonner" name="submit">S'abonner pour un an</button>
                        </div>
                    </div>
                </form>      
            </div><br /> <br />
            
            <div class="row">  	
                <div class="col-sm-12">    			   			
                    <h2 class="heading"><a href="#">Abonnement à vie - 400€</a></h2>    
                    <span>Utiliser notre service à vie !</span>
                </div>                
                <form action="ServletUsers" method="get">
                    <div class="row">
                        <div class="col-md-12">
                            <input type="hidden" name="action" value="abonnement_unlimited_jours"/>  <br /> 
                            <button type="submit" value="S'abonner" name="submit">S'abonner à vie</button>
                        </div>
                    </div>
                </form>      
            </div><br /> <br />
    </div>
</div>