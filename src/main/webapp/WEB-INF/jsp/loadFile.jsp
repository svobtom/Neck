<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/styles.css" rel="stylesheet" type="text/css"/>
<title> Neck </title>
</head>
<body>
<div id="center">
<h1> Neck </h1>
<br>
<h4> You can upload multiple files to process here.<br> But please, upload files of the same type.<br> Supported are .pcap .log and .csv </h4>
<form action="/Neck/loadFile" method="POST" enctype="multipart/form-data"> 
<br>
<table class="table1">
<tr>
<td><a>(store on server <input type="checkbox" name="store" value="store">)</a>
<input type="file" name="filesToUpload" multiple="multiple"></td>
<td><input type="submit" name="chooseFile" value="Choose stored file"></td>
</tr>
</table>
<br>
<br>
<div class="gray">
		<c:if test="${not empty fileList}">
		<h4> Previously updated files: </h4>
		<ul class="params">	
			<c:forEach var="item" items="${fileList}">
				<li> <input type="checkbox" name="checked" value="${item}"> ${item} </li>
				<input type="hidden" name="files" value="${item}">
			</c:forEach>
		</ul>
		</c:if>
		</div>
		<br>
<input class="btn" name="continue" type="submit" value="Next">
<br>
<br>
<div class="errorMessage">${message}</div> 
</form>
</div>
</body>
</html>
