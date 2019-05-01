import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import BookShowPages from './../components/BookShowPages'
import Footer from './../components/Footer'
import {Col,Row, Collapse, Divider} from 'antd'
import './BookView.css'
import SearchBar from '../components/SearchBar';


const Panel = Collapse.Panel;


class BookSearchView extends Component {
  state = {
    booklist: [],
    cate: [],
    query: this.props.match.params.key
  }

  setCateQuery = (e) => {
    this.props.onCateQuery(e.target.getAttribute("data-hide"))
    console.log("e.target.setState")
    // this.forceUpdate();
  }

  componentDidMount() {
    console.log(this.props.match.params.key)
    fetch(
      'http://localhost:8080/book/cate/10086', {
        method:'GET',
      }).then((response) => {
        // console.log(response)
        response.json().then((data) => {
          console.log(data);
          let list = data['books']
          this.setState(() => ({
            booklist: list
          }))
        });
        fetch(
          'http://localhost:8080/cate', {
            method:'GET',
          }).then((response) => {
            console.log(response)
            response.json().then((data) => {
              console.log(data['cate']);
              this.setState(() => ({
                cate: data['cate']
              }))
            });
          })
          .catch(e => console.log('错误:', e)
          )
      })
      .catch(e => console.log('错误:', e)
      )
    }
    
    render () {
        // const { areas, curArea, onChangeArea } = this.props
        const {booklist, cate, query} = this.state
        return (
            <div className='book-view'>
                {/* <Navigator 
                    areas = {areas}
                    curArea = {curArea}
                    onChangeArea = {onChangeArea}
                /> */}
                <div className='img-decoration'>
                    <img src={require('./../assets/imgs/retell-2.jpg')} alt='retell-2'/>
                </div>
                <SearchBar />
                <div className='white-space'> &nbsp;</div>

                <div className='book-view-area'>
                <Row>
                    <Col span={4}>
                        <div className='retell-view-catagories'>
                        <Collapse bordered={false} defaultActiveKey={['1']}>
                        {
                          cate.map((c) => (
                            <Panel header={c.name} key={c.id}>
                              <Link to={'/book-view/cate/' + c.id} onClick={this.setCateQuery.bind(this)}><span data-hide={c.id}>{c.name}</span></Link>
                            </Panel>
                          ))
                        }
                        </Collapse>
                        
                        </div>
                    </Col>
                    
                    <Col span={1}>
                    <Divider type="vertical" />
                    </Col>

                    <Col span={18}>
                        <div className='book-show-pages'>
                            <BookShowPages
                            booklist = {booklist}
                            query = {query}
                            search = {1}
                            />
                            
                        </div>
                    </Col>
                    
                </Row>
                </div>
                <Footer />
            </div>
        )
    }
}

export default BookSearchView