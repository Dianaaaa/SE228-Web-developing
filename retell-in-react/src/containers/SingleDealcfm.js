import React, {Component} from 'react'
import {withRouter} from 'react-router-dom'
import {Card, Form, Input, Row, Col, Button} from 'antd'
import './SingleDealcfm.css'
import Footer from "../components/Footer"
import BookItem from "../components/Deal/BookItem"

window.backpath = "http://localhost:8080"

const Phoneform = Form.create({
    name: 'global_state',
    onFieldsChange(props, changedFields) {
      props.onChange(changedFields);
    },
    mapPropsToFields(props) {
      return {
        phone: Form.createFormField({
          ...props.phone,
          value: props.phone.value,
        }),
      };
    },
    onValuesChange(_, values) {
      console.log(values);
    },
  })((props) => {
    const { getFieldDecorator } = props.form;
    return (
      <Form layout="inline">
        <Form.Item label="phone number">
          {getFieldDecorator('phone', {
            rules: [{ required: true, message: 'Phone number is required!' }],
          })(<Input />)}
        </Form.Item>
      </Form>
    );
  });

  const Addressform = Form.create({
    name: 'global_state',
    onFieldsChange(props, changedFields) {
      props.onChange(changedFields);
    },
    mapPropsToFields(props) {
      return {
        address: Form.createFormField({
          ...props.address,
          value: props.address.value,
        }),
      };
    },
    onValuesChange(_, values) {
      console.log(values);
    },
  })((props) => {
    const { getFieldDecorator } = props.form;
    return (
      <Form layout="inline">
        <Form.Item label="address">
          {getFieldDecorator('address', {
            rules: [{ required: true, message: 'address is required!' }],
          })(<Input />)}
        </Form.Item>
      </Form>
    );
  });

  const Receiverform = Form.create({
    name: 'global_state',
    onFieldsChange(props, changedFields) {
      props.onChange(changedFields);
    },
    mapPropsToFields(props) {
      return {
        receiver: Form.createFormField({
          ...props.receiver,
          value: props.receiver.value,
        }),
      };
    },
    onValuesChange(_, values) {
      console.log(values);
    },
  })((props) => {
    const { getFieldDecorator } = props.form;
    return (
      <Form layout="inline">
        <Form.Item label="receiver">
          {getFieldDecorator('receiver', {
            rules: [{ required: true, message: 'receiver is required!' }],
          })(<Input />)}
        </Form.Item>
      </Form>
    );
  });
  

class SingleDealcfm extends Component {
    state = {
        fields: {
          phone: {
            value: "",
          },
          address: {
              value: ""
          },
          receiver: {
              value: ""
          },
        },
        item: {},
        costsum: 0,
      };

      handleFormChange = (changedFields) => {
        this.setState(({ fields }) => ({
          fields: { ...fields, ...changedFields },
        }));
      }

      handleDealcfm = () => {
          console.log("cfm")
          const {item} = this.props.location.state
          console.log(item)
          let bookID = item.bookID
          let ammount = item.ammount
          let phone = this.state.fields.phone.value
          let addr = this.state.fields.address.value
          let receiver = this.state.fields.receiver.value
          let price = item.costsum
          if (phone === "" || addr === "") {
              alert("信息不全！确认失败。请填写信息")
              return
          }
          console.log(addr)
          const formData = JSON.stringify({"phone": phone, "address": addr, "tot_price": price, "receiver": receiver})
          console.log(formData)
          fetch(
            window.backpath + "/deal/create/" + bookID + "/" + ammount, {
              headers: {
                  'Content-Type': 'application/json'
              },
              method:'POST',
              body: formData,
              credentials: 'include'         //解决跨域问题
            }).then((response) => {
                console.log(response)
                if (response.status === 200) {
                    alert("购买成功！")
                  this.props.history.push("/deal")
                } else {
                    console.log("error")
                    alert(response.msg)
                }
            })
            .catch(e => console.log('错误:', e)
            )
      }

    render() {
        const {fields} = this.state;
        const {item} = this.props.location.state
        // const costsum = item.cur_cost * item.ammount
        // console.log("item", item)
        return (
            <div className="dealcfm">
                <div className="dealcfm-card">
                    <Card
                      title="请确认订单"
                    >
                        <BookItem 
                        bookID = {item.bookID}
                        cur_cost = {item.cur_cost}
                        name = {item.name}
                        author = {item.author}
                        ammount = {item.ammount}
                        front_page = {item.front_page}
                        key = {item.bookID}
                        />
                        <div className="price-card">
                            <Card>
                                <p>总计：<span className='cur-cost'>{item.costsum.toFixed(2)}</span></p>
                            </Card>
                        </div>
                        <div className="deal-form">
                        <Row>
                            <div className="receiver">
                            <Col span={8}>
                            <Receiverform {...fields} onChange={this.handleFormChange} />
                            </Col>
                            </div>
                            <Col span={8}>
                            <Phoneform {...fields} onChange={this.handleFormChange} />
                            </Col>
                            <Col span={8}>
                            <div className="addr">
                            <Addressform {...fields} onChange={this.handleFormChange} />
                            </div>
                            </Col>

                        </Row>
                        </div>
                        
                        <Button type="primary" onClick={this.handleDealcfm}>提交订单</Button>
                    </Card>
                </div>
                <Footer />
            </div>
        )
    }

}

export default withRouter(SingleDealcfm)