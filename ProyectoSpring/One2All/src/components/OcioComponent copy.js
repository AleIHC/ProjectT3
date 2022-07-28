import React from 'react'
import netflixImagen from '../assets/img/netflix.png'
import facebookImagen from '../assets/img/facebook.png'
import redditImagen from '../assets/img/reddit.png'
import crunchyImagen from '../assets/img/crunchyroll.png'

const OcioComponent = () =>{

    const netflix = {
        categoria: 'Ocio',
        nombre : 'Netflix',
        descripcion : 'StrangerThings',
        link : 'https:www.Netflix.com',
        imagen : {netflixImagen}
    };

    const facebook = {
        categoria: 'Ocio',
        nombre : 'Facebook',
        descripcion : 'Red Social',
        link : 'https:www.Facebook.com',
        imagen : {facebookImagen}
    };

    const reddit = {
        categoria: 'Ocio',
        nombre : 'Reddit',
        descripcion : 'Memes',
        link : 'https:www.reddit.com',
        imagen : {redditImagen}
    };

    const crunchy = {
        categoria: 'Ocio',
        nombre : 'Crunchyroll',
        descripcion : 'Anime',
        link : 'https://www.Crunchyroll.com',
        imagen : {crunchyImagen}
    };

    return(
        <div className="carousel-item" id="ocio">
<div className="colord">
    <h1 className="text-dark">{crunchy.categoria}</h1>
    <div className="row">
        <div className="col marker">
            <div className="card">
                <div className="card-body" style="display: flex !important; flex-direction: row !important; 
                justify-content: space-between;">
                    <div style="display: flex; flex-direction:column;">
                        <h5 className="card-title me-5">{netflix.nombre} </h5>
                        <p className="card-text">{netflix.descripcion}</p>
                        <a href={netflix.link} target="_blank"
                        className="btn btn-primary">Abrir Pestaña</a>
                    </div>
                    <img src={netflix.imagen} width="100px"/>
                </div>
            </div>
        </div>
        <div className="col marker">
            <div className="card">
                <div className="card-body" style="display: flex !important; flex-direction: row !important; 
                justify-content: space-between;">
                    <div style="display: flex; flex-direction:column;">
                        <h5 className="card-title me-5">{facebook.nombre}</h5>
                        <p className="card-text">{facebook.descripcion}</p>
                        <a href={facebook.link} target="_blank"
                        className="btn btn-primary">Abrir Pestaña</a>
                    </div>
                    <img src={facebook.imagen} width="100px"/>
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
                        <h5 className="card-title me-5">{reddit.nombre}</h5>
                        <p className="card-text">{reddit.descripcion}</p>
                        <a href={reddit.link} target="_blank"
                        className="btn btn-primary">Abrir Pestaña</a>
                    </div>
                    <img src={reddit.imagen} width="100px"/>
                </div>
            </div>
        </div>
        <div className="col marker">
            <div className="card">
                <div className="card-body" style="display: flex !important; flex-direction: row !important; 
                justify-content: space-between;">
                    <div style="display: flex; flex-direction:column;">
                        <h5 className="card-title me-5">{crunchy.nombre}</h5>
                        <p className="card-text">{crunchy.descripcion}</p>
                        <a href={crunchy.link} target="_blank"
                        className="btn btn-primary">Abrir Pestaña</a>
                    </div>
                    <img src={crunchy.imagen} width="100px"/>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
    );

}

export default OcioComponent;
