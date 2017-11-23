<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<c:import varReader="xslFile" url="test.xsl">
<c:import varReader="xmlFile" url="monDocument1.xml">
	<x:transform doc="${xmlFile}" xslt="${xslFile}"></x:transform>
</c:import>
</c:import>