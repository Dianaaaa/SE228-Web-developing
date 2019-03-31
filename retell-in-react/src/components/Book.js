import React, { Component } from 'react'
import './Book.css'

class Book extends Component {
    render () {
        return (
            <div className='book-card'>
                <div className='book-card-img'
                    style = {{
                        // backgroundImage: `url()` 
                    }}
                ></div>
                <div className='book-card-detail'>
                    <p className='book-card-name'>偷书贼</p>
                    <p className='book-card-writer'>Markus Zursak</p>
                    <p className='book-card-cost'><span className='cur-cost'>￥22.00</span><span className='prev-cost'>￥45.00</span></p>
                </div>
            </div>
        )
    }
}

export default Book