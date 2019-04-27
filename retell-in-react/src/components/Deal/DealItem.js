import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import {Card, Divider, Row, Col} from 'antd'
import "./DealItem.css"
import BookItem from "./BookItem"

class DealItem extends Component {
    render() {
        return (
            <div className = "dealitem">
            <Card
              title={"订单号："+ 1}
              extra={<a href="#">More</a>}
            >
              <BookItem />
              <BookItem />
              <Divider dashed />
              <Row>
                  <div className="info-row">
                <Col span={8}>
                    <p>用户名：{"user"}</p>
                    <p>手机：{"18217508975"}</p>
                   
                </Col>
                <Col span={8}>
                    <p>地址：{"上海市闵行区东川路800号交通大学"}</p>
                    <p>下单时间：{"2019-04-24 18:00:00"}</p>
                </Col>
                <Col span={8}>
                    <span>总价:{14.00}</span>
                </Col>
                </div>
              </Row>
            </Card>
            </div>
        )
    }
}

export default DealItem