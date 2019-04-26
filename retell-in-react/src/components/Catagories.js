import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import { Menu, Icon } from 'antd';
import './Catagories.css'

class Catagories extends Component {
    setCateQuery = (e) => {
      this.props.onCateQuery(e.target.getAttribute("data-hide"))
      console.log(e.target.getAttribute("data-hide"))
    }
  

    render() {
        const SubMenu = Menu.SubMenu;
        // const MenuItemGroup = Menu.ItemGroup;

        function handleClick(e) {
            console.log('click', e);
        }

        const { cate } = this.props
        

        return (
            

            <div className='retell-catagory-list'>
                <div className='retell-catagory-header'>图书分类</div>
                <Menu onClick={handleClick} mode="vertical">
                <SubMenu key="全部" title={<span><Icon type="read" /><Link to='/book-view' onClick={this.setCateQuery}><span>全部</span></Link></span>}/>
                    {
                      cate.map((c) => (
                        <SubMenu key={c.id} title={<span><Icon type="read" /><Link to='/book-view' onClick={this.setCateQuery}><span data-hide={c.id}>{c.name}</span></Link></span>}>
                          {/* <MenuItemGroup title="Item 1">
                            <Menu.Item key="1">Option 1</Menu.Item>
                            <Menu.Item key="2">Option 2</Menu.Item>
                          </MenuItemGroup>
                          <MenuItemGroup title="Iteom 2">
                            <Menu.Item key="3">Option 3</Menu.Item>
                            <Menu.Item key="4">Option 4</Menu.Item>
                          </MenuItemGroup> */}
                        </SubMenu>
                      ))
                       /* <SubMenu key="sub1" title={<span><Icon type="read" /><Link to='/book-view'><span>小说</span></Link></span>}>
                      <MenuItemGroup title="Item 1">
                        <Menu.Item key="1">Option 1</Menu.Item>
                        <Menu.Item key="2">Option 2</Menu.Item>
                      </MenuItemGroup>
                      <MenuItemGroup title="Iteom 2">
                        <Menu.Item key="3">Option 3</Menu.Item>
                        <Menu.Item key="4">Option 4</Menu.Item>
                      </MenuItemGroup>
                    </SubMenu>
                    <SubMenu key="sub2" title={<span><Icon type="read" /><span>Navigation Two</span></span>}>
                      <Menu.Item key="5">Option 5</Menu.Item>
                      <Menu.Item key="6">Option 6</Menu.Item>
                      <SubMenu key="sub3" title="Submenu">
                        <Menu.Item key="7">Option 7</Menu.Item>
                        <Menu.Item key="8">Option 8</Menu.Item>
                      </SubMenu>
                    </SubMenu>
                    <SubMenu key="sub4" title={<span><Icon type="read" /><span>Navigation Three</span></span>}>
                      <Menu.Item key="9">Option 9</Menu.Item>
                      <Menu.Item key="10">Option 10</Menu.Item>
                      <Menu.Item key="11">Option 11</Menu.Item>
                      <Menu.Item key="12">Option 12</Menu.Item>
                    </SubMenu>
                    <SubMenu key="sub5" title={<span><Icon type="read" /><span>Navigation Three</span></span>}>
                      <Menu.Item key="9">Option 9</Menu.Item>
                      <Menu.Item key="10">Option 10</Menu.Item>
                      <Menu.Item key="11">Option 11</Menu.Item>
                      <Menu.Item key="12">Option 12</Menu.Item>
                    </SubMenu>
                    <SubMenu key="sub6" title={<span><Icon type="read" /><span>Navigation Three</span></span>}>
                      <Menu.Item key="9">Option 9</Menu.Item>
                      <Menu.Item key="10">Option 10</Menu.Item>
                      <Menu.Item key="11">Option 11</Menu.Item>
                      <Menu.Item key="12">Option 12</Menu.Item>
                    </SubMenu>
                    <SubMenu key="sub7" title={<span><Icon type="read" /><span>Navigation Three</span></span>}>
                      <Menu.Item key="9">Option 9</Menu.Item>
                      <Menu.Item key="10">Option 10</Menu.Item>
                      <Menu.Item key="11">Option 11</Menu.Item>
                      <Menu.Item key="12">Option 12</Menu.Item>
                    </SubMenu> */}
                </Menu>
            </div>
        )
    }
}

export default Catagories