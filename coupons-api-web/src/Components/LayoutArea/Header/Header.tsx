import NavLink from "../../RoutingArea/NavLink/NavLink";
import "./Header.css";

function Header(): JSX.Element {
  if(localStorage.getItem('user') == null){
  return (
    <div className="Header flex-around">
      <h1>Coupon System</h1>
      <li>
      <NavLink to="/login">Login</NavLink>
      <div className="dropdown">
        <button className="dropbtn2">Register</button>
        <div className="dropdown-content">
          <NavLink to="/register/company">Company</NavLink>
          <NavLink to="/register/customer">Customer</NavLink>
        </div>
      </div>
      </li>
    </div>
  );
}else{
  return(
      <div className="Header flex-around">
        <h1>Coupon System</h1>
        <h2>Welcome back {localStorage.getItem('email')}</h2>
        <NavLink to="/logout">Logout</NavLink>
      </div>
  );
}
}

export default Header;
