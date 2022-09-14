const Header = () => {
    return (
        <div className="Header">
            <h1>
                Bar's Learning
            </h1>
        </div>
    )
}
const Main = () => {
    return (
        <div className="Main">
            <img src="https://media.giphy.com/media/TAdx21T5Rz3Y2kirUX/giphy.gif" alt="Shaq loves Coupons">
            </img>
        </div>
    )
}
const Footer = () => {
    return (
        <div className="Footer">
            <h2>Bar's practicing</h2>
        </div>
    )
}
const App = () => {
    return (
        <div className="App">
            <Header />
            <Main />
            <Footer />
        </div>
    );

}

const root = document.getElementById('root');
ReactDOM.render(<App />, root);