import React, { useEffect, useState } from "react";
import { eliminarMarcador, getAll, saveMarcador } from "../services/TrabajoServices";
import Button from 'react-bootstrap/Button';
import ModalComponent from "./ModalComponent";

const initialMarcador = [
    {
        id: 1,
        nombreMarcador: "",
        urlMarcador: "",
        descripcionMarcador: "",
        prioridad: 0,
        categoria: {},
        usuarios: {}
    }
]

const iconoApi = (url) => {
    if (url.startsWith('https://')) {
        return url.slice(8)
    }
    else if (url.startsWith('http://')) {
        return url.slice(7)
    }
    else return url;
}

const TrabajoComponenti = () => {

    const [marcadores, setMarcadores] = useState(initialMarcador);

    const obtenerMarcadores = async () => {
        setMarcadores(await getAll())
    }

    useEffect(
        () => { obtenerMarcadores() }
        , {})

    //Aqui se crea esta funcion en la cual se almacenara la informacion 
    const marcadorAdd = async (marcador) => {
        await saveMarcador(marcador)
        setMarcadores(await getAll())
    }

    //Aqui se crea la funcion para el button eliminar y se le asigan la key(id) para saber cual eliminar
    const tarjetaDelete = async (marcadorId) => {
        await eliminarMarcador(marcadorId)
        setMarcadores(await getAll())
    }

    console.log(marcadores);
    return (

        <div className="carousel-item" id="trabajo">
            <h1 className="text-dark category-name">Estudio</h1>
            <div className="col-10">
                <div className="container marker d-flex flex-wrap">
                    {
                        marcadores.map(m =>
                            <div className="card col-3">
                                <div className="card-body">
                                    {/* <button className='btn btn-sm btn-outline-danger'
                                        //Con este onClick le damos funcionalidad al boton eliminar
                                        onClick={() => tarjetaDelete(marcador.id)}>X</button> */}
                                    <div className="row">
                                        <div className="d-flex flex-row">
                                            <img src={`http://www.google.com/s2/favicons?domain=${iconoApi(m.urlMarcador)}`} height="40px" width="40px" />
                                            <p className="card-text mx-auto">{m.descripcionMarcador}</p>

                                        </div>


                                    </div>
                                </div>

                                <Button className="btn-card" href={m.urlMarcador} target="_blank">
                                    <a>Abrir {m.nombreMarcador}</a>
                                </Button>
                            </div>
                        )
                    }

                    <div className="card col-3">
                        <div className="card-body d-flex justify-content-center">
                            <ModalComponent 
                            marcadorAdd={marcadorAdd}
                            tarjetaDelete={tarjetaDelete}/>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    );
}


export default TrabajoComponenti;
