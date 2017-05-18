<%@include file="../jspf/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/webapp/bootstrap/css/global.css"/>
    <link rel="stylesheet" type="text/css" href="src/main/webapp/bootstrap/css/global.css"/>
    <link rel="stylesheet" type="text/css" href="src/main/webapp/bootstrap/css/global.css"/>
    <title>Add word</title>
</head>
<body>
<div class="container">
    <form action="/word" method="post">
        <div class="row offset-top">
            <div class="col-md-3 col-md-offset-1">
                <input class="form-control" type="text" name="value" placeholder="Word"/><br>
                <input class="form-control" type="text" name="transcription" placeholder="Transcription"/><br>
                <select class="form-control" name="language">
                    <c:forEach var="lang" items="${languages}">
                        <option name="${lang}">${lang}</option>
                    </c:forEach>
                </select><br>
                <input class="btn btn-success width-100" type="submit" value="Save">
            </div>
            <div class="col-md-3">
                <select id="partOfSpeech" class="form-control">
                    <c:forEach var="part" items="${partsOfSpeech}">
                        <option name="${part}">${part}</option>
                    </c:forEach>
                </select><br>
                <input id="definition" class="form-control" type="text" placeholder="definition"/><br>
                <input id="add-definition" type="button" class="btn btn-primary width-100" value="Add"><br>
            </div>
            <div class="col-md-4">
                <table id="definitionList" class="table table-striped">
                    <tr><th>Translation</th><th>Part of Speech</th><th></th></tr>
                </table>
            </div>
        </div>
    <%--<input class="form-control" type="text" name="value"/>--%>
    </form>
</div>
</body>
</html>
