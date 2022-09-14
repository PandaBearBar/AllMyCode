import "./Donate.css";


interface DonateProps {
    to: string;
    bank: number;
    branch: number;
    account: number;
}

const Donate : React.FC<DonateProps> = ( {to, bank, branch, account} ) =>  {
    return (
        <div className="Donate flex-col-top-center">
            <h1>Donate</h1>
            <span>This is an open source todo application</span>
            <span> please open your ❤️ and give some 💰</span>
            <span>Donate now to : {to} | Account Details : {bank}-{branch}-{account}</span>
        </div>
    );
}

export default Donate;