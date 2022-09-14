import "./SocialMedia.css";
import { BsFacebook, BsGithub, BsLinkedin } from "react-icons/bs";

function SocialMedia(): JSX.Element {
    return (
        <div className="SocialMedia">
            <a href="https://www.facebook.com/elad.gabay.71"><BsFacebook size={42} color="blue" /></a>
            <a href="https://www.linkedin.com/in/elad-gabay-a92223207"><BsLinkedin size={42} /></a>
            <a href="https://github.com/Elad52/"><BsGithub size={42} color ="black" /></a>

        </div>
    );
}

export default SocialMedia;
