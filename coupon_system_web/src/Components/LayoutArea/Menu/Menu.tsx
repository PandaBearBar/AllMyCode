import { useLocation } from "react-router-dom";
import MenuLink from "../../RoutingArea/MenuLink/MenuLink";
import "./Menu.css";

function Menu(): JSX.Element {

    const location = useLocation();
    const isRoot = location.pathname === '/'

    return (
        <div className="Menu flex-col-top-center">
            <MenuLink to="home"><div className={(isRoot) ? 'active' : ''}>Home</div></MenuLink>
            <MenuLink to="tasks">Tasks</MenuLink>
            <MenuLink to="about">About</MenuLink>
            <MenuLink to="donate">Donate</MenuLink>
            {/* <Link to="home">Home</Link>
            <Link to="tasks">Tasks</Link>
            <Link to="about">About</Link>
            <Link to="donate">Donate</Link> */}
            {/* <a href="home">Home</a>
			<a href="tasks">Tasks</a>
			<a href="about">About</a>
			<a href="donate">Donate</a> */}
        </div>
    );
}

export default Menu;