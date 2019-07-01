
import React, { Component } from 'react'
import {Row, Col,Icon, Divider, Button} from 'antd'
import './DealManage.css'
import DealItem from "../components/Deal/DealItem"

class DealManage extends Component {
    state = {
        query: '',
        deals: []
    }

    updateQuery = (query) => {
        this.setState(() => ({
            query: query.trim()  // 去除掉空格
        }))
    }

    clearQuery = () => {
        this.updateQuery('')
    }


    componentDidMount() {
          fetch(
            'http://localhost:8080/deal/all', {
              method:'GET',
              credentials: 'include' 
            }).then((response) => {
              // console.log(response)
              response.json().then((data) => {
                console.log(data);
                let deals = data['deals']
                console.log(deals)
                this.setState(() => ({
                  deals: deals
                }))
              });
            })
            .catch(e => console.log('错误:', e)
            )
        }

    render() {
        console.log('Props', this.props)
        const { query, deals } = this.state
        // const { onDeleteContact } = this.props

        const showedUsers = query === ''
        ? deals
        : deals.filter((c) => (
            c.address.toLowerCase().includes(query.toLowerCase()) || c.ID.toString().toLowerCase().includes(query.toLowerCase()) || c.receiver.toLowerCase().includes(query.toLowerCase()) || c.phone.toLowerCase().includes(query.toLowerCase())
            || (c.books[0].name.toLowerCase().includes(query.toLowerCase())) || (c.books[0].author.toLowerCase().includes(query.toLowerCase()))
        ))

        return (
            <div className='user-edit'>
                {/* {JSON.stringify(this.state)} */}
                <div className = 'user-edit-search'>
                    <input 
                        className='ant-input'
                        type='text'
                        placeholder='Search for deal'
                        value={query}
                        onChange={(event) => this.updateQuery(event.target.value)}
                    />
                </div>

                {showedUsers.length !== deals.length && (
                    <div className="showing-users-info">
                        <span className='users-info'>Now showing {showedUsers.length} of {deals.length} </span>
                        <button
                            className='ant-btn'
                            onClick={()=>this.clearQuery()}
                        >show all</button>
                    </div>
                )}

                <ol className='users-list'>
                {
                    showedUsers.map((item) => (
                        <Row key={item.ID}>
                            <DealItem
                                item = {item}
                            />
                        </Row>
                    ))
                }
                </ol>
            </div>
        )
    }    
}


export default DealManage