
import React, { Component } from 'react'
import {Row, Col,Icon} from 'antd'
import './BookEdit.css'

class BookEdit extends Component {
    state = {
        query: ''
    }

    updateQuery = (query) => {
        this.setState(() => ({
            query: query.trim()  // 去除掉空格
        }))
    }

    clearQuery = () => {
        this.updateQuery('')
    }

    render() {
        console.log('Props', this.props)
        const { query } = this.state
        const { contacts, onDeleteContact } = this.props

        const showedContacts = query === ''
        ? contacts
        : contacts.filter((c) => (
            c.title.toLowerCase().includes(query.toLowerCase()) || c.writer.toLowerCase().includes(query.toLowerCase())
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

                {showedContacts.length !== contacts.length && (
                    <div className="showing-books-info">
                        <span class='books-info'>Now showing {showedContacts.length} of {contacts.length} </span>
                        <button
                            className='ant-btn'
                            onClick={()=>this.clearQuery()}
                        >show all</button>
                    </div>
                )}

                <ol className='books-list'>
                    {showedContacts.map((contact) => (
                        <li key={contact.id} className='books-list-item'>
                        <Row>
                            <Col span={4}>
                                <div className='books-list-item-img'>
                                    <img src={require('./../assets/imgs/book-4.jpg')} alt='book'/>
                                </div>
                            </Col>
                            <Col span={12}>
                            <div className='contact-details'>
                                <p>{contact.title}</p>
                                <p>{contact.writer}</p>
                            </div>
                            </Col>
                            <Col span={8}>
                            <button className='contact-remove'
                                onClick={() => onDeleteContact(contact)}
                            ><Icon type="close-circle" /></button>
                            </Col>
                        </Row>
                        </li>
                    ))}
                </ol>
            </div>
        )
    }    
}

// ListContacts.propTypes = {
//     contacts: propTypes.array.isRequired,
//     onDeleteContact: propTypes.func.isRequired,
// }

export default BookEdit