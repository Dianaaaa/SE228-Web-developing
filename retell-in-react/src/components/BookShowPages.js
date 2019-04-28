import React, {Component} from 'react';
import './BookShowPages.css';
import { Pagination, Row, Col } from 'antd';
import Book from './Book'

function BookRow(booklist) {
    let Rows = []
    console.log("booklist",booklist.length)
    for (var j = 0; j < ((booklist.length-1)/4) + 1; j++) {
      let row = []
      // console.log("j",j)
      for (var k = j * 4; (k < (j+1)*4 && k < booklist.length); k++) {
        row.push(booklist[k])
        // console.log("k",k)
      }
      // console.log("row", row)
      Rows.push({id: j,row: row})
    }
    
    // console.log("bookRow", booksRow)
    return <div>{Rows.map((row) => (<Row key={row.id}>{row.row.map((book)=>(<Col span={6} key={book.id}><Book name = {book.name}
    author = {book.author}
    front_page = {book.front_page}
    cur_cost = {book.cur_cost}
    prev_cost = {book.prev_cost}
    id = {book.id}
    /></Col>))}</Row>))}</div>
  }


class BookShowPages extends Component {
    

    onChange = (pageNumber) => {
        console.log('Page: ', pageNumber);

      }

      
    
    render () {
        const { booklist } = this.props
        return (
            <div className='book-pages'>
                <div className='book-section'>
                {BookRow(booklist)}
                </div>
                <div className='page-section'>
                <Pagination showQuickJumper pageSize={16} defaultCurrent={1} total={1} onChange={this.onChange} />
                </div>
               
            </div>
        )
    }

}

export default BookShowPages