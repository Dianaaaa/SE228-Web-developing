import React, { Component } from 'react'
import Navigator from './../components/Navigator'
import { Carousel } from 'antd';
import './Home.css'

class Home extends Component {
    

    render () {
        const { areas, curArea, onChangeArea } = this.props
        return (
            <div class="home">
                <Navigator 
                areas = {areas}
                curArea = {curArea}
                onChangeArea = {onChangeArea}
                />

                <Carousel autoplay>
                  <div><h3>1</h3></div>
                  <div><h3>2</h3></div>
                  <div><h3>3</h3></div>
                  <div><h3>4</h3></div>
                </Carousel>
            </div>
        )
    }
}

export default Home