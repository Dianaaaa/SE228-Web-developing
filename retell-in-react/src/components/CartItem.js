import React, {Component} from 'react'
import './CartItem.css'
import {Row, Col, Divider, Button, Icon} from 'antd'

class CartItem extends Component {
    state = {
        amount: 1
    }

    incr = () => {
        if (this.state.amount < 99) {
            this.setState((currentState) => ({
                amount: currentState.amount + 1
            }))
        } 
    }

    decr = () => {
        if (this.state.amount > 1) {
            this.setState((currentState) => ({
                amount: currentState.amount - 1
            }))
        } 
    }

    handleDelete = (e) => {
        e.preventDefault()
        alert("删除")
    }

    handleCollect = (e) => {
        e.preventDefault()
        alert("收藏")
    }

    render () {
        
        return (
            <div className='cart-item'>
                <Divider />
                <Row>
                    
                    <Col span={4}>
                        <div className='good'>
                            <img src={require('./../assets/imgs/book-4.jpg')} alt='book'/>
                        </div>
                    </Col>
                    <Col span={1}>
                        <Divider type="vertical" />
                    </Col>
                    <Col span={6}>
                        <div className='name'>
                            <p>偷书贼（The Book Thief)</p>
                            <span class='book-writer'>Markus Zusak</span>
                        </div>
                    </Col>
                    <Col span={4}>
                        <div className='cost'>
                            <p>单价: <span className='cur-cost'>￥22</span> </p>
                        </div>
                    </Col>
                    <Col span={6}>
                        <div className='amount'>
                            <Button.Group size={'small'}>
                              <Button type="primary" onClick={this.decr}>
                                <Icon type="left" />
                              </Button>
                              <div class='amount-show'>{this.state.amount}</div>
                              <Button type="primary" onClick={this.incr}>
                                <Icon type="right" />
                              </Button>
                            </Button.Group>
                            
                        </div>
                    </Col>
                    <Col span={3}>
                        <div className='action'>
                            <p><a href='https://github.com/Dianaaaa' onClick={this.handleDelete}>删除</a></p>
                            <p><a href='https://github.com/Dianaaaa' onClick={this.handleCollect}>加入收藏夹</a></p>
                         </div>
                    </Col>
                </Row>
                <Divider />
            </div>
        )
    }
}

export default CartItem