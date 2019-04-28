import React, { Component } from 'react'
import './Footer.css'
import {Row, Col, Icon, Input} from 'antd'

class SearchBar extends Component {
    render () {
        return (
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
                    </div>
        )
    }
}

export default SearchBar