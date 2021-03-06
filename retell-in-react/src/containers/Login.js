import React, { Component } from 'react'
import { Link, withRouter } from 'react-router-dom'
import './Login.css'
import logo from './../assets/logo.png'

import {
    Form, Icon, Input, Button, Checkbox,
  } from 'antd'

  class NormalLoginForm extends React.Component {
    handleSubmit = (e) => {
      e.preventDefault();
      this.props.form.validateFields((err, values) => {
        if (!err) {
          console.log('Received values of form: ', values);
          let username = values.userName
          let password = values.password
          console.log('username', username)
          console.log('password', password)
          let path = 'http://localhost:8080/login';
          const formData = new URLSearchParams();
          formData.append('username', username);
          formData.append('password', password);
          console.log(formData.toString())
          console.log(path)
          fetch(
            path, {
              headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
              },
              method:'POST',
              body: formData.toString(),
              credentials: 'include'         //解决跨域问题
            }).then((response) => {
                console.log(response)
                if (response.status === 200) {
                  fetch(
                    "http://localhost:8080/msg", {
                      method: "GET",
                      credentials: 'include'
                    }
                  ).then((response) => {
                    if (response.status === 200) {
                      this.props.history.push("/")
                    window.location.href = window.location.href;
                    } else {
                      alert("用户不存在或已被禁用")
                    }
                  })
                  
                } else {
                    console.log("error")
                }
            })
            .catch(e => console.log('错误:', e)
            )
        }
      });
    }
  
    render() {
      const { getFieldDecorator } = this.props.form;
      return (
        <Form onSubmit={this.handleSubmit} className="login-form">
          <Form.Item>
            {getFieldDecorator('userName', {
              rules: [{ required: true, message: 'Please input your username!' }],
            })(
              <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />} placeholder="Username" />
            )}
          </Form.Item>
          <Form.Item>
            {getFieldDecorator('password', {
              rules: [{ required: true, message: 'Please input your Password!' }],
            })(
              <Input prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />} type="password" placeholder="Password" />
            )}
          </Form.Item>
          <Form.Item>
            {getFieldDecorator('remember', {
              valuePropName: 'checked',
              initialValue: true,
            })(
              <Checkbox>Remember me</Checkbox>
            )}
            <p className="login-form-forgot" href="">Forgot password</p>
            <Button type="primary" htmlType="submit" className="login-form-button">
              Log in
            </Button>
            Or <Link to='/signin'>register now!</Link>
          </Form.Item>
        </Form>
      );
    }
  }
  
  const WrappedNormalLoginForm = withRouter(Form.create({ name: 'normal_login' })(NormalLoginForm));
  

class Login extends Component {

    render () {
        return (
            
            <div className='log-in'> 
                <div className='retell-logo'>
                    <Link to='/'><img src={logo} alt='Retell Logo'/></Link>
                </div>
                <div className='log-in-box'>
                    <WrappedNormalLoginForm/>
                </div>
                <div className='log-in-footer'>
                    <div className="a-divider a-divider-section"><div className="a-divider-inner"></div></div>
                    <div>
                      Link
                    </div>
                </div>
            </div>
        )
    }
}

export default Login