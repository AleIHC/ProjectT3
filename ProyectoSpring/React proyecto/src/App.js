import React from 'react';
import BodyComponent from './components/BodyComponent';
import NavComponent from './components/NavComponent';
import SideLeftComponent from './components/SideLeftComponent';
import SideRightComponent from './components/SideRightComponent';

function App() {

  return (
    <div>
      <NavComponent/>
      <SideLeftComponent/>
      <div id="wrapper" className="toggled">
          <div className="container-fluid">
            <SideRightComponent/>
            <BodyComponent/>
          </div>
      </div>
    </div>
  );
}

export default App;
