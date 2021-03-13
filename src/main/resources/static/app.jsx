'use strict';

const e = React.createElement;

function Cake(props) {
    var val = props.value;
    return (<div>
            <h1>{val.title}</h1>
            <p>{val.desc}</p>
            <img src={val.image}></img>
        </div>);
}

class Main extends React.Component {
    constructor(props) {
        super(props);
        this.extremeValue = {title: '', description: '', image: ''};
        this.state = {cakes: [], input: this.extremeValue};
    }

    componentDidMount() {
        fetch('/cakes', {method: 'GET', headers: new Headers({'Accept': 'application/json'})})
            .then(resp => resp.json())
            .then(cakes => this.setState({ cakes }));
    }

    onAdd() {
        var input = this.state.input;
        if ('' === input.title || '' === input.description || '' === input.image) {
            alert('Please enter all datas!');
            return;
        }
        var payload = {
                title: input.title,
                desc: input.description,
                image: input.image
            };
        fetch('/cakes', {method: 'POST', headers: new Headers({'Content-Type': 'application/json'}), body: JSON.stringify(payload)})
            .then(_ => {this.state.cakes.push(payload);})
            .finally(() => this.setState({input: this.extremeValue}));
    }

    onEdit(key, event) {
        this.setState({input: {...this.state.input, [key]: event.target.value}});
    }

    render() {
        return (<div>
            <input type='text' placeholder='Title' value={this.state.input.title} onChange={e => this.onEdit('title', e)}></input>
            <input type='text' placeholder='Description' value={this.state.input.description} onChange={e => this.onEdit('description', e)}></input>
            <input type='text' placeholder='Image' value={this.state.input.image} onChange={e => this.onEdit('image', e)}></input>
            <button onClick={() => this.onAdd()}>Add new cake</button>
            <ul>{
                this.state.cakes.map((entity, index) => <li key={index}><hr /><Cake value={entity} /></li>)
            }</ul>
        </div>);
    }
}

const domContainer = document.querySelector('#container');
ReactDOM.render(e(Main), domContainer);