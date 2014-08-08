<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>

<body>
<h1>Welcome to Struts2!</h1>
<p><a href="<s:url action='hello' />">Hello World</a></p>

<s:url action="hello" var="helloLink">
  <s:param name="userName">Bruce Phillips</s:param>
</s:url>
 
<p><a href="${helloLink}">Hello Bruce Phillips</a></p>

<p>Get your own personal hello by filling out and submitting this form.</p>
 
<s:form action="hello">
   <s:textfield name="userName" label="Your name" />
   <s:submit value="Submit" />
</s:form>

<p><a href="register.jsp">Please register</a> for our prize drawing.</p>

<s:url action="registerInput" var="registerInputLink" />
<p><a href="${registerInputLink}">Please register</a> for our prize drawing.(by action)</p>

<h3>use Chinese</h3>
<s:url action="registerInput" var="registerInputLinkES">
    <s:param name="request_locale">es</s:param>
</s:url>
<p><a href="${registerInputLinkES}">请注册</a> 可参加抽奖</p>

<hr />
<s:text name="contact" />

<hr />
<a href="<s:url action="index" namespace="config-browser" />">Launch the configuration browser</a>

</body>
</html>
