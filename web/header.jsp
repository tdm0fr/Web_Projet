<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<header id="navigation">      
            <div class="navbar" role="banner">
                <div class="container">
                    <div class="row">
                            <div class="col-sm-3">
                                    <div class="navbar-header">
                                        <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" alt="logo"></a>
                                    </div>
                            </div>
                            <c:if test="${!empty sessionScope.connecte}">
                                <div class="col-sm-9">
                                        <nav class="navbar-right collapse navbar-collapse">
                                            <ul class="nav navbar-nav">
                                                <li class="active"><a data-hover="Accueil" href="index.jsp?action=">Accueil</a></li>
                                                <li><a data-hover="Abonnement" href="index.jsp?page=abonnement">Abonnement</a></li>                    
                                                <li><a data-hover="Utilisateurs" href="index.jsp?page=utilisateurs">Utilisateurs</a></li>
                                                <li><a data-hover="Musiques" href="ServletArtists?action=listeMusiques">Musiques</a></li>
                                                <li><a data-hover="Artistes" href="ServletArtists?action=listeArtistes">Artistes</a></li>
                                            </ul>
                                        </nav>
                                </div>
                            </c:if>
                    </div> 
                </div>
            </div>
        </header> <!--/#navigation-->