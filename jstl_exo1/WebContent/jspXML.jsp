<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>

<c:import url="monDocument.xml" varReader="monReader">
	<%-- Parse le contenu du fichier XML monDocument.xml dans une variable nommée 'doc' --%>
	<x:parse var="doc" doc="${monReader}"></x:parse>

	<x:out select="$doc/news/article/auteur"></x:out>

	<br>

	<x:out select="count($doc/news/article/auteur)"></x:out>

	<br>

	<%-- Enregistre le résultat de l'expression XPath, spécifiée dans l'attribut select, 
	dans une variable de session nommée 'auteur' --%>
	<x:set var="auteur" scope="session" select="$doc//auteur"></x:set>

	<%-- Affiche le contenu de la variable nommée 'auteur' enregistrée en session --%>
	<x:out select="$sessionScope:auteur"></x:out>

	<br>

	<%-- Afficher le titre de la news postée par 'Paul' --%>
	<x:if select="$doc/news/article[auteur='Paul']">
   Paul a déjà posté une news dont voici le titre :
   <x:out select="$doc/news/article[auteur='Paul']/titre"></x:out>
	</x:if>

	<br>

	<%-- Affiche le titre de la news postée par 'Nicolas' si elle existe, et un simple message sinon --%>
	<x:choose>
		<x:when select="$doc/news/article[auteur='Nicolas']">
      Nicolas a déjà posté une news dont voici le titre :
      <x:out select="$doc/news/article[auteur='Nicolas']/titre"></x:out>
		</x:when>
		<x:otherwise>
      Nicolas n'a pas posté de news.
   </x:otherwise>
	</x:choose>

	<br>

	<!-- Affiche les auteurs et titres de tous les articles -->
	<p>
		<x:forEach var="element" select="$doc/news/article">
			<strong><x:out select="$element/auteur"></x:out></strong> :
   <x:out select="$element/titre"></x:out>
   => <x:out select="$element/contenu"></x:out>.<br />
		</x:forEach>
	</p>
</c:import>


