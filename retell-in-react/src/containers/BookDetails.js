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
    render () {
        const { areas, curArea, onChangeArea } = this.props
        return (
            <div className='book-details'>
                <Navigator 
                    areas = {areas}
                    curArea = {curArea}
                    onChangeArea = {onChangeArea}
                />
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
                                        <img src={require('./../assets/imgs/book-4.jpg')} alt='book'/>
                                    </div>
                                </Col>
                                <Col span={16}>
                                    <div className='book-text'>
                                        <span class='book-title'><p>偷书贼（The Book Thief）</p></span>
                                        <span class='book-writer'><p>作者：Markus Zursak <Rate disabled defaultValue={4.5} /></p></span>
                                        <Divider />
                                        <div className= 'book-cost'>
                                            <span className='cur-cost'>￥22.00</span><span className='prev-cost'>￥45.00</span>
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
                            <p>“Brilliant and hugely ambitious…Some will argue that a book so difficult and sad may not be appropriate for teenage readers…Adults will probably like it (this one did), but it’s a great young-adult novel…It’s the kind of book that can be life-changing, because without ever denying the essential amorality and randomness of the natural order, The Book Thief offers us a believable hard-won hope…The hope we see in Liesel is unassailable, the kind you can hang on to in the midst of poverty and war and violence. Young readers need such alternatives to ideological rigidity, and such explorations of how stories matter. And so, come to think of it, do adults.” -New York Times</p>
                            <p>"The Book Thief is unsettling and unsentimental, yet ultimately poetic. Its grimness and tragedy run through the reader's mind like a black-and-white movie, bereft of the colors of life. Zusak may not have lived under Nazi domination, but The Book Thief deserves a place on the same shelf with The Diary of a Young Girl by Anne Frank and Elie Wiesel's Night. It seems poised to become a classic." -USA Today</p>
                            <p>"Zusak doesn’t sugarcoat anything, but he makes his ostensibly gloomy subject bearable the same way Kurt Vonnegut did in Slaughterhouse-Five: with grim, darkly consoling humor.” -Time Magazine</p>
                            <p>"Elegant, philosophical and moving...Beautiful and important." -Kirkus Reviews, Starred</p>
                            <p>"This hefty volume is an achievement...a challenging book in both length and subject..." -Publisher's Weekly, Starred </p>
                            <p>"One of the most highly anticipated young-adult books in years." -The Wall Street Journal</p>
                            <p>"Exquisitely written and memorably populated, Zusak's poignant tribute to words, survival, and their curiously inevitable entwinement is a tour de force to be not just read but inhabited." -The Horn Book Magazine, Starred</p>
                            <p>"An extraordinary narrative." -SLJ, Starred</p>
                          </TabPane>
                          <TabPane tab="作者信息" key="2">
                            <p>Markus Zusak is the author of I Am the Messenger, a Printz Honor Book and Los Angeles Times Book Award Finalist, and the international bestseller, The Book Thief, which has been translated into over thirty languages and has sold nine million copies around the world. He is the recipient of the Margaret A. Edwards Award for significant and lasting contribution to writing for teens and lives in Sydney, Australia, with his wife and children.</p>
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
                    <Col span={4}>
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