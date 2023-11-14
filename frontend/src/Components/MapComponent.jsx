// MapComponent.jsx
import React, { useEffect, useRef } from 'react';
import mapboxgl from 'mapbox-gl';
mapboxgl.accessToken =
  'pk.eyJ1IjoiYXNjaG9pIiwiYSI6ImNsbmtwMWdvajBrODEybHBtYXR3dmE3M3YifQ.7EtnhrpR2jJ1r4mnjCMwsQ';
export default function MapComponent() {
  const coordinatesRef = useRef(null);

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
      }
    }

    marker.on('dragend', onDragEnd);

    return () => map.remove();
  }, []);

  const mapStyle = {
    width: '400px',
    height: '300px',
  };

  return (
    <div>
      <div id="map" style={mapStyle}></div>
      <pre id="coordinates" ref={coordinatesRef} className="coordinates"></pre>
    </div>
  );
};

