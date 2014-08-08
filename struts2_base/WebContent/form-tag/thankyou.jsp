<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Update Successful</title>
</head>
<body>

<h1>Updated Information</h1>


<p>Your information: <s:property value="personBean" /> </p>

<p><a href="<s:url action='formtag_index' />" >Return to home page</a>.</p>
<table style="margin-left:15px;" border="1px">
    <s:iterator value="personBean.carModels">
        <tr><td><s:property /></td></tr>
    </s:iterator>
</table>
<hr />
<table style="margin-left:15px">
    <s:iterator value="states" >
        <tr><td><s:property value="stateAbbr" /></td> <td><s:property value="stateName" /></td></tr>
    </s:iterator>
</table>
</body>
</html>