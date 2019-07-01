
import React, { Component } from 'react'
import {Row, Col,Icon, Divider, Button} from 'antd'
import { Link } from 'react-router-dom'
import './BookManage.css'

class BookManage extends Component {
    state = {
        query: '',
        books: []
    }

    updateQuery = (query) => {
        this.setState(() => ({
            query: query.trim()  // 去除掉空格
        }))
    }

    clearQuery = () => {
        this.updateQuery('')
    }

    onDeleteBook = (contact) => {
        let path = 'http://localhost:8080/deletebook/' + contact.id;
          fetch(
            path, {
              headers: {
                  'Content-Type': 'application/json'
              },
              method:'POST',
              credentials: 'include'         //解决跨域问题
            }).then((response) => {
                console.log(response)
                if (response.status === 200) {
                    alert("删除成功")
                    window.location.href = window.location.href;
                } else {
                    console.log("error")
                }
            })
            .catch(e => console.log('错误:', e)
            )
    }

    componentDidMount() {
        fetch(
          'http://localhost:8080/book/cate/10086', {
            method:'GET',
          }).then((response) => {
            // console.log(response)
            response.json().then((data) => {
              console.log(data);
              let list = data['books']
              console.log(list)
              this.setState(() => ({
                books: list
              }))
            });
          })
          .catch(e => console.log('错误:', e)
          )
        }

    render() {
        console.log('Props', this.props)
        const { query, books } = this.state
        const {  onDeleteContact } = this.props

        const showedBooks = query === ''
        ? books
        : books.filter((c) => (
            c.name.toLowerCase().includes(query.toLowerCase()) || c.author.toLowerCase().includes(query.toLowerCase())
        ))

        return (
            <div className='book-edit'>
                {/* {JSON.stringify(this.state)} */}
                
                    <div className = 'book-edit-search'>
                    <Row>
                    <Col span={2}>
                    <div>
                        <Link to="/newbook">新建<Icon type="plus" /></Link>
                    </div>
                    </Col>
                    <Col span={8}></Col>
                    <Col span={22}>
                    <input 
                        className='ant-input'
                        type='text'
                        placeholder='Search for book'
                        value={query}
                        onChange={(event) => this.updateQuery(event.target.value)}
                    />
                    
                    </Col>
                </Row>
                </div>

                {showedBooks.length !== books.length && (
                    <div className="showing-books-info">
                        <span class='books-info'>Now showing {showedBooks.length} of {books.length} </span>
                        <button
                            className='ant-btn'
                            onClick={()=>this.clearQuery()}
                        >show all</button>
                    </div>
                )}

                <ol className='books-list'>
                    {showedBooks.map((contact) => (
                        <li key={contact.id} className='books-list-item'>
                        <Row>
                            <Col span={4}>
                                <Link to={'/book-details/'+ contact.id}>
                                <div className='books-list-item-img'>
                                    <img src={contact.front_page} alt='book'/>
                                </div>
                                </Link>
                            </Col>
                            <Col span={6}>
                            <div className='contact-details'>
                                <Link to={'/book-details/'+ contact.id}>
                                <p>{contact.name}</p>
                                </Link>
                                <p>{contact.author}</p>
                            </div>
                            </Col>
                            <Col span={6}>
                            <div className='contact-details'>
                                <p>ISBN: {contact.ISBN}</p>
                                <p>库存量: {contact.stock}</p>
                                <p>销量: {contact.sales}</p>
                            </div>
                            </Col>
                            <Col span={8}>
                                <Row>
                                    <Col span={6}>
                                    <Link to={"/editbook/" + contact.id}>修改</Link>
                                    </Col>
                                    <Col span={6}>
                                    <Button shape="circle" icon="close-circle"
                                    onClick={() => this.onDeleteBook(contact)}
                                />
                                    </Col>
                                
                                
                                </Row>
                            

                            </Col>
                        </Row>
                        <Divider />
                        </li>
                    ))}
                </ol>
            </div>
        )
    }    
}


export default BookManage