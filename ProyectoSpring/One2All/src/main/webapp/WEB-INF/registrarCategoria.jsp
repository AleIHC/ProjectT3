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
                    <c:if test="${msgErrorCategoria != null}">
                        <c:out value="${msgErrorCategoria}"></c:out>
                    </c:if>

                    <c:if test="${nombreUsuario != null}">
                        <c:out value="Bienvenido ${nombreUsuario}, añade tus categorías"></c:out>
                        <br>
                        <hr>
                    </c:if>

                    <c:if test="${listaCategorias != 0}">
                        <a href="/marcador">Omitir</a>
                        <br>
                        <hr>
                    </c:if>

                    <form:form action="/categoria/registro" method="post" modelAttribute="categoria" autocomplete="off">
                        <form:label path="nombre">Crea una categoría de marcadores:</form:label>
                        <form:input path="nombre" />
                        <br>
                        <input type="submit" value="Añadir Categoría">
                    </form:form>
                </div>
            </body>

            </html>