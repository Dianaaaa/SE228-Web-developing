import React, { Component } from 'react'
import './Footer.css'
import {Row, Col, Icon} from 'antd'

class Footer extends Component {
    render () {
        return (
            <div className='retell-footer'>
                <div className='decoration-line'>&nbsp;</div>
                <div className='foot-ad'>
                    <Row>
                        <Col span={4} offset={4}><Icon type="check-circle" /></Col>
                        <Col span={4}><Icon type="check-square" /></Col>
                        <Col span={4}><a href='https://github.com/Dianaaaa'><Icon type="github" /></a></Col>
                        <Col span={4}><Icon type="share-alt" /></Col>
                    </Row>
                </div>
                <div className='footer-nav'>
                    <Row>
                        <Col span={4} offset={4}>
                            <h1>了解我们</h1>
                            <ul>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                            </ul>
                        </Col>
                        <Col span={4}>
                            <h1>合作信息</h1>
                            <ul>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                            </ul>
                        </Col>
                        <Col span={4}>
                            <h1>支付方式</h1>
                            <ul>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                            </ul>
                        </Col>
                        <Col span={4}>
                            <h1>帮助中心和购物指南</h1>
                            <ul>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                                <li>LINK</li>
                            </ul>
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}

export default Footer