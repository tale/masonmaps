// MapComponent.jsx
import React, { useEffect, useRef } from 'react';
import mapboxgl from 'mapbox-gl';

mapboxgl.accessToken =
  'pk.eyJ1IjoiYXNjaG9pIiwiYSI6ImNsbmtwMWdvajBrODEybHBtYXR3dmE3M3YifQ.7EtnhrpR2jJ1r4mnjCMwsQ';

export default function MapComponent() {
  //const coordinatesRef = useRef(null);

  useEffect(() => {
    const map = new mapboxgl.Map({
      container: 'map', // container ID
      style: 'mapbox://styles/mapbox/streets-v12', // style URL
      center: [-77.307864, 38.829660], // starting position [lng, lat]
      zoom: 14.5, // starting zoom
    });

    const marker = new mapboxgl.Marker({
      draggable: true,
    })
      .setLngLat([-77.307864, 38.829660])
      .addTo(map);

    function onDragEnd() {
      const lngLat = marker.getLngLat();
      if (coordinatesRef.current) {
        coordinatesRef.current.style.display = 'block';
        coordinatesRef.current.innerHTML = `Longitude: ${lngLat.lng}<br />Latitude: ${lngLat.lat}`;
        console.log(`Longitude: ${lngLat.lng}, Latitude: ${lngLat.lat}`);
      }
    }

    

    marker.on('dragend', onDragEnd);

    // THIS IS THE INFO THAT NEEDS TO BE SENT TO THE BACKEND

    // Store the marker's longitude and latitude coordinates in a variable
    const lngLat = marker.getLngLat();
    // Print the marker's longitude and latitude values in the console
    console.log(`Longitude: ${lngLat.lng}, Latitude: ${lngLat.lat}`);

    return () => map.remove();
  }, []);



  const mapStyle = {
    display: 'flex',
    margin: 'auto',
    flexDirection: 'column',
    alignItems: 'center',
    width: '400px',
    height: '300px',
  };

  const coordinatesRef = {
    background: 'rgb(255, 255, 255)',
    color: '#fc8c03',
    position: 'absolute',
    bottom: '40px',
    left: '10px',
    padding: '5px 10px',
    margin: '0',
    fontSize: '11px',
    lineHeight: '18px',
    borderRadius: '3px',
    display: 'none',
  };

  return (
    <div>
      <div id="map" style={mapStyle}></div>
      <div className="ans-container">
      <div className="inputs">
        <text className="addGuess">
          <p>Make a Guesse, an Educated One!</p>
        <input type="text"  placeholder='Add Answer' />
        </text>
      </div>
        <button type="submit">Submit</button>
      </div>
      <pre id="coordinates" ref={coordinatesRef} className="coordinates"></pre>
    </div>
  );
};

