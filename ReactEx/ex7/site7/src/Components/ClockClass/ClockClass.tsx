import { Component } from "react";
import "./ClockClass.css";
import moment from 'moment'
interface ClockClassState {
    date: Date;
}

class ClockClass extends Component<{}, ClockClassState> {

    private timerId: any;
    public constructor(props: {}) {
        super(props);
        this.state = {
            date: new Date()
        };
    }

    // public format(date: Date): string {
    //     const hour = date.getHours();
    //     const minute = date.getMinutes();
    //     const second = date.getSeconds();
    //     return hour + ":" + minute + ":" + second;
    // }

    public render(): JSX.Element {
        return (
            <div className="ClockClass box cc ">
                <p>{moment(this.state.date).format("hh:mm:ss")}</p>
            </div>
        );
    }

    //Mounting State
    //after the first render
    public componentDidMount(): void {
        this.timerId = setInterval(() => {
            this.setState({ date: new Date() });
        }, 1000);
    }

    //Updating Stage
    //after any change in component State
    public componentDidUpdate() {

    }

    //UnMounting Stage
    public componentWillUnmount(): void {
        clearInterval(this.timerId);
    }



}

export default ClockClass;