import React, { Component } from 'react'
import { Breadcrumb } from 'antd'
import { Link } from 'react-router-dom'
import { Menu, Dropdown, Icon, Row, Col } from 'antd'
import './Navigator.css';

class Navigator extends Component {
    state = {
        username: "未登录",
        flag: 0
    }
    
    ChangeArea = (e) => {
        e.preventDefault()
        this.props.onChangeArea(e.target.innerHTML)
        console.log(e.target.innerHTML)
    }

    pvtDefault = (e) => {
        e.preventDefault()
    }

    componentDidMount() {
        fetch(
            'http://localhost:8080/getname', {
              method:'GET',
              credentials: 'include'         //解决跨域问题
            }).then((response) => {
              console.log(response)
              if (response.status === 200) {
                response.json().then((data) => {
                    console.log(data['name']);
                    this.setState(() => ({
                      username: data['name'],
                    }))
                    fetch(
                        'http://localhost:8080/checkadmin', {
                          method:'GET',
                          credentials: 'include'         //解决跨域问题
                        }).then((response) => {
                          console.log(response)
                          if (response.status === 200) {
                            response.json().then((data) => {
                                this.setState(() => ({
                                  flag: data['flag'],
                                }))
                                console.log(this.state.flag)
                              });
                          } else {
                              console.log("未登录")
                          }
                          
                        })
                        .catch(e => console.log('错误:', e)
                        )
                  });
              } else {
                  console.log("未登录")
              }
              
            })
            .catch(e => console.log('错误:', e)
            )
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
                <Link to="/mystat">我的统计</Link>
                </Menu.Item>
                <Menu.Item>
                    <Link to="/deal">我的订单</Link>
                </Menu.Item>
            </Menu>
        )

        return (
            <Row>
                <Breadcrumb>
                <Col span={8}>
                    <Breadcrumb.Item>
                        <Dropdown overlay={areaMenu} >
                            <a className="ant-dropdown-link" href="https://github.com/Dianaaaa" onClick={this.pvtDefault}>
                              地区：{curArea} <Icon type="down" />
                            </a>
                        </Dropdown>
                    </Breadcrumb.Item>
                </Col>
                <Col span={8} offset={8}>
                    <Breadcrumb.Item><Link to="/">Home</Link></Breadcrumb.Item>
                    <Breadcrumb.Item>
                        <Dropdown overlay={accountMenu} >
                            <Link className="ant-dropdown-link" to="/login">
                              {this.state.username} <Icon type="down" />
                            </Link>
                        </Dropdown>
                    </Breadcrumb.Item>
                    <Breadcrumb.Item><Link to="/cart"><Icon type="shopping-cart" /></Link></Breadcrumb.Item>
                    {this.state.flag === 1 ?
                            (<Breadcrumb.Item><Link to="/admin">管理中心</Link></Breadcrumb.Item>):
                            (<div></div>)}
                </Col>
                </Breadcrumb>
            </Row>
        )
    }
}

export default Navigator