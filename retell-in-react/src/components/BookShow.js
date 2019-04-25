import React, { Component } from 'react'
import { Carousel, Icon, Row, Col } from 'antd';
import Book from './Book'
import './BookShow.css'

class BookShow extends Component {

    state = {
      booklist1: [],
      booklist2: [],
      booklist3: [],
      booklist4: []
    }

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

    componentDidMount() {
      fetch(
        'http://localhost:8080/book/carousel', {
          method:'GET',
        }).then((response) => {
          console.log(response)
          response.json().then((data) => {
            console.log(data);
            let list = data['books']
            let list1 = []
            let list2 = []
            let list3 = []
            let list4 = []
            console.log(list)
            for (var i = 0; i < 16; i++) {
              if (i < 4) {
                list1.push(list[i])
              }
              else if (i < 8) {
                list2.push(list[i])
              } else if (i < 12) {
                list3.push(list[i])
              } else if (i < 16) {
                list4.push(list[i])
              }
            }
            console.log(list1)
            console.log(list2)
            console.log(list3)
            console.log(list4)
            this.setState(() => ({
              booklist1: list1,
              booklist2: list2,
              booklist3: list3,
              booklist4: list4
            }))
          });
        })
        .catch(e => console.log('错误:', e)
        )
      }

    render() {
        return (
            <div className='book-show'>
                <Carousel afterChange={this.onChange} ref='img'>
                  <div className='show-row'>
                      <Row>
                          {
                            this.state.booklist1.map((book) => (
                              <Col span={6} key={book.name}>
                                <Book 
                                name = {book.name}
                                author = {book.author}
                                front_page = {book.front_page}
                                cur_cost = {book.cur_cost}
                                prev_cost = {book.prev_cost}
                                id = {book.id}
                                />
                              </Col>
                            ))
                          }
                          {/* <Col span={6}>
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
                          </Col> */}
                      </Row>
                  </div>
                  <div className='show-row'>
                      <Row>
                      {
                            this.state.booklist2.map((book) => (
                              <Col span={6} key={book.name}>
                                <Book 
                                name = {book.name}
                                author = {book.author}
                                front_page = {book.front_page}
                                cur_cost = {book.cur_cost}
                                prev_cost = {book.prev_cost}
                                id = {book.id}
                                />
                              </Col>
                            ))
                          }
                      </Row>
                  </div>
                  <div className='show-row'>
                      <Row>
                      {
                            this.state.booklist3.map((book) => (
                              <Col span={6} key={book.name}>
                                <Book 
                                name = {book.name}
                                author = {book.author}
                                front_page = {book.front_page}
                                cur_cost = {book.cur_cost}
                                prev_cost = {book.prev_cost}
                                id = {book.id}
                                />
                              </Col>
                            ))
                          }
                      </Row>
                  </div>
                  <div className='show-row'>
                      <Row>
                      {
                            this.state.booklist4.map((book) => (
                              <Col span={6} key={book.name}>
                                <Book 
                                name = {book.name}
                                author = {book.author}
                                front_page = {book.front_page}
                                cur_cost = {book.cur_cost}
                                prev_cost = {book.prev_cost}
                                id = {book.id}
                                />
                              </Col>
                            ))
                          }
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