// MapComponent.jsx
import React, { useEffect, useState } from 'react';
import mapboxgl from 'mapbox-gl';

mapboxgl.accessToken =
  'pk.eyJ1IjoiYXNjaG9pIiwiYSI6ImNsbmtwMWdvajBrODEybHBtYXR3dmE3M3YifQ.7EtnhrpR2jJ1r4mnjCMwsQ';

export default function MapComponent() {
  //const coordinatesRef = useRef(null);

	const [lng, setLng] = useState(-77.307864);
	const [lat, setLat] = useState(38.829660);
	const [counter, setCounter] = useState(0);
	const [currentImage, setCurrentImage] = useState(null);
	const [score, setScore] = useState(0);
	const [roundScore, setRoundScore] = useState(null);
	const [difficulty, setDifficulty] = useState(1);

	useEffect(() => {
		requestImage().then((data) => {
			setCurrentImage(data);
		})
	}, [counter]);

	async function requestImage() {
		const response = await fetch(`http://localhost:8080/api/image?counter=${counter}`);
		const data = await response.json();
		return data;
	}

	async function submit() {
		console.log('submitting');
		const response = await fetch('http://localhost:8080/api/submit', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				...currentImage,
				lng,
				lat,
				score,
				difficulty,
			})
		});

		const data = await response.text();
		setCounter(counter + 1);

		let currentScore = parseInt(data);
		setRoundScore(currentScore - score);
		setTimeout(() => setRoundScore(null), 2000);
		setScore(currentScore);
		return data;
	}

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
      const { lng, lat } = marker.getLngLat();
		setLng(lng);
		setLat(lat);
	}

    marker.on('dragend', onDragEnd);
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

return (
	<div style={{ display: 'flex', gap: '10px', marginRight: '10px', justifyContent: 'space-between' }}>
		{currentImage?.url !== null ? (
			<img src={currentImage?.url} alt="currentImage" height={window.innerHeight} width="auto" style={{ margin: 'auto' }} />
		) : <div>Loading...</div>}
			<div style={{ display: 'flex', flexDirection: 'column', gap: '10px', paddingBottom: '10px' }}>
				<div>
					<p style={{ textAlign: 'center', color: 'white', fontSize: 12, fontWeight: 'bolder' }}>
						Your Score {roundScore !== null && `+ ${roundScore}`}
					</p>
					<p style={{ textAlign: 'center', color: 'white', fontSize: 64, padding: '4px', fontWeight: 'bolder', margin: 0 }}>
						{score}
					</p>
				</div>
				<div id="map" style={mapStyle} />
				<div style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
					<p style={{ textAlign: 'center', color: 'white', fontSize: 12 }}>
						Select Difficulty
					</p>
					<select onChange={(e) => setDifficulty(e.target.value)} style={{
						backgroundColor: 'white',
						border: 'none',
						borderRadius: '4px',
						padding: '8px',
						fontSize: 16,
					}}>
						<option value={1}>Easy</option>
						<option value={2}>Medium</option>
						<option value={3}>Hard</option>
					</select>
					<p style={{ textAlign: 'center', color: 'white', fontSize: 12 }}>
						Move the marker to the location you think the image was taken at.
					</p>
					<button onClick={submit}>Submit Guess</button>
				</div>
			</div>
		</div>
	);
}

