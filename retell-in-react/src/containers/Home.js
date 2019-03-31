import React, { Component } from 'react'
import Navigator from './../components/Navigator'
import Catagories from './../components/Catagories'
import { Carousel, Input, Row, Col } from 'antd';
import './Home.css'
import ad2 from './../assets/imgs/retell-2.jpg'

class Home extends Component {
    

    render () {
        const { areas, curArea, onChangeArea } = this.props
        return (
            <div className="home">
                <Navigator 
                areas = {areas}
                curArea = {curArea}
                onChangeArea = {onChangeArea}
                />

                <Carousel autoplay>
                    <div style={{
                        backgroundImage: `url(${ad2})")`
                    }}>
                        <h3>春季学期促销，教辅全场5折</h3>
                    </div>
                    <div>
                        <h3>高举启蒙的火把</h3>
                    </div>
                    <div>
                        <h3>你不知道的萨特</h3>
                    </div>
                    <div>
                        <h3>纪德三部曲</h3>
                    </div>
                </Carousel>
                
                <Row>
                    <div className='retell-search-bar'>
                        <Col span={4}>
                            <img src={require('./../assets/logo.png')} alt='logo' className='retell-logo'/>
                        </Col>
                        <Col span={8} offset={8}>
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
                        <Catagories/>
                    </Col>
                </Row>

            </div>
        )
    }
}

export default Home