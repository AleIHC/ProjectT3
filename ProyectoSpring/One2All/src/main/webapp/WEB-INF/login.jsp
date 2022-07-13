<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

            <html>

            <head>
                <title>Registro</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            </head>

            <body>
                <div>
                    <c:if test="${msgError != null}">
                        <c:out value="${msgError}"></c:out>
                    </c:if>
                    <form action="/registro/usuario" method="post" modelAttribute="usuario" autocomplete="off">

                        <label for="correo" class="form-label">Correo:</label>
                        <input type="text" class="form-control" name="correo"/>
                        <br>
                        <label for="password" class="form-label">Password:</label>
                        <input type="password" class="form-control" name="password"/>
                        <br>
                        <input type="submit" class="btn btn-primary mb-3" value="Ingresar">
                    </form>
                </div>
            </body>

            </html>