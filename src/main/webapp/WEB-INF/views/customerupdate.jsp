<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>
<html>
<body>

<h3>Customer-Update-Form</h3>
<hr>
	<fr:form action="savechanges" modelAttribute="customer">
	<pre>
			Code	<fr:input path="code"/>
			Name	<fr:input path="name"/>
			Adrs	<fr:input path="address"/>
			Mob.	<fr:input path="mobile"/>
				<input type="submit" value="SaveChanges"/>
	</pre>				
	</fr:form>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>