
import React, { Component } from 'react'
import {Row, Col,Icon, Divider} from 'antd'
import './BookEdit.css'

class BookEdit extends Component {
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

    onDeleteBook = () => {
        alert("delete!")
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
                    <input 
                        className='ant-input'
                        type='text'
                        placeholder='Search for book'
                        value={query}
                        onChange={(event) => this.updateQuery(event.target.value)}
                    />
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
                                <div className='books-list-item-img'>
                                    <img src={contact.front_page} alt='book'/>
                                </div>
                            </Col>
                            <Col span={6}>
                            <div className='contact-details'>
                                <p>{contact.name}</p>
                                <p>{contact.author}</p>
                            </div>
                            </Col>
                            <Col span={6}>
                            <div className='contact-details'>
                                <p>ISBN: {contact.ISBN}</p>
                                <p>库存量: {contact.stock}</p>
                            </div>
                            </Col>
                            <Col span={8}>
                            <button className='contact-remove'
                                onClick={() => this.onDeleteBook(contact)}
                            ><Icon type="close-circle" /></button>
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


export default BookEdit