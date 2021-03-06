import React, {Component} from 'react'
import {Row, Col} from 'antd'
import "./Statistics.css"
import { DatePicker } from 'antd';
import { Link } from 'react-router-dom'

const { RangePicker } = DatePicker;



class Statistics extends Component {
    state = {
        items: [],
        users: []
    }

    onChange = (date, dateString) => {
        console.log(date, dateString);
        fetch(
            'http://localhost:8080/statbook/' + dateString[0] + "/" + dateString[1], {
              method:'GET',
              credentials: 'include'         //解决跨域问题
            }).then((response) => {
              console.log(response)
              response.json().then((data) => {
                console.log(data["stat"]);
                let items = data["stat"]
                this.setState(() => ({
                    items: items
                  }))
                
                  fetch(
                    'http://localhost:8080/statuser/' + dateString[0] + "/" + dateString[1], {
                      method:'GET',
                      credentials: 'include'         //解决跨域问题
                    }).then((response) => {
                      console.log(response)
                      response.json().then((data) => {
                        console.log(data["stat"]);
                        let items = data["stat"]
                        this.setState(() => ({
                            users: items
                          }))
                      });
                    })
                    .catch(e => console.log('错误:', e)
                    )
              });
            })
            .catch(e => console.log('错误:', e)
            )
      }
    render() {
        const {items, users} = this.state
        return (
            <div className = "deal">
                <div className = "picker">
                    <RangePicker onChange={this.onChange} />
                </div>
                <div className="stat-show">
                    <Row>
                        <Col span={4}/>
                        <Col span={8}>
                            <div className="book-sale">
                                <h2>书籍销售情况</h2>
                            {items.length !== 0 &&
                                (items.map((item) => (
                                <div key={item.id}>
                                    <p><Link to={"/book/" + item.id}>{item.name}</Link></p>
                                    <p>销量：{item.sale}</p>
                                </div>
                            )))
                            }
                            </div>
                        </Col>
                        <Col span={8}>
                        <h2>用户消费情况</h2>
                            {users.length !== 0 &&
                                (users.map((item) => (
                                <div key={item.name}>
                                    <Row>
                                        <Col span={12}>
                                    <p>用户名：{item.name}</p>
                                    </Col>
                                    <Col span={12}>
                                    <p>消费：{item.sale.toFixed(2)}</p>
                                    </Col>
                                    </Row>
                                </div>
                            )))
                            }
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}

export default Statistics