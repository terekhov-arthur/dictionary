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
            <div><span style="color:indianred; font-size:45pt; font-weight: bold">Dance Sport Dictionary</span></div>
            <div class="col-md-7">
                <br><br>
                <input id="search" type="text" class="form-control search-field"/>
            </div>
        </div>
        <div id="data-block" class="row">
            <div class="col-md-8 col-md-offset-1">
                <div id="word" class="row"></div>
                <div id="transcription" class="row"></div>
                <div id="data"></div>
                <div id="definition" style="font-size: 16pt;width: 450px;color: #258a9c;background-color: rgba(0, 0, 0, 0.88);border-radius: 10px;"></div>
                <br>
                <div id="video"></div>
            </div>
        </div>
    </div>
</body>
</html>
