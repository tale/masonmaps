
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Homepage from './Components/Homepage';
import MapComponent from './Components/MapComponent'

function App() {
  return (
    <Router>
      {/* Move the MapboxGL script and stylesheet to the head of your HTML document */}


      
        <Routes>
          <Route path='/' element={<Homepage />} />
          <Route path='/game' element={<MapComponent/>} />
        </Routes>
      
    </Router>
  );
}

export default App;