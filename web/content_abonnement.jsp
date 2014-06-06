<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<div id="contact-page" class="container">
    <div class="bg">
        <div class="row">    		
            <div class="col-sm-12">
                <h3>Abonnez-vous !</h3>
            </div>
        </div>
    </div>
</div>        
        

<div class="content no-horizontal-padding">
    <div class="events">
        <div class="content no-horizontal-padding">
            <div class="events">
                <div class="event">
                    <div class="container">
                        <div class="event-content">
                            <div class="title">
                                <h3><a href="#">Abonnement week-end - 2€</a></h3>
                                <div class="location">
                                    <i></i>
                                    <span>Abonnez-vous juste pour vos week-ends et profitez-en pendant vos soirées !</span>
                                </div>
                            </div>
                            <div class="button">
                                <a href="ServletUsers?action=abonnementWE" class="">
                                    <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                                        <input type='hidden' value="2" name="amount" />
                                        <input name="currency_code" type="hidden" value="EUR" />
                                        <input name="shipping" type="hidden" value="0.00" />
                                        <input name="tax" type="hidden" value="0.00" />
                                        <input name="return" type="hidden" value="http://localhost:8080/TP2_Web/ServletUsers?action=abonnementWE" />
                                        <input name="cancel_return" type="hidden" value="http://localhost:8080/TP2_Web/cancelled.jsp" />
                                        <input name="notify_url" type="hidden" value="" />
                                        <input name="cmd" type="hidden" value="_xclick" />
                                        <input name="business" type="hidden" value="grinny_vendeur@mmp.com" />
                                        <input name="item_name" type="hidden" value="AbonnementWE" />
                                        <input name="no_note" type="hidden" value="1" />
                                        <input name="lc" type="hidden" value="FR" />
                                        <input name="bn" type="hidden" value="PP-BuyNowBF" />
                                        <input name="custom" type="hidden" value="grinny_acheteur@mmp.com" />
                                        <input alt="Effectuez vos paiements via PayPal : une solution rapide, gratuite et sécurisée" name="submit" src="https://www.paypal.com/fr_FR/FR/i/btn/btn_buynow_LG.gif" type="image" />
                                        <img src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" border="0" alt="" width="1" height="1" />
                                    </form>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="container">
                        <div class="event-content">
                            <div class="title">
                                <h3><a href="#">Abonnement semaine - 7€</a></h3>
                                <div class="location">
                                    <i></i>
                                    <span>Abonnement de 7 jours</span>
                                </div>
                            </div>
                            <div class="button">
                                <a href="ServletUsers?action=abonnementSemaine" class="">
                                    <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                                        <input type='hidden' value="7" name="amount" />
                                        <input name="currency_code" type="hidden" value="EUR" />
                                        <input name="shipping" type="hidden" value="0.00" />
                                        <input name="tax" type="hidden" value="0.00" />
                                        <input name="return" type="hidden" value="http://localhost:8080/TP2_Web/success.jsp" />
                                        <input name="cancel_return" type="hidden" value="http://localhost:8080/TP2_Web/cancelled.jsp" />
                                        <input name="notify_url" type="hidden" value="" />
                                        <input name="cmd" type="hidden" value="_xclick" />
                                        <input name="business" type="hidden" value="grinny_vendeur@mmp.com" />
                                        <input name="item_name" type="hidden" value="AbonnementSemaine" />
                                        <input name="no_note" type="hidden" value="1" />
                                        <input name="lc" type="hidden" value="FR" />
                                        <input name="bn" type="hidden" value="PP-BuyNowBF" />
                                        <input name="custom" type="hidden" value="grinny_acheteur@mmp.com" />
                                        <input alt="Effectuez vos paiements via PayPal : une solution rapide, gratuite et sécurisée" name="submit" src="https://www.paypal.com/fr_FR/FR/i/btn/btn_buynow_LG.gif" type="image" />
                                        <img src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" border="0" alt="" width="1" height="1" />
                                    </form>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="event">
                    <div class="container">
                        <div class="event-content">
                            <div class="title">
                                <h3><a href="#">Abonnement mois - 15€</a></h3>
                                <div class="location">
                                    <i></i>
                                    <span>Abonnez-vous pendant 30 jours !</span>
                                </div>
                            </div>
                            <div class="button">
                               <a href="" class="">
                                    <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                                        <input type='hidden' value="15" name="amount" />
                                        <input name="currency_code" type="hidden" value="EUR" />
                                        <input name="shipping" type="hidden" value="0.00" />
                                        <input name="tax" type="hidden" value="0.00" />
                                        <input name="return" type="hidden" value="http://localhost:8080/TP2_Web/ServletUsers?action=abonnementMois" />
                                        <input name="cancel_return" type="hidden" value="http://localhost:8080/TP2_Web/cancelled.jsp" />
                                        <input name="notify_url" type="hidden" value="" />
                                        <input name="cmd" type="hidden" value="_xclick" />
                                        <input name="business" type="hidden" value="grinny_vendeur@mmp.com" />
                                        <input name="item_name" type="hidden" value="AbonnementMois" />
                                        <input name="no_note" type="hidden" value="1" />
                                        <input name="lc" type="hidden" value="FR" />
                                        <input name="bn" type="hidden" value="PP-BuyNowBF" />
                                        <input name="custom" type="hidden" value="grinny_acheteur@mmp.com" />
                                        <input alt="Effectuez vos paiements via PayPal : une solution rapide, gratuite et sécurisée" name="submit" src="https://www.paypal.com/fr_FR/FR/i/btn/btn_buynow_LG.gif" type="image" />
                                        <img src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" border="0" alt="" width="1" height="1" />
                                    </form>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="event">
                    <div class="container">
                        <div class="event-content">
                            <div class="title">
                                <h3><a href="#">Abonnement 6 mois - 80€</a></h3>
                                <div class="location">
                                    <i></i>
                                    <span>Abonnez-vous pendant 6 mois et profitez en illimité !</span>
                                </div>
                            </div>
                            <div class="button">
                                <a href="ServletUsers?action=abonnementSemestre" class="">
                                    <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                                        <input type='hidden' value="80" name="amount" />
                                        <input name="currency_code" type="hidden" value="EUR" />
                                        <input name="shipping" type="hidden" value="0.00" />
                                        <input name="tax" type="hidden" value="0.00" />
                                        <input name="return" type="hidden" value="http://localhost:8080/TP2_Web/success.jsp" />
                                        <input name="cancel_return" type="hidden" value="http://localhost:8080/TP2_Web/cancelled.jsp" />
                                        <input name="notify_url" type="hidden" value="" />
                                        <input name="cmd" type="hidden" value="_xclick" />
                                        <input name="business" type="hidden" value="grinny_vendeur@mmp.com" />
                                        <input name="item_name" type="hidden" value="AbonnementSemestre" />
                                        <input name="no_note" type="hidden" value="1" />
                                        <input name="lc" type="hidden" value="FR" />
                                        <input name="bn" type="hidden" value="PP-BuyNowBF" />
                                        <input name="custom" type="hidden" value="grinny_acheteur@mmp.com" />
                                        <input alt="Effectuez vos paiements via PayPal : une solution rapide, gratuite et sécurisée" name="submit" src="https://www.paypal.com/fr_FR/FR/i/btn/btn_buynow_LG.gif" type="image" />
                                        <img src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" border="0" alt="" width="1" height="1" />
                                    </form>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="event">
                    <div class="container">
                        <div class="event-content">
                            <div class="title">
                                <h3><a href="#">Abonnement année - 150€</a></h3>
                                <div class="location">
                                    <i></i>
                                    <span>Abonnez-vous à l'année pour plus de tranquillité !</span>
                                </div>
                            </div>
                            <div class="button">
                                <a href="ServletUsers?action=abonnementAnnee" class="">
                                    <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                                        <input type='hidden' value="150" name="amount" />
                                        <input name="currency_code" type="hidden" value="EUR" />
                                        <input name="shipping" type="hidden" value="0.00" />
                                        <input name="tax" type="hidden" value="0.00" />
                                        <input name="return" type="hidden" value="http://localhost:8080/TP2_Web/success.jsp" />
                                        <input name="cancel_return" type="hidden" value="http://localhost:8080/TP2_Web/cancelled.jsp" />
                                        <input name="notify_url" type="hidden" value="" />
                                        <input name="cmd" type="hidden" value="_xclick" />
                                        <input name="business" type="hidden" value="grinny_vendeur@mmp.com" />
                                        <input name="item_name" type="hidden" value="AbonnementAnnee" />
                                        <input name="no_note" type="hidden" value="1" />
                                        <input name="lc" type="hidden" value="FR" />
                                        <input name="bn" type="hidden" value="PP-BuyNowBF" />
                                        <input name="custom" type="hidden" value="grinny_acheteur@mmp.com" />
                                        <input alt="Effectuez vos paiements via PayPal : une solution rapide, gratuite et sécurisée" name="submit" src="https://www.paypal.com/fr_FR/FR/i/btn/btn_buynow_LG.gif" type="image" />
                                        <img src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" border="0" alt="" width="1" height="1" />
                                    </form>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>