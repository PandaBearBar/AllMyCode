import React from 'react';
import logo from './logo.svg';
import './App.css';
import PlayerFunction from './Components/PlayerFunction/PlayerFunction';
import PlayerClass from './Components/PlayerClass/PlayerClass';

function App() {
  return (
    <div className="App">
      <h1>Class Vs Function Component</h1>
      {/* Functional Components */}
      <PlayerFunction name='Ronaldo' goals={-5} />
      <PlayerFunction name='Zlatan' goals={-5} />
      {/* Class Components */}
      <PlayerClass name='Messi' goals={5} />
      <PlayerClass name='Ronaldo' goals={-5} />
      <PlayerClass name='Zlatan' goals={-5} />
    </div>
  );
}

export default App;
