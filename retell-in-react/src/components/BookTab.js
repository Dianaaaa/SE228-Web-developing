import React, { Component } from 'react'
import Book from './Book'
import './BookTab.css'
import { Tabs, Row, Col } from 'antd';

const TabPane = Tabs.TabPane;

function generateBookRow(n) {
  
  let booksRow = []
  // console.log("n", n)
  // console.log(booksAll[n-1])
  // console.log(booksAll[n-1].id)
  // console.log(booksAll[n-1].books)
  for (var i = 0; i < 9; i++) {
    if (typeof(booksAll[i]) == "undefined") {
      return;
    }
    if (booksAll[i].id === n) {
      booksRow = booksAll[i].books
    }
  }

  let Rows = []
  // console.log(booksRow.length)
  for (var j = 0; j < ((booksRow.length)/6) + 1; j++) {
    let row = []
    for (var k = j * 6; (k < (j+1)*6 && k < booksRow.length); k++) {
      row.push(booksRow[k])
      // console.log(booksRow[k])
    }
    // console.log("row", row)
    Rows.push({id: j,row: row})
  }
  
  // console.log("bookRow", booksRow)
  return <div>{Rows.map((row) => (<Row key={row.id}>{row.row.map((book)=>(<Col span={4} key={book.id}><Book name = {book.name}
  author = {book.author}
  front_page = {book.front_page}
  cur_cost = {book.cur_cost}
  prev_cost = {book.prev_cost}
  id = {book.id}
  /></Col>))}</Row>))}</div>
}

let booksAll = []

class BookTab extends Component {
    state = {
      cateBooks: []
    }
    
      componentDidMount() {
        for (var i = 1; i <= 9; i++) {
          let id = i
          fetch(
            'http://localhost:8080/book/cate/limit/' + i, {
              method:'GET',
            }).then((response) => {
              // console.log(response)
              response.json().then((data) => {
                // console.log(data['books']);
                let books = data['books']
                booksAll.push({id: id, books: books})
                // console.log(booksAll)
              });
            })
            .catch(e => console.log('错误:', e)
            )
          }
        }
        

    render () {
        const {cate} = this.props

        return (
            <div className='book-tab'>
                <Tabs
                  defaultActiveKey="1"
                  tabPosition='top'
                //   style={{ height: 220 }}
                >
                  {
                  cate.map((c) => (
                    <TabPane tab={c.name} key={c.id}>
                      {generateBookRow(c.id)}
                    </TabPane>
                  ))}
                </Tabs>
            </div>
        )
    }
}

export default BookTab