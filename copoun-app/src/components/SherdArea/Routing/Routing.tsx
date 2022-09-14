import React from 'react'
import { Outlet, Route, Routes } from 'react-router-dom';
import App from '../../../App';
// import About from '../../PageArea/About/About';
import Coupons from '../../Coupons/Coupons';

const Routing = () => {
    return (
        <div className="Routing">
            <Routes>
                <Route path="/" element={<Coupons />} />
                {/* <Route path="/about" element={<About />} /> */}
                {/* <Route path="*" element={<Page404 />} /> */}
            </Routes>
        </div>
    );
}

export default Routing