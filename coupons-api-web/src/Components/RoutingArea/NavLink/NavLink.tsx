import { Link, useLocation, useMatch, useResolvedPath } from "react-router-dom";
import "./NavLink.css";
interface MenuLinkProps {
    to: string;
    children: any;
}
function NavLink(props: MenuLinkProps): JSX.Element {
    let resolved = useResolvedPath(props.to);
    let match = useMatch({ path: resolved.pathname, end: true });
    return (
        <div className="dropbtn">
            <Link className={(match) ? "NavLink active" : "NavLink"} to={props.to}>{props.children}</Link>

        </div>
    );
}

export default NavLink;
