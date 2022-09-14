import moment from "moment";
import { useEffect, useState } from "react";
import "./ClockFunction.css";

function ClockFunction(): JSX.Element {
    let timerId: any;
    const [date, setDate] = useState(new Date());

    useEffect (() => {
        //Mounting 
        timerId = setInterval(() => {
            setDate(new Date());
        },1000)
        //UnMounting
        return ()=> {clearInterval(timerId);}
    })
    return (
        <div className="ClockFunction">
			<p>{moment(date).format('hh:mm:ss')}</p>
        </div>
    );
}

export default ClockFunction;
