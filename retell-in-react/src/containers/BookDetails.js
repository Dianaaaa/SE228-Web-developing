import React, { Component } from 'react'
import Navigator from './../components/Navigator'
import Comment from './../components/Comment'
import Footer from './../components/Footer'
import {Col, Input, Row, Divider, Rate, Tooltip, Button, Tabs} from 'antd'
import './BookDetails.css'

const TabPane = Tabs.TabPane;

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
      if ((!Number.isNaN(value) && reg.test(value)) || value === '' || value === '-') {
        this.props.onChange(value);
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
      return <NumericInput style={{ width: 120 }} value={this.state.value} onChange={this.onChange} />;
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
    img_url: './../assets/imgs/book-4.jpg'
  }


  componentDidMount() {
  fetch(
    'http://localhost:8080/book/' + this.props.match.params.id, {
      method:'GET',
    }).then((response) => {
      console.log(response)
      response.json().then((data) => {
        console.log(data);
        this.setState(() => ({
          book_name: data['book-name'],
          author: data['author'],
          prev_cost: data['prev-cost'],
          cur_cost: data['cur-cost'],
          book_detail: data['book-detail'],
          author_detail: data['author-detail'],
          img_url: data['img-url']
        }))
      });
    })
    .catch(e => console.log('错误:', e)
    )
  }

    render () {
      const { book_name, author, prev_cost, cur_cost, book_detail, author_detail, img_url } = this.state
        const { areas, curArea, onChangeArea } = this.props
        console.log(this.props);
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
                <div className='retell-view-search-bar'>
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
                </div>
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
                                        <span class='book-title'><p>{book_name}</p></span>
                                        <span class='book-writer'><p>作者：{author} <Rate disabled defaultValue={4.5} /></p></span>
                                        <Divider />
                                        <div className= 'book-cost'>
                                            <span className='cur-cost'>￥{cur_cost}</span><span className='prev-cost'>￥{prev_cost}</span>
                                        </div>

                                    </div>
                                    <div className='book-buttons'>
                                        <p>数量:</p>
                                        <NumericInputDemo />
                                        <Button type="primary">加入购物车</Button>
                                        <Button type="primary">立即购买</Button>
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
                            <Comment />
                            <Comment />
                            <Comment />
                            <Comment />
                            <Comment />
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

export default BookDetails