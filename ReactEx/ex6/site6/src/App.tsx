import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import CountdownClass from './Components/CountdownClass/CountdownClass';
import CountdownFunction from './Components/CountdownFunction/CountdownFunction';

function App() {
  // Countdown class
  const [flagCC, setFlagCC] = useState(true);

  const exitCC = () => {
    setFlagCC(false);
  }
  // Countdown function

  const [flagFC, setFlagFC] = useState(true);

  const exitFC = () => {
    setFlagFC(false);
  }

  return (
    <div className="App">
      {flagCC && <CountdownClass num={10} exit={exitCC} />}
      {flagFC && <CountdownFunction num={10} exit={exitFC} />}
    </div>
  );
}

export default App;
