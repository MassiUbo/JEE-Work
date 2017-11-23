<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accès public</title>
    </head>
    <body>
        
        <c:choose>
			
			<c:when test="${!empty sessionScope.sessionUtilisateur}">
			<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
			<p> Vous avez acces aux pages restreintes</p>
			<p><a href="restreint/accesRestreint.jsp"> page 1 </a> </p>
			<p><a href="restreint/accesRestreint.jsp"> page 2 </a></p>
			<p><a href="restreint/accesRestreint.jsp"> page 3 </a></p>
			
			</c:when>
			
			<c:otherwise>
			 <p>Vous n'avez pas accès à l'espace restreint : vous devez vous <a href="connexion">connecter</a> d'abord. </p>
			</c:otherwise>
		</c:choose>
    </body>
</html>