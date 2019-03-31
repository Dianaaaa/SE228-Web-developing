import React, { Component } from 'react'
import { Carousel, Icon, Row, Col } from 'antd';
import Book from './Book'
import './BookShow.css'

class BookShow extends Component {

    prevPage = (e) => {
        e.preventDefault()
        this.refs.img.prev()
    }

    nextPage = (e) => {
        e.preventDefault()
        this.refs.img.next()
    }

    onChange(a, b, c) {
        console.log(a, b, c);
    }
    render() {
        return (
            <div className='book-show'>
                <Carousel afterChange={this.onChange} ref='img'>
                  <div className='show-row'>
                      <Row>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                      </Row>
                  </div>
                  <div className='show-row'>
                      <Row>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                      </Row>
                  </div>
                  <div className='show-row'>
                      <Row>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                      </Row>
                  </div>
                  <div className='show-row'>
                      <Row>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                          <Col span={6}>
                            <Book />
                          </Col>
                      </Row>
                  </div>
                </Carousel>
                <a className="carousel-control-prev" href="https://github.com/Dianaaaa" onClick={this.prevPage}>
                    <span><Icon type="left" /></span>
                    <span className="sr-only">Previous</span>
                </a>
                <a className="carousel-control-next" href="https://github.com/Dianaaaa" onClick={this.nextPage}>
                    <span><Icon type="right" /></span>
                    <span className="sr-only">Next</span>
                </a>
            </div>
        )
    }
}

export default BookShow