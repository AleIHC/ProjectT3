import React from "react";
import Carousel from 'react-bootstrap/Carousel';
import EstudiosComponent from "./EstudiosComponent";
import OcioComponent from "./OcioComponent";
import TrabajoComponenti from "./TrabajoComponenti";


const BodyComponent = () => {
  return (
    <Carousel className="d-grid">
    <Carousel.Item>
      <TrabajoComponenti/>
    </Carousel.Item>
    <Carousel.Item>
      {/* <EstudiosComponent/> */}
    </Carousel.Item>
    <Carousel.Item>
      {/* <OcioComponent/> */}
    </Carousel.Item>
  </Carousel>
  );
};

export default BodyComponent;
