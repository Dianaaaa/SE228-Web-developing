import React, {Component} from 'react'
import './CartItem.css'
import {Link} from 'react-router-dom'
import {Row, Col, Divider, Button, Icon} from 'antd'

class CartItem extends Component {
    state = {
        cur_cost: this.props.cur_cost,
        amount: this.props.ammount
    }

    incr = () => {
        if (this.state.amount < 99) {
            this.props.setSum(this.state.cur_cost, 1)
            this.setState((currentState) => ({
                amount: currentState.amount + 1
            }))
            fetch(
                "http://localhost:8080/cart/1/" + this.props.bookID + "/" + (this.state.amount+1), {
                  headers: {
                      'Content-Type': 'application/x-www-form-urlencoded'
                  },
                  method:'POST',
                //   body: formData.toString(),
                  credentials: 'include'         //解决跨域问题
                }).then((response) => {
                    console.log(response)
                    if (response.status === 200) {
                        console.log("ok")
                    //   this.props.history.push("/")
                    } else {
                        console.log("error")
                    }
                })
                .catch(e => console.log('错误:', e)
                )
        } 
    }

    decr = () => {
        if (this.state.amount > 1) {
            this.props.setSum(this.state.cur_cost, 0)
            this.setState((currentState) => ({
                amount: currentState.amount - 1
            }))
            fetch(
                "http://localhost:8080/cart/1/" + this.props.bookID + "/" + (this.state.amount-1), {
                  headers: {
                      'Content-Type': 'application/x-www-form-urlencoded'
                  },
                  method:'POST',
                //   body: formData.toString(),
                //   credentials: 'include'         //解决跨域问题
                }).then((response) => {
                    console.log(response)
                    if (response.status === 200) {
                        console.log("ok")
                    //   this.props.history.push("/")
                    } else {
                        console.log("error")
                    }
                })
                .catch(e => console.log('错误:', e)
                )
        } 
    }

    handleDelete = (e) => {
        e.preventDefault()
        fetch(
            window.backpath + "/cart/delete/" + this.props.cartID, {
              headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
              },
              method:'POST',
              // body: formData.toString(),
              credentials: 'include'         //解决跨域问题
            }).then((response) => {
                console.log(response)
                if (response.status === 200) {
                //   this.props.history.push("/cart")
                  alert("删除成功")
                    window.location.href = window.location.href;
                } else {
                    console.log("error")
                }
            })
            .catch(e => console.log('错误:', e)
            )
        // alert("删除")
    }

    handleCollect = (e) => {
        e.preventDefault()
        alert("收藏")
    }

    render () {
        const {bookID, cur_cost, name, author, front_page} = this.props
        return (
            <div className='cart-item'>
                <Divider />
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
                    <Col span={6}>
                        <div className='name'>
                            <p>{name}</p>
                            <span className='book-writer'>{author}</span>
                        </div>
                    </Col>
                    <Col span={4}>
                        <div className='cost'>
                            <p>单价: <span className='cur-cost'>{cur_cost}</span> </p>
                        </div>
                    </Col>
                    <Col span={6}>
                        <div className='amount'>
                            <Button.Group size={'small'}>
                              <Button type="primary" onClick={this.decr}>
                                <Icon type="left" />
                              </Button>
                              <div className='amount-show'>{this.state.amount}</div>
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