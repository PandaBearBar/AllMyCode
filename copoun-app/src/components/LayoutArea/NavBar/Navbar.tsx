import React from 'react'
import { Container, Nav, Navbar as NavbarBS } from 'react-bootstrap'
import './Navbar.css';

const Navbar = () => {
return (
    <NavbarBS bg="dark" variant="dark" className='navbar'>
    <Container>
    <NavbarBS.Brand href="/">Home</NavbarBS.Brand>
    <Nav className="me-auto">
    <Nav.Link href="/donate">Donate</Nav.Link>
    <Nav.Link href="/about">About</Nav.Link>
    </Nav>
    </Container>
    </NavbarBS>
)
}

export default Navbar