import React, { useState } from 'react';
import { getAll, saveMarcador } from "../services/TrabajoServices";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form';

const initialMarcador = [
  {
      id: '',
      nombreMarcador: "",
      urlMarcador: "",
      descripcionMarcador: "",
      prioridad: 0,
      categoria: {},
      usuarios: {}
  }
]


function ModalComponent({marcadorAdd}) {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const [marcadores, setMarcadores] = useState(initialMarcador);

  const {nombreMarcador, urlMarcador, descripcionMarcador} = marcadores;

  const handleSubmit = (e) => {
    e.preventDefault();//Esto es para evitar que la pagina se actualize al presionar el button
    marcadorAdd(marcadores);
  }

  const handleInputChange = (e) => {
    console.log(e.target.marcadores)
        //...values-> es una condicional para que el contenido de values se mantenga
        setMarcadores({...marcadores, [e.target.name] : e.target.value})//Aqui el event.target.name toma el name de cada input para añadirle datos
        //key:key
    }
    

  return (
    <>
      <Button><i class="bi bi-plus-lg" variant="success" onClick={handleShow}> Agregar Marcador</i></Button>

      <Modal show={show} onHide={handleClose} >
        <Modal.Header closeButton>
          <Modal.Title>Agrega tu marcador</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <form onSubmit={handleSubmit}>
        <div className='form-group'>
            <label>Nombre</label>
            <input type='text' className='form-control' id='nombreMarcador' placeholder='Nombre' value={nombreMarcador} name='nombreMarcador' onChange={handleInputChange}/>
            <br />
        </div>
        <div className='form-group'>
            <label>Url</label>
            <input type='text' className='form-control' id='urlMarcador' placeholder='Url' value={urlMarcador} name='urlMarcador' onChange={handleInputChange}/>
            <br />
        </div>
        <div className='form-group'>
            <label>Descripcion</label>
            <input type='text' className='form-control' id='descripcionMarcador' placeholder='Descripcion' value={descripcionMarcador} name='descripcionMarcador' onChange={handleInputChange}/>
            <br />
        </div>
        <br/>
        <button type='submit' className='btn btn-outline-primary me-2'>Agregar</button>
    </form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Cerrar
          </Button>
          
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default ModalComponent;