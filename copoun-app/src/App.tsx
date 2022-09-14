import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import Navbar from './components/LayoutArea/NavBar/Navbar'
import Routing from './components/SherdArea/Routing/Routing'
import { BrowserRouter, Outlet } from 'react-router-dom'
import Footer from './components/LayoutArea/Footer/Footer'

function App() {

  return (
    <div className="App">
      <BrowserRouter>
      <Navbar />
      <Routing />
      </BrowserRouter>
      <Footer />
    </div>
  )
}

export default App
