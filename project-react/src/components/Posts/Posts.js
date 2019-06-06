import React from 'react';
import Post from './Post/Post';

class Posts extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            posts:[]
        }
    }

    componentDidMount() {
        fetch(`http://localhost:8080/allAds`, { method: 'GET'})
            .then(reponse => reponse.json())
            .then(posts => this.setState({posts : posts}))
    }


    render() {
        const postList = this.state.posts.map(post => {
            return (
                <Post post={post} key={post.id}/>
            );
        });

        return(
            <div className="container">
                <div className="row">
                        {postList}
                </div>
            </div>
        )
    }
}

export default Posts;