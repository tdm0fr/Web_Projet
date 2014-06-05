<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<div class="page-header-bg">
    <a href="#" class="expand-icon"><i class="fa fa-expand"></i></a>
    <div class="overlay"></div>
    <img src="images/gallery/slides/slide2.jpg" alt="">
    <div class="page-header-bg-content">
        <h3>Musiques</h3>
    </div>
</div> 

<!--Recherche : <input id="filter" type="text" value="" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;"/> -->

<c:if test="${param['action'] == 'listeMusiques'}" >
    <div class="content no-horizontal-padding">
        <div class="events">
            <c:forEach var="m" items="${requestScope['listeMusiques']}">
                        <div class="event">
                            <div class="container">
                                <div class="event-content">
                                    <div class="image">
                                        <a href="#">
                                            <img src="images/gallery/thumbnails/2.jpg" alt="">
                                        </a>
                                    </div>

                                    <div class="title">
                                        <h3><a href="#">${m.titre}</a></h3>

                                        <div class="location">
                                            <i></i>
                                            <span>${m.artiste.nomArtiste}</span>
                                        </div>
                                        <div class="location">
                                            <i></i>
                                            <a href="ServletArtists?action=detailsMusique&id=${m.id}">Voir détails</a>
                                        </div>
                                    </div>

                                    <div class="button">
                                        <a>
                                            <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                                                <input type='hidden' value="0.99" name="amount" />
                                                <input name="currency_code" type="hidden" value="EUR" />
                                                <input name="shipping" type="hidden" value="0.00" />
                                                <input name="tax" type="hidden" value="0.00" />
                                                <input name="return" type="hidden" value="http://localhost:8080/TP2_Web/success.jsp" />
                                                <input name="cancel_return" type="hidden" value="http://localhost:8080/TP2_Web/cancelled.jsp" />
                                                <input name="notify_url" type="hidden" value="" />
                                                <input name="cmd" type="hidden" value="_xclick" />
                                                <input name="business" type="hidden" value="grinny_vendeur@mmp.com" />
                                                <input name="item_name" type="hidden" value="AbonnementWE" />
                                                <input name="no_note" type="hidden" value="1" />
                                                <input name="lc" type="hidden" value="FR" />
                                                <input name="bn" type="hidden" value="PP-BuyNowBF" />
                                                <input name="custom" type="hidden" value="grinny_acheteur@mmp.com" />
                                                <input alt="Effectuez vos paiements via PayPal : une solution rapide, gratuite et sécurisée" name="submit" src="https://www.paypal.com/fr_FR/FR/i/btn/btn_buynow_LG.gif" type="image" /><img src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" border="0" alt="" width="1" height="1" />
                                            </form>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
            </c:forEach>
        </div>
    </div>
</c:if>

<c:if test="${param['action'] == 'listeArtistes'}" >
    <div class="content">
        <div class="container-fluid no-horizontal-padding">
            <div class="articles albums">
                <div class="row">
                    <c:forEach var="a" items="${requestScope['listeArtistes']}">
                        <div class="col-md-3 article">
                            <a href="">
                                <div class="image">
                                    <div class="overlay">
                                        <h5>View Details</h5>
                                    </div>
                                    <img src="images/gallery/thumbnails/1.jpg" alt="">
                                </div>
                            </a>
                            <h3 class="title"><a href="">${a.nomArtiste}</a></h3>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${param['action'] == 'detailsMusique'}" >
    
    <c:forEach var="a" items="${requestScope['listeInstruments']}">
        ${a.nomInstrument}
    </c:forEach>
    
</c:if>

<!-- <script> //Script pour la recherche dynamique dans la liste
    jQuery.expr[':'].contains = function(a, i, m) {
        return jQuery(a).text().toUpperCase()
                .indexOf(m[3].toUpperCase()) >= 0;
    };
    $(document).ready(function() {
        $("#filter").focus();
        $("#filter").keyup(function() {
            str = $(this).val();
            if (str == '')
                $('div.event div.container div.event_content').css('display', '');
            $('div.event div.container div.event_content').css('display', 'none');
            $('div.event div.container div.event_content div.title a:contains("' + str + '")').parent().css('display', '');
            $('div.event div.container div.event_content div.title div.location span:contains("' + str + '")').parent().css('display', '');
        });
    });
</script> -->
