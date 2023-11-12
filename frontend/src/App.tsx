import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import mapboxgl from 'mapbox-gl'; 
import React, {useEffect} from 'react';
mapboxgl.accessToken = 'pk.eyJ1IjoiYXNjaG9pIiwiYSI6ImNsbmtwMWdvajBrODEybHBtYXR3dmE3M3YifQ.7EtnhrpR2jJ1r4mnjCMwsQ';


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <script src='https://api.mapbox.com/mapbox-gl-js/v2.14.1/mapbox-gl.js'></script>
        <link href='https://api.mapbox.com/mapbox-gl-js/v2.14.1/mapbox-gl.css' rel='stylesheet' />
      </div>

      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>

      <h1>Vite + React</h1>

      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>

      <div>
        <h4>Your Map App</h4>
        <MapComponent />
      </div>

      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}


const MapComponent: React.FC = () => {

  useEffect(() => {
    // Create a new map when the component mounts
    const map = new mapboxgl.Map({
      container: 'map', // container ID
      style: 'mapbox://styles/mapbox/streets-v12', // style URL
      center: [-74.5, 40], // starting position [lng, lat]
      zoom: 9, // starting zoom
    });

    // Cleanup function to remove the map when the component unmounts
    return () => map.remove();
  }, []); // Empty dependency array ensures the effect runs once on mount

  const mapStyle = {
    width: '400px',
    height: '300px',
  };

  return <div id="map" style={mapStyle}></div>;
};

export default App
