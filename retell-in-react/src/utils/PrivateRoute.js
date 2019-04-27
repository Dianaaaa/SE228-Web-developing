import React, {Component} from 'react';
import {Route, withRouter} from 'react-router-dom';

class PrivateRoute extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isAuthenticated: window.sessionStorage.getItem("userId") ? true: false
        }
    }

    componentWillMount() {
        if(!this.state.isAuthenticated){
            const {history} = this.props;
            setTimeout(() => {
                history.replace("/login");
            }, 1000)
        }
    }

    render() {
        let { component: Component, ...rest} = this.props;
        console.log("windows", localStorage)
        // console.log("Component", Component)
        // console.log("...rest", ...rest)
        return  this.state.isAuthenticated ? 
        (<Component /> ) : (<p></p>)

    }
}

export default withRouter(PrivateRoute);