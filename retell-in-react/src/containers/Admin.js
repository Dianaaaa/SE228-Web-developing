import React, { Component } from 'react'
import { Row, Col, Tabs} from 'antd'
import './Admin.css'
import BookManage from './../components/BookManage'
import UserEdit from './../components/UserEdit'
import DealManage from './../components/DealManage'

const TabPane = Tabs.TabPane

class Admin extends Component {

    removeBook = (contact) => {
        console.log("555")
        this.setState((currentState) => ({
          books: currentState.books.filter((c)=>{
            return c.id !== contact.id
          })
        }))
      }
    
      createContact = (contact) => {
          this.setState((currentState) => ({
            books: currentState.books.concat([contact])
        }))
      }

    render() {
        return (
            <div>
                <Tabs tabPosition="left">
              <TabPane tab="书籍管理" key="1">
                <div className='workspace'>
                <BookManage/>
                </div>
              </TabPane>
              <TabPane tab="用户管理" key="2">
                <UserEdit/>
              </TabPane>
              <TabPane tab="订单管理" key="3">
                <DealManage/>
              </TabPane>
            </Tabs>
            </div>
        )
    }
}

export default Admin