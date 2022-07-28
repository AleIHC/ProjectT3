import React from 'react'
import linkedinImagen from '../assets/img/linkedin.png'
import slackImagen from '../assets/img/slack.png'
import trelloImagen from '../assets/img/trello.png'
import teamsImagen from '../assets/img/teams.png'


const TrabajoComponent = () =>{

    /*iterar con map, por ahora solo estático*/ 
    const linkedin = {
        categoria: 'Trabajo',
        nombre : 'Linkedin',
        descripcion : 'Perfil de Linkedin',
        link : 'https://www.linkedin.com',
        imagen : linkedinImagen
    };

    const slack = {
        categoria: 'Trabajo',
        nombre : 'Slack',
        descripcion : 'Slack Generation',
        link : 'https://www.slack.com',
        imagen : slackImagen
    }

    const trello = {
        categoria: 'Trabajo',
        nombre : 'Trello',
        descripcion : 'Historias Trello',
        link : 'https://www.trello.com',
        imagen : trelloImagen
    }

    const teams = {
        categoria: 'Trabajo',
        nombre : 'Teams',
        descripcion : 'Webinars',
        link : 'https://www.microsoft.com/es-cl/microsoft-teams/log-in',
        imagen : teamsImagen
    }
        
    
    return(

        <div className="carousel-item d-flex" id="trabajo">
        <h1 className="text-dark">{linkedin.categoria}</h1>
        
    <div className="row ">
        <div className="col marker">
            <div className="card">
                <div className="card-body d-flex flex-row justify-content-between">
                    <div className='d-flex flex-column'>
                        <h5 className="card-title me-5">{linkedin.nombre}</h5>
                        <p className="card-text">{linkedin.descripcion}</p>
                        <a href={linkedin.link} className="btn btn-primary"
                            target="_blank">Abrir Pestaña</a>
                    </div>
                    <img src={linkedin.imagen} width="100px"/>
                </div>
            </div>
        </div>
        <div className="col marker">
            <div className="card">
                <div className="card-body d-flex flex-row justify-content-between">
                    <div className="d-flex flex-column">
                        <h5 className="card-title me-5">{slack.nombre}</h5>
                        <p className="card-text">{slack.descripcion}</p>
                        <a href={slack.link} className="btn btn-primary"
                            target="_blank">Abrir Pestaña</a>
                    </div>
                    <img src={slack.imagen} width="100px"/>
                </div>
            </div>
        </div>
    </div>

    <div className="row mt-3">
        <div className="col marker">
            <div className="card">
                <div className="card-body d-flex flex-row justify-content-between">
                    <div className="d-flex flex-column">
                        <h5 className="card-title me-5">{trello.nombre}</h5>
                        <p className="card-text">{trello.descripcion}</p>
                        <a href={trello.link} className="btn btn-primary"
                            target="_blank">Abrir Pestaña</a>
                    </div>
                    <img src={trello.imagen} width="100px"/>
                </div>
            </div>
        </div>
        <div className="col marker">
            <div className="card">
                <div className="card-body d-flex flex-row justify-content-between">
                    <div className="d-flex flex-column">
                        <h5 className="card-title me-5">{teams.nombre}</h5>
                        <p className="card-text">{teams.descripcion}</p>
                        <a href={teams.link}
                            target="_blank" className="btn btn-primary">Abrir Pestaña</a>
                    </div>
                    <img src={teams.imagen} width="100px"/>
                </div>
            </div>
        </div>
    </div>
</div>
    );
}

export default TrabajoComponent;
