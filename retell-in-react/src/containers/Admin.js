import React, { Component } from 'react'
import { Row, Col} from 'antd'
import './Admin.css'
import BookEdit from './../components/BookEdit'

const contacts=[
    {
    'id': 1,
    'title': '偷书贼',
    'writer': 'Markus Zursak',
    'bookUrl': 'E:/SE/SE228-Web-developing/retell-in-react/src/assets/imgs/book-4.jpg'
    },
    {
    'id': 2,
    'title': '步履不停',
    'writer': 'blablabla',
    'bookUrl': 'E:/SE/SE228-Web-developing/retell-in-react/src/assets/imgs/book-4.jpg'
    },
    {
    'id': 3,
    'title': 'csapp',
    'writer': 'dalao',
    'bookUrl': 'E:/SE/SE228-Web-developing/retell-in-react/src/assets/imgs/book-4.jpg'
    },
    {
    'id': 4,
    'title': '数学分析教程',
    'writer': '史济怀',
    'bookUrl': 'E:/SE/SE228-Web-developing/retell-in-react/src/assets/imgs/book-4.jpg'
    }
]

class Admin extends Component {
    state = {
        contacts: contacts
    }

    removeContact = (contact) => {
        console.log("555")
        this.setState((currentState) => ({
          contacts: currentState.contacts.filter((c)=>{
            return c.id !== contact.id
          })
        }))
      }
    
      createContact = (contact) => {
          this.setState((currentState) => ({
            contacts: currentState.contacts.concat([contact])
        }))
      }

    render() {
        return (
            <div>
                <Row>
                    <Col span={4}>
                        <div className='control-panel'>

                        </div>
                    </Col>
                    <Col span={2}/>
                    <Col span={16}>
                        <div className='workspace'>
                        <BookEdit
                        contacts={this.state.contacts}
                        onDeleteContact={this.removeContact}
                        />
                        </div>
                    </Col>
                </Row>
            </div>
        )
    }
}

export default Admin