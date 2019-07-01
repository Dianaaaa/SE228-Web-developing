import React, {Component} from 'react'
import {Row, Col} from 'antd'
import "./MyStat.css"
import { DatePicker } from 'antd';
import { Link } from 'react-router-dom'

const { RangePicker } = DatePicker;



class MyStat extends Component {
    state = {
        items: [],
        cost: 0
    }

    onChange = (date, dateString) => {
        console.log(date, dateString);
        fetch(
            'http://localhost:8080/mystatbook/' + dateString[0] + "/" + dateString[1], {
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
                    'http://localhost:8080/mystat/' + dateString[0] + "/" + dateString[1], {
                      method:'GET',
                      credentials: 'include'         //解决跨域问题
                    }).then((response) => {
                      console.log(response)
                      response.json().then((data) => {
                        console.log(data["cost"]);
                        let cost = data["cost"]
                        this.setState(() => ({
                            cost: cost
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
        const {items, cost} = this.state
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
                                <h2>书籍购买情况</h2>
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
                                    <p>消费：{cost.toFixed(2)}</p>
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}

export default MyStat