import React from 'react';

class Register extends React.Component{

    constructor(props){
        super(props);
        this.state={
            firstName:'',
            lastName:'',
            username:'',
            email:'',
            password:'',
        };

        this.handleNameChange = this.handleNameChange.bind(this);
    }

    handleSubmit = (event) => {
        event.preventDefault();

        const data = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            username: this.state.username,
            email : this.state.email,
            password: this.state.password
        };

        console.log(data);
    };

    handleNameChange = (event) => {
        console.log(event);
        this.setState({
            firstName:event.target.value
        });
    };

    handleLastNameChange = (event) =>{

        this.setState({
            lastName:event.target.value
        });

    };

    render() {
        return(
            <div className="card w-50 mt-5 text-left border-primary mx-auto">
                <div className="card-header bg-primary text-white text-center">
                    <h4>Register</h4>
                </div>
                <div className="card-body">
                    <form className="justify-content-center">
                        <div className="form-row">
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="firstName">First name</label>
                                    <input type="text" id="firstName" className="form-control" placeholder="Enter First name" value={this.state.firstName} onChange={this.handleNameChange}/>
                                </div>
                            </div>
                            <div className="col">
                                <div className="form-group">
                                    <label htmlFor="lastName">Last Name</label>
                                    <input type="text" id="lastName" className="form-control" placeholder="Enter Last name" value={this.state.lastName} onChange={this.handleLastNameChange}/>
                                </div>
                            </div>
                        </div>
                        <div className="form-group">
                            <label htmlFor="email">Email</label>
                            <input type="text" id="email" className="form-control" placeholder="Enter Email"/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="username">Username</label>
                            <input type="text" id="username" className="form-control" placeholder="Enter Username"/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input type="password" id="password" className="form-control" placeholder="Enter Password"/>
                        </div>
                        <div className="form-row">
                            <div className="col">
                                <button type="submit" className="btn btn-success w-100" onSubmit={this.handleSubmit}>Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}

export default Register;