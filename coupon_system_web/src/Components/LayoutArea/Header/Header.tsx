import AuthMenu from "../../AuthorizationArea/AuthMenu/AuthMenu";
import Logo from "../../SherdArea/Logo/Logo";
import "./Header.css";

function Header(): JSX.Element {
    return (
        <div className="Header flex-around">
            <Logo/>
			<h1>Todo App</h1>
            {/* <Clock/> */}
            <AuthMenu/>
        </div>
    );
}

export default Header;