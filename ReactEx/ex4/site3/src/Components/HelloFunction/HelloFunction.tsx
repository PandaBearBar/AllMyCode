import "./HelloFunction.css";
interface HelloFunctionProps {
    str: string
}
function HelloFunction(props: HelloFunctionProps): JSX.Element {
    return (
        <div className="HelloFunction">
			<span>{props.str}</span>
        </div>
    );
}

export default HelloFunction;
