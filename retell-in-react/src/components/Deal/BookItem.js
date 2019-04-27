import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import {Card, Row, Col, Divider} from 'antd'
import "./BookItem.css"

class BookItem extends Component {
    render() {
        return (
            <div className = "book-item">
                <Card>
                <Row>
                    
                    <Col span={4}>
                        <Link to={'/book-details/'+ 1}>
                        <div className='good'>
                            <img src={"http://localhost:8080/resources/2.jpg"} alt='book'/>
                        </div>
                        </Link>
                    </Col>
                    <Col span={1}>
                        <Divider type="vertical" />
                    </Col>
                    <Col span={14}>
                        <div className='name'>
                            <p><span className="book-name">{"name"}</span></p>
                            <span className='book-writer'>{"author"}</span>
                        </div>
                    </Col>
                    <Col span={4}>
                        <div className='cost'>
                            <p>单价: <span className='cur-cost'>{"cur_cost"}</span> </p>
                        </div>
                    </Col>
                </Row>
                </Card>,
            </div>
        )
    }
}

export default BookItem