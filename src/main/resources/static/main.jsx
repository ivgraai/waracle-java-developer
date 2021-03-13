'use strict';

const e = React.createElement;

class Tablazat extends React.Component {
    constructor(props) {
        super(props);
        this.state = {clicked: false};
    }

    render() {
        return (
                this.state.clicked ? 'You already clicked.' :
                <button onClick={() => this.setState({ clicked: true })}>
                    Click
                </button>
            );
    }
}

const domContainer = document.querySelector('#container');
ReactDOM.render(e(Tablazat), domContainer);