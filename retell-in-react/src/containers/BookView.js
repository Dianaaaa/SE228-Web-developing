import React, {Component} from 'react'
import BookShowPages from './../components/BookShowPages'
import Footer from './../components/Footer'
import {Col, Input, Row, Collapse, Divider} from 'antd'
import './BookView.css'


const Panel = Collapse.Panel;

const text = (
  <p style={{ paddingLeft: 24 }}>
    A dog is a type of domesticated animal.
    Known for its loyalty and faithfulness,
    it can be found as a welcome guest in many households across the world.
  </p>
);

class BookView extends Component {
    
    render () {
        // const { areas, curArea, onChangeArea } = this.props
        return (
            <div className='book-view'>
                {/* <Navigator 
                    areas = {areas}
                    curArea = {curArea}
                    onChangeArea = {onChangeArea}
                /> */}
                <div className='img-decoration'>
                    <img src={require('./../assets/imgs/retell-2.jpg')} alt='retell-2'/>
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

                <div className='book-view-area'>
                <Row>
                    <Col span={4}>
                        <div className='retell-view-catagories'>
                        <Collapse bordered={false} defaultActiveKey={['1']}>
                          <Panel header="小说" key="1">
                            {text}
                          </Panel>
                          <Panel header="社会学" key="2">
                            {text}
                          </Panel>
                          <Panel header="This is panel header 3" key="3">
                            {text}
                          </Panel>
                        </Collapse>
                        
                        </div>
                    </Col>
                    
                    <Col span={1}>
                    <Divider type="vertical" />
                    </Col>

                    <Col span={18}>
                        <div className='book-show-pages'>
                            <BookShowPages/>
                            
                        </div>
                    </Col>
                    
                </Row>
                </div>
                <Footer />
            </div>
        )
    }
}

export default BookView