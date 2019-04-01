import React, { Component } from 'react'
import Navigator from './../components/Navigator'
import {Col, Input, Row} from 'antd'
import './BookDetails.css'

class BookDetails extends Component {
    render () {
        const { areas, curArea, onChangeArea } = this.props
        return (
            <div>
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
                <Row>
                    <Col span={16}>

                    </Col>
                </Row>
                Book details
            </div>
        )
    }
}

export default BookDetails