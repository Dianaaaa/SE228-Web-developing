import React, {Component} from 'react'
import {Row} from 'antd'
import "./Deal.css"
import DealItem from "../components/Deal/DealItem"
import Footer from "../components/Footer"
import SearchBar from '../components/SearchBar';

class Deal extends Component {
    state = {
        items: []
    }

    componentDidMount() {
        fetch(
          'http://localhost:8080/deal', {
            method:'GET',
            credentials: 'include'         //解决跨域问题
          }).then((response) => {
            console.log(response)
            response.json().then((data) => {
              console.log(data["dealitems"]);
              let items = data['dealitems']
              console.log("sum",)
              this.setState(() => ({
                items: items,
              }))
            });
          })
          .catch(e => console.log('错误:', e)
          )
        }
    render() {
        const {items} = this.state
        return (
            <div className = "deal">
            <div className='img-decoration'>
                    <img src={require('./../assets/imgs/deal.jpg')} alt='deal'/>
            </div>

            <SearchBar />
            
            {
                items.map((item) => (
                    <Row key={item.ID}>
                        <DealItem
                            item = {item}
                        />
                    </Row>
                ))
            }
            <Footer />
            </div>
        )
    }
}

export default Deal