import React from 'react';
import './homepage.css';
import { Link } from 'react-router-dom';
export default function Homepage() {
 return (
    <div className="homepage">
      <h1>GeoGuessr</h1>
      <p>Easy to learn but really hard to master, so is really addictive!</p>
      <Link to="/game">
        <button>Start Game</button>
      </Link>
    </div>
 );
}

