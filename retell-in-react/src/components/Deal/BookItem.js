import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import {Card, Row, Col, Divider} from 'antd'
import "./BookItem.css"

class BookItem extends Component {
    render() {
        const {bookID, cur_cost, name, author, front_page, ammount} = this.props
        return (
            <div className = "book-item">
                <Card>
                <Row>
                    
                    <Col span={4}>
                        <Link to={'/book-details/'+ bookID}>
                        <div className='good'>
                            <img src={front_page} alt='book'/>
                        </div>
                        </Link>
                    </Col>
                    <Col span={1}>
                        <Divider type="vertical" />
                    </Col>
                    <Col span={12}>
                        <div className='name'>
                            <p><span className="book-name">{name}</span></p>
                            <span className='book-writer'>{author}</span>
                        </div>
                    </Col>
                    <Col span={4}>
                        <div className='cost'>
                            <p>单价: <span className='cur-cost'>{cur_cost}</span> </p>
                        </div>
                    </Col>
                    <Col span={4}>
                        <div className='cost'>
                            <p>数量: <span className='ammount'>{ammount}</span> </p>
                        </div>
                    </Col>
                </Row>
                </Card>
            </div>
        )
    }
}

export default BookItem