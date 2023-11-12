import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import mapboxgl from 'mapbox-gl'; 
import React, {useEffect, useRef} from 'react';
mapboxgl.accessToken = 'pk.eyJ1IjoiYXNjaG9pIiwiYSI6ImNsbmtwMWdvajBrODEybHBtYXR3dmE3M3YifQ.7EtnhrpR2jJ1r4mnjCMwsQ';


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/* Jank "header" that should probably be addressed*/}
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
      {/*<pre id="coordinates" class="coordinates"></pre>*/}

      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}


const MapComponent: React.FC = () => {

  //const mapContainer = useRef<HTMLDivElement | null>(null);
  const coordinatesRef = useRef<HTMLPreElement | null>(null);

  useEffect(() => {
    // Create a new map when the component mounts
    //const coordinates = document.getElementById('coordinates');
    const map = new mapboxgl.Map({
      container: 'map', // container ID
      style: 'mapbox://styles/mapbox/streets-v12', // style URL
      center: [-77.307864, 38.829660], // starting position [lng, lat]
      zoom: 14.5, // starting zoom
    });
    
    const marker = new mapboxgl.Marker({
      draggable: true
    })
      .setLngLat([-77.307864, 38.829660])
      .addTo(map);
       
    function onDragEnd() {
      const lngLat = marker.getLngLat();
      if(coordinatesRef.current) {
        coordinatesRef.current.style.display = 'block';
        coordinatesRef.current.innerHTML = `Longitude: ${lngLat.lng}<br />Latitude: ${lngLat.lat}`;
      }
    }
       
    marker.on('dragend', onDragEnd);

    // Cleanup function to remove the map when the component unmounts
    return () => map.remove();
  }, []); // Empty dependency array ensures the effect runs once on mount

  const mapStyle = {
    width: '400px',
    height: '300px',
  };
  

  return  <div>  
            <div id="map" style={mapStyle}></div>
            <pre id="coordinates" ref={coordinatesRef} className="coordinates"></pre>
          </div>;
};

export default App


