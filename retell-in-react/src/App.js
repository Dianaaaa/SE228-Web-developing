import React, { Component } from 'react';
import { Route } from 'react-router-dom'
import { BackTop } from 'antd';
import logo from './logo.svg';
import './App.css';
import Home from './containers/Home'
import Signin from './containers/Signin'
import Login from './containers/Login'
import BookView from './containers/BookView'
import BookSearchView from './containers/BookSearchView'
import BookDetails from './containers/BookDetails'
import ShoppingCart from './containers/ShoppingCart'
import Navigator from './components/Navigator'
import Admin from './containers/Admin'
import Deal from './containers/Deal'
import Dealcfm from './containers/Dealcfm'
import SingleDealcfm from './containers/SingleDealcfm'
import BookEdit from './containers/BookEdit'
import BookCreate from './containers/BookCreate'
import PrivateRoute from './utils/PrivateRoute'
import MyStat from './containers/MyStat';


window.backpath = "http://localhost:8080"

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
      curArea: '北京',
      searchkey: "",
  }
  setArea = (name) => {
    // e.preventDefault()
    // console.log(e)
    this.setState(() => ({
        curArea: name
    }))
  }

  setSearchKey = (key) => {
    this.setState(() => ({
      searchkey: key
    }))
  }




  componentDidUpdate(prevProps, prevState) {
        console.log("prevState.curArea", prevState.curArea);
        console.log("this.state.curArea", this.state.curArea);
        console.log("this.state.curArea", this.state.searchkey);
}
  render() {
    return (
      <div className="App">
          <BackTop />

          <Navigator 
          areas = {areaList}
          curArea = {this.state.curArea}
          onChangeArea = {this.setArea}
          />
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

        <Route exact path='/' component={Home}/>
        
        <Route exact path='/signin' component={Signin}/>

        <Route exact path='/login' component={Login}/>

        <Route exact path='/book-view/cate/:id' component={BookView}/>
         {/* render={() => (
          <BookView 
          cate = {this.state.cate}
          cateQuery = {this.state.cateQuery}
          onCateQuery = {this.setCateQuery}
          />
        )}/> */}
        <Route exact path='/book-view/:key' component={BookSearchView}/>

        <Route exact path='/book-details/:id' component={BookDetails}/>
        
        <Route exact path='/cart' component={ShoppingCart}/>

        <Route exact path='/deal' component={Deal}/>

        <Route exact path='/dealcfm' component={Dealcfm}/>
        
        <Route exact path='/dealcfmsingle' component={SingleDealcfm}/>

        <Route exact path='/admin' render={() => (
          <Admin
          // areas={areaList}
          // curArea={this.state.curArea}
          // onChangeArea={this.setArea}
          />
        )}/>

        <Route exact path='/editbook/:id' component={BookEdit}/>

        <Route exact path='/newbook' component={BookCreate}/>

        <Route exact path='/mystat' component={MyStat}/>
      </div>
    );
  }
}

export default App;
