<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/webapp/bootstrap/css/global.css"/>
    <title>$Title$</title>
    <%@ include file="../jspf/header.jspf"%>
</head>
<body>
    <div class="container margin-top150">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <input id="search" type="text" class="form-control search-field" placeholder="What do you want to translate"/>
            </div>
        </div>
        <div id="data-block" class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="word" class="row"></div>
                <div id="transcription" class="row"></div>
                <div id="data">
                </div>
            </div>
        </div>
    </div>
</body>
</html>
