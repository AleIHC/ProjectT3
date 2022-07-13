<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

            <!DOCTYPE html>
            <html>

            <head>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
                <link href="css/styles.css" rel="stylesheet">
                <meta charset="ISO-8859-1">
                <title>Despliegue de Marcadores</title>
            </head>

            <body>


                <c:if test="${msgError!=null }">
                    <c:out value="${msgError }"></c:out>
                </c:if>

                <div class="container">
                    <!--Formulario de busqueda-->
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="card">
                                            <div class="card-body" style="display: flex !important; flex-direction: row !important; 
                                            justify-content: space-between;">
                                                <div style="display: flex; flex-direction:column;">
                                                    <h5 class="card-title me-5">Linkedin</h5>
                                                    <p class="card-text">Perfil de LinkedIn</p>
                                                    <a href="https://www.linkedin.com" class="btn btn-primary"
                                                        target="_blank">Abrir Pestaña</a>
                                                </div>
                                                <img src="img/linkedin.png" width="100px">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="card">
                                            <div class="card-body" style="display: flex !important; flex-direction: row !important; 
                                            justify-content: space-between;">
                                                <div style="display: flex; flex-direction:column;">
                                                    <h5 class="card-title me-5">Slack</h5>
                                                    <p class="card-text">Slack Generation</p>
                                                    <a href="https://www.slack.com" class="btn btn-primary"
                                                        target="_blank">Abrir Pestaña</a>
                                                </div>
                                                <img src="img/slack.png" width="100px">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                    <form action="/marcador/buscar" method="post">
                        <label for="categoría">Categoria</label>
                        <input type="number" id="categoria" name="id" placeholder="Filtra por categoría">
                        <input type="submit" value="Filtrar">
                    </form>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Url</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">Icono</th>
                                <th scope="col">Categoría</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="marcador" items="${marcadoresCapturados}">
                                <tr>
                                    <th scope="row">${marcador.id}</th>
                                    <td>${marcador.nombreMarcador}</td>
                                    <td><a href="${marcador.urlMarcador}">Link</a></td>
                                    <td>${marcador.descripcionMarcador}</td>
                                    <td><img src="http://www.google.com/s2/favicons?domain=${marcador.urlMarcador}"></td>
                                    <td>${marcador.categoria.nombre}</td>
                                    <td><a class="btn btn-warning" href="/marcador/editar/${marcador.id}" role="button">Editar</a>
                                    </td>
                                    <td><a class="btn btn-danger" href="/marcador/eliminar/${marcador.id}" role="button">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

            </body>

            </html>