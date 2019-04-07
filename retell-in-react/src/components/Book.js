import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import './Book.css'

class Book extends Component {
    render () {
        return (
            <div className='book-card'>
                <Link to='/book-details'>
                <div className='book-card-img'
                    style = {{
                        // backgroundImage: `url()` 
                    }}
                >&nbsp;</div></Link>
                <div className='book-card-detail'>
                    <p className='book-card-name'><Link to='/book-details'>偷书贼</Link></p>
                    <p className='book-card-writer'>Markus Zursak</p>
                    <p className='book-card-cost'><span className='cur-cost'>￥22.00</span><span className='prev-cost'>￥45.00</span></p>
                </div>
            </div>
        )
    }
}

export default Book