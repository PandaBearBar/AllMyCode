import React from 'react';
import logo from './logo.svg';
import './App.css';
import ClockClass from './Components/ClockClass/ClockClass';
import ClockFunction from './Components/ClockFunction/ClockFunction';

function App() {
  return (
    <div className="App">
      <ClockClass/>
      <ClockFunction/>
    </div>
  );
}

export default App;
