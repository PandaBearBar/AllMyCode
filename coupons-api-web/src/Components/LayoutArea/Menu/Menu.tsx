import { useLocation } from "react-router-dom";
import MenuLink from "../../RoutingArea/MenuLink/MenuLink";
import "./Menu.css";

function Menu(): JSX.Element {
  const location = useLocation();
  const isRoot = location.pathname === '/home' || location.pathname === '/';
  if(localStorage.getItem('type') === 'administrator'){
    return (
      <div className="Menu flex-top-center">
        <MenuLink to="home">
          Home
        </MenuLink>
        <MenuLink to="coupons">Coupons</MenuLink>
        <MenuLink to="about">About</MenuLink>
      </div>
    );
  }else{
  return (
    <div className="Menu flex-top-center">
      <MenuLink to="home">
        Home
      </MenuLink>
      <MenuLink to="coupons">Coupons</MenuLink>
      <MenuLink to="about">About</MenuLink>
    </div>
  );
  }
}

export default Menu;
