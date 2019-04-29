import React, { Component } from 'react'
import BookTab from './../components/BookTab'
import Footer from './../components/Footer'
import SearchBar from './../components/SearchBar'
import { Carousel, Row} from 'antd';
import './Home.css'

class Home extends Component {
    state = {
        cate: []
    }

    componentDidMount() {
        fetch(
          'http://localhost:8080/cate', {
            method:'GET',
          }).then((response) => {
            console.log(response)
            response.json().then((data) => {
              console.log(data['cate']);
              this.setState(() => ({
                cate: data['cate']
              }))
            });
          })
          .catch(e => console.log('错误:', e)
          )
        }

    render () {
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

                <SearchBar />

                <Row>
                    <BookTab 
                    cate = {this.state.cate}
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