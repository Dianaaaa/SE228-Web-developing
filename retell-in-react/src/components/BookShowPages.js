import React, {Component} from 'react';
import './BookShowPages.css';
import { Pagination, Row, Col } from 'antd';
import Book from './Book'


function renderBooks(x, y) {
    var rows = []
    var cols = []
    for (var i = 0; i<x; i++){
        for (var j=0; j<y; j++) {
            cols.push(<Book />)
        }
        rows.push(cols)
    }
    return (
        <div>
            {rows.map((row)=>(
            <div className='book-pages-row'>
            <Row>
                {row.map((col)=>(
                    <Col span={6}>
                        {col}
                    </Col>
                ))}
            </Row>
            </div>
            ))}
        </div>
    )
}

class BookShowPages extends Component {
    onChange = (pageNumber) => {
        console.log('Page: ', pageNumber);

      }
    render () {
        return (
            <div className='book-pages'>
                <div className='book-section'>
                {renderBooks(3, 4)}
                </div>
                <div className='page-section'>
                <Pagination showQuickJumper pageSize={16} defaultCurrent={1} total={200} onChange={this.onChange} />
                </div>
               
            </div>
        )
    }

}

export default BookShowPages