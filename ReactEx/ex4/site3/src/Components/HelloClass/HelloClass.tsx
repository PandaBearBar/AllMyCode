import { Component } from "react";
import "./HelloClass.css";
interface HelloClassProps{
    str : string;
}

class HelloClass extends Component<HelloClassProps> {

    public constructor(props: HelloClassProps) {
        super(props);
    }

    public render(): JSX.Element {
        return (
            <div className="HelloClass">
				<span>{this.props.str}</span>
            </div>
        );
    }
}

export default HelloClass;
