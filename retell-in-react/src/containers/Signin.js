import React, { Component } from 'react'
import {Link, withRouter} from 'react-router-dom'
import {
    Form, Input,  Icon, Checkbox, Button
} from 'antd';
import './Signin.css'
import logo from './../assets/logo.png'

// const { Option } = Select;
// const AutoCompleteOption = AutoComplete.Option;

// const residences = [{
//   value: 'zhejiang',
//   label: 'Zhejiang',
//   children: [{
//     value: 'hangzhou',
//     label: 'Hangzhou',
//     children: [{
//       value: 'xihu',
//       label: 'West Lake',
//     }],
//   }],
// }, {
//   value: 'jiangsu',
//   label: 'Jiangsu',
//   children: [{
//     value: 'nanjing',
//     label: 'Nanjing',
//     children: [{
//       value: 'zhonghuamen',
//       label: 'Zhong Hua Men',
//     }],
//   }],
// }];

class RegistrationForm extends React.Component {
  state = {
    confirmDirty: false,
    autoCompleteResult: [],
  };

  /* ajax here */
  handleSubmit = (e) => {
    e.preventDefault();
    this.props.form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        // let formData = values;
        let path="http://localhost:8080/signin"
        console.log(values);
        fetch(
          path, {
            headers: {
                'Content-Type': 'application/json'
            },
            method:'POST',
            body: JSON.stringify(values),
          }).then(response => response.json())
          .then(responseJson => {
            console.log(responseJson);
              if (responseJson.status === 200) {
                console.log(responseJson.msg)
                alert("用户创建成功")
                this.props.history.push(`/login`)

              } else {
                console.log(responseJson.msg)
                alert(responseJson.msg)
              }
              return responseJson;
          })
          .catch(e => console.log('错误:', e)
        )

        console.log('Received values of form: ', values);
      }
    });
  }

  handleConfirmBlur = (e) => {
    const value = e.target.value;
    this.setState({ confirmDirty: this.state.confirmDirty || !!value });
  }

  compareToFirstPassword = (rule, value, callback) => {
    const form = this.props.form;
    if (value && value !== form.getFieldValue('password')) {
      callback('Two passwords that you enter is inconsistent!');
    } else {
      callback();
    }
  }

  validateToNextPassword = (rule, value, callback) => {
    const form = this.props.form;
    if (value && this.state.confirmDirty) {
      form.validateFields(['confirm'], { force: true });
    }
    callback();
  }

  handleWebsiteChange = (value) => {
    let autoCompleteResult;
    if (!value) {
      autoCompleteResult = [];
    } else {
      autoCompleteResult = ['.com', '.org', '.net'].map(domain => `${value}${domain}`);
    }
    this.setState({ autoCompleteResult });
  }

  render() {
    const { getFieldDecorator } = this.props.form;
    // const { autoCompleteResult } = this.state;

    const formItemLayout = {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 8 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 16 },
      },
    };
    const tailFormItemLayout = {
      wrapperCol: {
        xs: {
          span: 24,
          offset: 0,
        },
        sm: {
          span: 16,
          offset: 8,
        },
      },
    };
    // const prefixSelector = getFieldDecorator('prefix', {
    //   initialValue: '86',
    // })(
    //   <Select style={{ width: 70 }}>
    //     <Option value="86">+86</Option>
    //     <Option value="87">+87</Option>
    //   </Select>
    // );

    // const websiteOptions = autoCompleteResult.map(website => (
    //   <AutoCompleteOption key={website}>{website}</AutoCompleteOption>
    // ));

    return (
      <Form {...formItemLayout} onSubmit={this.handleSubmit}>
        <Form.Item
          label="username"
        >
            {getFieldDecorator('username', {
              rules: [{ required: true, message: 'Please input your username!' }],
            })(
              <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />} placeholder="Username" />
            )}
          </Form.Item>
        <Form.Item
          label="Password"
        >
          {getFieldDecorator('password', {
            rules: [{
              required: true, message: 'Please input your password!',
            }, {
              validator: this.validateToNextPassword,
            }],
          })(
            <Input type="password" />
          )}
        </Form.Item>
        <Form.Item
          label="Confirm Password"
        >
          {getFieldDecorator('confirm', {
            rules: [{
              required: true, message: 'Please confirm your password!',
            }, {
              validator: this.compareToFirstPassword,
            }],
          })(
            <Input type="password" onBlur={this.handleConfirmBlur} />
          )}
        </Form.Item>
        <Form.Item
          label="E-mail"
        >
          {getFieldDecorator('email', {
            rules: [{
              type: 'email', message: 'The input is not valid E-mail!',
            }, {
              required: true, message: 'Please input your E-mail!',
            }],
          })(
            <Input />
          )}
        </Form.Item>
        {/* <Form.Item
          label={(
            <span>
              Nickname&nbsp;
              <Tooltip title="What do you want others to call you?">
                <Icon type="question-circle-o" />
              </Tooltip>
            </span>
          )}
        >
          {getFieldDecorator('nickname', {
            rules: [{ required: true, message: 'Please input your nickname!', whitespace: true }],
          })(
            <Input />
          )}
        </Form.Item>
        <Form.Item
          label="Habitual Residence"
        >
          {getFieldDecorator('residence', {
            initialValue: ['zhejiang', 'hangzhou', 'xihu'],
            rules: [{ type: 'array', required: true, message: 'Please select your habitual residence!' }],
          })(
            <Cascader options={residences} />
          )}
        </Form.Item>
        <Form.Item
          label="Phone Number"
        >
          {getFieldDecorator('phone', {
            rules: [{ required: true, message: 'Please input your phone number!' }],
          })(
            <Input addonBefore={prefixSelector} style={{ width: '100%' }} />
          )}
        </Form.Item>
        <Form.Item
          label="Website"
        >
          {getFieldDecorator('website', {
            rules: [{ required: true, message: 'Please input website!' }],
          })(
            <AutoComplete
              dataSource={websiteOptions}
              onChange={this.handleWebsiteChange}
              placeholder="website"
            >
              <Input />
            </AutoComplete>
          )}
        </Form.Item>
        <Form.Item
          label="Captcha"
          extra="We must make sure that your are a human."
        >
          <Row gutter={8}>
            <Col span={12}>
              {getFieldDecorator('captcha', {
                rules: [{ required: true, message: 'Please input the captcha you got!' }],
              })(
                <Input />
              )}
            </Col>
            <Col span={12}>
              <Button>Get captcha</Button>
            </Col>
          </Row>
        </Form.Item> */}
        <Form.Item {...tailFormItemLayout}>
          {getFieldDecorator('agreement', {
            valuePropName: 'checked',
          })(
            <Checkbox>I have read the <a href="https://github.com">agreement</a></Checkbox>
          )}
        </Form.Item>
        <Form.Item {...tailFormItemLayout}>
          <Button type="primary" htmlType="submit">Register</Button>
        </Form.Item>
      </Form>
    );
  }
}

const WrappedRegistrationForm = withRouter(Form.create({ name: 'register' })(RegistrationForm));

class Signin extends Component {
    
    render () {
        return (
            <div className='sign-in'>
                <div className='retell-logo'>
                    <Link to='/'><img src={logo} alt='Retell Logo'/></Link>
                </div>
                <div className='sign-in-box'>
                    <WrappedRegistrationForm 
                    />
                </div>
                <div className='sign-in-footer'>
                    <div className="a-divider a-divider-section"><div className="a-divider-inner"></div></div>
                    <div>
                      Link
                    </div>
                </div>
            </div>
        )
    }
}

export default Signin