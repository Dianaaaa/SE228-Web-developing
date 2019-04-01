import React, {Component} from 'react'
import { Rate, Row, Col } from 'antd'
import './Comment.css'

class Comment extends Component {

    render () {
        return (
            <div className='comment'>
                <Row>
                    <Col span={8}>
                <div className='user-avatar'><img src={require('./../assets/imgs/avator2.jpg')} alt='avatar'/></div>
                </Col>
                <div className='comment-body'>
                        <div className='user-rating'><Rate disabled defaultValue={5} /></div>
                        <div className='user-comment'>我太喜欢这本书了！</div>
                </div>
                </Row>
            </div>
        )
    }
}

export default Comment