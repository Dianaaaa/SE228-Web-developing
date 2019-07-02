import React, { Component } from 'react'
import {withRouter} from 'react-router-dom'
import Comment from './../components/Comment'
import Footer from './../components/Footer'
import {Col, Input, Row, Divider, Rate, Tooltip, Button, Tabs} from 'antd'
import './BookDetails.css'
import SearchBar from '../components/SearchBar';

const TabPane = Tabs.TabPane;
const { TextArea } = Input;
window.backpath = "http://localhost:8080"

function formatNumber(value) {
    value += '';
    const list = value.split('.');
    const prefix = list[0].charAt(0) === '-' ? '-' : '';
    let num = prefix ? list[0].slice(1) : list[0];
    let result = '';
    while (num.length > 3) {
      result = `,${num.slice(-3)}${result}`;
      num = num.slice(0, num.length - 3);
    }
    if (num) {
      result = num + result;
    }
    return `${prefix}${result}${list[1] ? `.${list[1]}` : ''}`;
  }
  
  class NumericInput extends React.Component {
    onChange = (e) => {
      const { value } = e.target;
      const reg = /^-?(0|[1-9][0-9]*)(\.[0-9]*)?$/;
      if ((!Number.isNaN(value) && reg.test(value)) || value === '' || value === '-' || value < 1 || value > 99) {
        this.props.onChange(value);
        this.props.setammount(value);
      }
    }
  
    // '.' at the end or only '-' in the input box.
    onBlur = () => {
      const { value, onBlur, onChange } = this.props;
      if (value.charAt(value.length - 1) === '.' || value === '-') {
        onChange(value.slice(0, -1));
      }
      if (onBlur) {
        onBlur();
      }
    }
  
    render() {
      const { value } = this.props;
      const title = value ? (
        <span className="numeric-input-title">
          {value !== '-' ? formatNumber(value) : '-'}
        </span>
      ) : 'Input a number';
      return (
        <Tooltip
          trigger={['focus']}
          title={title}
          placement="topLeft"
          overlayClassName="numeric-input"
        >
          <Input
            {...this.props}
            onChange={this.onChange}
            onBlur={this.onBlur}
            placeholder="Input a number"
            maxLength={25}
          />
        </Tooltip>
      );
    }
  }
  
  class NumericInputDemo extends React.Component {

    constructor(props) {
      super(props);
      this.state = { value: '' };
    }
  
    onChange = (value) => {
      this.setState({ value });
    }
  
    render() {
      return <NumericInput style={{ width: 120 }} value={this.state.value} onChange={this.onChange} setammount = {this.props.setammount}/>;
    }
  }

class BookDetails extends Component {

  state = {
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

  setammount = (value) => {
    this.setState(() => ({
      ammount: value
    }))
  }

  handleCart = () => {
    if (this.state.stock === 0 || this.state.stock < this.state.ammount) {
      alert("库存不足！")
      return
    }
    let bookID = this.props.match.params.id;
    fetch(
      window.backpath + "/cart/add/" + bookID + "/" + this.state.ammount, {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        method:'POST',
        // body: formData.toString(),
        credentials: 'include'         //解决跨域问题
      }).then((response) => {
          console.log(response)
          if (response.status === 200) {
            // this.props.history.push("/")
            alert("成功加入购物车")
          } else {
              console.log("error")
          }
      })
      .catch(e => console.log('错误:', e)
      )

  }

  handleDeal = () => {
    let ammount = this.state.ammount
    let stock = this.state.stock
    if (ammount > stock || stock === 0) {
      alert("库存不足！")
      return
    }

    let bookID = this.props.match.params.id;
    let name = this.state.book_name
    let author = this.state.author
    let cur_cost = this.state.cur_cost
    let front_page = this.state.img_url
    let costsum = ammount * cur_cost
    const item = {bookID: bookID, name: name, author: author, ammount: ammount, cur_cost: cur_cost, front_page: front_page, costsum: costsum}
    this.props.history.push({ pathname : '/dealcfmsingle' ,state : { item: item} })
  }

  handleComment = () => {
    let bookID = this.props.match.params.id;
    let score = this.state.starvalue
    let content = this.state.content
    const formData = JSON.stringify({"score": score, "bookID": bookID, "content": content})
    fetch(
      window.backpath + "/addcommentm", {
        headers: {
            'Content-Type': 'application/json'
        },
        method:'POST',
        body: formData,
        credentials: 'include'         //解决跨域问题
      }).then((response) => {
          console.log(response)
          if (response.status === 200) {
            // this.props.history.push("/")
            alert("评论成功！")
            window.location.href = window.location.href;
          } else {
              console.log("error")
          }
      })
      .catch(e => console.log('错误:', e)
      )

  }

  handleStarChange = (starvalue) => {
    this.setState({ starvalue });
  }

  handleContentChange = (event) => {
    this.setState({ content: event.target.value });
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
          ISBN: data['ISBN']
        }))

      });
      fetch(
        'http://localhost:8080/commentm/' + this.props.match.params.id, {
          method:'GET',
        }).then((response) => {
          console.log(response)
          response.json().then((data) => {
            console.log(data['comments']);
            this.setState(() => ({
              comments: data['comments']
            }))
          });
        })
        .catch(e => console.log('错误:', e)
        )
      })
    .catch(e => console.log('错误:', e)
    )

    
  }

    render () {
      const { book_name, author, prev_cost, cur_cost, book_detail, author_detail, img_url, comments, starvalue, content, stock, ISBN } = this.state
        // console.log(this.props);
        return (
            <div className='book-details'>
                {/* <Navigator 
                    areas = {areas}
                    curArea = {curArea}
                    onChangeArea = {onChangeArea}
                /> */}
                <div className='img-decoration'>
                    <img src={require('./../assets/imgs/retell-3.jpg')} alt='retell-2'/>
                </div>
                <SearchBar />
                {/* <div className='retell-view-search-bar'>
                    <Col span={4}>
                        <img src={require('./../assets/logo.png')} alt='logo' className='retell-logo'/>
                    </Col>
                    <Col span={4} offset={8}>
                        <Input.Search
                          placeholder="input search text"
                          onSearch={value => console.log(value)}
                          enterButton
                        />
                    </Col>
                </div> */}
                <div className='white-space'> &nbsp;</div>
                <Row>
                    <Col span={1}/>
                    <Col span={17}>
                        <div className='buy-section'>
                            <Row>
                                <Col span={8}>
                                    <div className='book-img'>
                                        <img src={img_url} alt='book'/>
                                    </div>
                                </Col>
                                <Col span={16}>
                                    <div className='book-text'>
                                        <span className='book-title'><p>{book_name}</p></span>
                                        <span className='book-writer'>作者：{author} <Rate disabled defaultValue={4.5} /></span>
                                        <Divider />
                                        <div className= 'book-cost'>
                                            <span className='cur-cost'>￥{cur_cost}</span><span className='prev-cost'>￥{prev_cost}</span>
                                        </div>

                                    </div>
                                    <div className='book-buttons'>
                                        <p>ISBN: {ISBN} </p>
                                        <p>库存: {stock}</p>
                                        <p>数量:</p>
                                        <NumericInputDemo 
                                        setammount = {this.setammount}
                                        />
                                        <Button type="primary" onClick={this.handleCart}>加入购物车</Button>
                                        <Button type="primary" onClick={this.handleDeal}>立即购买</Button>
                                    </div>
                                </Col>
                                
                            </Row>
                        </div>
                        
                        <div className='detail-section'>
                        <Tabs type="card">
                          <TabPane tab="图书信息" key="1">
                            <p>{book_detail}</p>
                          </TabPane>
                          <TabPane tab="作者信息" key="2">
                            <p>{author_detail}</p>
                            </TabPane>
                        </Tabs>
                        </div>
                        <div className='comments-section'>
                        {
                          comments.map((com) => (
                            <Comment 
                            content = {com.content}
                            score = {com.score}
                            time = {com.time}
                            username = {com.username}
                            key = {com.ID}
                            />
                          ))
                        }
                            {/* <Comment 
                            id = {this.props.match.params.id}
                            /> */}
                        </div>

                        <div className="add-comment">
                            <Row>
                              <Col span={6}>
                                <span className="add-comment-title">快来评论吧：</span>
                              </Col>
                              <Col span={12}>
                                <Rate onChange={this.handleStarChange} value={starvalue}/>
                                <br/>
                                <TextArea rows={4} onChange={this.handleContentChange} value={content}/>
                                
                              </Col>
                              <Col span={4}>
                              <div className="comment-button">
                              <Button onClick={this.handleComment}>提交评论</Button>
                              </div>
                              </Col>
                            </Row>
                        </div>
                    </Col>
                    <Col span={1}>
                    <Divider type="vertical" />
                    </Col>
                    <Col span={5}>
                        <div className='ad-section'>
                            <img alt='add-1' src={require('./../assets/imgs/ad-1.jpg')}/>
                            <img alt='add-2' src={require('./../assets/imgs/ad-2.jpg')}/>
                            <img alt='add-1' src={require('./../assets/imgs/ad-1.jpg')}/>
                            <img alt='add-2' src={require('./../assets/imgs/ad-2.jpg')}/>
                        </div>
                    </Col>
                </Row>
                <Footer />
            </div>
        )
    }
}

export default withRouter(BookDetails)