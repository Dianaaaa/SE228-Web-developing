import React, {Component} from 'react'
import {Card, Form, Input, Row, Col, Button} from 'antd'
import './Dealcfm.css'
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
  

class Dealcfm extends Component {
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
        items: [],
        costsum: 0,
      };

      handleFormChange = (changedFields) => {
        this.setState(({ fields }) => ({
          fields: { ...fields, ...changedFields },
        }));
      }

      handleDealcfm = () => {
          console.log("cfm")
          let phone = this.state.fields.phone.value
          let addr = this.state.fields.address.value
          let receiver = this.state.fields.receiver.value
          let price = this.state.costsum
          if (phone === "" || addr === "") {
              alert("信息不全！确认失败。请填写信息")
              return
          }
          console.log(addr)
          const formData = JSON.stringify({"phone": phone, "address": addr, "tot_price": price, "receiver": receiver})
          console.log(formData)
          fetch(
            window.backpath + "/deal/create", {
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
                    // window.location.href = window.location.href;
                    this.props.history.push("/deal")
                } else {
                    console.log("error")
                    alert(response.msg)
                }
            })
            .catch(e => console.log('错误:', e)
            )
      }

      componentDidMount() {
        fetch(
          'http://localhost:8080/cart', {
            method:'GET',
            credentials: 'include'         //解决跨域问题
          }).then((response) => {
            console.log(response)
            response.json().then((data) => {
              console.log(data['items']);
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
    render() {
        const {fields, costsum, items} = this.state;
        return (
            <div className="dealcfm">
                <div className="dealcfm-card">
                    <Card
                      title="请确认订单"
                    >
                        {
                            items.map((item) => (
                                <BookItem 
                                bookID = {item.book.id}
                                cur_cost = {item.book.curCost}
                                name = {item.book.name}
                                author = {item.book.author}
                                ammount = {item.amount}
                                front_page = {item.book.frontpage}
                                key = {item.book.id}
                                />
                            ))
                        }
                        {/* <BookItem />
                        <BookItem /> */}
                        <div className="price-card">
                            <Card>
                                <p>总计：<span className='cur-cost'>{costsum.toFixed(2)}</span></p>
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

export default Dealcfm