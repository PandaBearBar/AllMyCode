import { Component } from "react";
import "./CountdownClass.css";

interface CountdownClassProps {
    num: number;
    exit: Function;
}

interface CountdownClassState {
    num: number;
}

class CountdownClass extends Component<CountdownClassProps, CountdownClassState> {

    private timerId: any;
    public constructor(props: CountdownClassProps){
        super(props);
        this.state = {
            num: props.num
        };
    }

    public render(): JSX.Element {
        return (
            <div className="CountdownClass">
				<p>{this.state.num}</p>
            </div>
        );
    }

    //Mounting Stage - after 1st render
    public componentDidMount(){
        this.timerId = setInterval(() =>{
            this.setState({num: this.state.num - 1});
        }, 1000);
    }
    //Updating Stage - after any state change
    public componentDidUpdate(){
        if(this.state.num === 0) {
            this.props.exit();
        }
    }
    //UnMounting Stage - asta-la-vista -> ant last words
    public componentWillUnmount(){
        clearInterval(this.timerId);
    }
}

export default CountdownClass;
