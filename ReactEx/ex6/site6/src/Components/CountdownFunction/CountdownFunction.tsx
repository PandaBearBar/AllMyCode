import { useEffect, useState } from "react";
import "./CountdownFunction.css";
interface CountdownFunctionProps {
    num : number;
    exit : Function;
}
function CountdownFunction(props : CountdownFunctionProps): JSX.Element {
    const [num,setNum] = useState(props.num);
    let timerId:any;
    useEffect (() =>
        {
//--------------------------------------------------------
            //Mounting :
            timerId = setInterval (() => {
                setNum(x => x-1);
            },1000);
//--------------------------------------------------------
            //Updating 
            if (num === 0){
                props.exit();
            }
//--------------------------------------------------------
            //UnMounting
            return () => { clearInterval (timerId); };
        }, [num]);
    return (
        <div className="CountdownFunction">
			<p>{num}</p>
        </div>
    );
}

export default CountdownFunction;
