import { Component } from "react";
import "./PlayerClass.css";
interface PlayerClassProps {
    name: string;
    goals: number;
}
interface PlayerClassState {
    goals: number;
}
class PlayerClass extends Component<PlayerClassProps, PlayerClassState> {
    public add = () => {
        this.setState({goals: this.state.goals + 1});
    }

    public minus = () => {
        this.setState({goals: this.state.goals - 1});
    }

    public constructor(props: PlayerClassProps) {
        super(props);
        this.state = {
            goals: props.goals,
        };
    }

    public render(): JSX.Element {
        return (
            <div className="PlayerClass single-col box">
				<p className="single-row">{this.props.name}</p>
                <div className="single-row">
                    <button onClick={this.add}>+</button>
                    <span className={this.state.goals > 0 ?
                        "green" : (this.state.goals < 0) ? 
                        "red" : "orange"}>{this.state.goals}</span>
                    <button onClick={this.minus}>-</button>
                </div>
            </div>
        );
    }
}
export default PlayerClass;
