import React from 'react';

class Post extends React.Component{

    render() {

        return(
            <div className="col-4 mt-5">
                <div className="card">
                    <div className="card-header">
                        <h5>{this.props.post.title}</h5>
                    </div>
                    <div className="card-body">
                        <p className="card-text">
                            {this.props.post.description}
                        </p>
                        <p className="card-subtitle">
                            {this.props.post.price}
                        </p>
                    </div>
                    <div className="card-header">
                        {this.props.post.dateCreated}
                    </div>
                </div>
            </div>
        )
    }
}


export default Post;