<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

            <html>

            <head>
                <title>Registro</title>
            </head>

            <body>
                <div>
                    <c:if test="${msgError != null}">
                        <c:out value="${msgError}"></c:out>
                    </c:if>
                    <form:form action="/registro/usuario" method="post" modelAttribute="usuario" autocomplete="off">
                        <form:label path="nombreUsuario">Nombre de usuario:</form:label>
                        <form:input path="nombreUsuario" />
                        <br>
                        <form:label path="password">Password:</form:label>
                        <form:input type="password" path="password" />
                        <br>
                        <form:label path="correo">Correo :</form:label>
                        <form:input type="text" path="correo" />
                        <br>
                        <input type="submit" value="Registrar">
                    </form:form>
                </div>
            </body>

            </html>