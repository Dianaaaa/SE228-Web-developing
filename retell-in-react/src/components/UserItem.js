import React, { Component } from 'react'
import {Row, Col,Icon, Divider, Button} from 'antd'
import './UserEdit.css'

class UserItem extends Component {

    state = {
        status: 0
    }

    onBanUser = (user) => {
        fetch(
            'http://localhost:8080/user/ban/' + user.username, {
              method:'POST',
              credentials: 'include' 
            }).then((response) => {
                this.setState(() => ({
                    status: 0
                  }))
            })
            .catch(e => console.log('错误:', e)
            )
        // alert("delete!")
    }

    onRebanUser = (user) => {
        fetch(
            'http://localhost:8080/user/reban/' + user.username, {
              method:'POST',
              credentials: 'include' 
            }).then((response) => {
                this.setState(() => ({
                    status: 1
                  }))
            })
            .catch(e => console.log('错误:', e)
            )
        // alert("delete!")
    }

    componentDidMount() {
        this.setState(() => ({
            status: this.props.user.status
          }))
    }

    render() {
        const {user} = this.props
        const {status} = this.state
        return (
            <div className="user-item">
                <li className='users-list-item'>
                        <Row>
                            <Col span={4}>
                                <div className='users-list-item-img'>
                                    <img src={user.avator} alt='user'/>
                                </div>
                            </Col>
                            <Col span={12}>
                            <div className='contact-details'>
                                <p>用户名：{user.username}</p>
                                <p>Role: {user.role}</p>
                                <p>状态： {status === 1 ? "正常": "已禁用"}</p>
                            </div>
                            </Col>
                            <Col span={8}>
                            {user.role === "ADMIN" ?
                            (<div></div>):
                            (status === 1 ?
                            (<Button type="danger"
                                onClick={() => this.onBanUser(user)}
                            ><Icon type="close-circle" />禁用该用户</Button>):
                            (<Button onClick={() => this.onRebanUser(user)}>取消禁用</Button>))
                            }
                            </Col>
                        </Row>
                        <Divider />
                        </li>
            </div>
        )
    }
}

export default UserItem;