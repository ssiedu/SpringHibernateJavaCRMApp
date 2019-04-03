<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Customer Update Form</h3>
	<form action="savechanges">
		<pre>
			Code	<input type="text" name="code" value="${customer.code}"/>
			Name	<input type="text" name="name" value="${customer.name}"/>
			Adrs	<input type="text" name="address" value="${customer.address}"/>
			Mob.	<input type="text" name="mobile" value="${customer.mobile}"/>
				<input type="submit" value="SaveChanges" />
		</pre>
	</form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>