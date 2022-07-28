import axios from 'axios';

const baseUrl = "http://localhost:9080/api"

const getAll = async()=> {
    const res = await axios.get(baseUrl + "/obtener/marcadores")
    //await axios.get(localhost:9080/api/obtener/marcadores)
    console.log(res.data)
    return res.data;
}

const saveMarcador = async(marcador)=>{
    //peticion con valores desde body
    const res = await axios.post(baseUrl + "/guardar/marcadores", marcador);
    return res.data;
}

const eliminarMarcador = async(id)=>{
    //eliminarMarcador(1)
    //peticion con valores en path
    const res = await axios.post(baseUrl + "/eliminar/" + id);
    //axios.post(http://localhost:9080/api/eliminar/1)
    return res.data;
}


export {getAll, saveMarcador, eliminarMarcador};