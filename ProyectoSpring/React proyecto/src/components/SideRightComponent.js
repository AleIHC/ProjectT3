import React from "react";
import avatar from "../assets/img/avatar.png";

const SideRightComponent = () =>{

    return(
    <div id="sidebar-wrapper">
        <ul className="sidebar-nav">
            <li className="sidebar-brand">
                <img className=" avatarimg"src={avatar}/>
            </li>
            <hr/>
            <li>
                <a href="#" className="navbar-brand">Mi nombre</a>
            </li>
            <li>
                <font color="#337AB7">Configuraciones</font>
            </li>
            <li>
                <a href="#"> Colores</a>
            </li>
            <li>
                <a href="#"> Tamaño</a>
            </li>
            <li>
                <div className="form-check form-switch">
                    <input className="form-check-input" type="checkbox" id="lightSwitch" width="5px"/>
                </div>
            </li>
        </ul>
    </div>
    )
};

export default SideRightComponent;