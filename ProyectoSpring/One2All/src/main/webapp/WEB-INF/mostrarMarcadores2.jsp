<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html>

            <head>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
                    rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
                    crossorigin="anonymous">
                <link rel="stylesheet" href="css/styles.css">
                <meta charset="ISO-8859-1">
                <title>Despliegue de Marcadores</title>
            </head>
            <style>
                /*
                .carousel-indicators [data-bs-target] {
                    box-sizing: content-box;
                    flex: 0 1 auto;
                    width: 69px !important;
                    height: 27px;
                    padding: 0;
                    margin-right: 3px;
                    margin-left: 3px;
                    cursor: pointer;
                    background-color: #fff;
                    background-clip: padding-box;
                    border: 0;
                    border-top: 10px solid transparent;
                    border-bottom: 10px solid transparent;
                    opacity: 0.7;
                    transition: opacity .6s ease;
                    text-indent: 0px !important;
                }

                .carousel-indicators {
                    position: static;
                }
                */
            </style>

            <body>


                <c:if test="${msgError!=null }">
                    <c:out value="${msgError }"></c:out>
                </c:if>

                <div class="container">
                    <!--Formulario de busqueda
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
                    -->
                    <div class="row">
                        <div class="col">
                            <!-- Carrousel-->
                            <!-- Carousel wrapper -->
                            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <c:forEach var="categoria" items="${categoriasCapturadas}">
                                        <div class="carousel-item">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <div class="card">
                                                        <div class="card-body">
                                                            <h5 class="card-title">Special title treatment</h5>
                                                            <p class="card-text">With supporting text below as a natural
                                                                lead-in to additional content.</p>
                                                            <a href="#" class="btn btn-primary">Go somewhere</a>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>

                                <div class="row mt-3 justify-content-center">

                                    <div class="carousel-indicators">
                                        <!-- Carousel wrapper -->
                                        <ul class="nav nav-pills nav-fill gap-2 p-1 small bg-white border rounded-5 shadow-sm"
                                            id="pillNav2" role="tablist">
                                            <c:forEach var="categoria" items="${categoriasCapturadas}">
                                                <li class="nav-item" role="presentation">
                                                    <button class="nav-link rounded-5 active"
                                                        data-bs-target="#carouselExampleIndicators" id="home-tab2"
                                                        data-bs-slide-to="0" data-bs-toggle="tab" type="button"
                                                        role="tab" aria-selected="false" tabindex="-1"
                                                        aria-label="Slide 1">Home</button>
                                                </li>
                                            </c:forEach>
                                        </ul>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
                    crossorigin="anonymous"></script>

            </body>

            </html>