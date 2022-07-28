import React from "react";
import logo2 from "../assets/img/logo2.png";

const NavComponent = () => {


    return(
    <nav className="navbar navbar-expand-lg">
    <div className="container-fluid">
        <img className="logo justify-content-start" src={logo2} alt=""/>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
        </button>
    <div className="collapse navbar-collapse justify-content-end" id="navbarTogglerDemo02">
        <form className="d-flex">
        <input className="form-control me-2" type="search" placeholder="Buscar" aria-label="Search"/>
        <button className="btn btn-outline-light" type="submit">Buscar</button>
        <button className="btn btn-outline-dark navbar-toggle collapsed" id="menu-toggle"><i className="bi bi-person-lines-fill"></i></button>
        <a className="navbar-brand" href="#menu-toggle"><span className="glyphicon glyphicon-list" aria-hidden="true"></span></a>
        </form>
    </div>
</div>
</nav>);
}

export default NavComponent;
