drop database if exists one2all;
create database one2all;

use one2all;

CREATE TABLE usuarios (
    id int auto_increment PRIMARY KEY,
    nombreUsuario varchar(20),
    password varchar(20),
    correo varchar(30),
    datosPersonales_id int, 
    tablero_id int
);

CREATE TABLE datosPersonales (
    id int auto_increment PRIMARY KEY,
    nombre varchar(20),
    apellido varchar(20),
    edad varchar(30)
);

CREATE TABLE usuarios_categorias (
    id int auto_increment PRIMARY KEY,
    usuario_id int,
    categoria_id int 
);

Create table Tablero(
    id  int AUTO_INCREMENT PRIMARY KEY,
    color Varchar(30),
    fuentes Varchar(30)
);

Create table Categorias(
    id int PRIMARY KEY AUTO_INCREMENT,
    nombre Varchar(30) Not Null
);

Create table Marcadores(
    id int PRIMARY KEY AUTO_INCREMENT,
    nombre Varchar(30) Not Null,
    url Varchar(30) Not Null,
    descripcion Varchar(30) Not Null,
    prioridad Varchar(30) Not Null,
    categorias_id int
);

ALTER TABLE Usuarios
ADD CONSTRAINT FK_datosPersonales_id -- asignar nombre a la relacion
FOREIGN KEY (datosPersonales_id) REFERENCES DatosPersonales(id),
ADD CONSTRAINT FK_tablero_id -- asignar nombre a la relacion
FOREIGN KEY (tablero_id) REFERENCES Tablero(id)
;

ALTER TABLE Marcadores
ADD CONSTRAINT FK_categorias_id -- asignar nombre a la relacion
FOREIGN KEY (categorias_id) REFERENCES Categorias(id);

ALTER TABLE Usuarios_Categorias
ADD CONSTRAINT FK_usuarios_id -- asignar nombre a la relacion
FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
ADD CONSTRAINT FK_categorias_usuarios_id -- asignar nombre a la relacion
FOREIGN KEY (categoria_id) REFERENCES Categorias(id);