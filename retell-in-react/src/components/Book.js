import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import './Book.css'

class Book extends Component {
    
    render () {
        const { name, author, front_page, cur_cost, prev_cost, id } = this.props
        // console.log(id)
        return (
            <div className='book-card'>
                <Link to={'/book-details/'+ id}>
                <div className='book-card-img-noback'>
                <img src={front_page} alt='book'/>
                </div>
                </Link>
                <div className='book-card-detail'>
                    <p className='book-card-name'><Link to={'/book-details/'+ id}>{name}</Link></p>
                    <p className='book-card-writer'>{author}</p>
                    <p className='book-card-cost'><span className='cur-cost'>{cur_cost}</span><span className='prev-cost'>{prev_cost}</span></p>
                </div>
            </div>
        )
    }
}

export default Book