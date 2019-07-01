import React, { Component } from 'react'
import { Upload, message, Button, Icon, Input, Form, Select} from 'antd'
import { Link, withRouter } from 'react-router-dom'
import './BookEdit.css'

const { Option } = Select;
const { TextArea } = Input;

const props = {
    name: 'file',
    action: 'https://www.mocky.io/v2/5cc8019d300000980a055e76',
    headers: {
      authorization: 'authorization-text',
    },
    onChange(info) {
      if (info.file.status !== 'uploading') {
        console.log(info.file, info.fileList);
      }
      if (info.file.status === 'done') {
        message.success(`${info.file.name} file uploaded successfully`);
      } else if (info.file.status === 'error') {
        message.error(`${info.file.name} file upload failed.`);
      }
    },
  };


  
  class EBookForm extends React.Component {

    state = {
        id : 0,
        book_name : '',
        author : '',
        prev_cost: '',
        cur_cost: '',
        book_detail: '',
        author_detail: '',
        img_url: './../assets/imgs/book-4.jpg',
        comments: [],
        stock:0,
        ammount: 1,
        starvalue: 0,
        content: "",
        ISBN: ""
      }
    handleSubmit = (e) => {
      e.preventDefault();
      this.props.form.validateFields((err, values) => {
        if (!err) {
          console.log('Received values of form: ', values);
          let path = 'http://localhost:8080/updatebook/' + this.state.id;
          fetch(
            path, {
              headers: {
                  'Content-Type': 'application/json'
              },
              method:'POST',
              body: JSON.stringify(values),
              credentials: 'include'         //解决跨域问题
            }).then((response) => {
                console.log(response)
                if (response.status === 200) {
                    alert("修改成功")
                    this.props.history.push(`/admin`)
                } else {
                    console.log("error")
                }
            })
            .catch(e => console.log('错误:', e)
            )
        }
      });
    }
    
    componentDidMount() {
        fetch(
          'http://localhost:8080/book/' + this.props.match.params.id, {
            method:'GET',
          }).then((response) => {
            console.log(response)
            response.json().then((data) => {
              // console.log(data);
              this.setState(() => ({
                book_name: data['book-name'],
                author: data['author'],
                prev_cost: data['prev-cost'],
                cur_cost: data['cur-cost'],
                book_detail: data['book-detail'],
                author_detail: data['author-detail'],
                img_url: data['img-url'],
                stock: data['stock'],
                ISBN: data['ISBN'],
                id: data['id']
              }))
      
            });
            })
          .catch(e => console.log('错误:', e)
          )
      
          
        }


    render() {
      const { getFieldDecorator } = this.props.form;
      const formItemLayout = {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 4 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 20 },
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
      return (
        <Form {...formItemLayout} onSubmit={this.handleSubmit} className="login-form">
          <Form.Item
            label="BookName"
          >
            {getFieldDecorator('name', {
              rules: [{ required: true, message: 'Please input the book name!' }],
              initialValue: this.state.book_name,
            })(
              <Input placeholder="Book Name"/>
            )}
          </Form.Item>
          <Form.Item
            label="Author"
          >
            {getFieldDecorator('author', {
              rules: [{ required: true, message: 'Please input the author of this book!' }],
              initialValue: this.state.author,
            })(
              <Input placeholder="Author"/>
            )}
          </Form.Item>
          <Form.Item
            label="Author Detail"
          >
            {getFieldDecorator('author_detail', {
              rules: [{ required: true, message: 'Please input the author detail!' }],
              initialValue: this.state.author_detail,
            })(
              <TextArea placeholder="Author Detail"/>
            )}
          </Form.Item>
          <Form.Item
            label="ISBN"
          >
            {getFieldDecorator('ISBN', {
              rules: [{ required: true, message: 'Please input ISBN of this book!' }],
              initialValue: this.state.ISBN,
            })(
              <Input placeholder="ISBN"/>
            )}
          </Form.Item>
          <Form.Item
            label="Book Detail"
          >
            {getFieldDecorator('book_detail', {
              rules: [{ required: true, message: 'Please input the book detail!' }],
              initialValue: this.state.book_detail,
            })(
              <TextArea placeholder="Book Detail"/>
            )}
          </Form.Item>
          <Form.Item
            label="Stock"
          >
            {getFieldDecorator('stock', {
              rules: [{ required: true, message: 'Please input stock of this book!' }],
              initialValue: this.state.stock,
            })(
              <Input placeholder="stock"/>
            )}
          </Form.Item>
          <Form.Item
            label="Previous Cost"
          >
            {getFieldDecorator('prev_cost', {
              rules: [{ required: true, message: 'Please input the previors cost of this book!' }],
              initialValue: this.state.prev_cost,
            })(
              <Input placeholder="Previous Cost"/>
            )}
          </Form.Item>
          <Form.Item
            label="Current Cost"
          >
            {getFieldDecorator('cur_cost', {
              rules: [{ required: true, message: 'Please input the current cost of this book!' }],
              initialValue: this.state.cur_cost,
            })(
              <Input placeholder="Current Cost"/>
            )}
          </Form.Item>
          <Form.Item
            label="Category"
          >
            {getFieldDecorator('cate', {
              rules: [{ required: true, message: 'Please select the category of this book!' }],
              initialValue: this.state.cate,
            })(
                <Select>
                    <Option value="1">计算机</Option>
                    <Option value="2">小说</Option>
                    <Option value="3">文学</Option>
                    <Option value="4">人文社科</Option>
                    <Option value="5">医学</Option>
                    <Option value="6">教辅</Option>
                    <Option value="7">艺术</Option>
                    <Option value="8">生活</Option>
                    <Option value="9">进口原版</Option>
                </Select>
            )}
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit" className="login-form-button">
              修改
            </Button>
          </Form.Item>
        </Form>
      );
    }
  }
  
  const EditBookForm = withRouter(Form.create({ name: 'normal_login' })(EBookForm));


class BookEdit extends Component {

    render() {
        return (
            <div className="bookcreate">
                <div className="bookform">
                    {/* <div className="imgupload">
                    <Upload {...props}>
                        <Button>
                            <Icon type="upload" /> Click to Upload
                        </Button>
                        
                    </Upload>
                    </div> */}
                    <EditBookForm />
                </div>
            </div>
        )
    }

} 
export default BookEdit