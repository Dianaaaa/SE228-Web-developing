import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import {Row} from 'antd'
import "./Deal.css"
import DealItem from "../components/Deal/DealItem"
import Footer from "../components/Footer"

class Deal extends Component {
    render() {
        return (
            <div className = "deal">
            <div className='img-decoration'>
                    <img src={require('./../assets/imgs/deal.jpg')} alt='deal'/>
            </div>
            <Row>
                <DealItem/>
            </Row>
            <Row>
                <DealItem/>
            </Row>
            <Row>
                    <Footer />
                </Row>
            </div>
        )
    }
}

export default Deal