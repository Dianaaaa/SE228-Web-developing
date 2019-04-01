import React, { Component } from 'react'
import Navigator from './../components/Navigator'
import CartItem from './../components/CartItem'
import Footer from './../components/Footer'
import { Button, Icon, Col} from 'antd'
import './ShoppingCart.css'

class ShoppingCart extends Component {

    render () {
        const { areas, curArea, onChangeArea } = this.props
        return (
            <div className='shopping-cart'>
                <Navigator 
                    areas = {areas}
                    curArea = {curArea}
                    onChangeArea = {onChangeArea}
                />
                <div className='img-decoration'>
                    <img src={require('./../assets/imgs/cart.jpg')} alt='retell-2'/>
                </div>
                <div className='cart-items'>
                    <CartItem/>
                    <CartItem/>
                    <CartItem/>
                </div>
                <div className='cart-button'>
                    <Col span={16}>
                    <div className='total'>
                        <p>总价：<span className='cur-cost'>222</span></p>
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