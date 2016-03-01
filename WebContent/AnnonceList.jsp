<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        
        <title>Master Annonce</title>
    </head>
    <body>
        <ol class="breadcrumb">
            <li><a href="AnonceAdd">MasterAnnonce</a></li>
            <li><a href="AnonceAdd">AnnonceAdd</a></li>
            <li class="active">AnnonceList</li>
			<li><a href="AnnonceUpdate">AnnonceUpdate</a></li>
        </ol>
        
        <h1>Annonce List (${fn:length(annonceList)})</h1>
        
        <c:if test="${requestScope.message != null}">
            <div class="alert alert-warning" role="alert">
                ${requestScope.message}
            </div>
        </c:if>
       
        <c:if test="${fn:length(annonceList) eq 0}">
            <div class="alert alert-warning" role="alert">
                No item.
                <a href="AnonceAdd">Create one.</a>
            </div>
        </c:if>
        
        <div class="list-group">
            <c:forEach var="item" items="${annonceList}">
                <a href="./AnnonceRead?id=${item.id}" class="list-group-item" title="${item.description}">
                    ${item.title}
                    
                    <div class="pull-right">
                        <c:out value="id = ${item.id}" />
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    </div>
                </a>
            </c:forEach>
        </div>
    </body>
</html>