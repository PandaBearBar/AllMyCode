import React from 'react';
import logo from './logo.svg';
import './App.css';
import HelloClass from './Components/HelloClass/HelloClass';
import HelloFunction from './Components/HelloFunction/HelloFunction';

function App() {
  return (
    <div className="App">
      <HelloClass  />
      <HelloFunction />
    </div>
  );
}

export default App;
