<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <li class="active">AnnonceAdd</li>
            <li><a href="AnnonceList">AnnonceList</a></li>
            <li><a href="#">AnnonceUpdate</a></li>
            
        </ol>
        
        <h1>Annonce Add</h1>
        
        <c:if test="${requestScope.message != null}">
            <div class="alert alert-warning" role="alert">
                ${requestScope.message}
            </div>
        </c:if>
        
        <form role="form" method="post" action="AnonceAdd" class="well">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" name="title" id="title" placeholder="Enter title" value="${annonce.title}">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" class="form-control" name="description" id="description" placeholder="Description" value="${annonce.description}">
            </div>
            <div class="form-group">
                <label for="adress">Adress</label>
                <input type="text" class="form-control" name="adress" id="adress" placeholder="Adress" value="${annonce.adress}">
            </div>
            <div class="form-group">
                <label for="mail">Mail</label>
                <input type="text" class="form-control" name="mail" id="mail" placeholder="Mail" value="${annonce.mail}">
            </div>
            
            <button type="submit" class="btn btn-default">SAVE</button>
        </form>
    </body>
</html>