import React, {Component} from 'react'
import {Card, Divider, Row, Col} from 'antd'
import "./DealItem.css"
import BookItem from "./BookItem"

class DealItem extends Component {
    render() {
        const {item} = this.props 
        return (
            <div className = "dealitem">
            <Card
              title={"订单号："+ item.ID}
            //   extra={<a href="#">More</a>}
            >
                {
                    item.books.map((book) => (
                        <BookItem 
                                bookID = {book.bookID}
                                cur_cost = {book.cur_cost}
                                name = {book.name}
                                author = {book.author}
                                ammount = {book.ammount}
                                front_page = {book.front_page}
                                key = {book.bookID}
                                />
                    ))
                }
              <Divider dashed />
              <Row>
                  <div className="info-row">
                <Col span={8}>
                    <p>收件人：{item.receiver}</p>
                    <p>手机：{item.phone}</p>
                   
                </Col>
                <Col span={8}>
                    <p>地址：{item.address}</p>
                    <p>下单时间：{item.time}</p>
                </Col>
                <Col span={8}>
                    <span>总价:<span className='cur-cost'>{item.total_price.toFixed(2)}</span></span>
                </Col>
                </div>
              </Row>
            </Card>
            </div>
        )
    }
}

export default DealItem