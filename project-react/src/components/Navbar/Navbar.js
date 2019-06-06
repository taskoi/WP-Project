import React from 'react';
import {Route, NavLink, Switch} from "react-router-dom";
import Home from '../Home/Home';
import Posts from '../Posts/Posts';
import Register from '../Users/Register/Register';

class Navbar extends React.Component {

    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg bg-light navbar-light">
                    <span className="navbar-brand">
                        <NavLink
                            to="/home"
                            className="navbar-brand">Brand</NavLink>
                        <button className="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                                     <span className="navbar-toggler-icon"></span>
                        </button>
                    </span>
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item">
                            <NavLink
                                to="/home"
                                exact className="nav-link">Home</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink
                                to="/posts"
                                className="nav-link">Posts</NavLink>
                        </li>
                    </ul>
                    <span className="btn btn-outline-primary">
                        <NavLink
                            to="/signin"
                            className="nav-link">Sign in</NavLink>
                    </span>
                </nav>

                <Switch>
                    <Route path="/home" component={Home}/>
                    <Route path="/posts" component={Posts}/>
                    <Route path="/signin" component={Register}/>
                </Switch>
            </div>

        )
    }
}

export default Navbar;