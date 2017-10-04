<c:if test="${ sessionScope.utilisateur != null }" var="variable">
    <c:set var="deconnexion" scope="page"><a href="./accesAnimateur?deconnexion=true">Deconnexion</a></c:set>
    <c:set var="animateur" scope="page"><a href="./accesAnimateur">Page animateur</a></c:set>
    <c:set var="stagiaire" scope="page"><a href="./accesStagiaire">Page stagiaire</a></c:set>
</c:if>

<fieldset id="menu">
	<a href="./">Accueil</a><br>
	<a href="./listeDesFormations">Liste des formations</a><br>
	<c:out value="${ animateur }" escapeXml="false"><a href="./accesAnimateur">Accès animateur</a></c:out><br>
	<c:out value="${ stagiaire }" escapeXml="false"><a href="./accesStagiaire">Accès stagiaires</a></c:out><br>
	<c:out value="${ deconnexion }" escapeXml="false"/><br>
	
	<form method="get" action="http://www.google.fr/search?hl=fr&">
		<input type="search" name="q"></input>
		<input type="submit" name="rechercher" value="Rechercher"/>
	</form>
</fieldset>