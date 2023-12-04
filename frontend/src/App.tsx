
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Homepage from './Components/Homepage';
import MapComponent from './Components/MapComponent'
import LoginSignup from './Components/LoginSignup/LoginSignup'

function App() {
  return (
    <Router>
      {/* Move the MapboxGL script and stylesheet to the head of your HTML document */}


      
        <Routes>
          <Route path='/' element={<Homepage />} />
          <Route path='/game' element={<MapComponent/>} />
          <Route path='/LoginSignup' element={<LoginSignup/>} />
        </Routes>
      
    </Router>
  );
}

export default App;
