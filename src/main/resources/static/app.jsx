'use strict';

const e = React.createElement;

function Cake(props) {
    const val = props.value;
    return (<div>
            <h1>{val.title}</h1>
            <p>{val.desc}</p>
            <img src={val.image}></img>
        </div>);
}

class Main extends React.Component {
    constructor(props) {
        super(props);
        this.state = {cakes: []};
    }

    componentDidMount() {
        fetch('/cakes', {method: 'GET', headers: new Headers({'Accept': 'application/json'})})
            .then(res => res.json())
            .then(cakes => this.setState({ cakes }));
    }

    render() {
        return (<ul>{
                this.state.cakes.map((entity, index) => <li key={index}><Cake value={entity} /></li>)
            }</ul>);
    }
}

const domContainer = document.querySelector('#container');
ReactDOM.render(e(Main), domContainer);