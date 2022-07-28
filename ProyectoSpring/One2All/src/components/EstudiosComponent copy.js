import React from 'react'
import bootstrapImagen from '../assets/img/bootstrap.png'
import javaImagen from '../assets/img/java.png'
import stackImagen from '../assets/img/stack.png'
import springImagen from '../assets/img/spring.svg'

const EstudiosComponent = () =>{

    const bootstrap = {
        categoria: 'Estudios',
        nombre : 'Bootstrap',
        descripcion : 'Documentacion',
        link : 'https://getbootstrap.com/docs/5.2/getting-started/introduction/',
        imagen : {bootstrapImagen}
    };

    const java = {
        categoria: 'Estudios',
        nombre : 'Java API',
        descripcion : 'Documentacion oficial',
        link : 'https://docs.oracle.com/en/java/javase/18/docs/api/index.html',
        imagen : {javaImagen}
    };

    const stack = {
        categoria: 'Estudios',
        nombre : 'StackOverFlow',
        descripcion : 'Para resolver dudas',
        link : 'https:www.StackOverFlow.com',
        imagen : {stackImagen}
    };

    const spring = {
        categoria: 'Estudios',
        nombre : 'Spring Framework',
        descripcion : 'Documentacion',
        link : 'https://spring.io/learn',
        imagen : {springImagen}
    };
    return(
        <div className="carousel-item" id="estudios">
        <h1 className="text-dark">{bootstrap.categoria}</h1>
        <div className="row" >
            <div className="col marker">
                <div className="card">
                    <div className="card-body" style="display: flex !important; flex-direction: row !important; 
                justify-content: space-between;">
                        <div style="display: flex; flex-direction:column;">
                            <h5 className="card-title me-5">{bootstrap.nombre}</h5>
                            <p className="card-text">{bootstrap.descripcion}</p>
                            <a href={bootstrap.link}
                                target="_blank" className="btn btn-primary">Abrir Pestaña</a>
                        </div>
                        <img src={bootstrap.imagen} width="100px"/>
                    </div>
                </div>
            </div>
            <div className="col marker">
                <div className="card">
                    <div className="card-body" style="display: flex !important; flex-direction: row !important; 
                    justify-content: space-between;">
                        <div style="display: flex; flex-direction:column;">
                            <h5 className="card-title me-5">{java.nombre}</h5>
                            <p className="card-text">{java.descripcion}</p>
                            <a href={java.link}
                                target="_blank" className="btn btn-primary">Abrir Pestaña</a>
                        </div>
                        <img src={java.imagen} width="100px"/>
                    </div>
                </div>
            </div>
        </div>

        <div className="row mt-3">
            <div className="col marker">
                <div className="card">
                    <div className="card-body" style="display: flex !important; flex-direction: row !important; 
                    justify-content: space-between;">
                        <div style="display: flex; flex-direction:column;">
                            <h5 className="card-title me-5">{spring.nombre}</h5>
                            <p className="card-text">{spring.descripcion}</p>
                            <a href={spring.link} target="_blank"
                                className="btn btn-primary">Abrir Pestaña</a>
                        </div>
                        <img src={spring.imagen} width="100px"/>
                    </div>
                </div>
            </div>
            <div className="col marker">
                <div className="card">
                    <div className="card-body" style="display: flex !important; flex-direction: row !important; 
                    justify-content: space-between;">
                        <div style="display: flex; flex-direction:column;">
                            <h5 className="card-title me-5">{stack.nombre}</h5>
                            <p className="card-text">{stack.descripcion}</p>
                            <a href={stack.link} target="_blank"
                                className="btn btn-primary">Abrir Pestaña</a>
                        </div>
                        <img src={stack.imagen} width="100px"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    );
}

export default EstudiosComponent;