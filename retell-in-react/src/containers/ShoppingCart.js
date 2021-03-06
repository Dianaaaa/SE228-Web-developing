import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import CartItem from './../components/CartItem'
import Footer from './../components/Footer'
import { Button, Icon, Col} from 'antd'
import './ShoppingCart.css'
import SearchBar from '../components/SearchBar';

class ShoppingCart extends Component {
    state = {
        items: [],
        costsum: 0,
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
            credentials: 'include'         //解决跨域问题
          }).then((response) => {
            console.log(response)
            response.json().then((data) => {
              console.log("items:", data['items']);
              let items = data['items']
              let sum = 0;
              for (var i = 0; i < items.length; i++) {
                  sum += items[i].amount * items[i].book.curCost
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
                <SearchBar />
                <div className='cart-items'>
                {
                    items.map((item) => (
                        <CartItem
                        bookID = {item.book.id}
                        cur_cost = {item.book.curCost}
                        name = {item.book.name}
                        author = {item.book.author}
                        ammount = {item.amount}
                        front_page = {item.book.frontpage}
                        cartID = {item.id}
                        stock = {item.book.stock}
                        setSum = {this.setCostsum}
                        key = {item.book.id}
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
                    <Button type="primary"><Link to="/dealcfm">进入结算中心 <Icon type="arrow-right" /></Link></Button>
                </div>
                <div className='white-space'>&nbsp;</div>
                <Footer />
            </div>
        )
    }
}

export default ShoppingCart