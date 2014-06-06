<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!--Recherche : <input id="filter" type="text" value="" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;"/> -->

<c:if test="${param['action'] == 'listeMusiques'}" >
    <div id="album">
        <div class="container">
            <div class="album-inner">               
                <div class="row">                    
                    <div class="col-sm-12 col-md-8">
                        <div class="bg">
                            <h2 class="heading">Musiques</h2>
                            <div class="row">
                                <c:forEach var="m" items="${requestScope['listeMusiques']}">
                                    <div class="col-sm-4">
                                        <div class="single-album">
                                            <img src="images/album/album1.jpg" alt="">
                                            <div class="album-heading">
                                               <h3><a href="#">${m.titre}</a></h3>
                                                
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>                          
                </div>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${param['action'] == 'listeArtistes'}" >
    <div id="album">
        <div class="container">
            <div class="album-inner">               
                <div class="row">                    
                    <div class="col-sm-12 col-md-8">
                        <div class="bg">
                            <h2 class="heading">Artistes</h2>
                            <div class="row">
                                <c:forEach var="m" items="${requestScope['listeArtistes']}">
                                    <div class="col-sm-4">
                                        <div class="single-album">
                                            <img src="images/album/album1.jpg" alt="">
                                            <div class="album-heading">
                                               <h3 class="title"><a href="">${a.nom}</a></h3>                                     
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>                          
                </div>
            </div>
        </div>
    </div>
</c:if>
