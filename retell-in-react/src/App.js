import React, { Component } from 'react';
import { Route } from 'react-router-dom'
import logo from './logo.svg';
import './App.css';
import Home from './containers/Home'
import Signin from './containers/Signin'
import Login from './containers/Login'
import BookView from './containers/BookView'
import BookDetails from './containers/BookDetails'
import ShoppingCart from './containers/ShoppingCart'



const areaList = [
  {name: '北京'},{name: '天津'},{name: '河北'},{name: '山西'},{name: '内蒙古'},
  {name: '辽宁'},{name: '吉林'},{name: '黑龙江'},{name: '上海'},{name: '江苏'},
  {name: '浙江'},{name: '安徽'},{name: '福建'},{name: '江西'},{name: '山东'},
  {name: '河南'},{name: '湖北'},{name: '湖南'},{name: '广东'},{name: '广西'},
  {name: '海南'},{name: '重庆'},{name: '四川'},{name: '贵州'},{name: '云南'},
  {name: '西藏'},{name: '陕西'},{name: '甘肃'},{name: '青海'},{name: '宁夏'},
  {name: '新疆'},{name: '台湾'},{name: '香港'},{name: '澳门'},{name: '钓鱼岛'},
]



class App extends Component {        //react component 组件。
  state = {
      curArea: '北京'
  }
  setArea = (name) => {
    // e.preventDefault()
    // console.log(e)
    this.setState(() => ({
        curArea: name
    }))
  }

  componentDidUpdate(prevProps, prevState) {
        console.log("prevState.curArea", prevState.curArea);
        console.log("this.state.curArea", this.state.curArea);
}
  render() {
    
    return (
      <div className="App">
        <Route exact path='/react' render={() => (
          <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/containers/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
        )}/>

        <Route exact path='/' render={() => (
          <Home 
          areas={areaList}
          curArea={this.state.curArea}
          onChangeArea={this.setArea}
          />
        )}/>
        
        <Route exact path='/signin' render={() => (
          <Signin
          />
        )}/>

        <Route exact path='/login' render={() => (
          <Login
          />
        )}/>

        <Route exact path='/book-view' render={() => (
          <BookView 
          areas={areaList}
          curArea={this.state.curArea}
          onChangeArea={this.setArea}
          />
        )}/>

        <Route exact path='/book-details' render={() => (
          <BookDetails 
          areas={areaList}
          curArea={this.state.curArea}
          onChangeArea={this.setArea}
          />
        )}/>
        
        <Route exact path='/cart' render={() => (
          <ShoppingCart
          areas={areaList}
          curArea={this.state.curArea}
          onChangeArea={this.setArea}
          />
        )}/>
      </div>
    );
  }
}

export default App;
