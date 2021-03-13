'use strict';

const e = React.createElement;

class Tablazat extends React.Component {
    constructor(props) {
        super(props);
        this.state = {clicked: false};
    }

    render() {
        if (this.state.clicked) {
            return 'You already clicked.';
        }

        return e(
                'button',
                {onClick: () => this.setState({clicked: true})},
                'Click'
                );
    }
}

const domContainer = document.querySelector('#container');
ReactDOM.render(e(Tablazat), domContainer);