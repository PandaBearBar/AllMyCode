import SocialMedia from "../../SherdArea/SocialMedia/SocialMedia";
import "./Footer.css";

function Footer(): JSX.Element {
    return (
        <div className="Footer flex-around">
            <SocialMedia/>
            <h2>All right reserved & copy to Bar</h2>
        </div>
    );
}

export default Footer;
