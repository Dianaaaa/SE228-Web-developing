import React, {Component} from 'react'
import './Comment.css'
import { Rate, Row, Col } from 'antd'

class Comment extends Component {
    state={
        comments: []
    }
    componentDidMount() {
    
    }
    render () {
        const {content, score, time} = this.props
        return (
            <div className='comment'>
                        <Row>
                            <Col span={8}>
                        <div className='user-avatar'><img src={require('./../assets/imgs/avator2.jpg')} alt='avatar'/></div>
                        </Col>
                        <div className='comment-body'>
                                <div className='user-rating'><Rate disabled defaultValue={score} /></div>
                                <div className='user-comment'>{content}</div>
                                <div className='comment-time'>{time}</div>
                        </div> 
                        </Row>
                
            </div>
        )
    }
}

export default Comment