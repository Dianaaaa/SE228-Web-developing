import React, { Component } from 'react'
import Catagories from './../components/Catagories'
import BookShow from './../components/BookShow'
import BookTab from './../components/BookTab'
import Footer from './../components/Footer'
import { Carousel, Input, Row, Col } from 'antd';
import './Home.css'

class Home extends Component {

    render () {
        const {cateQuery, onCateQuery, cate } = this.props
        return (
            <div className="home">

                <Carousel autoplay>
                    <div className='retell-home-add1'>
                        <h3>春季学期促销，教辅全场5折</h3>
                    </div>
                    <div className='retell-home-add2'>
                        <h3>高举启蒙的火把</h3>
                    </div>
                    <div className='retell-home-add3'>
                        <h3>你不知道的萨特</h3>
                    </div>
                    <div className='retell-home-add4'>
                        <h3>纪德三部曲</h3>
                    </div>
                </Carousel>
                
                <Row>
                    <div className='retell-search-bar'>
                        <Col span={4}>
                            <img src={require('./../assets/logo.png')} alt='logo' className='retell-logo'/>
                        </Col>
                        <Col span={6} offset={12}>
                            <Input.Search
                              placeholder="input search text"
                              onSearch={value => console.log(value)}
                              enterButton
                            />
                        </Col>
                    </div>.
                </Row>

                <Row>
                    <Col span={8}>
                        <Catagories
                        cate = {cate}
                        cateQuery = {cateQuery}
                        onCateQuery = {onCateQuery}
                        />
                    </Col>
                    <Col span={16}>
                        <div className='sell-book-show'>
                            <BookShow/>
                        </div>
                    </Col>
                </Row>

                <Row>
                    <BookTab 
                    cate = {cate}
                    />
                </Row>

                <Row>
                    <Footer />
                </Row>
            </div>
        )
    }
}

export default Home