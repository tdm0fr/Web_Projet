<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  

<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:if test="${empty sessionScope.connecte}">
    <c:choose>

        <c:when test="${param['action'] == 'connexion'}">
            <div class="page-header-bg">
                <a href="#" class="expand-icon"><i class="fa fa-expand"></i></a>
                <div class="overlay"></div>
                <img src="images/gallery/slides/slide1.jpg" alt="">
                <div class="page-header-bg-content">
                    <h3>Connexion</h3>
                </div>
            </div>
        </c:when>

        <c:when test="${param['action'] == 'inscription'}">
            <div class="page-header-bg">
                <a href="#" class="expand-icon"><i class="fa fa-expand"></i></a>
                <div class="overlay"></div>
                <img src="images/gallery/slides/slide1.jpg" alt="">
                <div class="page-header-bg-content">
                    <h3>Inscription</h3>
                </div>
            </div>
        </c:when>

        <c:otherwise>
            <div class="big-home-slider">
                <ul>
                    <li class="starting-slide">
                        <div class="slide-content">
                            <div class="image">
                                <img src="images/gallery/slides/slide1.jpg" />
                            </div>

                            <div class="slide-content-inner">
                                <h1 class="animated fadeInDown">Bienvenue ♫</h1>

                                <p class="animated fadeInUp">MMP est une plateforme d'achat de musique à l'unité, ou par abonnement. <c:if test="${empty sessionScope.connecte}">Pour en profiter :</p>

                                    <div class="button">
                                        <a class="animated fadeInRight" href="index.jsp?action=inscription">Inscrivez-vous !</a>
                                        <a class="animated fadeInRight" href="index.jsp?action=connexion">Connectez-vous !</a>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="audio-player">
            </div>
        </c:otherwise>

    </c:choose>
</c:if>

<c:if test="${!empty sessionScope.connecte}">
    <div class="page-header-bg">
        <a href="#" class="expand-icon"><i class="fa fa-expand"></i></a>
        <div class="overlay"></div>
        <img src="images/gallery/slides/slide1.jpg" alt="">
        <div class="page-header-bg-content">
            <h3>Bienvenue ♫</h3>
        </div>
    </div>
</c:if>