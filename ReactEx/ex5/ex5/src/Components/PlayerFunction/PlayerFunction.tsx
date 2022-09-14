import { useState } from "react";
import "./PlayerFunction.css";
interface PlayerFunctionProps {
    name : string;
    goals : number;
}
function PlayerFunction(props : PlayerFunctionProps): JSX.Element {
    const [goals, setGoals] = useState(props.goals);
    const add = () => {
        setGoals (x => x + 1)
    }
    const minus = () => {
        setGoals (x => x - 1)
    }
    return (
        <div className="PlayerFunction">
            <p className="single-row">{props.name}</p>
            <div className="single-row">
                <button onClick={add}>+</button>
                <span className={goals > 0 ? "green" : (goals < 0) ? "red" : "orange"}>{goals}</span>
                <button onClick={minus}>-</button>
            </div>
        </div>
    );
}

export default PlayerFunction;

