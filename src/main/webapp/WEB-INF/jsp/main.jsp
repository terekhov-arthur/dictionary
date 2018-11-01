<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>$Title$</title>
    <%@ include file="../jspf/header.jspf"%>
</head>
<body>
    <div class="container margin-top150">
        <div class="row">
            <div class="col-md-6">
                <input id="search" type="text" class="form-control search-field" placeholder="What do you want to translate"/>
            </div>
        </div>
        <div id="data-block" class="row">
            <div class="col-md-8 col-md-offset-1">
                <div id="word" class="row"></div>
                <div id="transcription" class="row"></div>
                <div id="data"></div>
                <div id="definition"></div>
                <div id="video"></div>
            </div>
        </div>
    </div>
</body>
</html>
