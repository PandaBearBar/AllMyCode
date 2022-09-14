import { Component } from "react";
import "./HelloClass.css";

class HelloClass extends Component {

    public render(): JSX.Element {
        return (
            <div className="HelloClass">
				<span>{'Hello Class'}</span>
            </div>
        );
    }
}

export default HelloClass;
