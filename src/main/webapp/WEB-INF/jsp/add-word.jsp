<%@include file="../jspf/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add word</title>
</head>
<body>
<div class="add-word-form">
    <form action="/word" method="post">
        <input class="btn btn-success" type="submit" value="Save">

        <input class="form-control" type="text" name="value" placeholder="Word"/><br>
        <input class="form-control" type="text" name="transcription" placeholder="Transcription"/><br>
        <select class="form-control" name="language">
            <c:forEach var="lang" items="${languages}">
                <option name="${lang}">${lang}</option>
            </c:forEach>
        </select><br>

        <select id="partOfSpeech" class="form-control">
            <c:forEach var="part" items="${partsOfSpeech}">
                <option name="${part}">${part}</option>
            </c:forEach>
        </select><br>
        <input id="definition" class="form-control" type="text" placeholder="definition"/><br>
        <input id="add-definition" type="button" value="Add"><br>

        <div id="definitionList">

        </div>
        <%--<input class="form-control" type="text" name="value"/>--%>
    </form>
</div>
</body>
</html>
