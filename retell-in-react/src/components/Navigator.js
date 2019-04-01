import React, { Component } from 'react'
import { Breadcrumb } from 'antd'
import { Link } from 'react-router-dom'
import { Menu, Dropdown, Icon, Row, Col } from 'antd'
import './Navigator.css';

class Navigator extends Component {
    
    ChangeArea = (e) => {
        e.preventDefault()
        this.props.onChangeArea(e.target.innerHTML)
        console.log(e.target.innerHTML)
    }

    render () {

        const { areas, curArea} = this.props

        

        const areaMenu = (
            <Menu>
            {areas.map((area) => (
                <Menu.Item key={area.name}>
                    <a target="_blank" rel="noopener noreferrer" href="https://github.com/Dianaaaa" onClick={this.ChangeArea}>{area.name}</a>
                </Menu.Item>
            ))}
            </Menu>
        )

        const accountMenu = (
            <Menu>
                <Menu.Item>
                    <a target="_blank" rel="noopener noreferrer" href="https://github.com/Dianaaaa">我的账户</a>
                </Menu.Item>
                <Menu.Item>
                    <a target="_blank" rel="noopener noreferrer" href="https://github.com/Dianaaaa">我的订单</a>
                </Menu.Item>
                <Menu.Item>
                    <a target="_blank" rel="noopener noreferrer" href="https://github.com/Dianaaaa">我的收藏</a>
                </Menu.Item>
            </Menu>
        )

        return (
            <Row>
                <Breadcrumb>
                <Col span={8}>
                    <Breadcrumb.Item>
                        <Dropdown overlay={areaMenu} >
                            <Link className="ant-dropdown-link" to="/">
                              地区：{curArea} <Icon type="down" />
                            </Link>
                        </Dropdown>
                    </Breadcrumb.Item>
                </Col>
                <Col span={8} offset={8}>
                    <Breadcrumb.Item><Link to="/">Home</Link></Breadcrumb.Item>
                    <Breadcrumb.Item>
                        <Dropdown overlay={accountMenu} >
                            <Link className="ant-dropdown-link" to="/login">
                              我的RETELL <Icon type="down" />
                            </Link>
                        </Dropdown>
                    </Breadcrumb.Item>
                    <Breadcrumb.Item><Link to="/react"><Icon type="shopping-cart" /></Link></Breadcrumb.Item>
                    <Breadcrumb.Item><Link to="/react">卖家中心</Link></Breadcrumb.Item>
                </Col>
                </Breadcrumb>
            </Row>
        )
    }
}

export default Navigator