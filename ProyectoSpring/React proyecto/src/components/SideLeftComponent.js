import React from "react";
import {Link} from 'react-router-dom'
import marcadores from "./MarcadoresComponent";
import { useState } from "react";

const SideLeftComponent = () =>{

  /*  //declarar variables
    const[category,setCategory] = useState();
    const[listaMarcadores,setLista] = useState();


    //Funcion 
    const SeleccionCategoria = (e) =>{
        const seleccion = marcadores.find(
                (iterador) => iterador.categoria === e.target.textContent);
            setCategory(seleccion.categoria);    
            setLista(seleccion.listaMarcadores);
            console.log(category);
            console.log(listaMarcadores);
        };
*/
    return(

        <div className="left">
        <div  className="item mt-3">
        <p><i className="bi bi-grid-fill"></i>Categorias</p>
        
        </div>
        <div className="item active" 
        data-bs-target="#carouselExampleIndicators" id="home-tab2" data-bs-slide-to="0"
        data-bs-toggle="tab" type="button" role="tab" aria-selected="false"
        tabindex="-1" aria-label="Slide 1"><i className="bi bi-briefcase-fill"></i>
        Trabajo</div>
        <div className="item" data-bs-target="#carouselExampleIndicators"
        id="profile-tab2" data-bs-slide-to="1" data-bs-toggle="tab" type="button"
        role="tab" aria-selected="true" aria-label="Slide 2"><i className="bi bi-book-fill"></i>
        Estudios</div>
        <div className="item" data-bs-target="#carouselExampleIndicators"
        id="contact-tab2" data-bs-slide-to="2" data-bs-toggle="tab" type="button"
        role="tab" aria-selected="false" tabindex="-1"
        aria-label="Slide 3"><i className="bi bi-joystick"></i>
        Ocio</div>
        <div className="item">
        <i className="bi bi-plus-square-fill"></i>
        Agregar categoría</div>
    </div>  
    )
};

export default SideLeftComponent;