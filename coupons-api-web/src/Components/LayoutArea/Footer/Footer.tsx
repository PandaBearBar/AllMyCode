import SocialMedia from "../../SharedArea/SocialMedia/SocialMedia";
import "./Footer.css";


function Footer(): JSX.Element {
  return (
    <div className="Footer flex-around">
      <h2>All right reserved to Elad &copy;</h2>
      <h2>    </h2>
      <SocialMedia />
    </div>
  );
}

export default Footer;
