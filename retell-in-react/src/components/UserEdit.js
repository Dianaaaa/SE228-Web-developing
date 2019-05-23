
import React, { Component } from 'react'
import {Row, Col,Icon, Divider, Button} from 'antd'
import './UserEdit.css'
import UserItem from './UserItem'

class UserEdit extends Component {
    state = {
        query: '',
        users: []
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
            'http://localhost:8080/user/all', {
              method:'GET',
              credentials: 'include' 
            }).then((response) => {
              // console.log(response)
              response.json().then((data) => {
                console.log(data);
                let users = data['users']
                console.log(users)
                this.setState(() => ({
                  users: users
                }))
              });
            })
            .catch(e => console.log('错误:', e)
            )
        }

    render() {
        console.log('Props', this.props)
        const { query, users } = this.state
        // const { onDeleteContact } = this.props

        const showedUsers = query === ''
        ? users
        : users.filter((c) => (
            c.username.toLowerCase().includes(query.toLowerCase())
        ))

        return (
            <div className='user-edit'>
                {/* {JSON.stringify(this.state)} */}
                <div className = 'user-edit-search'>
                    <input 
                        className='ant-input'
                        type='text'
                        placeholder='Search for user'
                        value={query}
                        onChange={(event) => this.updateQuery(event.target.value)}
                    />
                </div>

                {showedUsers.length !== users.length && (
                    <div className="showing-users-info">
                        <span class='users-info'>Now showing {showedUsers.length} of {users.length} </span>
                        <button
                            className='ant-btn'
                            onClick={()=>this.clearQuery()}
                        >show all</button>
                    </div>
                )}

                <ol className='users-list'>
                    {showedUsers.map((contact) => (
                        <UserItem 
                        user = {contact}
                        key = {contact.username}
                        />
                    ))}
                </ol>
            </div>
        )
    }    
}


export default UserEdit