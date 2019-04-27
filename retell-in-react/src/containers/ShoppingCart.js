import React, { Component } from 'react'
import CartItem from './../components/CartItem'
import Footer from './../components/Footer'
import { Button, Icon, Col} from 'antd'
import './ShoppingCart.css'

class ShoppingCart extends Component {
    state = {
        items: [],
        costsum: 0
    }
    setCostsum = (cost, flag) => {
        if (flag === 0) {
            this.setState((currentState) => ({
                costsum: currentState.costsum - cost
            }))
        } else if (flag === 1) {
            this.setState((currentState) => ({
                costsum: currentState.costsum + cost
            }))
        }
        
    }
    componentDidMount() {
        fetch(
          'http://localhost:8080/cart', {
            method:'GET',
          }).then((response) => {
            console.log(response)
            response.json().then((data) => {
            //   console.log(data['items']);
              let items = data['items']
              let sum = 0;
              for (var i = 0; i < items.length; i++) {
                  sum += items[i].ammount * items[i].cur_cost
              }
              console.log("sum", sum)
              this.setState(() => ({
                items: data['items'],
                costsum: sum
              }))
            });
          })
          .catch(e => console.log('错误:', e)
          )
        }

    render () {
        // const { areas, curArea, onChangeArea } = this.props
        const { items } = this.state
        return (
            <div className='shopping-cart'>
                {/* <Navigator 
                    areas = {areas}
                    curArea = {curArea}
                    onChangeArea = {onChangeArea}
                /> */}
                <div className='img-decoration'>
                    <img src={require('./../assets/imgs/cart.jpg')} alt='retell-2'/>
                </div>
                <div className='cart-items'>
                {
                    items.map((item) => (
                        <CartItem
                        bookID = {item.bookID}
                        cur_cost = {item.cur_cost}
                        name = {item.name}
                        author = {item.author}
                        ammount = {item.ammount}
                        front_page = {item.front_page}
                        setSum = {this.setCostsum}
                        key = {item.bookID}
                        />
                    ))
                }
                    {/* <CartItem/>
                    <CartItem/>
                    <CartItem/> */}
                </div>
                <div className='cart-button'>
                    <Col span={16}>
                    <div className='total'>
                        <p>总价：<span className='cur-cost'>{this.state.costsum.toFixed(2)}</span></p>
                    </div>
                    </Col>
                    <Button type="primary">进入结算中心 <Icon type="arrow-right" /></Button>
                </div>
                <div className='white-space'>&nbsp;</div>
                <Footer />
            </div>
        )
    }
}

export default ShoppingCart