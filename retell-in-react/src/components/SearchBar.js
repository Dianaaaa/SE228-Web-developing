import React, { Component } from 'react'
import {withRouter } from 'react-router-dom'
import './Footer.css'
import {Col,Input} from 'antd'

class SearchBar extends Component {

    handleSearch = (value) => {
        this.props.history.push("/book-view/"+value)
        window.location.href = window.location.href;
    }
    render () {
        return (
                    <div className='retell-search-bar'>
                        <Col span={4}>
                            <img src={require('./../assets/logo.png')} alt='logo' className='retell-logo'/>
                        </Col>
                        <Col span={6} offset={12}>
                            <Input.Search
                              placeholder="input search text"
                              onSearch={value => this.handleSearch(value)}
                              enterButton
                            />
                        </Col>
                    </div>
        )
    }
}

export default withRouter(SearchBar)