import React from 'react';
import './Homepage.css';
import { Link } from 'react-router-dom';

<<<<<<< HEAD
import logo_icon from '../assets/Logo.png';
=======
import logo_icon from '../assets/react.svg';
>>>>>>> 50e8a3bc06149fd57d12d8526ad08222589d2f9f

const Homepage = () => {
 return (
    <div className="homepage-container">
    <header className="center-header">
    <div className="underline"></div>
        <h1>MasonMaps</h1>
    </header>
    <text className="text-center">
        <p>Easy to learn but really hard to master, become an expert on George Mason's Campus!</p>
    </text> 
    <div className="reviews-container">
    <text className="reviews">
        <p> "This game helped me gain familiarity with Mason and feel at home on campus!"</p>
        <p> Megan -Freshman, Psycology Major </p>
    </text> 
    </div>
    <div className="icon-container">
        <img src={logo_icon} alt="LogoIcon" className="centered-image"/>
    </div>
      <Link to="/game" className="button">
       Start Game
      </Link>
      <Link to="/LoginSignup" className="button">
        Login
      </Link>
      </div>
 );
}


export default Homepage;

